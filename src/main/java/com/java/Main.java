package com.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.java.dto.Student;

public class Main {
	
	static SessionFactory sf;
	static {
			Configuration cfg=new Configuration().addPackage("com.java.dto");
			cfg.configure("hibernate.cfg.xml");
			sf=cfg.buildSessionFactory();
	}

	public void detahedStateEx() {
		
		Session session= sf.openSession();
		Transaction tx=session.beginTransaction();
		Student student= new Student(2, "Payal", "10R, delhi");//transient
		session.save(student);//persistent
		student.setName("ritu");//
		//detached state
	//	session.evict(student);//removed this object from the session
		session.clear();//remove all the objects from the session
		student.setName("parul");
		Student st=session.get(Student.class, 2);//null
		System.out.println(st);
		tx.commit();
		session.close(); 
		
	}
public void detahedStateEx2() {
		
		Session session= sf.openSession();
		Transaction tx=session.beginTransaction();
		Student student= new Student(2, "Payal", "10R, delhi");//transient
		session.save(student);//persistent
		student.setName("ritu");//
		session.flush();
		session.evict(student);//removed this object from the session
		student.setName("parul");
		Student st=session.get(Student.class, 2);// 2 ritu 10r delhi
		System.out.println(st);
		tx.commit();
		session.close(); 
		
	}

public void detahedStateEx3() {
	
	Session session= sf.openSession();
	Transaction tx=session.beginTransaction();
	Student student= new Student(2, "Payal", "10R, delhi");//transient
	session.save(student);//persistent: insert
	student.setName("ritu");//update
	student.setAddress("20r");
	session.flush();
	//detached state
//	session.evict(student);//removed this object from the session
	session.clear();//remove all the objects from the session
	student.setName("parul");
	session.update(student);//persistent: parul: update
	Student st=session.get(Student.class, 2);
	System.out.println(st); //3: queries fired, 2 ,parul, 10r delhi
	tx.commit();
	session.close(); 
	
}


public void getStudentById() {
	
	Session session= sf.openSession();
	Transaction tx=session.beginTransaction();
	/*Student st= new Student(1,"Payal","10R");
	session.save(st);*/
	//persistent
	//session.flush();
	Student st1=session.get(Student.class, 1);//st1 : persistent : row in the db with id 1
	session.delete(st1);//no query fired
	Student st=session.get(Student.class, 1); //st: persistent : 1
	
	//st1.setName("payal");
	//session.update(st1);
	//no query fired : data is already there in session: 
	System.out.println(st);
	tx.commit(); //fires delete query
	session.close();
	
}



public static void main(String args[]) {
	Main obj= new Main();
	obj.detahedStateEx3();
	
	sf.close();
}
}
