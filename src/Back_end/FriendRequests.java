/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//add and get friend requests
public class FriendRequests {
    private List<User> requests = new ArrayList<>();

    public void addRequest(User user) {
        requests.add(user);
    }

    public List<User> getRequests() {
        return requests;
    }

}

