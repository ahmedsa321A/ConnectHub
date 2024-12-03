/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.awt.Image;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class userService {

    private static final String DATABASE_FILE = "signup_data.json";

    static ArrayList<User> userList = new ArrayList<>();
    static ContentDatabase content = new ContentDatabase();

    public static boolean checkIfUserExists(String email) {

        loadUsersFromJson();

        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<JLabel> getPosts(User user) {
        content.loadContent();
        ArrayList<JLabel> posts = new ArrayList<>();
        for (Content c : content.getContents()) {
            if (c.getAuthorId().equals("userid") && !c.isStory()) {
//                user.getUserId()
                JLabel label = new JLabel();
                String timestamp = c.getTimestamp();
                DateTimeFormatter inputFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; // Handles the 'T' and fractional seconds
                LocalDateTime dateTime = LocalDateTime.parse(timestamp, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy @ HH");
                String formattedDate = dateTime.format(outputFormatter);
                String text = "<html><strong>" + user.getUsername() + "</strong>"
                        + " <em>(" + formattedDate + ")</em><br>"
                        + c.getContentText() + "</html>";
                label.setText(text);
                if (c.getImagePath() != null && !c.getImagePath().isEmpty()) {
                    ImageIcon imageIcon = new ImageIcon(c.getImagePath());
                    Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(scaledImage));
                    label.setHorizontalTextPosition(SwingConstants.RIGHT);
                }

                posts.add(label);
            }
        }
        return posts;
    }

    public static String getStatusofUser(String name) {
        loadUsersFromJson();
        String state = "online";
        for (User user : userList) {
            if (user.getUsername().equals(name)) {
                state = user.getStatus();
            }
        }
        return state;
    }

    private static void loadUsersFromJson() {
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
        loadUsersFromJson(); // Load existing users

        userList.add(user); // Add the new user to the list

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Enable pretty printing

        String json = gson.toJson(userList); // Convert the list to JSON

        try (FileWriter writer = new FileWriter(DATABASE_FILE)) {
            writer.write(json); // Save the JSON to the file
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
