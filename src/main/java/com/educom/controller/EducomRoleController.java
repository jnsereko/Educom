package com.educom.controller;

import java.util.Date;
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
import com.educom.entity.StudentCourse;
import com.educom.exception.ResourceNotFoundException;
import com.educom.service.LecturerService;
import com.educom.service.RoleService;

@Controller
@RequestMapping("home/roles")
public class EducomRoleController {

	@Autowired
	private LecturerService lecturerService;
	
	@Autowired
	private RoleService roleService;
	

	@GetMapping("")
    public String listRoles(Model model) {
        List<EducomRole> roles = roleService.getEducomRoles();
        model.addAttribute("roles", roles);
        return "list-roles";
    }

	@GetMapping("/search")
    public String searchForRoles(@RequestParam("keyword") String keyword, Model model) {
        List<EducomRole> roles = roleService.findEducomRoleByIdCodeAndName(keyword);
        if(roles.isEmpty()) {
            model.addAttribute("message", "No Roles were found for search "+keyword);
            return "error";
        }
        model.addAttribute("roles", roles);
        model.addAttribute("keyword", keyword);
        return "list-roles";
    }

    @GetMapping("/createNewRole")
    public String addNewRole(Model model) {
    	EducomRole role = new EducomRole();
    	model.addAttribute("role", role);
    	model.addAttribute("message", "Register New Role");
    	List<Lecturer> lecturers  = lecturerService.getAllLecturers();
    	model.addAttribute("lecturers", lecturers);
    	
        return "new-role";
    }

    @PostMapping("/saveRole")
    public String saveRole(@ModelAttribute("role") EducomRole role, @RequestParam("userUUID") String userUUID) {
		Lecturer lecturer = lecturerService.findLecturerByUserUUID(userUUID);
		role.setLecturer(lecturer);
		roleService.saveEducomRole(role);
		return "redirect:/home/roles";
    }

	@GetMapping("/updateRole")
    public String showFormForUpdate(@RequestParam("roleId") Long roleId, Model model) throws ResourceNotFoundException {
    	System.out.println(roleId);
    	EducomRole role = roleService.getEducomRole(roleId);
    	model.addAttribute("role", role);
    	List<Lecturer> lecturers  = lecturerService.getAllLecturers();
    	model.addAttribute("lecturers", lecturers);        
    	model.addAttribute("message", "Re-edit "+"\"Role " +roleId+"\"");
        return "new-role";
    }

    @GetMapping("/deleteRole")
    public String deleteCustomer(@RequestParam("roleId") Long roleId, Model model) throws ResourceNotFoundException {
    	roleService.deleteEducomRoleByRoleId(roleId);
    	return "redirect:/home/roles";
    }
}
