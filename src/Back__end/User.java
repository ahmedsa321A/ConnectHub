
package Back__end;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class User extends UserParent {
    @SerializedName("FriendsId")
    private final List<String> friends;
    private final List<String> requestsReceived;
    private final List<String> suggestions;
    private final List<String> blocked;

    // Private constructor used by the Builder
    private User(Builder builder) {
        super(builder.userId, builder.email, builder.username, builder.password, builder.dateOfBirth, builder.status);
        this.friends = builder.friends;
        this.requestsReceived = builder.requestsReceived;
        this.suggestions = builder.suggestions;
        this.blocked = builder.blocked;
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
    public List<String> getFriendsIdArray() {
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
        String friendsIds = String.join(", ", friends);
        String suggestionsIds = String.join(", ", suggestions);
        String receivedRequestsIds = String.join(", ", requestsReceived);
        String blockedIds = String.join(", ", blocked);
        return super.toString() +
               ", friends IDs=[" + friendsIds + "]" +
               ", suggestions IDs=[" + suggestionsIds + "]" +
               ", receivedRequests IDs=[" + receivedRequestsIds + "]" +
               ", blocked IDs=[" + blockedIds + "]";
    }

 
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


