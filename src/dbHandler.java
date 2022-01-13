import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PACKAGE_NAME
 * Created by Le Nguyen Anh Khoi
 * Date 1/13/2022 - 12:06 AM
 * Description: ...
 */
public class dbHandler {
    public static List<Staff> getStaff(){
        // Create a list to contain staffs
        List<Staff> staffList= new ArrayList<>();
        // Connect to Database
        Connection con=null;
        Statement statement=null;
        try {
            /*
            * In this project, we will use MySQL in Xampp to manage the database
            * port :3306
            * */
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/staff_management","root","");
            String query= "Select * From Staff";
            statement=con.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next()){
                Staff staff= new Staff(resultSet.getInt("ID"),resultSet.getString("Name"),
                                        resultSet.getDate("DOB"),resultSet.getFloat("Salary"), resultSet.getString("Gender"),
                                        resultSet.getString("Address"),resultSet.getString("Position"),resultSet.getDate("StartDate"));
                staffList.add(staff);
            }
            if(con!=null){
                System.out.println("Connection available!");
                con.close();
            }
            if(statement!=null){
                System.out.println("Valid statement!");
                statement.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return staffList;
    }
    public static void addStaff(Staff staff) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/staff_management", "root", "");
            String sqlQuery="INSERT INTO staff (ID,Name,DOB,Salary,Gender,Address,Position,StartDate) VALUES(?,?,?,?,?,?,?,?)";
            statement=con.prepareStatement(sqlQuery);
            statement.setInt(1,staff.getID());
            statement.setString(2,staff.getStaffName());
            statement.setDate(3, (Date) staff.getDateOfBirth());
            statement.setFloat(4,staff.getSalary());
            statement.setString(5,staff.getGender());
            statement.setString(6,staff.getAddress());
            statement.setString(7,staff.getPosition());
            statement.setDate(8,(Date) staff.getStartDate());
            statement.execute();
            if(con!=null){
                System.out.println("Add Success!");
                con.close();
            }
            if(statement!=null){
                System.out.println("Valid statement!");
                statement.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void updateStaff(Staff staff) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/staff_management", "root", "");
            String sqlQuery="Update staff set ID=?,Name=?,DOB=?,Salary=?,Gender=?,Address=?,Position=?,StartDate=? where id=?";
            statement=con.prepareStatement(sqlQuery);
            statement.setInt(9,staff.getID());
            statement.setString(2,staff.getStaffName());
            statement.setDate(3, (Date) staff.getDateOfBirth());
            statement.setFloat(4,staff.getSalary());
            statement.setString(5,staff.getGender());
            statement.setString(6,staff.getAddress());
            statement.setString(7,staff.getPosition());
            statement.setDate(8,(Date) staff.getStartDate());
            statement.execute();
            if(con!=null){
                System.out.println("Update Success!");
                con.close();
            }
            if(statement!=null){
                System.out.println("Valid statement!");
                statement.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
