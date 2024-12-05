
package Back__end;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class User extends UserParent {
 //updated version of user where it adds these 4 lists    
 private List<String>friends;
 private List<String> requestsReceived;
 private List<String>suggestions;
 private List<String>blocked;

    public User(String userId, String email, String username, String password, String dateOfBirth, String status) {
       super(userId, email, username, password, dateOfBirth, status);
       friends = new ArrayList<>();
       requestsReceived = new ArrayList<>();
       suggestions =new ArrayList<>();
       blocked=new ArrayList<>();
    }
    
    public void addFriend(String friendId) {
        if(!friends.contains(friendId)) //checks if user already friend or not
        {
            friends.add(friendId); //add friend
           removeReceivedRequest(friendId); //remove request from user2
        }
        else
        {
        JOptionPane.showMessageDialog(null, "User is already a friend.", "Validation Error", JOptionPane.ERROR_MESSAGE);    
        return;
        }
    }
    public void removeFriend(String userId) {
       
        friends.remove(userId);
        addSuggestion(userId);
    }
    public List<String> getFriends() {
        return friends;
    }
    
     public void receivedRequest(String friendId){
         if (requestsReceived.contains(friendId)) //checks if user already in requests
         {
            JOptionPane.showMessageDialog(null, "Friend request already received from this user.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (friends.contains(friendId)) {
            JOptionPane.showMessageDialog(null, "User is already a friend.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        requestsReceived.add(friendId);
        if(suggestions.contains(friendId))
        removeSuggestion(friendId);
        
    }
     
     public void removeReceivedRequest(String userId) {
        requestsReceived.remove(userId);
        addSuggestion(userId);
    }
     
     public List<String> getReceivedRequests(){
        return requestsReceived;
    }
     public void addSuggestion(String friendId) {
    if(!suggestions.contains(friendId) && !friends.contains(friendId) && !blocked.contains(friendId)&&!requestsReceived.contains(friendId))
        suggestions.add(friendId);
    }

    public void removeSuggestion(String userId) {
        suggestions.remove(userId);
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
    public void addBlock(String userId){
        if(blocked.contains(userId))
        {
          JOptionPane.showMessageDialog(null, "User already bolcked.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;  
        }
        blocked.add(userId);
    }
    public void removeBlock(String userId){
        if(!blocked.contains(userId))
        {
            JOptionPane.showMessageDialog(null, "User is not even bolcked.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        blocked.remove(userId);
    }
    public List<String> getBlocked() {
        return blocked;
    }
   @Override
    public String toString() {
    String friendsIds = friends.stream().collect(Collectors.joining(", "));
    String suggestionsIds = suggestions.stream().collect(Collectors.joining(", "));
    String receivedRequestsIds = requestsReceived.stream().collect(Collectors.joining(", "));
    String blockedIds = blocked.stream().collect(Collectors.joining(", "));
    return super.toString() + 
           ", friends IDs=[" + friendsIds + "]" +
           ", suggestions IDs=[" + suggestionsIds + "]" +
           ", receivedRequests IDs=[" + receivedRequestsIds + "]"+
           ", Blocked IDs=[" + blockedIds + "]" ;
    
}
}

