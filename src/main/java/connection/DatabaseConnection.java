package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
	
	private static final String url="jdbc:postgresql://localhost:5432/university";
	private static final String user="postgres";
	private static final String password="root";
	
	
	static List<Connection> connectionPool=new ArrayList<>();
	
	private static final int pool_size=5;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			
			for(int i=0;i<pool_size;i++)
			{
				connectionPool.add(createConnection());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static Connection createConnection()
	{
		Connection connection=null;
		try {
			connection =DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Connection getConnection()
	{
		if(!connectionPool.isEmpty())
		{
			return connectionPool.remove(0);
		}
		else
			return createConnection();
	}
	
	public static void receiveConnection(Connection connection)
	{
		if(connectionPool.size()<pool_size)
			connectionPool.add(connection);
		else
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
