package edu.cjc.sms.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.service.StudentServiceI;

@Controller
public class StudentController {

	@Autowired
	StudentServiceI si;
	
	@RequestMapping("/")
	public String loginpage() {
		return "login";
	}
	@RequestMapping("/login")
	public String onlogin(@RequestParam String username, @RequestParam String password,Model m) {
		if(username.equals("admin")&& password.equals("admin")) {
			return "adminscreen";
		}else {
		m.addAttribute("login_fail","Enter the valid login details..");
		return "login";
		}
	}
		@RequestMapping("enroll_student")
		public String saveStudent(@ModelAttribute Student student) {
			si.saveStudentDetails(student);
			return "adminscreen";
		}
		
}
	
	

