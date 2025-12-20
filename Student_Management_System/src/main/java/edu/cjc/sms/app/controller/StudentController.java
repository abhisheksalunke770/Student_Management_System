package edu.cjc.sms.app.controller;

import java.util.List;

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
			List<Student> students=si.getAllStudent();
			m.addAttribute("data", students);
			return "adminscreen";
		}else {
		m.addAttribute("login_fail","Enter the valid login details..");
		return "login";
		}
	}
		@RequestMapping("enroll_student")
		public String saveStudent(@ModelAttribute Student student,Model m) {
			
			si.saveStudentDetails(student);
			List<Student> students=si.getAllStudent();
			m.addAttribute("data", students);
			return "adminscreen";
		}
		@RequestMapping("/delete")
		public String deleteStudent(@RequestParam("id") int studentId,Model m) {
		
			si.deleteStudent(studentId);
			List<Student> student=si.getAllStudent();
			m.addAttribute("data",student);
			return "adminscreen";
			
		}
		@RequestMapping("/paging")
		public String paging(@RequestParam("pageNo") int pageNo,Model m) {
			List<Student> list=si.paging(pageNo,2);
			m.addAttribute("data", list);
			return "adminscreen";
		}
		@RequestMapping("/search")
		public String getBatchStudent(@RequestParam String batchNumber ,@RequestParam String batchMode,Model m) {
			List<Student> result=si.searchStudentByBatch(batchNumber,batchMode);
			if(result.size()>0) {
				m.addAttribute("data",result);
			}
			else {
				List<Student> student=si.getAllStudent();
				m.addAttribute("data", student);
				m.addAttribute("message","No records are avilable for the bacth'"+batchNumber+""+batchMode+"'...!");
			}
			return "adminscreen";
		}
		
		@RequestMapping("/fees")
		public String onFees(@RequestParam int id,Model m) {
			Student st=si.getSingleStudent(id);
			m.addAttribute("st",st);
			return "fees";
		}
		@RequestMapping("/payfees")
		public String updateFees(@RequestParam int studentid,@RequestParam double ammount,Model m)
		{
			si.updateStudentFees(studentid,ammount);
			List<Student> students=si.getAllStudent();
			m.addAttribute("data",students);
			
			return "adminscreen";
		}
		@RequestMapping("/changeBatch")
		public String onShift(@RequestParam int id,Model m) {
			Student st=si.getSingleStudent(id);
			m.addAttribute("st",st);
			return "shiftBatch";
		}
		@RequestMapping("/shiftbatch")
		public String updateShiftBatch(@RequestParam int studentid,@RequestParam String batchNumber,Model m ) {
			si.updateStudentBatch(studentid,batchNumber);
			List<Student> student =si.getAllStudent();
			m.addAttribute("data",student);
			return "adminscreen";
		}
		
}
		
		

	
	

