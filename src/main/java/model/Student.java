package model;

public class Student {

	private int id;
	private String name;
	private double percentage;
	private int age;
	private String course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Student() {
	}

	public Student(int id, String name, double percentage, int age, String course) {
		super();
		this.id = id;
		this.name = name;
		this.percentage = percentage;
		this.age = age;
		this.course = course;
	}

}
