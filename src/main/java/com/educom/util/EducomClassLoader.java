package com.educom.util;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class EducomClassLoader extends URLClassLoader {

	public EducomClassLoader(ClassLoader parent) {
		super(new URL[0], parent);
	}
	
	/**
	 * Normal constructor. Sets this class as the parent classloader
	 */
	public EducomClassLoader() {
		this(EducomClassLoader.class.getClassLoader());
	}

	/**
	 * Private class to hold the one classloader used throughout openmrs. This is an alternative to
	 * storing the instance object on {@link OpenmrsClassLoader} itself so that garbage collection
	 * can happen correctly.
	 */
	private static class EducomClassLoaderHolder {

		private EducomClassLoaderHolder() {
		}
		
		private static EducomClassLoader INSTANCE = null;
		
	}
	
	
	/**
	 * Get the static/singular instance of the module class loader
	 *
	 * @return OpenmrsClassLoader
	 */
	public static EducomClassLoader getInstance() {
		if (EducomClassLoaderHolder.INSTANCE == null) {
			EducomClassLoaderHolder.INSTANCE = new EducomClassLoader();
		}
		
		return EducomClassLoaderHolder.INSTANCE;
	}
	

}
