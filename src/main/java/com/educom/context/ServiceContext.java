package com.educom.context;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.educom.exception.ResourceNotFoundException;
import com.educom.service.CourseUnitService;
import com.educom.util.EducomClassLoader;

public class ServiceContext  implements ApplicationContextAware {
	private static final Logger log = LoggerFactory.getLogger(ServiceContext.class);
	
	private static boolean refreshingContext = false;
	
	private static final Object refreshingContextLock = new Object();
	
	// Cached service objects
		Map<Class, Object> services = new HashMap<Class, Object>();
		

		// Advisors added to services by this service
		Map<Class, Set<Advisor>> addedAdvisors = new HashMap<Class, Set<Advisor>>();
		
		// Advice added to services by this service
		Map<Class, Set<Advice>> addedAdvice = new HashMap<Class, Set<Advice>>();

	private ApplicationContext applicationContext;
	
	/**
	 * Returns the current proxy that is stored for the Class <code>cls</code>
	 *
	 * @param cls
	 * @return Object that is a proxy for the <code>cls</code> class
	 * @throws ResourceNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	public <T> T getService(Class<? extends T> cls) throws ResourceNotFoundException {
		if (log.isTraceEnabled()) {
			log.trace("Getting service: " + cls);
		}
		
		// if the context is refreshing, wait until it is
		// done -- otherwise a null service might be returned
		synchronized (refreshingContextLock) {
			try {
				while (refreshingContext) {
					if (log.isDebugEnabled()) {
						log.debug("Waiting to get service: " + cls + " while the context is being refreshed");
					}
					
					refreshingContextLock.wait();
					
					if (log.isDebugEnabled()) {
						log.debug("Finished waiting to get service " + cls + " while the context was being refreshed");
					}
				}
				
			}
			catch (InterruptedException e) {
				log.warn("Refresh lock was interrupted", e);
			}
		}
		
		Object service = services.get(cls);
		if (service == null) {
			throw new ResourceNotFoundException("Service not found: " + cls);
		}
		
		return (T) service;
	}
	

	/**
	 * Allow other services to be added to our service layer
	 *
	 * @param cls Interface to proxy
	 * @param classInstance the actual instance of the <code>cls</code> interface
	 * @throws ResourceNotFoundException 
	 */
	public void setService(Class cls, Object classInstance) throws ResourceNotFoundException {
		
		log.debug("Setting service: " + cls);
		
		if (cls != null && classInstance != null) {
			try {
				Advised cachedService = (Advised) services.get(cls);
				boolean noExistingService = cachedService == null;
				boolean replacingService = cachedService != null && cachedService != classInstance;
				boolean serviceAdvised = classInstance instanceof Advised;
				
				if (noExistingService || replacingService) {
					
					Advised advisedService;
					
					if (!serviceAdvised) {
						// Adding a bare service, wrap with AOP proxy
						Class[] interfaces = { cls };
						ProxyFactory factory = new ProxyFactory(interfaces);
						factory.setTarget(classInstance);
						advisedService = (Advised) factory.getProxy(EducomClassLoader.getInstance());
					} else {
						advisedService = (Advised) classInstance;
					}
					
					if (replacingService) {
						moveAddedAOP(cachedService, advisedService);
					}
					
					services.put(cls, advisedService);
				}
				log.debug("Service: " + cls + " set successfully");
			}
			catch (Exception e) {
				throw new ResourceNotFoundException("service.unable.create.proxy.factory"+e);
			}
			
		}
	}

	private static class ServiceContextHolder {

		private ServiceContextHolder() {
		}

		private static ServiceContext instance = null;
	}
	
	
	/**
	 * There should only be one ServiceContext per openmrs (java virtual machine). This method
	 * should be used when wanting to fetch the service context Note: The ServiceContext shouldn't
	 * be used independently. All calls should go through the Context
	 *
	 * @return This VM's current ServiceContext.
	 * @see org.openmrs.api.context.Context
	 */
	public static ServiceContext getInstance() {
		if (ServiceContextHolder.instance == null) {
			ServiceContextHolder.instance = new ServiceContext();
		}
		
		return ServiceContextHolder.instance;
	}
	
	/**
	 * @return concept related services
	 * @throws ResourceNotFoundException 
	 */
	public CourseUnitService getStudentService() throws ResourceNotFoundException {
		return getService(CourseUnitService.class);
	}	
	
	/**
	 * @return concept related services
	 * @throws ResourceNotFoundException 
	 */
	public Object getCourseUnitService(){
		return CourseUnitService.class;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;

	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}	
	

	/**
	 * Moves advisors and advice added by ServiceContext from the source service to the target one.
	 *
	 * @param source the existing service
	 * @param target the new service
	 */
	private void moveAddedAOP(Advised source, Advised target) {
		Class serviceClass = source.getClass();
		Set<Advisor> existingAdvisors = getAddedAdvisors(serviceClass);
		for (Advisor advisor : existingAdvisors) {
			target.addAdvisor(advisor);
			source.removeAdvisor(advisor);
		}
		
		Set<Advice> existingAdvice = getAddedAdvice(serviceClass);
		for (Advice advice : existingAdvice) {
			target.addAdvice(advice);
			source.removeAdvice(advice);
		}
	}



		/**
	 * Returns the set of advisors added by ServiceContext.
	 *
	 * @param cls the class of the cached service
	 * @return the set of advisors or an empty set
	 */
	@SuppressWarnings("unchecked")
	private Set<Advisor> getAddedAdvisors(Class cls) {
		Set<Advisor> result = addedAdvisors.get(cls);
		return (Set<Advisor>) (result == null ? Collections.emptySet() : result);
	}
	
	/**
	 * Returns the set of advice added by ServiceContext.
	 *
	 * @param cls the class of the cached service
	 * @return the set of advice or an empty set
	 */
	@SuppressWarnings("unchecked")
	private Set<Advice> getAddedAdvice(Class cls) {
		Set<Advice> result = addedAdvice.get(cls);
		return (Set<Advice>) (result == null ? Collections.emptySet() : result);
	}
	
}
