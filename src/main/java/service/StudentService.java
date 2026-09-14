package service;

import java.util.List;

import dao.StudentDAO;
import model.Student;

public class StudentService {
	
	StudentDAO dao=new StudentDAO();
	
	public void addStudent(Student student)
	{
		int id=student.getId();
		String name=student.getName();
		double percentage=student.getPercentage();
		int age=student.getAge();
		String course=student.getCourse();
		
		if(id<0 || percentage>100 || name.length()==0 || age<10 )
			System.out.println("data");
		else
			dao.save(id, name, percentage,age ,course);
	}
	
	public void update(Student student)
	{
		int id=student.getId();
		String name=student.getName();
		double percentage=student.getPercentage(); 
		int age=student.getAge();
		String course=student.getCourse();
		
		if(percentage>100 || id<=0 || name.length()==0 || age<10)
			System.out.println("provided details are incorrect");
		else
			dao.update(id, name, percentage,age,course);
	}
	
	
	public int delete(int id)
	{
		int update=0;
		if(id<0)
			System.out.println("invalid id");
		else
			 update =dao.delete(id);
		return update;
	}
	
	public Student findById(int id)
	{
		return dao.findBy(id);
	}
	
	
	public List<Student> findAll()
	{
		return dao.findAll();
	}

}
