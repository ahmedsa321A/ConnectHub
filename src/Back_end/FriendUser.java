
package Back_end;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class FriendUser extends User {
   
    @SerializedName("photoPath")
    private String photoPath;
    
 private List<FriendUser>friends=new ArrayList<>();
 private List<FriendUser> requestsSent = new ArrayList<>();
 private List<FriendUser> requestsReceived = new ArrayList<>();
 private List<FriendUser>suggestions=new ArrayList<>();

    public FriendUser(String userId,String username,String photoPath) {
        super();
       
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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
    public void sentRequest(FriendUser user){
        requestsSent.add(user);
    }
    public void removeSentRequest(FriendUser user) {
        requestsSent.remove(user);
    }
    public List<FriendUser> getSentRequests(){
        return requestsSent;
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

    // Remove a suggestion
    public void removeSuggestion(FriendUser user) {
        suggestions.remove(user);
    }

    // Get the list of suggestions
    public List<FriendUser> getSuggestions() {
        return suggestions;
    }
   @Override
     public String toString() {
        return "FriendUser{" +
               "userId='" + userId + '\'' +
               ", username='" + username + '\'' +
               ", photoPath='" + photoPath + '\'' +
               '}';
    }
}

