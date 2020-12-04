package com.educom.controller;

import java.util.Date;
import java.util.HashSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.educom.entity.CourseUnit;
import com.educom.entity.EducomRole;
import com.educom.entity.Lecturer;
import com.educom.entity.StudentCourse;
import com.educom.exception.ResourceNotFoundException;
import com.educom.service.CourseUnitService;
import com.educom.service.LecturerService;
import com.educom.service.RoleService;
import com.educom.service.StudentCourseService;
import com.educom.service.UserService;
import com.educom.util.EducomGenerator;

@Controller
@RequestMapping("/home/lecturers")
@Transactional
public class LecturerController {

	private static final Logger LOG = LoggerFactory.getLogger(LecturerController.class);

	@Autowired
	private StudentCourseService studentcourseSevice;
	
	@Autowired
	private LecturerService lecturerService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseUnitService courseUnitService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
    public String listLecturers(Model model) {
        List<Lecturer> lecturers = lecturerService.getAllLecturers();
        model.addAttribute("message", "Lecturers");
        model.addAttribute("lecturers", lecturers);
        return "list-lecturers";
    }

    @GetMapping("/createNewLecturer")
    public String addNewLecturer(Model model) {
    	Lecturer lecturer = new Lecturer();
    	model.addAttribute("lecturer", lecturer);

    	List<CourseUnit> courseUnits  = courseUnitService.getCourseUnits();
    	model.addAttribute("courseUnits", courseUnits);
    	
    	List<StudentCourse> classesTaught  = studentcourseSevice.getStudentCourses();
    	model.addAttribute("classesTaught", classesTaught);
    	
    	List<EducomRole> lecturerRoles  = roleService.getEducomRoles();
    	model.addAttribute("lecturerRoles", lecturerRoles);
        return "new-lecturer";
    }

    @PostMapping("/saveLecturer")
    public String saveLecturer(@ModelAttribute("lecturer") Lecturer lecturer,
    		@RequestParam("userBirthDate") String date, @RequestParam("unitUUID") String[] unitUUID,
    		 @RequestParam("roleUUID") String[] roleUUID, @RequestParam("courseUUID") String[] courseUUID) {
		try {
		    
			lecturer.setCourseUnits(appendCourseUnitToList1(unitUUID));
			lecturer.setClassesTaught(appendClasseToList(courseUUID));
			lecturer.setRoles(appendRoleToList(roleUUID));
			Date dob = userService.parseDate(date);
			int age = userService.calculateUserAge(date);
	    	lecturer.setUserAge(age);
		    lecturer.setUserBirthDate(dob);
	     	lecturerService.saveLecturer(lecturer);
	     	lecturerService.createLecturerId(lecturer);
	        return "redirect:/home/lecturers";
	     	
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
    	
		return "error";
    	
    }


	@GetMapping("/search")
    public String searchForRoles(@RequestParam("keyword") String keyword, Model model) {
        List<Lecturer> lecturers = lecturerService.findLecturerByIdOrName(keyword);
        if(lecturers.isEmpty()) {
            model.addAttribute("message", "No Lecturers were found for search "+keyword);
            return "error";
        }
        model.addAttribute("lecturers", lecturers);
        model.addAttribute("keyword", keyword);
        return "list-lecturers";
    }


	@GetMapping("/updateLecturer")
    public String showFormForUpdate(@RequestParam("lecturerId") Long lecturerId, Model theModel) throws ResourceNotFoundException {
    	Lecturer lecturer = lecturerService.getLecturer(lecturerId);
        theModel.addAttribute("lecturer", lecturer);
        return "new-lecturer";
    }

    @GetMapping("/deleteLecturer")
    public String deleteCustomer(@RequestParam("userId") Long userId) throws ResourceNotFoundException {
    	lecturerService.deleteLecturee(userId);
        return "redirect:/home/lecturers";
    }
    
    @InitBinder
    public void initBinder (WebDataBinder binder) {
    	SimpleDateFormat date = new SimpleDateFormat("MM-dd-yy");
    	date.setLenient(true);
    	binder.registerCustomEditor(Date.class, new CustomDateEditor(date, true));
    	
    }
    
    private Set<CourseUnit> appendCourseUnitToList1(String[] unitUUID) throws ResourceNotFoundException {
    	Set<CourseUnit> units = new HashSet<CourseUnit>();
		for(String courseUnitUUID: unitUUID) {
			CourseUnit courseUnit = courseUnitService.findCourseUnitByUnitUUID(courseUnitUUID);
			Boolean isAddedUnit = units.add(courseUnit);
			if(!isAddedUnit)
				throw new ResourceNotFoundException("Could not add" + courseUnit);
		}
		return units;
    }
    
    private Set<EducomRole> appendRoleToList(String[] roleUUID) throws ResourceNotFoundException {
		Set<EducomRole> roles = new HashSet<EducomRole>();
		for(String UUID: roleUUID) {
			EducomRole role = roleService.findEducomRoleByUUID(UUID);
			Boolean isAddedRole = roles.add(role);
			if(!isAddedRole)
				throw new ResourceNotFoundException("Could not add" + role);
		}
		return roles;
	}

	private Set<StudentCourse> appendClasseToList(String[] courseUUID) throws ResourceNotFoundException {
		Set<StudentCourse> courses = new HashSet<StudentCourse>();
		for(String UUID: courseUUID) {
			StudentCourse course = studentcourseSevice.findStudentCourseByUUID(UUID);
			Boolean isAddedCourse = courses.add(course);
			if(!isAddedCourse)
				throw new ResourceNotFoundException("Could not add" + course);
		}
		return courses;
	}

}















