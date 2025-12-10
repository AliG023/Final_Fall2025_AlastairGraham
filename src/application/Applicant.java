package application;

public class Applicant {
    private String fullName;            
    private String address;               
    private String phone;                   
    private String email;                
    private String education;             
    private String gender;                
    private String startDate;             
    private String position;              
    private String salary;                   
    private String legal;                 
    private String relative;              
    private String relativeExplanation;   

    public Applicant() {
    }

    public Applicant(String fullName,
                     String address,
                     String phone,
                     String email,
                     String education,
                     String gender,
                     String startDate,
                     String position,
                     String salary,
                     String legal,
                     String relative,
                     String relativeExplanation) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.gender = gender;
        this.startDate = startDate;
        this.position = position;
        this.salary = salary;
        this.legal = legal;
        this.relative = relative;
        this.relativeExplanation = relativeExplanation;
    }

    // Setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) { 
        this.phone = phone; 
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public void setLegal(String legal) {
        this.legal = legal;
    }
    public void setRelative(String relative) {
        this.relative = relative;
    }
    public void setRelativeExplanation(String relativeExplanation) {
        this.relativeExplanation = relativeExplanation;
    }

    // Getters
    public String getFullName() {
        return fullName;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() { 
        return phone; 
    }
    public String getEmail() {
        return email;
    }
    public String getEducation() {
        return education;
    }
    public String getGender() {
        return gender;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getPosition() {
        return position;
    }
    public String getSalary() {
        return salary;
    }
    public String getLegal() {
        return legal;
    }
    public String getRelative() {
        return relative;
    }
    public String getRelativeExplanation() {
        return relativeExplanation;
    }
}
