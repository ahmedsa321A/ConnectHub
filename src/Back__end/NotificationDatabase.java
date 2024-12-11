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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            Type listType = new TypeToken<List<Notification>>() {
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
     public void addnotification(Notification notification) {
        for(Notification f: this.notifications )
        {
            if(containnotifications(notification)){
            f.setDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            }
        }
        if(!containnotifications(notification))
        this.notifications.add(notification);
    }
     public void removenotification(Notification notification) {
        this.notifications.remove(notification);
    }
    public static ArrayList<Notification> getNotifications(String id) {
        ArrayList<Notification> personnotifications =new ArrayList<>();
        for(Notification n:NotificationDatabase.notifications)
            if(n.getReceiveruserid().equals(id)) 
                personnotifications.add(n);
        return personnotifications;
    }

    public static void setNotifications(ArrayList<Notification> notifications) {
        NotificationDatabase.notifications = notifications;
    }
    public void savenotifications() {
        try (Writer writer = new FileWriter(DATABASE_FILE)) {
            gson.toJson(this.notifications, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getnumberofnotification(String id) {
        ArrayList<Notification> personnotifications =getNotifications(id);
        return personnotifications.size();
    }
    public boolean containnotifications(Notification notification) {
        for(Notification f: this.notifications)
        {
            if(f.getSenderuserid().equals(notification.getSenderuserid())&&f.getReceiveruserid().equals(notification.getReceiveruserid())) 
                return true;
        }
        return false;
    }
}
