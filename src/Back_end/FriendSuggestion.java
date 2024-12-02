/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;

import java.util.ArrayList;
import java.util.List;

//add and get suggesstions
public class FriendSuggestion {
    
     public void acceptSuggestion(FriendUser user1,FriendUser user2) {
         Relationship relationship = new Relationship(user1, user2);
         relationship.setStatus(RelationshipStatus.PENDING);
         user1.sentRequest(user2);
         user1.removeSuggestion(user2);
         user2.receivedRequest(user2);
         user2.removeSuggestion(user1);
    }

    public void RemoveSuggestion(FriendUser user1,FriendUser user2) {
       user1.removeSuggestion(user2);
    }
   
}
