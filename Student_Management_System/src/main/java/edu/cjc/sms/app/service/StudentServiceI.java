package edu.cjc.sms.app.service;

import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentServiceI {

	void saveStudentDetails(Student student);
	public List<Student> getAllStudent();
	public void deleteStudent(int studentId);
	List<Student> paging(int pageNo, int i);
	
}
