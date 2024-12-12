package Back__end;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {

    private final String id;
    private final String name;
    private final String description;
    private final String groupPhotoPath;
    private final String primaryAdmin;
    private final List<String> admins;
    private final List<String> members;
    private final List<String> requests;
    private final List<String> postsId;

    // Private constructor accessible only via Builder
    private Group(GroupBuilder builder) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for the group
        this.name = builder.name;
        this.description = builder.description;
        this.groupPhotoPath = builder.groupPhotoPath;
        this.primaryAdmin = builder.primaryAdmin;
        this.admins = new ArrayList<>(builder.admins);
        this.members = new ArrayList<>(builder.members);
        this.requests = new ArrayList<>(builder.requests);
        this.postsId = new ArrayList<>(builder.postsId);
        if (!this.admins.contains(this.primaryAdmin)) {
            this.admins.add(this.primaryAdmin); // Ensure the primary admin is added to admins
        }
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGroupPhotoPath() {
        return groupPhotoPath;
    }

    public String getPrimaryAdmin() {
        return primaryAdmin;
    }

    public List<String> getAdmins() {
        return new ArrayList<>(admins);
    }

    public List<String> getMembers() {
        return new ArrayList<>(members);
    }

    public List<String> getRequests() {
        return new ArrayList<>(requests);
    }

    public List<String> getPostsId() {
        return new ArrayList<>(postsId);
    }

    // Methods for promoting/demoting admins
    public void promoteToAdmin(String user) {
        if (!admins.contains(user)) {
            admins.add(user);
        }
    }

    public void demoteAdmin(String user) {
        if (!user.equals(primaryAdmin)) {
            admins.remove(user);
        }
    }

    public void addRequest(String requestId) {
        requests.add(requestId);
    }

    public void removeRequest(String requestId) {
        requests.remove(requestId);
    }

    public void addMember(String memberId) {
        members.add(memberId);
    }

    public void removeMember(String memberId) {
        members.remove(memberId);
    }

    public void addPost(String postId) {
        postsId.add(postId);
    }

    public void removePost(String postId) {
        postsId.remove(postId);
        GroupPostsDatabase.removeGroupPostById(postId);
    }

    // Builder Class
    public static class GroupBuilder {
        private final String name;
        private final String primaryAdmin;
        private String description = "";
        private String groupPhotoPath = "";
        private List<String> admins = new ArrayList<>();
        private List<String> members = new ArrayList<>();
        private List<String> requests = new ArrayList<>();
        private List<String> postsId = new ArrayList<>();

        public GroupBuilder(String name, String primaryAdmin) {
            this.name = name;
            this.primaryAdmin = primaryAdmin;
        }

        public GroupBuilder description(String description) {
            this.description = description;
            return this;
        }

        public GroupBuilder groupPhotoPath(String groupPhotoPath) {
            this.groupPhotoPath = groupPhotoPath;
            return this;
        }

        public GroupBuilder admins(List<String> admins) {
            this.admins = admins;
            return this;
        }

        public GroupBuilder members(List<String> members) {
            this.members = members;
            return this;
        }

        public GroupBuilder requests(List<String> requests) {
            this.requests = requests;
            return this;
        }

        public GroupBuilder postsId(List<String> postsId) {
            this.postsId = postsId;
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }
}
