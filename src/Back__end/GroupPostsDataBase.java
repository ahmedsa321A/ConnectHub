
package Back__end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class GroupPostsDataBase {

    private static final String FILE_PATH = "group_posts.json";

    public static List<GroupPost> groupPosts = new ArrayList<>();

    public  static void addPost(GroupPost p){
    groupPosts.add(p);
    saveToJSON();
    }
    
    // Static method to save the static list of GroupPost objects to JSON
    public static void saveToJSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Create Gson with pretty printing
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(groupPosts, writer); // Write the groupPosts list to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Static method to load the static list of GroupPost objects from JSON
    public static void loadFromJSON() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<GroupPost>>() {
            }.getType();
            groupPosts = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            groupPosts = new ArrayList<>();
        }
    }

    public static GroupPost getGroupPostById(String id) {
        for (GroupPost post : groupPosts) {
            if (post.getContentId().equals(id)) {
                return post;
            }
        }
        return null; // Return null if no matching post is found
    }
    
    public static boolean removeGroupPostById(String id) {
        for (GroupPost post : groupPosts) {
            if (post.getContentId().equals(id)) {
                groupPosts.remove(post);
                saveToJSON(); // Save changes to the JSON file
                GroupDatabase.saveGroupsToJson();
                return true; // Return true if the post was removed successfully
            }
        }
        return false; // Return false if no matching post was found
    }

}

