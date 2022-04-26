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

import Adapter.ap_adapter;
import Adapter.ap_data;
import Model.Appointment;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static controller.ap_controller.getInstance;

public class AppointmentPage extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText requstinfo;
    private Button submitap;
    private RecyclerView recyclerView;
    private ap_adapter ap_adapter;
    //public TextView regnoap;
    public String registration_no,request_info,post_url1;
    private ap_data appointments;
    public static  final String KEY_REGNO="registration_no";
    public static final String KEY_REQUESTINFO="request_info";

    private List<Appointment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView)findViewById(R.id.ap_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(AppointmentPage.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        getAppointment();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     //   .setAction("Action", null).show();
           createPopupDialog();
            }
        });

       // TextView userId = findViewById(R.id.regnoap);
       Bundle bundle = getIntent().getExtras();
       // String reg_no;
        registration_no= bundle.getString("KEY_REGNO");
     //  userId.setText(reg_no);



    }
    private void createPopupDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.popup_appointment,null);
            requstinfo = (EditText) view.findViewById(R.id.requstinfo_id);
            submitap = (Button) view.findViewById(R.id.report_submit);

            dialogBuilder.setView(view);
            dialog = dialogBuilder.create();
            dialog.show();

            submitap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    submitapAppointment(v);

                }

                private void submitapAppointment(View v) {
            request_info = requstinfo.getText().toString().trim();


                    post_url1 ="http://192.168.137.1:88/AcademicAdvisor/insertap1.php";
                    StringRequest stringRequest1 = new StringRequest(Request.Method.POST, post_url1, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.trim().equals("success")) {
                                Toast.makeText(AppointmentPage.this, response, Toast.LENGTH_LONG).show();
                                dialog.dismiss();

                            } else {
                                Toast.makeText(AppointmentPage.this, "error", Toast.LENGTH_LONG).show();
                            }

                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }
                    )
                    {
                        @Override
                        protected Map<String, String> getParams()throws AuthFailureError {
                            Map<String,String> map = new HashMap<>();
                            map.put(KEY_REGNO,registration_no);
                            map.put(KEY_REQUESTINFO,request_info);
                            return map;
                        }

                    };
                    RequestQueue requestQueue1 = Volley.newRequestQueue(getApplicationContext());
                    requestQueue1.add(stringRequest1);


                }
            });
    }


    public void getAppointment(){

        list = new ArrayList<>();

        String  ap_url = "http://192.168.137.1:88/AcademicAdvisor/get_appointments.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, ap_url,
                null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray apArray = response.getJSONArray("appointments");
                    for (int i=0; i< apArray.length();i++){
                        JSONObject apObject = apArray.getJSONObject(i);

                        Appointment appointment = new Appointment();
                        appointment.setRequest_info(apObject.getString("request_info"));
                        appointment.setResponse(apObject.getString("response"));
                        appointment.setAppointment_id(apObject.getString("appointment_id"));
                        appointment.setAdvisor_id(apObject.getString("advisor_id"));
                        appointment.setStudent_id(apObject.getString("student_id"));
                        appointment.setAdvisor_fname(apObject.getString("advisor_fname"));
                        appointment.setAdvisor_lname(apObject.getString("advisor_lname"));
                        appointment.setStudent_fname(apObject.getString("student_fname"));
                        appointment.setStudent_lname(apObject.getString("student_lname"));
                        appointment.setTimestamp(apObject.getString("time_stamp"));

                        if(registration_no.equals(appointment.getStudent_id())){
                            list.add(appointment);
                        }
                        else if(registration_no.equals(appointment.getAdvisor_id())){
                            list.add(appointment);
                        }

                    }

                    ap_adapter = new ap_adapter(AppointmentPage.this,list);
                    recyclerView.setAdapter(ap_adapter);


                    // if (null != callBack)callBack.processFinish(appointments);
                } catch (JSONException e){
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