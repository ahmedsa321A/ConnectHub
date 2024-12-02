
package Back__end;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Content {
    private String contentId;
    private String authorId;
    private String contentText;
    private String imagePath; // Path to the image
    private String timestamp; // Stored as a string
    private boolean isStory;

    public Content(String contentId, String authorId, String contentText, String imagePath, boolean isStory) {
        this.contentId = contentId;
        this.authorId = authorId;
        this.contentText = contentText;
        this.imagePath = imagePath;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        this.isStory = isStory;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isStory() {
        return isStory;
    }

    public void setStory(boolean stutes) {
        isStory = stutes;
    }
}
