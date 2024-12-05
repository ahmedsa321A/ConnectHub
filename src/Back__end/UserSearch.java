package Back__end;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class UserSearch {
    private HashMap<String, User> userMap;
        private static final String DATABASE_FILE = "user_db.json";
    
    public void setUserMap(HashMap<String, User> userMap) {
        this.userMap = userMap;
    }

    public User getUserById(String userId) {
        return userMap.get(userId);
    }
    
    public static User getUserByIdFromJson(String userId) {
        try (FileReader reader = new FileReader(DATABASE_FILE)) {
            // Parse the JSON file
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            // Check if the user with the given ID exists in the JSON file
            if (jsonObject.has(userId)) {
                Gson gson = new Gson();
                return gson.fromJson(jsonObject.get(userId), User.class);
            } else {
                System.out.println("User not found with ID: " + userId);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}