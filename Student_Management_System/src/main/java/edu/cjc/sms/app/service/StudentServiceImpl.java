package edu.cjc.sms.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repository.StudentRepository;

@Repository
public class StudentServiceImpl implements StudentServiceI{

	@Autowired
	StudentRepository sr;
	
	@Override
	public void saveStudentDetails(Student student) {
		sr.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return sr.findAll();
		
	}

	@Override
	public void deleteStudent(int studentId) {
		sr.deleteById(studentId);
	}

	@Override
	public List<Student> paging(int pageNo, int i) {
		Pageable page=PageRequest.of(pageNo, i);
		System.out.println(page);
		return sr.findAll(page).getContent();
	}

	
	
}
