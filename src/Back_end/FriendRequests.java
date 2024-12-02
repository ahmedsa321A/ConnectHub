/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;
public class FriendRequests {
    

    public void sendRequest(FriendUser user1,FriendUser user2){
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.PENDING);
        user2.receivedRequest(user2);
    }
    public void acceptRequest(FriendUser user1,FriendUser user2)
    {
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.FRIENDS);
        user1.addFriend(user2);
        user2.addFriend(user1);
        user1.removeReceivedRequest(user2);
    }
    public void declineRequest(FriendUser user1,FriendUser user2)
    {
        RelationshipManager.setRelationship(user1, user2, RelationshipStatus.NOT_FRIENDS);
        user2.removeReceivedRequest(user1);
    }

}

