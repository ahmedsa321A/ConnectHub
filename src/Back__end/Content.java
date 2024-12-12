package Back__end;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Content {

    private final String contentId;
    private final String authorId;
    private final String contentText;
    private final String imagePath;
    private final String timestamp;
    private final boolean isStory;

    // Private constructor to enforce object creation through the builder
     Content(ContentBuilder builder) {
        this.contentId = builder.contentId;
        this.authorId = builder.authorId;
        this.contentText = builder.contentText;
        this.imagePath = builder.imagePath;
        this.timestamp = builder.timestamp;
        this.isStory = builder.isStory;
    }

    // Getters
    public String getContentId() {
        return contentId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getContentText() {
        return contentText;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public boolean isStory() {
        return isStory;
    }

    // Builder Class
    public static class ContentBuilder {
        private String contentId;
        private String authorId;
        private String contentText;
        private String imagePath;
        private String timestamp;
        private boolean isStory;

        public ContentBuilder(String contentId, String authorId) {
            this.contentId = contentId;
            this.authorId = authorId;
            this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        }

        public ContentBuilder setContentText(String contentText) {
            this.contentText = contentText;
            return this;
        }

        public ContentBuilder setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public ContentBuilder setIsStory(boolean isStory) {
            this.isStory = isStory;
            return this;
        }

        public Content build() {
            return new Content(this);
        }
    }
}
