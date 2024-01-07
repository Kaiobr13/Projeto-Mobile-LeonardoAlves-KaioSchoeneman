package pt.iade.leonardokaio.sportbuddy.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class LobbyItem implements Serializable {
        private int id;
        private String title;
        private String notes;
        private String modDate;

        public LobbyItem(){
            this(0, "","","");
        }
        public LobbyItem(int id, String title, String notes, String modDate){
            this.id =  id;
            this.title = title;
            this.notes = notes;
            this.modDate = modDate;
        }

        public static  ArrayList<LobbyItem> List(){
            ArrayList<LobbyItem> items = new ArrayList<>();

            items.add(new LobbyItem(1, "Monday night RAW", "WWE monday night show at night",
                    "11 December 2023 at 18:36"));
            items.add(new LobbyItem(2, "Party hard after exams", "ONLY AFTER EXAMS BRO DON'T STOP STUDYING",
                    "05 March 2023 at 09:00"));
            items.add(new LobbyItem(3, "Borussia Dortmund x PSV", "Champions League 16 rounds",
                    "18 December 2023 at 15:00"));
            items.add(new LobbyItem(4, "Late night gaming session", "Fortnite, COD, PUBG and more. When? 21/12",
                    "10 September 2023 at 12:00"));
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
        public String getNotes() {
            return notes;
        }
        public void setNotes(String notes) {
            this.notes = notes;
        }
        public String getModDate() {
            return modDate;
        }
        public void setModDate(String modDate) {
            this.modDate = modDate;
        }
}
