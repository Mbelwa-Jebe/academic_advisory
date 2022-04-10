package com.example.fyptest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class student_dashboard extends AppCompatActivity implements View.OnClickListener {

public String reg_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_student_dashboard2);

        ImageView menuic = findViewById(R.id.menuic_id);
        ImageView advisoric = findViewById(R.id.advisoric_id);
        ImageView reportic = findViewById(R.id.reportic_id);
        ImageView appointmentic = findViewById(R.id.appointmentic_id);
        ImageView messagesic = findViewById(R.id.messageic_id);
        ImageView faqsic = findViewById(R.id.faqsic_id);
        ImageView settingsic = findViewById(R.id.settingsic_id);
       TextView userId = findViewById(R.id.userId);

        menuic.setOnClickListener(this);
        advisoric.setOnClickListener(this);
        reportic.setOnClickListener(this);
        appointmentic.setOnClickListener(this);
        messagesic.setOnClickListener(this);
        faqsic.setOnClickListener(this);
        settingsic.setOnClickListener(this);


        Bundle bundle = getIntent().getExtras();
        reg_no= bundle.getString("KEY_REGNO");
        userId.setText(reg_no);


    }


    @SuppressLint("ShowToast")
    @Override
    public void onClick(View v) {
      Bundle bundle = getIntent().getExtras();
       // String reg_no;
      reg_no= bundle.getString("KEY_REGNO");



        switch (v.getId()){

            case R.id.menuic_id:
                Toast.makeText(this,"menu",Toast.LENGTH_LONG).show();
                break;

            case R.id.advisoric_id:
                Toast.makeText(this,"advisor",Toast.LENGTH_LONG).show();
                break;

            case R.id.reportic_id:
                Toast.makeText(this,"report",Toast.LENGTH_LONG).show();
                break;

            case R.id.appointmentic_id:
               // Toast.makeText(this,"appointment",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(student_dashboard.this, AppointmentPage.class);
              //  Bundle bundle1 = new Bundle();
               // bundle1.putString("KEY_REGNO1",reg_no);
               intent.putExtras(bundle);
                this.startActivity(intent);

                break;

            case R.id.messageic_id:
                Toast.makeText(this,"messages",Toast.LENGTH_LONG).show();
                break;

            case R.id.faqsic_id:
                Toast.makeText(this,"faqs",Toast.LENGTH_LONG).show();
                break;

            case R.id.settingsic_id:
                Toast.makeText(this,"settings",Toast.LENGTH_LONG).show();
                break;


             }
    }
}