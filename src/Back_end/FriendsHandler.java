/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

// handler to take type of friend operation 
// open close principle
public class FriendsHandler<T> {
      private final Class<T> clazz;

    
    public FriendsHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T data, String filePath) {
        FriendSaver<T> saver = new FriendSaver<>();
        saver.saveToFile(data, filePath);
    }

    public T load(String filePath) {
        FriendLoader<T> loader = new FriendLoader<>();
        Type type = TypeToken.get(clazz).getType();
        return loader.loadFromFile(filePath, type);
    }
}