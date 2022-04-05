package Adapter;

/*public class student_dash_adapter extends RecyclerView.Adapter<student_dash_adapter.ViewHolder> {
   private Context context;
    private List<listItem> listItems;

    private DashboardData dashboardData = new DashboardData();
    public student_dash_adapter(Context context, List listitem){
      this.context = context;
        this.listItems = listitem;

     }
    @NonNull
    @Override
   // public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     //  View view = LayoutInflater.from(parent.getContext())
         //      .inflate(R.layout.student_dash_item, parent, false);
    //    return new ViewHolder(view);

   // }

   // @Override
    public void onBindViewHolder(@NonNull student_dash_adapter.ViewHolder holder, int position) {
       listItem item = dashboardData.itemList().get(position);
       holder.tittle.setText(item.getTitle());
       // listItem item = listItems.get(position);
        holder.tittle.setText(item.getTitle());
        holder.description.setText(item.getDescription());

    }

    @Override
    public int getItemCount() {
     // return dashboardData.itemList().size();
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tittle;
        public TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
    //        tittle = itemView.findViewById(R.id.tittle);
   //         description = itemView.findViewById(R.id.desc);

        }
    }
}*/
