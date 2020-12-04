package com.educom.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	 @Override
	    protected Class < ? > [] getRootConfigClasses() {
	        // TODO Auto-generated method stub
			 return new Class[] {
			            PersistenceJPAConfig.class
			 };
	    }

	    @Override
	    protected Class < ? > [] getServletConfigClasses() {
	        return new Class[] {
	            MvcConfig.class
	        };
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] {
	            "/"
	        };
	    }

	 @Override
	 protected void customizeRegistration(ServletRegistration.Dynamic registration) {
	     registration.setMultipartConfig(getMultipartConfigElement());
	 }

	    private MultipartConfigElement getMultipartConfigElement(){
	  MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
	  return multipartConfigElement;
	 }
	    
	    /*Set these variables for your project needs*/ 
	    
	 private static final String LOCATION = "C:/mytemp/";

	 private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
	 
	 private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB

	 private static final int FILE_SIZE_THRESHOLD = 0;
	
}
