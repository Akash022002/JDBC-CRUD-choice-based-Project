import java.sql.*;
import java.util.Scanner;

public class CRUD {

    public static void main(String[] args) throws Exception {
    	//Accept the into your database
        String user, url, pass;
        url = "jdbc:mysql://localhost:3306/loginclass";
        user = "root";
        pass = "Akash@2002";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Scanner s = new Scanner(System.in);

        Connection con = DriverManager.getConnection(url, user, pass);
        System.out.println("Connection was established.................");

        int choice;
        do {
        	//Accept the choice from the user for do the operation 
            System.out.println("Enter your choice:");
            System.out.println("1] Create Table\n 2] Insert data \n 3] Update existing data\n 4] Delete data \n 5] Delete data with specific name\n 6]Show data\n 7] Exit");

            choice = s.nextInt();
            switch (choice) {
                case 1:
                    // Code to create a table
                    String create = "CREATE TABLE IF NOT EXISTS studentnew (rno INT PRIMARY KEY, name VARCHAR(20), marks INT)";
                    Statement st = con.createStatement();
                    st.executeUpdate(create);
                    System.out.println("Table created successfully..............");
                    break;

                case 2:
                    // Code to insert data
                    System.out.println("How many records do you want to insert:");
                    int records = s.nextInt();
                    for (int j = 0; j < records; j++) {
                        System.out.println("Enter data for record " + (j + 1) + ":");
                        int rno = s.nextInt();
                        String name = s.next();
                        int marks = s.nextInt();

                        String insert = "INSERT INTO studentnew VALUES (" + rno + ", '" + name + "', " + marks + ")";
                        Statement st1 = con.createStatement();
                        st1.executeUpdate(insert);
                        System.out.println("Data inserted successfully.......");
                    }
                    break;

                case 3:
                    // Code to update data
                    System.out.println("Enter the data of name, marks, and rno:");
                    int rnoToUpdate = s.nextInt();
                    String newName = s.next();
                    int newMarks = s.nextInt();

                    String updateData = "UPDATE studentnew SET name = '" + newName + "', marks = " + newMarks + " WHERE rno = " + rnoToUpdate;
                    Statement st2 = con.createStatement();
                    st2.executeUpdate(updateData);
                    System.out.println("Data updated successfully...............");
                    break;

                case 4:
                    // Code to delete data by rno
                    System.out.println("Enter rno whose data should be deleted:");
                    int rnoToDelete = s.nextInt();
                    String deleteData = "DELETE FROM studentnew WHERE rno = " + rnoToDelete;
                    Statement st3 = con.createStatement();
                    st3.executeUpdate(deleteData);
                    System.out.println("Data deleted successfully.............");
                    break;

                case 5:
                    // Code to delete data by name
                    System.out.println("Enter name whose data should be deleted:");
                    String nameToDelete = s.next();
                    String deleteDataByName = "DELETE FROM studentnew WHERE name = '" + nameToDelete + "'";
                    Statement st4 = con.createStatement();
                    st4.executeUpdate(deleteDataByName);
                    System.out.println("Data deleted successfully");
                    break;

                case 6:
                    // Code to show data
                    String showData = "SELECT * FROM studentnew";
                    Statement st5 = con.createStatement();
                    ResultSet rs = st5.executeQuery(showData);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
                    }
                    break;

                case 7:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Enter a valid choice.");
                    break;
            }
        } while (choice != 7);

        con.close();  
        s.close();   
    }
}
