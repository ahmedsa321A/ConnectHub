
package Back_end;
public class FriendRequests {
    
    public void sendRequest(User user1,User user2)
    {//set relationship to pending, remove from suggestions and user2 recieve friend request
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.PENDING);
        user1.removeSuggestion(user2.getUserId());
        user2.receivedRequest(user1.getUserId());
    }
    public void acceptRequest(User user1,User user2)
    {//set relationship to friends, add friends in both users and remove received request from user2 
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.FRIENDS);
        user1.addFriend(user2.getUserId());
        user2.addFriend(user1.getUserId());
        user1.removeReceivedRequest(user2.getUserId());
    }
    public void declineRequest(User user1,User user2)
    {//set relationship from pending back to not friends, remove request from user2 and add both to suggestions
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.NOT_FRIENDS);
        user2.removeReceivedRequest(user1.getUserId());
        user1.addSuggestion(user2.getUserId());
        user2.addSuggestion(user1.getUserId());
    }
}

