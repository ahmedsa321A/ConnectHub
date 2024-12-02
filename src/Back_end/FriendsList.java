/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;

import java.util.ArrayList;
import java.util.List;

// add friends or return friends list
public class FriendsList {
 private List<User>friends=new ArrayList<>();
  
 public void addFriend(User user) {
        friends.add(user);
    }

    public List<User> getFriends() {
        return friends;
    }
}
