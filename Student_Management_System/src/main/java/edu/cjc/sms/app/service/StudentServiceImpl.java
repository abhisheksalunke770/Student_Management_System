package edu.cjc.sms.app.service;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	
}
