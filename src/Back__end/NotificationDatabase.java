/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hazembarakat
 */
public class NotificationDatabase {
    private static ArrayList<Notification> notifications=new ArrayList<>();
    private static NotificationDatabase instance;
    private static final String DATABASE_FILE = "notification_db.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
     public static NotificationDatabase getInstance() {//using singelton for accesing database globally
        if (instance == null) {
               instance = new NotificationDatabase();
            }
        return instance;
    }
     public void loadnotification() {
        try (Reader reader = new FileReader(DATABASE_FILE)) {
            Type listType = new TypeToken<List<Content>>() {
            }.getType();
            this.notifications = gson.fromJson(reader, listType);
            if (this.notifications  == null) {
                this.notifications = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            this.notifications  = new ArrayList<>(); //return an empty list if the file doesn't exist
        } catch (IOException e) {
            e.printStackTrace();
            this.notifications = new ArrayList<>();
        }
    }
    public void savenotification() {
        try (Writer writer = new FileWriter(DATABASE_FILE)) {
            gson.toJson(this.notifications, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
