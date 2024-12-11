package Back__end;


public class GroupPost extends Content {

    private final String groupId;

    public GroupPost(GroupPostBuilder builder) {
        super(builder);
        this.groupId = builder.groupId;
    }

    // Getter for groupId
    public String getGroupId() {
        return groupId;
    }

    // Builder Class
    public static class GroupPostBuilder extends Content.ContentBuilder {
        private String groupId;

        public GroupPostBuilder(String contentId, String authorId, String groupId) {
            super(contentId, authorId);
            this.groupId = groupId;
        }

        @Override
        public GroupPost build() {
            return new GroupPost(this);
        }
    }
}
