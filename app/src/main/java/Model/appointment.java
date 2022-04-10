package Model;

public class  appointment {
    private String request_info;
    private String response;
    private String student_fname;
    private String student_lname;
    private String advisor_fname;
    private String advisor_lname;
    private String timestamp;

    public String getRequest_info() {
        return request_info;
    }

    public void setRequest_info(String request_info) {
        this.request_info = request_info;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStudent_fname() {
        return student_fname;
    }

    public void setStudent_fname(String student_fname) {
        this.student_fname = student_fname;
    }

    public String getStudent_lname() {
        return student_lname;
    }

    public void setStudent_lname(String student_lname) {
        this.student_lname = student_lname;
    }

    public String getAdvisor_fname() {
        return advisor_fname;
    }

    public void setAdvisor_fname(String advisor_fname) {
        this.advisor_fname = advisor_fname;
    }

    public String getAdvisor_lname() {
        return advisor_lname;
    }

    public void setAdvisor_lname(String advisor_lname) {
        this.advisor_lname = advisor_lname;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
