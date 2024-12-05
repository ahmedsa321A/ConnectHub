package Back_end;

import java.util.HashMap;

public class UserSearch {
    private HashMap<String, FriendUser> userMap;

    public void setUserMap(HashMap<String, FriendUser> userMap) {
        this.userMap = userMap;
    }

    public FriendUser getUserById(String userId) {
        return userMap.get(userId);
    }
}