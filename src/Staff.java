import java.sql.Date;

/**
 * PACKAGE_NAME
 * Created by Le Nguyen Anh Khoi
 * Date 1/13/2022 - 12:02 AM
 * Description: ...
 */
public class Staff {
    private int ID;
    private String staffName;
    private Date dateOfBirth;
    private Float Salary;
    private String Gender;
    private String Address;
    private String Position;
    private Date startDate;
    private String imgPath;

    /*
     * Constructor for staffs
     * */
    public Staff (){}

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Staff(int ID, String staffName, Date dateOfBirth, Float salary, String gender, String address, String position, Date startDate, String imgPath) {
        this.ID = ID;
        this.staffName = staffName;
        this.dateOfBirth = dateOfBirth;
        Salary = salary;
        Gender = gender;
        Address = address;
        Position = position;
        this.imgPath=imgPath;
        this.startDate = startDate;
    }

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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