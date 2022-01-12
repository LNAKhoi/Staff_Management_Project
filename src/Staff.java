import java.util.Date;

/**
 * PACKAGE_NAME
 * Created by Le Nguyen Anh Khoi
 * Date 1/13/2022 - 12:02 AM
 * Description: ...
 */
public class Staff {
    private int ID;
    private String staffName;
    private String dateOfBirth;
    private Float Salary;
    private String Gender;
    private String Address;
    private String Position;
    private Date startDate;


    /*
     * Constructor for staffs
     * */
    public Staff (){}
    public Staff(int ID, String staffName, String dateOfBirth, Float salary, String gender, String address, String position, Date startDate) {
        this.ID = ID;
        this.staffName = staffName;
        this.dateOfBirth = dateOfBirth;
        Salary = salary;
        Gender = gender;
        Address = address;
        Position = position;
        this.startDate = startDate;
    }
    /*
    * Getter and Setter
    * */

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Float getSalary() {
        return Salary;
    }

    public void setSalary(Float salary) {
        Salary = salary;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}