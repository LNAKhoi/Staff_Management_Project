/**
 * PACKAGE_NAME
 * Created by Le Nguyen Anh Khoi
 * Date 3/10/2022 - 5:07 PM
 * Description: ...
 */
public class Salary extends Staff {
    long hardSalary=5000000;
    int bonus;
    int absentDays;
    float taxes;
    int otHours;
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

    public void setHardSalary(long hardSalary) {
        if(this.getPosition().equals("Data Analysis")){
            this.hardSalary=12000000;
        }
        else if(this.getPosition().equals("Data Science")){
            this.hardSalary=22450000;
        }
        else if(this.getPosition().equals("FrontEnd Developer")){
            this.hardSalary=11500000;
        }
        else if(this.getPosition().equals("BackEnd Developer")){
            this.hardSalary=12500000;
        }
        else if(this.getPosition().equals("AI Engineering")){
            this.hardSalary=26400000;
        }
        else if(this.getPosition().contains("Internship")){
            this.hardSalary=45000000;
        }
        else{
            this.hardSalary=hardSalary;
        }
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

    public void setTaxes(float taxes) {
        if(hardSalary<11000000){
            taxes=0;
        }
        else if(hardSalary>11000000&& hardSalary<21000000){
            taxes=0.05f;
        }
        else if( hardSalary>=21000000){
            taxes=0.1f;
        }
        else{
            this.taxes=taxes;
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
        long temp=(long) (hardSalary+bonus+otHours*120000-absentDays*250000);
        finalSalary= (long) (temp-taxes*temp);
        staff.setSalary((float)finalSalary);
    }
}

