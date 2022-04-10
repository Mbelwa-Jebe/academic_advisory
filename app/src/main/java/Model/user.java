package Model;

import android.text.Editable;

public class user {
    public String regist_no;
    public user(Editable regist_no) {
    }

    public String getRegist_no() {
        return regist_no;
    }

    public void setRegist_no(String regist_no) {
        this.regist_no = regist_no;
    }
}
