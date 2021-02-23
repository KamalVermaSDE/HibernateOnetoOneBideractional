package com.bideractional.onetoone.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.bideractional.onetoone.hibernate.model.Address;
import com.bideractional.onetoone.hibernate.model.Student;

public class HibernateStandAlone {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Student student = new Student("Kamal","Verma","Maths");
		Address address = new Address("Faridabad","Haryana","India");
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		student.setAddress(address);
		address.setStudent(student);
		session.save(student);
		
		List<Student> students = (List<Student>)session.createQuery("from Student ").list();
		for(Student s: students){
			System.out.println("Details : "+s);
		}
		
		session.getTransaction().commit();
		session.close();  
	}

}
