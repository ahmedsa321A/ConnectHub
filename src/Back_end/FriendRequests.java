/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//add and get friend requests
public class FriendRequests {
    

    public void sendRequest(FriendUser user1,FriendUser user2){
        Relationship relationship = new Relationship(user1, user2);
        relationship.setStatus(RelationshipStatus.PENDING);
        user1.sentRequest(user2);
        user2.receivedRequest(user2);
    }
    public void acceptRequest(FriendUser user1,FriendUser user2)
    {
         Relationship relationship = new Relationship(user1, user2);
        relationship.setStatus(RelationshipStatus.FRIENDS);
        user1.addFriend(user2);
        user1.removeSentRequest(user2);
        user2.addFriend(user1);
        user2.removeReceivedRequest(user1);
    }
    public void declineRequest(FriendUser user1,FriendUser user2)
    {
        Relationship relationship = new Relationship(user1, user2);
        relationship.setStatus(RelationshipStatus.NOT_FRIENDS);
        user1.removeSentRequest(user2);
        user2.removeReceivedRequest(user1);
    }

}

