/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;

import java.util.ArrayList;
import java.util.List;

// add friends or return friends list
public class FriendsList {
    
    public void removeFriend(FriendUser user1,FriendUser user2)//in user first parameter is always this 
    {// second parameter going to be the user wants to remove
        Relationship relationship = new Relationship(user1, user2);
        relationship.setStatus(RelationshipStatus.NOT_FRIENDS);
        user1.removeFriend(user2);
        user2.removeFriend(user1);
    }
    
    public void blockFriend(FriendUser user1,FriendUser user2)
    {
        Relationship relationship = new Relationship(user1, user2);
        relationship.setStatus(RelationshipStatus.BLOCKED);
        user1.removeFriend(user2);
        user2.removeFriend(user1);
    }

}
