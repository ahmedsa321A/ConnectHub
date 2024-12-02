
package Back_end;
public class FriendsList {
    
    public void removeFriend(FriendUser user1,FriendUser user2)//in user first parameter is always this 
    {// second parameter going to be the user wants to remove
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.NOT_FRIENDS);
        user1.removeFriend(user2);
        user2.removeFriend(user1);
    }
    
    public void blockFriend(FriendUser user1,FriendUser user2)
    {
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.BLOCKED);
        user1.removeFriend(user2);
        user2.removeFriend(user1);
    }

}
