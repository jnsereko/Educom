package com.educom.context;

import com.educom.context.ServiceContext;
import com.educom.exception.ResourceNotFoundException;
import com.educom.service.CourseUnitService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Context {
	
	private static final Logger log = LoggerFactory.getLogger(Context.class);

	private static ServiceContext serviceContext;
	private static CourseUnitService courseUnitService;

	/**
	 * Gets the currently defined service context. If one is not defined, one will be created and
	 * then returned.
	 *
	 * @return the current ServiceContext
	 */
	public static ServiceContext getServiceContext() {
		if (serviceContext == null) {
			synchronized (Context.class) {
				if (serviceContext == null) {
					log.error("serviceContext is null.  Creating new ServiceContext()");
					serviceContext = ServiceContext.getInstance();
				}
			}
		}
		log.trace("serviceContext: {}", serviceContext);

		return ServiceContext.getInstance();
	}

	/**
	 * @return concept dictionary-related services
	 */
	public static CourseUnitService getStudentService() {
		return (CourseUnitService) getServiceContext().getCourseUnitService();
	}	
	
	public static CourseUnitService getCourseUnitService() {
		if (courseUnitService == null) {
			synchronized (CourseUnitService.class) {
				if (courseUnitService == null) {
					log.error("courseUnitService is null.  Creating new courseUnitService()");
				}
			}
		}
		log.trace("courseUnitService: {}", serviceContext);

		return courseUnitService;
	}
}
