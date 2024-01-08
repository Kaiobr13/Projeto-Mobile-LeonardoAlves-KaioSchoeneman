package pt.iade.leonardokaio.sportbuddy.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class LobbyItem implements Serializable {
        private int id;
        private String title;
        private String description;
        private String modality;

        public LobbyItem(){
            this(0, "","","");
        }
        public LobbyItem(int id, String title, String description, String modality){
            this.id =  id;
            this.title = title;
            this.description = description;
            this.modality = modality;
        }

        public static  ArrayList<LobbyItem> List(){
            ArrayList<LobbyItem> items = new ArrayList<>();

            items.add(new LobbyItem(1, "Afternoon with Futsal", "15/12 17h00 - 18h00",
                    "Futsal"));
            items.add(new LobbyItem(2, "Swimming to relax", "17/12 18h00 - 19h00",
                    "Swimming"));
            items.add(new LobbyItem(3, "Grind time at Gym", "20/12 08h00 - 09h00",
                    "Gym"));
            items.add(new LobbyItem(4, "Chilling and Padel", "22/12 20h00 - 21h00",
                    "Padel"));
            items.add(new LobbyItem(5,"High Level Golfing","25/12 09h00 - 10h00","Golf"));
            return items;

        }

        //public static TodoItem GetbyId(int id){
        //return new TodoItem(id, "Something wrong from the webserver", "Just kidding, I don't have a server","18 December 2023 at 18:52");}

        public void save(){

            if (id==0){
                id = new Random().nextInt(1000) + 1;
            } else {

            }
        }
        public int getId() {
            return id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getNotes() { return description; }
        public void setNotes(String notes) {
            this.description = notes;
        }
        public String getModDate() {
            return modality;
        }
        public void setModDate(String modDate) {
            this.modality = modDate;
        }
}
