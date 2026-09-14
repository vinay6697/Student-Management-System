package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;
import model.Student;

public class StudentDAO {

	/**
	 * take the parameters and inserts the data into the database
	 * @param id
	 * @param name
	 * @param percentage
	 * @param age
	 * @param course
	 */
	public void save(int id,String name,double percentage,int age,String course)
	{
		String insertQuery="INSERT INTO student VALUES(?,?,?,?,?)";
		try {
			Connection connection=DatabaseConnection.getConnection();
			PreparedStatement prepareStatement=connection.prepareStatement(insertQuery);
			
			
			prepareStatement.setInt(1,id);
			prepareStatement.setString(2, name);
			prepareStatement.setDouble(3, percentage);
			prepareStatement.setInt(4, age);
			prepareStatement.setString(5, course);
			
			prepareStatement.executeUpdate();
			System.out.println("details entered");
			
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * used to update the provided details 
	 * @param id
	 * @param name
	 * @param percentage
	 * @param age
	 * @param course
	 */
	public void update(int id,String name,double percentage,int age,String course)
	{
		String updateQuery="UPDATE student SET name=?,perc=?,age=?,course=? WHERE id=?";
		try {
			 Connection connection=DatabaseConnection.getConnection();
			PreparedStatement prepareStatement=connection.prepareStatement(updateQuery);
			prepareStatement.setString(1, name);
			prepareStatement.setDouble(2,percentage);
			prepareStatement.setInt(3,age);
			prepareStatement.setString(4,course);
			prepareStatement.setInt(5, id);
			
			prepareStatement.executeUpdate();
			System.out.println("details updated");
			
			prepareStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * used to delete the object based on the provided id
	 * @param id
	 */
	public int delete(int id)
	{
		int update=0;
		String deleteQuery="DELETE FROM student WHERE id=?";
		try {
			 Connection connection=DatabaseConnection.getConnection();
			 
			PreparedStatement prepareStatement=connection.prepareStatement(deleteQuery);
			prepareStatement.setInt(1,id);
			
			update=prepareStatement.executeUpdate();
			
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

	
	/**
	 * used to find the object by the id and returns the object 
	 * @param id
	 * @return
	 */
	public Student findBy(int id)
	{
		Student student=new Student();
		
		String selectQuery="SELECT * FROM student WHERE id=?";
		try {
			 Connection connection=DatabaseConnection.getConnection();
			PreparedStatement prepareStatement=connection.prepareStatement(selectQuery);
			
			prepareStatement.setInt(1,id);
			
			ResultSet resultSet=prepareStatement.executeQuery();
				while(resultSet.next())
				{
					int retrievedId=resultSet.getInt(1);
					String retrievedName=resultSet.getString(2);
					double retrievedPercentage=resultSet.getDouble(3);
					int retrievedAge=resultSet.getInt(4);
					String retrievedCourse=resultSet.getString(5);
					
					student.setId(retrievedId);
					student.setName(retrievedName);
					student.setPercentage(retrievedPercentage);
					student.setAge(retrievedAge);
					student.setCourse(retrievedCourse);
				}
				
				prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	
	
	/**
	 * used to find all the record present in the database
	 * @return
	 */
	public List<Student> findAll()
	{
		List<Student> students=new ArrayList<>();
		String selectQuery="SELECT * FROM student";
		try {
			 Connection connection=DatabaseConnection.getConnection();

			PreparedStatement prepareStatement=connection.prepareStatement(selectQuery);
			ResultSet resultSet=prepareStatement.executeQuery();
			
			while(resultSet.next())
			{
				Student student=new Student();
				
				int retrievedId=resultSet.getInt(1);
				String retrievedName=resultSet.getString(2);
				double retrievedPercentage=resultSet.getDouble(3);
				int retrievedAge=resultSet.getInt(4);
				String retrievedCourse=resultSet.getString(5);
				
				student.setId(retrievedId);
				student.setName(retrievedName);
				student.setPercentage(retrievedPercentage);
				student.setAge(retrievedAge);
				student.setCourse(retrievedCourse);
				
				students.add(student);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
}
