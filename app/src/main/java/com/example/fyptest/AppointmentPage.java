package com.example.fyptest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AppointmentPage extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText requstinfo;
    private Button submitap;
    //public TextView regnoap;
    public String reg_no;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     //   .setAction("Action", null).show();
           createPopupDialog();
            }
        });

        TextView userId = findViewById(R.id.regnoap);
       Bundle bundle = getIntent().getExtras();
       // String reg_no;
     reg_no= bundle.getString("KEY_REGNO");
       userId.setText(reg_no);

    }
    private void createPopupDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.popup_appointment,null);
            requstinfo = (EditText) view.findViewById(R.id.requstinfo_id);
            submitap = (Button) view.findViewById(R.id.ap_submit);

            dialogBuilder.setView(view);
            dialog = dialogBuilder.create();
            dialog.show();

            submitap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    submitapAppointment(v);

                }

                private void submitapAppointment(View v) {



                }
            });
    }
}