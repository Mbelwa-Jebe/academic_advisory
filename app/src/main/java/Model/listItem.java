package Model;

public class listItem {

    private String title;
    private String description;

    public listItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public listItem() {
        this.title = title;
        this.description = description;

    }


   // public int getImageResourceID(Context context){
      //  return context.getResources().getIdentifier(this.dash_image, "drawable",context.getPackageName());
   // }



}
