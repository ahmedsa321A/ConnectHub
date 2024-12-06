package Back__end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Image;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class userService {

    private static final String DATABASE_FILE = "user_db.json";

    //public static ArrayList<User> userList = new ArrayList<>();
    //static ContentDatabase content = new ContentDatabase();
    public static boolean checkIfUserExists(String email) {

        UserRepository.loadUsersFromJson();

        for (User user : UserRepository.userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    protected ImageIcon loadImageIcon(String photoPath) {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(photoPath);
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Resize to fit
            icon = new ImageIcon(resizedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icon;
    }
    public ImageIcon saveImageIconProfile(String photoPath)
    {
        ImageIcon imgicon;
        if (photoPath.equals("")) {
                imgicon = new javax.swing.ImageIcon(getClass().getResource("/icons/noprofile.png")); 
            }
        else
        {
             imgicon = new ImageIcon(photoPath);
        }
        Image image = imgicon.getImage();
        Image resizedImage = image.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Resize to fit
        imgicon = new ImageIcon(resizedImage);
        return imgicon;
    }
    public static String getStatusofUser(String name) {
        UserRepository.loadUsersFromJson();

        for (User user : UserRepository.userList) {
            if (user.getUsername().equals(name)) {
                String state = user.getStatus();
                return state;
            }
        }
        return null;

    }

    public static ArrayList<String> getPathAndName(String id) {
        ArrayList<String> data = new ArrayList<>();
        for (User u : UserRepository.userList) {
            if (u.getUserId().equals(id)) {
                data.add(u.getUsername());
                data.add(u.getProfilePhotoPath());
            }
        }
        return data;
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
        UserRepository.loadUsersFromJson(); // Load existing users
        if (!checkIfUserExists(user.getEmail())) {
            UserRepository.userList.add(user); // Add the new user to the list
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Enable pretty printing

        String json = gson.toJson(UserRepository.userList); // Convert the list to JSON

        try (FileWriter writer = new FileWriter(DATABASE_FILE)) {
            writer.write(json); // Save the JSON to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean signup(String email, String username, String password, String dateOfBirth) throws NoSuchAlgorithmException {
        // Create a factory instance
        ConcreteFactory userFactory = new ConcreteFactory();

        // Use the factory to create the User object
        User user = userFactory.createUser(email, username, password, dateOfBirth);

        // Save the user (assuming saveSignup is defined to handle saving the user data)
        saveSignup(user);

        return true;
    }

    public static User login(String email, String password) throws NoSuchAlgorithmException {
        UserRepository.loadUsersFromJson();

        String hashedPassword = hashPassword(password);

        for (User user : UserRepository.userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(hashedPassword)) {
                UserRepository.loadUsersFromJson();
                user = userService.getUser(user.getUserId());
                user.setStatus("online"); 
                UserRepository.saveData();
                return user;
            }
        }
        return null;
    }

    public static User getUser(String id) {

        for (User u : UserRepository.userList) {
            if (u.getUserId().equals(id)) {
                return u;
            }
        }
        return null;

    }

}
