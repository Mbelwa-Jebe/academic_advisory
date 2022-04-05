package com.example.fyptest;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String LOGIN_URL = "http://192.168.137.1:88/AcademicAdvisor/login2.php";
   public static  final String KEY_REGNO="registration_no";
   public static final String KEY_PASSWORD="password";
    EditText etName, etPassword;
    Button btlogin;
    TextView advisorLogin;
    private String registration_no;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.studentuname);
        etPassword = findViewById(R.id.studentpass);
        btlogin = findViewById(R.id.studentlogin);
        btlogin.setOnClickListener(this);
        advisorLogin = findViewById(R.id.advisorText);

        advisorLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "advisor login test", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, advisor_Login.class);
               MainActivity.this.startActivity(intent);

            }
        });

    }

    public void login() {
        registration_no = etName.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>()  {
                @Override
                    public void onResponse(String response) {
                    if (response.trim().equals("success")) {
                        openProfile();

                    } else {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                }
                },
                    new Response.ErrorListener (){
                @Override
                        public void onErrorResponse(VolleyError error){
                                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();

                        }
                })
                        {
            @Override
            protected Map<String, String> getParams()throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put(KEY_REGNO,registration_no);
                map.put(KEY_PASSWORD,password);
                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
                    }
                        public void openProfile(){
                           // Toast.makeText(MainActivity.this, "logged in", Toast.LENGTH_LONG).show();

                              Intent intent = new Intent(MainActivity.this, student_dashboard.class);
                           intent.putExtra(KEY_REGNO,registration_no);
                           MainActivity.this.startActivity(intent);
                        }

    @Override
    public void onClick(View v) {
        login();
    }
}


