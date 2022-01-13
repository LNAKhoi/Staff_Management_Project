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

    public static void main(String[] args) {
        List<Staff> temp= new ArrayList<Staff>();
        temp=getStaff();
    }
}
