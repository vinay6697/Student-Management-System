package ui;

import java.util.List;
import java.util.Scanner;

import model.Student;
import service.StudentService;

public class StudentDriver {
	public static void main(String[] args) {
		StudentService service=new StudentService();
		Scanner sc=new Scanner(System.in);
		String c="Y";
		String str="";
		
		do {
			System.out.println("Enter 1 to add student ");
			System.out.println("Enter 2 to update student ");
			System.out.println("Enter 3 to delete student ");
			System.out.println("Enter 4 to find student ");
			System.out.println("Enter 5 to findAll students ");
			System.out.println("Enter 6 to find students by name");
			
			int choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:{
					System.out.println("Enter the id");
					int id=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter the name");
					String name=sc.nextLine();
					
					System.out.println("Enter the percentage");
					double percentage=sc.nextDouble();
					
					System.out.println("Enter the age");
					int age=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter the course");
					String course=sc.nextLine();
					
					Student student=new Student(id,name,percentage,age,course);
					service.addStudent(student);
					break;
				}
				case 2:{
					System.out.println("Enter the id");
					int id=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter the name");
					String name=sc.nextLine();
					
					
					System.out.println("Enter the percentage");
					double percentage=sc.nextDouble();
					
					System.out.println("Enter the age");
					int age=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter the course");
					String course=sc.nextLine();
					
					Student student=new Student(id,name,percentage,age,course);
					service.update(student);
					break;
				}
				case 3:{
					System.out.println("Enter the id");
					int id=sc.nextInt();
					
					if(service.delete(id)==0)
						System.out.println("no data found with id "+id);
					else
						System.out.println("details with id "+id+" deleted");
					break;
				}
				case 4:{
					System.out.println("Enter the id");
					int id=sc.nextInt();
					Student student=service.findById(id);
					
					System.out.println("-----------------------------------");

					if(student.getId()==id)
					{
						System.out.println("Student id is:\t\t|"+student.getId());
						System.out.println("Student name is:\t|"+student.getName());
						System.out.println("Student percentage is:\t|"+student.getPercentage());
						System.out.println("Student age is:\t\t|"+student.getAge());
						System.out.println("Student course is:\t|"+student.getCourse());
						System.out.println("-----------------------------------");
						break;
					}
					else
						System.out.println("student with id "+id+" not found");
					
					break;
				}
				case 5:{
					List<Student> students=service.findAll();
					
					System.out.println("-------------------------------------------------");

					for(Student student:students)
					{
						System.out.println("Student id is:\t\t|"+student.getId());
						System.out.println("Student name is:\t|"+student.getName());
						System.out.println("Student percentage is:\t|"+student.getPercentage());
						System.out.println("Student age is:\t\t|"+student.getAge());
						System.out.println("Student course is:\t|"+student.getCourse());
						System.out.println("-------------------------------------------------");
					}
					break;
				}
				case 6:{
					sc.nextLine();
					System.out.println("Enter the name");
					String name=sc.nextLine();
					
					Student student=service.findByName(name);
					
					System.out.println("-------------------------------------------------");
					if(student!=null)
					{
						System.out.println("Student id is:\t\t|"+student.getId());
						System.out.println("Student name is:\t|"+student.getName());
						System.out.println("Student percentage is:\t|"+student.getPercentage());
						System.out.println("Student age is:\t\t|"+student.getAge());
						System.out.println("Student course is:\t|"+student.getCourse());
						System.out.println("-------------------------------------------------");
					}
					else
					{
						System.out.println("no student found");
					}
					break;
				}
				default:{
					System.out.println("invalid choice");
				}
			}
			System.out.println("Do you want to repeat \nEnter Y for YES  & N for NO");
			str = sc.next();
		}while(c.equalsIgnoreCase(str));
		
		System.out.println("closed succcessfully");
		sc.close();
	}
}
