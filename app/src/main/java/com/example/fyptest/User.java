package com.example.fyptest;

public class User {
    private String registration_no,student_fname,student_lname,programme,advisor_id;

    public User (String registration_no,String student_fname,String student_lname,String programme,String advisor_id){
        this.registration_no = registration_no;
           this.student_fname = student_fname;
           this.student_lname = student_lname;
           this.programme = programme;
           this.advisor_id = advisor_id;
    }

    public String getRegistration_no() {
        return registration_no;
    }

    public String getStudent_fname() {
        return student_fname;
    }

    public String getStudent_lname() {
        return student_lname;
    }

    public String getProgramme() {
        return programme;
    }

    public String getAdvisor_id() {
        return advisor_id;
    }

    public void setRegistration_no(String registration_no) {
        this.registration_no = registration_no;
    }

    public void setStudent_fname(String student_fname) {
        this.student_fname = student_fname;
    }

    public void setStudent_lname(String student_lname) {
        this.student_lname = student_lname;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setAdvisor_id(String advisor_id) {
        this.advisor_id = advisor_id;
    }
}
