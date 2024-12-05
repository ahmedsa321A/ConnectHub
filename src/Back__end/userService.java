package Back__end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class userService {

    private static final String DATABASE_FILE = "user_db.json";

    public static ArrayList<User> userList = new ArrayList<>();
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

    public static ArrayList<JPanel> getPosts(User user) {
        content.loadContent();
        ArrayList<JPanel> posts = new ArrayList<>();
        for (Content c : content.getContents()) {
            if (c.getAuthorId().equals(user.getUserId()) && !c.isStory()) { //change userid
                posts.add(createContentPanel(c));

            }
        }
        return posts;
    }

    public static ArrayList<JPanel> getPostsOfFriends(User user) {
        ArrayList<JPanel> posts = new ArrayList<>();
        content.loadContent();
        for (String id : user.getFriendsIdArray()) {
                    for (Content c : content.getContents()) {
                        if(c.getAuthorId().equals(id))
                        posts.add(createContentPanel(c));
                    }
                
            
        }
        return posts;
    }


    public static JPanel createContentPanel(Content content) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Text content
        JLabel authorId = new JLabel("Author: " + content.getAuthorId());
        JLabel contentText = new JLabel("<html><b>" + content.getContentText() + "</b></html>");
        String[] date = content.getTimestamp().split("T");
        String Date = date[0];
        LocalDate D = LocalDate.parse(Date, DateTimeFormatter.ISO_DATE);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        String formattedDate = D.format(outputFormatter);
        JLabel timestamp = new JLabel(formattedDate);

        // Arrange text in a vertical panel
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(authorId);
        textPanel.add(contentText);
        textPanel.add(timestamp);

        // Image content
        ImageIcon icon = new ImageIcon(content.getImagePath());
        Image scaledImage = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledimage = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledimage);

        // Combine text and image in a single panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(textPanel, BorderLayout.NORTH);
        contentPanel.add(imageLabel, BorderLayout.CENTER);

        // Add combined panel to the main panel
        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
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
    
    public static ArrayList<String> getPathAndName(String id) {
        ArrayList<String> data = new ArrayList<>();
        for(User u:userList){
            if(u.getUserId().equals(id)){
                data.add(u.getUsername());
                data.add(u.getUsername());
            }
        }
        return data;
    }

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

    public static void saveSignup(User user) {
        loadUsersFromJson(); // Load existing users
        if(!checkIfUserExists(user.getEmail()))
        userList.add(user); // Add the new user to the list

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Enable pretty printing

        String json = gson.toJson(userList); // Convert the list to JSON

        try (FileWriter writer = new FileWriter(DATABASE_FILE)) {
            writer.write(json); // Save the JSON to the file
        } catch (IOException e) {
            e.printStackTrace();
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

    public static boolean signup(String email, String username, String password, String dateOfBirth) throws NoSuchAlgorithmException {

        String hashedPassword = hashPassword(password);

        String userId = UUID.randomUUID().toString();

        User user = new User(userId, email, username, hashedPassword, dateOfBirth, "offline");

        saveSignup(user);

        return true;
    }

    public static User login(String email, String password) throws NoSuchAlgorithmException {
        loadUsersFromJson();

        String hashedPassword = hashPassword(password);

        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(hashedPassword)) {
                return user;
            }
        }
        return null;
    }

}
