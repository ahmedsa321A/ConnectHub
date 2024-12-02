
package Back_end;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FriendUser extends User {
   
    
 private List<FriendUser>friends=new ArrayList<>();
 private List<FriendUser> requestsReceived = new ArrayList<>();
 private List<FriendUser>suggestions=new ArrayList<>();

    public FriendUser(String userId, String email, String username, String password, String dateOfBirth, String status,String photoPath) {
       super(userId, email, username, password, dateOfBirth, status,photoPath);
    }

    public void addFriend(FriendUser user) {
         friends.add(user);
    }
    public void removeFriend(FriendUser user) {
        friends.remove(user);
    }
    public List<FriendUser> getFriends() {
        return friends;
    }
     public void receivedRequest(FriendUser user){
        requestsReceived.add(user);
    }
     
     public void removeReceivedRequest(FriendUser user) {
        requestsReceived.remove(user);
    }
     
     public List<FriendUser> getReceivedRequests(){
        return requestsReceived;
    }
     public void addSuggestion(FriendUser user) {
        suggestions.add(user);
    }

    public void removeSuggestion(FriendUser user) {
        suggestions.remove(user);
    }

    public List<FriendUser> getSuggestions() {
        return suggestions;
    }
   @Override
    public String toString() {
        //  list of userIds for each list (friends, suggestions, requestsReceived)
        String friendsIds = friends.stream()
                                   .map(friend -> friend.getUserId())
                                   .collect(Collectors.joining(", "));
        String suggestionsIds = suggestions.stream()
                                           .map(suggestion -> suggestion.getUserId())
                                           .collect(Collectors.joining(", "));
        String receivedRequestsIds = requestsReceived.stream()
                                                     .map(request -> request.getUserId())
                                                     .collect(Collectors.joining(", "));

        return super.toString() +
               ", friendsIds=[" + friendsIds + "]" +
               ", suggestionsIds=[" + suggestionsIds + "]" +
               ", receivedRequestsIds=[" + receivedRequestsIds + "]";
    }
}

