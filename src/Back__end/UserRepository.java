/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class UserRepository {
    private static final String DATABASE_FILE = "user_db.json";

    public static ArrayList<User> userList = new ArrayList<>();
       public static void loadUsersFromJson() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(DATABASE_FILE)) {
            Type userListType = new TypeToken<List<User>>() {
            }.getType();
            userList = gson.fromJson(reader, userListType);
            if (userList == null) {
                userList = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            userList = new ArrayList<>();
        }
    }
           public static void saveData() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Enable pretty printing
        String json = gson.toJson(userList); // Convert the list to JSON
        try (FileWriter writer = new FileWriter(DATABASE_FILE)) {
            writer.write(json); // Save the JSON to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  
      
}
