package Back__end;

import java.util.ArrayList;
import java.util.HashMap;

//search for user by Id better than list for complexity 
public class UserSearch {
    private static HashMap<String, User> userMap=new HashMap<String, User>();

    public void setAllMap(ArrayList<User> userList) {
        if (userList != null) {
            for (User user : userList) {
                userMap.put(user.getUserId(), user);
            }
        }
    }
    public HashMap<String, User> getMap(){
    
    return userMap;
    }
    public void setUserMap(HashMap<String, User> userMap) {
        this.userMap = userMap;
    }

    public User getUserById(String userId) {
        return userMap.get(userId);
    }
}