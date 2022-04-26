package com.example.fyptest;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Adapter.Report_adapter_student;
import Model.Report;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static controller.ap_controller.getInstance;

public class Student_Report_Page extends AppCompatActivity {


    private RecyclerView recyclerView;
    private Report_adapter_student student_report_adapter;
    private List<Report> list;
    public String registration_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__report__page);

        recyclerView = (RecyclerView)findViewById(R.id.student_report_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(Student_Report_Page.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        Bundle bundle = getIntent().getExtras();
        // String reg_no;
        registration_no= bundle.getString("KEY_REGNO");
        //  userId.setText(reg_no);

        getReports();


    }

    private void getReports() {
        list = new ArrayList<>();

        String  get_report_url = "http://192.168.137.1:88/AcademicAdvisor/get_reports.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, get_report_url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray report_arr = response.getJSONArray("reports");
                    for (int i =0;i < report_arr.length();i++){
                        JSONObject reportObj = report_arr.getJSONObject(i);

                        Report report = new Report();
                        report.setReport_date(reportObj.getString("report_date"));
                        report.setReport(reportObj.getString("report"));
                        report.setAdvisor_lname(reportObj.getString("advisor_lname"));
                        report.setAdvisor_fname(reportObj.getString("advisor_fname"));
                        report.setStudent_lname(reportObj.getString("student_lname"));
                        report.setStudent_fname(reportObj.getString("student_fname"));
                        report.setStudent_id(reportObj.getString("student_id"));
                        report.setAdvisor_id(reportObj.getString("advisor_id"));
                        report.setConsultation_id(reportObj.getString("consultation_id"));

                        if(registration_no.equals(report.getStudent_id())){
                            list.add(report);
                        }
                    }

                    student_report_adapter = new Report_adapter_student(Student_Report_Page.this,list);
                    recyclerView.setAdapter(student_report_adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        getInstance().addToRequestQueue(jsonObjectRequest);

    }
}