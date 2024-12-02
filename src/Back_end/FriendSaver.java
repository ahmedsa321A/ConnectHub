
package Back_end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;


public class FriendSaver<T> implements SaveToFile<T> {
    
private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public void saveToFile(T data, String filePath) {
       try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error saving to file: " + filePath, e);
        }
    }
    
}
