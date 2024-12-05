package Back__end;

import java.util.ArrayList;
import java.util.HashMap;

public class UserSearch {
    private static HashMap<String, User> userMap=new HashMap<String, User>();

    public void setAllMap(ArrayList<User> userList) {
        if (userList != null) {
            for (User user : userList) {
                //System.out.println(user.getUserId());
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