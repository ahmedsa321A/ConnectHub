package Back__end;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class GroupPost {

    private final String contentId;
    private final String authorId;
    private String contentText;
    private String imagePath;
    private final String timestamp;
    private final String groupID; 

    // Private constructor to enforce object creation through the builder
     GroupPost(ContentPostBuilder builder) {
        this.contentId = builder.contentId;
        this.authorId = builder.authorId;
        this.contentText = builder.contentText;
        this.imagePath = builder.imagePath;
        this.timestamp = builder.timestamp;
       this.groupID=builder.groupID;
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

    public void setContentText(String contentText){
        this.contentText=contentText;
    }
    
    public void setImagePath(String imagePath){
        this.imagePath=imagePath;
    }

    // Builder Class
    public static class ContentPostBuilder {
        private String contentId;
        private String authorId;
        private String contentText;
        private String imagePath;
        private String timestamp;
         private final String groupID;

        public ContentPostBuilder(String contentId, String authorId,String groupID) {
            this.groupID=groupID;
            this.contentId = contentId;
            this.authorId = authorId;
            this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        }

        public ContentPostBuilder setContentText(String contentText) {
            this.contentText = contentText;
            return this;
        }

        public ContentPostBuilder setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public GroupPost build() {
            return new GroupPost(this);
        }
    }
}