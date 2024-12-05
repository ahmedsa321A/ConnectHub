
package Back__end;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User extends UserParent {
 //updated version of user where it adds these 4 lists    

 private ArrayList<String> friends;
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
    }
    public void removeFriend(String userId) {
       if(friends.contains(userId))
       {     
        friends.remove(userId);
        addSuggestion(userId);
       }
    }
    public List<String> getFriendsIdArray() {
        return friends;
    }
    
     public void receivedRequest(String friendId){
       
        if(!requestsReceived.contains(friendId))
        requestsReceived.add(friendId);
        if(suggestions.contains(friendId))
        removeSuggestion(friendId);
        
    }
     
     public void removeReceivedRequest(String userId) {
      if(requestsReceived.contains(userId))   
      {
          requestsReceived.remove(userId);
          addSuggestion(userId);
      }
    }
     
     public List<String> getReceivedRequests(){
        return requestsReceived;
    }
     public void addSuggestion(String friendId) {
    if(!suggestions.contains(friendId) && !friends.contains(friendId) && !blocked.contains(friendId)&&!requestsReceived.contains(friendId))
        suggestions.add(friendId);
    }

    public void removeSuggestion(String userId) {
        if(suggestions.contains(userId))
        suggestions.remove(userId);
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
    public void addBlock(String userId){
        if(!blocked.contains(userId))
        blocked.add(userId);
    }
    public void removeBlock(String userId){
        if(blocked.contains(userId))
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

