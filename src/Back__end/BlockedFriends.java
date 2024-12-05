
package Back__end;


public class BlockedFriends {
    public void unBlockFriend(User user1,User user2)
    {//set relation back to not friends , remove from block and add as suggestion
        RelationshipManager.getInstance().setRelationship(user1, user2, RelationshipStatus.NOT_FRIENDS);
        user1.removeBlock(user2.getUserId());
        user1.addSuggestion(user2.getUserId());
        user2.addSuggestion(user1.getUserId());
    }
}
