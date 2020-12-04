package com.educom.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.educom.entity.Student;
import com.educom.entity.StudentCourse;
import com.educom.exception.ResourceNotFoundException;
import com.educom.service.CourseUnitService;
import com.educom.service.LecturerService;
import com.educom.service.StudentCourseService;
import com.educom.service.StudentService;
import com.educom.service.UserService;

@Controller
@RequestMapping("/home/students")
public class StudentController {

	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentCourseService studentCourseSevice;
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseUnitService courseUnitService;
	
	@GetMapping("")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("message", "Hello students");
        model.addAttribute("students", students);
        return "list-students";
    }

    @GetMapping("/createNewStudent")
    public String addNewCourseUnit(Model model) {
    	Student student = new Student();

    	List<CourseUnit> courseUnits  = courseUnitService.getCourseUnits();
    	model.addAttribute("courseUnits", courseUnits);
    	
    	List<StudentCourse> allClasses  = studentCourseSevice.getStudentCourses();
    	model.addAttribute("allClasses", allClasses);
    	
    	model.addAttribute("student", student);
        return "new-student";
    }

    @PostMapping("/saveStudent")
    public String saveCourseUnit(@ModelAttribute("student") Student student, @RequestParam("userBirthDate") String date,
    		@RequestParam("unitUUID") String[] unitUUID, @RequestParam("courseUUID") String courseUUID){
			try {
				System.out.println(student.getUserContact()[0]);
				Date  dob = userService.parseDate(date);
				int age = userService.calculateUserAge(date);

				student.setUserAge(age);
				student.setUserBirthDate(dob);
				student.setStudentClass(studentCourseSevice.findStudentCourseByUUID(courseUUID));
				student.setSubjects(appendCourseUnitToList(unitUUID));
				
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			studentService.saveStudent(student);		

	        return "redirect:/home/students";
    }

    @GetMapping("/updateStudent")
    public String showFormForUpdate(@RequestParam("studentId") Long studentId, Model theModel) throws ResourceNotFoundException {
    	Student student = studentService.getStudent(studentId);
        theModel.addAttribute("student", student);
        return "new-student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Long studentId) throws ResourceNotFoundException {
    	studentService.deleteStudent(studentId);
        return "redirect:/home/students";
    }
    
    @GetMapping("/search")
    public String searchForRoles(@RequestParam("keyword") String keyword, Model model) {
        List<Student> students = studentService.findStudentByIdAndName(keyword);
        if(students.isEmpty()) {
            model.addAttribute("message", "No Students were found for search "+keyword);
            return "error";
        }
        model.addAttribute("Students", students);
        model.addAttribute("keyword", keyword);
        return "list-students";
    }

    private Set<CourseUnit> appendCourseUnitToList(String[] unitUUID) throws ResourceNotFoundException {
    	Set<CourseUnit> units = new HashSet<CourseUnit>();
		for(String courseUnitUUID: unitUUID) {
			CourseUnit courseUnit = courseUnitService.findCourseUnitByUnitUUID(courseUnitUUID);
			Boolean isAddedUnit = units.add(courseUnit);
			if(!isAddedUnit)
				throw new ResourceNotFoundException("Could not add" + courseUnit);
		}
		return units;
    }
    
    @InitBinder
    public void initBinder (WebDataBinder binder) {
    	SimpleDateFormat date = new SimpleDateFormat("MM-dd-yy");
    	date.setLenient(true);
    	binder.registerCustomEditor(Date.class, new CustomDateEditor(date, true));
    	
    }
    
}
