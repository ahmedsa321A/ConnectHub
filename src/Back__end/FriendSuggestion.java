
package Back__end;
public class FriendSuggestion {
    //send friend request to the suggestion
     public void acceptSuggestion(User user1,User user2) 
     {//set relationship to pending, remove suggestion user1 and user2 and user2 receive request
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.PENDING);
        user1.removeSuggestion(user2.getUserId());
        user2.removeSuggestion(user1.getUserId());
        user2.receivedRequest(user1.getUserId());
        
    }
    //turn the suggestion down 
    public void RemoveSuggestion(User user1,User user2) 
    {//remove user2 from user1 suggestions
       RelationshipManager.setRelationship(user1, user2, RelationshipStatus.DONT_SUGGEST);
       user1.removeSuggestion(user2.getUserId());
    }
   
}
