package edu.cjc.sms.app.service;


import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Student> searchStudentByBatch(String batchNumber) {
		List<Student> batchStudents=sr.findAllByBatchNumber(batchNumber);
		return batchStudents;
	}

	@Override
	public Student getSingleStudent(int id) {
		Optional<Student> opStudent=sr.findById(id);
		
		return opStudent.get();
	}

	@Override
	public void updateStudentFees(int studentid, double ammount) {
		Optional<Student> opStudent=sr.findById(studentid);
		Student st=opStudent.get();
		st.setFeesPaid(st.getFeesPaid()+ammount);
		sr.save(st);
	}

	@Override
	public void updateStudentBatch(int studentid, String batchNumber) {
		Optional<Student> opStudent=sr.findById(studentid);
		Student st=opStudent.get();
		st.setBatchNumber(batchNumber);
		sr.save(st);
		
	}

	
	
}
