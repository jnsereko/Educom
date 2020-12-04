package com.educom.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.educom.entity.CourseUnit;
import com.educom.entity.EducomRole;
import com.educom.entity.Lecturer;
import com.educom.entity.Student;
import com.educom.entity.StudentCourse;
import com.educom.entity.User;
import com.educom.exception.ResourceNotFoundException;
import com.educom.service.CourseUnitService;
import com.educom.service.LecturerService;
import com.educom.service.StudentCourseService;
import com.educom.service.StudentService;

@Controller
@RequestMapping("/home/classes")
public class StudentCourseController {
	
	@Autowired
	private StudentCourseService courseService;

	@Autowired
	private StudentService studentService;

	@Autowired	
	private LecturerService lecturerService;
	
	@Autowired	
	private CourseUnitService courseUnitService;
			
	@GetMapping("")
	public String listStudentCourses(Model model) {
		List<StudentCourse> studentCourses = courseService.getStudentCourses();
		model.addAttribute("studentCourses", studentCourses);
		model.addAttribute("message", "hello Uganda");
		return "list-classes";
	}
	
	@GetMapping("/createNewClass")
	public String addNewClass(Model model) {
		StudentCourse course = new StudentCourse();
		model.addAttribute("course", course);
		
		List<Lecturer> lecturers = lecturerService.getAllLecturers();
		model.addAttribute("lecturers", lecturers);		
		
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		
		List<CourseUnit> courseUnit = courseUnitService.getCourseUnits();
		model.addAttribute("courseUnit", courseUnit);
		model.addAttribute("message", "Register New Class");
		return "new-class";
	}
	
	@PostMapping("/saveClass")
	public String saveCustomer(@ModelAttribute("course") StudentCourse course, 
			@RequestParam("studentUUID") String[] studentUUID, @RequestParam("lecturerUUID") String[] lecturerUUID, 
			@RequestParam("unitUUID") String[] unitUUID) throws ResourceNotFoundException {
		course.setLecturers(appendLecturerToList(lecturerUUID));
		course.setStudents(appendStudentToList(studentUUID));
		course.setSubjects(appendCourseUnitToList1(unitUUID));
		courseService.saveCustomer(course);
	    return "redirect:/home/classes";
	}
	
	@GetMapping("/search")
    public String searchForRoles(@RequestParam("keyword") String keyword, Model model) {
        List<StudentCourse> studentCourses = courseService.findStudentCourseByIdCodeAndName(keyword);
        if(studentCourses.isEmpty()) {
            model.addAttribute("message", "No Classes were found for search "+"\""+keyword+"\"");
            return "error";
        }
        model.addAttribute("studentCourses", studentCourses);
        model.addAttribute("keyword", keyword);
        return "list-classes";
    }
	
	@GetMapping("/updateClass")
	public String showFormForUpdate(@RequestParam("studentClassId") Long classId, Model model) throws ResourceNotFoundException {
	    StudentCourse course = courseService.getStudentCourse(classId);
	    model.addAttribute("course", course);
		List<Lecturer> lecturers = lecturerService.getAllLecturers();
		model.addAttribute("lecturers", lecturers);		
		
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		
		List<CourseUnit> courseUnit = courseUnitService.getCourseUnits();
		model.addAttribute("courseUnit", courseUnit);
		
		model.addAttribute("message", "Update "+"\"Class "+classId+"\"");
		return "new-class";
	}

	@GetMapping("/deleteClass")
	public String deleteCustomer(@RequestParam("studentClassId") Long classId) throws ResourceNotFoundException {
		courseService.deleteStudentCourseById(classId);
		return "redirect:/home/classes";
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
    
    private Set<Student> appendStudentToList(String[] studentUUID) throws ResourceNotFoundException {
    	Set<Student> students = new HashSet<Student>();
		for(String tempUserUUID: studentUUID) {
			Student student = studentService.findStudentByUserUUID(tempUserUUID);
			Boolean isAddedUnit = students.add(student);
			if(!isAddedUnit)
				throw new ResourceNotFoundException("Could not add" + studentUUID);
		}
		return students;
    }   
    private Set<Lecturer> appendLecturerToList(String[] lecturerUUID) throws ResourceNotFoundException {
    	Set<Lecturer> lecturers = new HashSet<Lecturer>();
		for(String tempLecturerUUID: lecturerUUID) {
			Lecturer lecturer = lecturerService.findLecturerByUserUUID(tempLecturerUUID);
			Boolean isAddedUnit = lecturers.add(lecturer);
			if(!isAddedUnit)
				throw new ResourceNotFoundException("Could not add" + tempLecturerUUID);
		}
		return lecturers;
    }

    
}
