package com.spring.learning;

import com.spring.learning.bean.Cat;
import com.spring.learning.bean.Pet;
import com.spring.learning.entitiy.Department;
import com.spring.learning.entitiy.Detail;
import com.spring.learning.entitiy.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Pet pet = context.getBean("catBean", Cat.class);
		pet.say();
		context.close();

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.spring.learning.entitiy.Employee.class)
				.addAnnotatedClass(Detail.class)
				.addAnnotatedClass(Department.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
	try {
//		Employee employee1 = new Employee("Vak", "Bak", 100);
//		Employee employee2 = new Employee("Dak", "Bang", 500);
//		Department department = new Department("DiVoSN", 100, 500);
//
//		department.addEmployeeToDepartment(employee1);
//		department.addEmployeeToDepartment(employee2);
//
		Employee employee = session.get(Employee.class, 38);
		System.out.println(employee);
		System.out.println(employee.getDepartment());


//		session.save(department);
		session.getTransaction().commit();
	}
		finally {
		if(session.isOpen()){session.close();}
		factory.close();
	}
	}
}
