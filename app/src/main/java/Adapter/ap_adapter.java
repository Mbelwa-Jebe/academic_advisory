package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fyptest.AppointmentPage;
import com.example.fyptest.R;

import java.util.List;

import Model.Appointment;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ap_adapter extends RecyclerView.Adapter<ap_adapter.ViewHolder> {
    List<Appointment> list;
    Context context;

    public ap_adapter(Context context, List<Appointment> list) {
        this.list = list;
        this.context = context;
    }

    public ap_adapter(ap_data appointments, AppointmentPage context) {

    }

    @Override
    public ap_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View ap_row = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.appointment_row, parent, false);
       return new ViewHolder(ap_row);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Appointment appointment = list.get(position);
    holder.ap_time.setText(appointment.getTimestamp());
    holder.ap_advisor.setText(appointment.getAdvisor_lname());
    holder.ap_info.setText(appointment.getRequest_info());
    holder.ap_response.setText(appointment.getResponse());

    holder.editBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            appointment.getAppointment_id();
        }
    });

    holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView ap_info,ap_response,ap_advisor,ap_time;
        public ImageButton editBtn,deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                     ap_info = itemView.findViewById(R.id.report_studentlname);
                     ap_response = itemView.findViewById(R.id.report_studentid);
                     ap_advisor = itemView.findViewById(R.id.report_studentfname);
                     ap_time = itemView.findViewById(R.id.ap_date);

                     editBtn = itemView.findViewById(R.id.edit_report);
                     deleteBtn = itemView.findViewById(R.id.delete_report);
        }
    }
}
