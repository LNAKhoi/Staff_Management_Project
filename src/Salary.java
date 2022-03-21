/**
 * PACKAGE_NAME
 * Created by Le Nguyen Anh Khoi
 * Date 3/10/2022 - 5:07 PM
 * Description: ...
 */
public class Salary extends Staff {
    long hardSalary=500;
    int bonus=0;
    int absentDays=0;
    float taxes=0;
    int otHours=0;
    long finalSalary;
    String level;
    public Salary(){

    }
    public Salary(long hardSalary, int bonus, int absentDays, float taxes, int otHours, long finalSalary, String level) {
        this.hardSalary = hardSalary;
        this.bonus = bonus;
        this.absentDays = absentDays;
        this.taxes = taxes;
        this.otHours = otHours;
        this.finalSalary = finalSalary;
        this.level=level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public long getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(Staff staff) {
        if(staff.getPosition().equals("Data Analysis")){
            staff.setSalary((float)550);
        }
        else if(staff.getPosition().equals("Data Science")){
            staff.setSalary((float)980);
        }
        else if(staff.getPosition().equals("Frontend Developer")){
            staff.setSalary((float)505);
        }
        else if(staff.getPosition().equals("Backend Developer")){
            staff.setSalary((float)545);
        }
        else if(staff.getPosition().equals("AI Engineering")){
            staff.setSalary((float)1150);
        }
        else if(staff.getPosition().contains("Internship")){
            staff.setSalary((float)2000);
        }
    }

    public void setHardSalary(long hardSalary) {
        this.hardSalary = hardSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(int absentDays) {
        this.absentDays = absentDays;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(Staff staff) {
        if(staff.getSalary()<=500){
            this.taxes=0;
        }
        else if(staff.getSalary()>500&& staff.getSalary()<1000){
            this.taxes=0.05f;
        }
        else if( staff.getSalary()>=1000){
            this.taxes=0.1f;
        }
    }

    public int getOtHours() {
        return otHours;
    }

    public void setOtHours(int otHours) {
        this.otHours = otHours;
    }

    public long getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(long finalSalary) {
        this.finalSalary = finalSalary;
    }
    public void finalSalaryCalculation(Staff staff){
        long temp=(long) (staff.getSalary()+this.bonus+this.otHours*15-this.absentDays*20);
        finalSalary= (long) (temp-this.taxes*temp);
        staff.setSalary((float)finalSalary);
    }
}

