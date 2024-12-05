package Back__end;


import java.util.ArrayList;
import java.util.HashMap;

public class UserSearch {
    public static HashMap<String, User> userMap=new HashMap<>(); //hash map
        private static final String DATABASE_FILE = "user_db.json";
    public void setAllMap(ArrayList<User> userList) {
        if (userList != null) {
            for (User user : userList) {
                userMap.put(user.getUserId(), user);
            }
        }
    }
    public void setUserMap(HashMap<String, User> userMap) {
        this.userMap = userMap;
    }

    public User getUserById(String userId) {
        return userMap.get(userId);
    }
    
}