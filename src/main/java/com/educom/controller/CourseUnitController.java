package com.educom.controller;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.educom.entity.StudentCourse;
import com.educom.exception.ResourceNotFoundException;
import com.educom.service.CourseUnitService;
import com.educom.service.LecturerService;
import com.educom.service.StudentCourseService;

@Controller
@RequestMapping("/home/courseUnits")
public class CourseUnitController {

	private static final Logger LOG = LoggerFactory.getLogger(CourseUnitController.class);

	@Autowired
	private StudentCourseService classSevice;

	@Autowired
	private LecturerService lecturerservice;

	@Autowired
	private CourseUnitService courseUnitService;
	
	@GetMapping("")
    public String listCourseUnits(Model model) {
        List < CourseUnit > courseUnits = courseUnitService.getCourseUnits();
        model.addAttribute("message", "Course Units");
        model.addAttribute("courseUnits", courseUnits);
        return "list-course-units";
    }

    @GetMapping("/createNewCourseUnit")
    public String addNewCourseUnit(Model model) {
    	CourseUnit courseUnit = new CourseUnit();
    	model.addAttribute("courseUnit", courseUnit);
        return "new-course-unit";
    }

    @PostMapping("/saveCourseUnit")
    public String saveCourseUnit(@ModelAttribute("courseUnit") CourseUnit courseUnit) {
        courseUnitService.saveCourseUnit(courseUnit);
        return "redirect:/home/courseUnits";
    }

    @GetMapping("/updateCourseUnit")
    public String showFormForUpdate(@RequestParam("unitId") Long unitId, Model theModel) throws ResourceNotFoundException {
    	CourseUnit courseUnit = courseUnitService.getCourseUnit(unitId);
        theModel.addAttribute("courseUnit", courseUnit);
        return "new-course-unit";
    }

    @GetMapping("/deleteCourseUnit")
    public String deleteCustomer(@RequestParam("unitId") Long unitId) throws ResourceNotFoundException {
        courseUnitService.deleteCourseUnit(unitId);
        return "redirect:/subjects/listCourseUnits";
    }
    
	@GetMapping("/search")
    public String searchForCourseUnit(@RequestParam("keyword") String keyword, Model model) {
        List<CourseUnit> courseUnits = courseUnitService.findCourseUnitByIdCodeOrName(keyword);
        if(courseUnits.isEmpty()) {
            model.addAttribute("message", "No CourseUnits were found for search "+"\""+keyword+"\"");
            return "error";
        }
        model.addAttribute("courseUnits", courseUnits);
        model.addAttribute("keyword", keyword);
        model.addAttribute("message", "Course Units matching "+"\""+keyword+"\"");
        return "list-course-units";
    }
}
