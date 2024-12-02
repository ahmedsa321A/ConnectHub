
package Back_end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

//load from file implementation
public class FriendLoader<T> implements LoadFromFile<T> {

private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Override
    public T loadFromFile(String filePath, Type typeOfT) {
         try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, typeOfT);
        } catch (IOException e) {
            throw new RuntimeException("Error loading from file: " + filePath, e);
        }
    }
    
}
