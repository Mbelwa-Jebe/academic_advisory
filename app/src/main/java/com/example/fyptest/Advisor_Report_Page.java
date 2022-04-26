package com.example.fyptest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapter.Report_adapter_advisor;
import Model.Report;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static controller.ap_controller.getInstance;

public class Advisor_Report_Page extends AppCompatActivity {

    private EditText stdnt_id,report_info;
    private Button submit_report;
    private RecyclerView recyclerView;
    private Report_adapter_advisor report_adapter_advisor;
    //public TextView regnoap;
    public String registration_no,report,report_stdntid;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    public static  final String KEY_STDNT_ID="report_stdntid";
    public static final String KEY_REPORT_INFO="report";
    public static final String KEY_ADV_REGNO="registration_no";

    private List<Report> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor__report__page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.advisor_report_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(Advisor_Report_Page.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        Bundle bundle = getIntent().getExtras();
        // String reg_no;
        registration_no= bundle.getString("KEY_REGNO");
        //  userId.setText(reg_no)


        getReports();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopupDialog();
            }


        });
       ;

    }

    private void createPopupDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.pop_up_add_report,null);
        stdnt_id = (EditText) view.findViewById(R.id.report_stdntid);
        report_info = (EditText) view.findViewById(R.id.report_info);
        submit_report = (Button) view.findViewById(R.id.report_submit);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

        submit_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitReport(v);
            }

            private void submitReport(View v) {
                report = report_info.getText().toString().trim();
                report_stdntid = stdnt_id.getText().toString().trim();

                String  post_report_url = "http://192.168.137.1:88/AcademicAdvisor/insert_reports.php";
                StringRequest stringRequest5 = new StringRequest(Request.Method.POST, post_report_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.trim().equals("success")) {
                            Toast.makeText(Advisor_Report_Page.this, response, Toast.LENGTH_LONG).show();
                            dialog.dismiss();

                        } else {
                            Toast.makeText(Advisor_Report_Page.this, "error", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                        new Response.ErrorListener(){

                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        })
                {
                    @Override
                    protected Map<String, String> getParams()throws AuthFailureError {
                        Map<String,String> map = new HashMap<>();
                        map.put(KEY_STDNT_ID,report_stdntid);
                        map.put(KEY_REPORT_INFO,report);
                        map.put(KEY_ADV_REGNO,registration_no);
                        return map;
                    }


                };

                RequestQueue requestQueue5 = Volley.newRequestQueue(getApplicationContext());
                requestQueue5.add(stringRequest5);

            }

        });


    }





    public void getReports() {
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

                        if(registration_no.equals(report.getAdvisor_id())){
                            list.add(report);
                        }
                    }

                    report_adapter_advisor = new Report_adapter_advisor(Advisor_Report_Page.this,list);
                    recyclerView.setAdapter(report_adapter_advisor);

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