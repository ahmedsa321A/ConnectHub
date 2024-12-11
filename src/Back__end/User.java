
package Back__end;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User extends UserParent {
    @SerializedName("FriendsId")
    private final List<String> friends;
    private final List<String> requestsReceived;
    private final List<String> suggestions;
    private final List<String> blocked;

    // Private constructor used by the Builder design pattern
    private User(Builder builder) {
        super(builder.userId, builder.email, builder.username, builder.password, builder.dateOfBirth, builder.status);
        this.friends = builder.friends;
        this.requestsReceived = builder.requestsReceived;
        this.suggestions = builder.suggestions;
        this.blocked = builder.blocked;
    }
    public void addFriend(String friendId) {
        if(!isFriend(friendId)) //checks if user already friend or not
        {
            friends.add(friendId); //add friend
           removeReceivedRequest(friendId); //remove request from user2
        }
    }
    public void removeFriend(String userId) {
       if(isFriend(userId)) //check if user in friends or not before removing
       {
        //remove if true   
        friends.remove(userId);
        addSuggestion(userId);
       }
    }
    public List<String> getFriendsIdArray() {
        return friends;
    }
    
     public void receivedRequest(String friendId){
       //check if user already sent a request before and if  user is already friend 
        if(!requestsReceived.contains(friendId)&& !isFriend(friendId))
        {
         //receive request from him and remove him from sussgestion if true
        requestsReceived.add(friendId);
        removeSuggestion(friendId);
        }
    }
     
     public void removeReceivedRequest(String userId) {
      //check if the requests exits first 
        if(requestsReceived.contains(userId))   
      {//if true remove it and add him to suggestion
          requestsReceived.remove(userId);
          addSuggestion(userId);
      }
    }
     
     public List<String> getReceivedRequests(){
        return requestsReceived;
    }
     public void addSuggestion(String friendId) {
         //check first if he doesnt exist in all of these lists
    if(! userService.getUser(friendId).isBlocked(this.getUserId()) &&!suggestions.contains(friendId) && !isFriend(friendId) && !isBlocked(friendId)&&!requestsReceived.contains(friendId))
        //if true add him to suggestions
        suggestions.add(friendId);
    }

    public void removeSuggestion(String userId) {
        //check if user in suggestions first
        if(suggestions.contains(userId))
        //if true remove him    
        suggestions.remove(userId);
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
    public void addBlock(String userId){
        //check if he isnt blocked
        if(!isBlocked(userId))
        //if yes block him    
        blocked.add(userId);
    }
    public void removeBlock(String userId){
        //check if already blocked
        if(isBlocked(userId))
        //remove him from block if true    
        blocked.remove(userId);
    }
    public List<String> getBlocked() {
        return blocked;
    }
    public boolean isFriend(String userId){
        return friends.contains(userId);
    }
    public boolean isBlocked(String userId)
    {
        return blocked.contains(userId);
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
    //Builder design pattern better than complex constructor
    public static class Builder {
        private final String userId;
        private final String email;
        private String username;
        private String password;
        private String dateOfBirth;
        private String status;
        private List<String> friends = new ArrayList<>();
        private List<String> requestsReceived = new ArrayList<>();
        private List<String> suggestions = new ArrayList<>();
        private List<String> blocked = new ArrayList<>();

        public Builder(String userId, String email) {
            this.userId = userId;
            this.email = email;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder addFriend(String friendId) {
            this.friends.add(friendId);
            return this;
        }

        public Builder addReceivedRequest(String request) {
            this.requestsReceived.add(request);
            return this;
        }

        public Builder addSuggestion(String suggestion) {
            this.suggestions.add(suggestion);
            return this;
        }

        public Builder addBlocked(String blockedUser) {
            this.blocked.add(blockedUser);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}


