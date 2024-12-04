/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;


public class BlockedFriends {
    public void unBlockFriend(FriendUser user1,FriendUser user2)
    {
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.NOT_FRIENDS);
        user1.removeBlock(user2.getUserId());
        user1.addSuggestion(user2.getUserId());
        user2.addSuggestion(user1.getUserId());
    }
}
