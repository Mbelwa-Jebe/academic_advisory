package com.example.fyptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class advisor_dashboard extends AppCompatActivity {
    public String reg_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        ImageView menuic = findViewById(R.id.menuic_id);
        ImageView advisoric = findViewById(R.id.advisoric_id);
        ImageView reportic = findViewById(R.id.reportic_id);
        ImageView appointmentic = findViewById(R.id.appointmentic_id);
        ImageView messagesic = findViewById(R.id.messageic_id);
        ImageView faqsic = findViewById(R.id.faqsic_id);
        ImageView settingsic = findViewById(R.id.settingsic_id);
        //TextView userId = findViewById(R.id.userId);

        menuic.setOnClickListener(this::onClick);
        advisoric.setOnClickListener(this::onClick);
        reportic.setOnClickListener(this::onClick);
        appointmentic.setOnClickListener(this::onClick);
        messagesic.setOnClickListener(this::onClick);
        faqsic.setOnClickListener(this::onClick);
        settingsic.setOnClickListener(this::onClick);


        Bundle bundle = getIntent().getExtras();
        reg_no= bundle.getString("KEY_REGNO");
        // userId.setText(reg_no);


    }


    public void onClick(View view) {
        Bundle bundle = getIntent().getExtras();
        // String reg_no;
        reg_no= bundle.getString("KEY_REGNO");



        switch (view.getId()){

            case R.id.menuic_id:
                Toast.makeText(this,"menu",Toast.LENGTH_LONG).show();
                break;

            case R.id.advisoric_id:
                Toast.makeText(this,"students",Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(advisor_dashboard.this, Advisor_students_Page.class);
                //  Bundle bundle1 = new Bundle();
                // bundle1.putString("KEY_REGNO1",reg_no);
                intent2.putExtras(bundle);
                this.startActivity(intent2);
                break;

            case R.id.reportic_id:
                Toast.makeText(this,"report",Toast.LENGTH_LONG).show();
                break;

            case R.id.appointmentic_id:
                // Toast.makeText(this,"appointment",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(this, AdvisorAppointmentPage.class);
                // Bundle bundle1 = new Bundle();
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