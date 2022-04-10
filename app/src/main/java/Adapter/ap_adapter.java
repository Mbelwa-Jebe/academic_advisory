package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fyptest.R;

import java.util.ArrayList;

import Model.appointment;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ap_adapter extends RecyclerView.Adapter<ap_adapter.ViewHolder> {
    @NonNull
    ArrayList<appointment> appointments = new ArrayList<>();
    Context context;

    public ap_adapter(@NonNull ArrayList<appointment> appointments, Context context) {
        this.appointments = appointments;
        this.context = context;
    }

    @Override
    public ap_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View ap_row = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.appointment_row, parent, false);
       return new ViewHolder(ap_row);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    appointment appointment = appointments.get(position);
    holder.ap_time.setText(appointment.getTimestamp());
    holder.ap_advisor.setText(appointment.getAdvisor_lname());
    holder.ap_info.setText(appointment.getRequest_info());
    holder.ap_response.setText(appointment.getResponse());

    }


    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView ap_info,ap_response,ap_advisor,ap_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                     ap_info = itemView.findViewById(R.id.ap_info);
                     ap_response = itemView.findViewById(R.id.ap_response);
                     ap_advisor = itemView.findViewById(R.id.ap_advisor);
                     ap_time = itemView.findViewById(R.id.ap_date);
        }
    }
}
