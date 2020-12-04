package com.educom.util;

import java.util.Date;
import java.util.UUID;

import org.omg.IOP.ServiceContext;

public class EducomGenerator {
	public static String generateStudentId(String courseCode, Long long1) {
		Date now = new Date();
		String tempId = now.getYear()+"/"+ courseCode.toUpperCase();
		String id = tempId.concat("/"+EducomConstants.SCHOOL_CODE.toUpperCase());
		id = String.format("%03d", long1);
		id = id.concat("/"+ id);
		return id;
	}
	
	public static String generateLecturerId(int workingHours, String firstName,Long long1) {
		Date now = new Date();
		String tempId = now.getYear()-100 +"/"+ String.format("%03d", workingHours);
		String id = tempId.concat("/"+firstName.toUpperCase()+EducomConstants.SCHOOL_CODE.toUpperCase());
		id = id.concat("/"+ String.format("%03d", long1));
		return id;
	}
	
	public static UUID generateUuid() {
		return UUID.randomUUID();
	} 
}
