import java.sql.*;
import java.util.Scanner;
public class JDBBCDemo {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		//int rno,marks;
		//String name;
		
		String user,url,pass;
		url="jdbc:mysql://localhost:3306/loginclass";
		user="root";
		pass="Akash@2002";
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded Sucessfully");
		Connection con = DriverManager.getConnection(url,user,pass);
		System.out.println("Connection established.......");
		
		// Write the query of the code for send the data to the database;
		/*String query = "create table student(rno int primary key,name varchar(20),marks int)";
		
		// That was create the statement
		Statement st = con.createStatement();
		// execute the Statement
		st.executeUpdate(query);
		System.out.println("Table was created.........");*/
		
		// Code for the insert the data into the datbase
		/*String query = "insert into student values(1,'Akash',99)";
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("Data inserted succesfully.......");*/
				
		// Accept the data from the user by their choice 
		//Scanner s = new Scanner(System.in);
		//System.out.println("Enter the data into the database:");
		//rno = s.nextInt();
		//name = s.next();
		//marks = s.nextInt();
		
		/*String query = "insert into student values("+rno+",'"+name+"',"+marks+")";
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("Data inserted succesfully.......");*/
		
		// code for update the data from the database by the user
		
		/*String query = "update student set name='"+name+"',marks="+marks+" where rno="+rno+"";
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("data updated successfully...............");*/
		
		// Code for delete the data form the databse by the user
		/*String query = "delete from student where rno="+rno+"";
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("data deleted successfully...............");*/
		
		// Code for the read the data from the database
		String query = "select *from student";
		Statement st = con.createStatement();
		
		// Here we want to store the data into the temp variable in interface 
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		}
		
		con.close();
	}

}
