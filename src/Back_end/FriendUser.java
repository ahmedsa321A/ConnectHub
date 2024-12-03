
package Back_end;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FriendUser extends User {
     
 private List<String>friends;
 private List<String> requestsReceived;
 private List<String>suggestions;

    public FriendUser(String userId, String email, String username, String password, String dateOfBirth, String status,String photoPath) {
       super(userId, email, username, password, dateOfBirth, status,photoPath);
       friends = new ArrayList<>();
       requestsReceived = new ArrayList<>();
       suggestions =new ArrayList<>();
    }

    public void addFriend(String friendId) {
         friends.add(friendId);
    }
    public void removeFriend(String userId) {
        friends.remove(userId);
    }
    public List<String> getFriends() {
        return friends;
    }
     public void receivedRequest(String friendId){
        requestsReceived.add(friendId);
    }
     
     public void removeReceivedRequest(String userId) {
        requestsReceived.remove(userId);
    }
     
     public List<String> getReceivedRequests(){
        return requestsReceived;
    }
     public void addSuggestion(String friendId) {
        suggestions.add(friendId);
    }

    public void removeSuggestion(String userId) {
        suggestions.remove(userId);
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
   @Override
    public String toString() {
      String friendsIds = friends.stream()
                               .collect(Collectors.joining(", "));

    String suggestionsIds = suggestions.stream()
                                       .collect(Collectors.joining(", "));

    String receivedRequestsIds = requestsReceived.stream()
                                                 .collect(Collectors.joining(", "));

    // Build the string representation
    return super.toString() + 
           ", friends IDs=[" + friendsIds + "]" +
           ", suggestions IDs=[" + suggestionsIds + "]" +
           ", receivedRequests IDs=[" + receivedRequestsIds + "]";
}
}

