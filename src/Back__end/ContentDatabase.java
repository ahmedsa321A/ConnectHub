package Back__end;

import static Back__end.ContentService.content;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContentDatabase {

    private static final String DATABASE_FILE = "content_db.json";
    private static final long STORY_EXPIRY_HOURS = 24;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static ArrayList<Content> contents=new ArrayList<>();
    private static ContentDatabase instance;
    
    private  ContentDatabase() {
        loadContent(); // Load content from json file
        deleteExpiredStories(); // delete expire stories
    }
     public static ContentDatabase getInstance() {//using singelton for accesing database globally
        if (instance == null) {
               instance = new ContentDatabase();
            }
        return instance;
    }

    public void loadContent() {
        try (Reader reader = new FileReader(DATABASE_FILE)) {
            Type listType = new TypeToken<List<Content>>() {
            }.getType();
            this.contents = gson.fromJson(reader, listType);
            Collections.reverse(this.contents);
            if (this.contents == null) {
                this.contents = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            this.contents = new ArrayList<>(); //return an empty list if the file doesn't exist
        } catch (IOException e) {
            e.printStackTrace();
            this.contents = new ArrayList<>();
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

    public void deleteExpiredStories() {//delete story if 24 hrs passed
        LocalDateTime now = LocalDateTime.now();
        this.contents.removeIf(content -> content.isStory()
                && LocalDateTime.parse(content.getTimestamp(), DateTimeFormatter.ISO_DATE_TIME)
                        .plusHours(STORY_EXPIRY_HOURS).isBefore(now));
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Content> contents) {
        this.contents = contents;
    }

}
