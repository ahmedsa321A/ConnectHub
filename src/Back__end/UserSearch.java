package Back__end;

import java.util.HashMap;

public class UserSearch {
    private HashMap<String, User> userMap;

    
    public void setUserMap(HashMap<String, User> userMap) {
        this.userMap = userMap;
    }

    public User getUserById(String userId) {
        return userMap.get(userId);
    }
}