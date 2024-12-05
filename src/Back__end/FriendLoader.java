
package Back__end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

//load from file implementation
public class FriendLoader implements LoadFromFile {

private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
@Override
public void loadFromFile(User currentUser, String filePath, Type typeOfT) {
        try (FileReader reader = new FileReader(filePath)) {
           
            List<User> users = gson.fromJson(reader, typeOfT);

            
            for (User user : users) {
                if (user.getUserId().equals(currentUser.getUserId())) {
                    
                    for (String friendID : user.getFriends()) {
                        currentUser.addFriend(friendID);
                    }

                   
                    for (String suggestionId : user.getSuggestions()) {
                        currentUser.addSuggestion(suggestionId);
                    }

                   
                    for (String requestId : user.getReceivedRequests()) {
                        currentUser.receivedRequest(requestId);
                    }
                    break; 
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading from file: " + filePath, e);
        }
    }
}