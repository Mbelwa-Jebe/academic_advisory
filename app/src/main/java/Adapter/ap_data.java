package Adapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

import Model.appointment;

import static controller.ap_controller.getInstance;

public class ap_data {

    ArrayList<appointment> appointments = new ArrayList<>();
    private Object StringRequest;

    public void getAppointment(){

        String ap_url = "http://192.168.137.1:88/AcademicAdvisor/get_appointments.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ap_url, new Response.Listener<String> (){
            @Override
            public void onResponse(String response) {

            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        getInstance().addToRequestQueue(stringRequest);

    }
}

