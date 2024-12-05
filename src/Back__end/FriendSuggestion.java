/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;
public class FriendSuggestion {
    
     public void acceptSuggestion(User user1,User user2) {
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.PENDING);
        user1.removeSuggestion(user2.getUserId());
        user2.removeSuggestion(user1.getUserId());
        user2.receivedRequest(user1.getUserId());
        
    }

    public void RemoveSuggestion(User user1,User user2) {
       user1.removeSuggestion(user2.getUserId());
    }
   
}
