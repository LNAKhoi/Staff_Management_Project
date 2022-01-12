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
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=staffManagement;user=sa;password=123456");
            String query= "Select * From Staff";
            statement=con.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next()){
                Staff staff= new Staff(resultSet.getInt("ID"),resultSet.getString("Name"),
                                        resultSet.getString("DOB"),resultSet.getFloat("Salary"), resultSet.getString("Gender"),
                                        resultSet.getString("Address"),resultSet.getString("Position"),resultSet.getDate("StartDate"));
                staffList.add(staff);
            }
            if(con!=null){
                con.close();
            }
            if(statement!=null){
                statement.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return staffList;
    }
}
