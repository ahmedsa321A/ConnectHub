/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;

import java.util.ArrayList;
import java.util.List;

//add and get suggesstions
public class FriendSuggesstion {
    private List<User>Suggesstions=new ArrayList<>();
    
     public void addSuggest(User user) {
        Suggesstions.add(user);
    }

    public List<User> getSuggesstions() {
        return Suggesstions;
    }
    
}
