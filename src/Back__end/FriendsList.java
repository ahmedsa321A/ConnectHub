
package Back__end;
public class FriendsList {
    
    public void removeFriend(User user1,User user2)
    {// second parameter going to be the user wants to remove
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.NOT_FRIENDS);
        user1.removeFriend(user2.getUserId());
        user2.removeFriend(user1.getUserId());
        user1.addSuggestion(user2.getUserId());
        user2.addSuggestion(user1.getUserId());
    }
    
    public void blockFriend(User user1,User user2)
    {// second parameter going to be the user wants to block
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.BLOCKED);
        user1.removeFriend(user2.getUserId());
        user2.removeFriend(user1.getUserId());
        user1.addBlock(user2.getUserId());
    }

}
