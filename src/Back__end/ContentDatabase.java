package Back__end;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class ContentDatabase {
    private static final String DATABASE_FILE = "content_db.json";
    private static final long STORY_EXPIRY_HOURS = 24;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private ArrayList<Content> contents;
    
    public ContentDatabase() {
        loadContent(); // Load content from JSON file
        deleteExpiredStories(); // auto delete expire stories
    }
    public void loadContent() {
        try (Reader reader = new FileReader(DATABASE_FILE)) {
            Type listType = new TypeToken<List<Content>>() {}.getType();
            this.contents=gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            this.contents= new ArrayList<>(); // Return an empty list if the file doesn't exist
        } catch (IOException e) {
            e.printStackTrace();
            this.contents= new ArrayList<>();
        }
    }
    // Save content to JSON file
    public void saveContent() {
        try (Writer writer = new FileWriter(DATABASE_FILE)) {
            gson.toJson(this.contents, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addContent(Content content) {
        this.contents.add(content);
    }
    public void deleteExpiredStories() {
        LocalDateTime now = LocalDateTime.now();
        this.contents.removeIf(content -> content.isStory() &&
                LocalDateTime.parse(content.getTimestamp(), DateTimeFormatter.ISO_DATE_TIME)
                        .plusHours(STORY_EXPIRY_HOURS).isBefore(now));
    }
    public List<Content> getContents() {
        return contents;
    }
    public void setContents(ArrayList<Content> contents) {
        this.contents = contents;
    }

   
}
