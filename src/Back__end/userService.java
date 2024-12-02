/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class userService {
    private static final String DATABASE_FILE = "signup_data.json"; 
    
    private static ArrayList<User> userList = new ArrayList<>();
        public static boolean checkIfUserExists(String email) {

        loadUsersFromJson();

        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true; 
            }
        }
        return false;  
    }


private static void loadUsersFromJson() {
    Gson gson = new Gson();
    try (FileReader reader = new FileReader(DATABASE_FILE)) {
        Type userListType = new TypeToken<List<User>>() {}.getType();
        userList = gson.fromJson(reader, userListType);

        if (userList == null) {
            userList = new ArrayList<>();
        }
    } catch (IOException e) {
        e.printStackTrace();
        userList = new ArrayList<>();
    }
}

    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
  public static String hashPassword(String password) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-1");
    byte[] hash = digest.digest(password.getBytes());
    StringBuilder hexString = new StringBuilder();
    for (byte b : hash) {
        hexString.append(String.format("%02x", b));
    }
    return hexString.toString(); 
   }
    
    
public static void saveSignupDataToJson(User user) {
    loadUsersFromJson(); 
    userList.add(user); 

    Gson gson = new Gson();
    String json = gson.toJson(userList); 

    try (FileWriter writer = new FileWriter(DATABASE_FILE)) {
        writer.write(json); 
    } catch (IOException e) {
        e.printStackTrace();
    }
}
        
        
       public static boolean signup(String email, String username, String password, String dateOfBirth) throws NoSuchAlgorithmException {

        String hashedPassword = hashPassword(password);


        String userId = UUID.randomUUID().toString();


        User user = new User(userId, email, username, hashedPassword, dateOfBirth, "offline");

        saveSignupDataToJson(user);

        return true;
    }
        public static boolean login(String email, String password) throws NoSuchAlgorithmException {
        loadUsersFromJson();

        String hashedPassword = hashPassword(password);

        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(hashedPassword)) {
                return true; 
            }
        }

        return false; 
    }
    
}
