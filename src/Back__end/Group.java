package Back__end;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {

    private String id;
    private String name;
    private String description;
    private String groupPhoto;
    private String primaryAdmin;
    private List<String> admins;
    private List<String> members;
    private List<String> requests;
    private List<String> postsId;

    public Group(String name, String description, String groupPhoto, String primaryAdmin) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for the group
        this.name = name;
        this.description = description;
        this.groupPhoto = groupPhoto;
        this.primaryAdmin = primaryAdmin;
        this.admins = new ArrayList<>();
        this.members = new ArrayList<>();
        this.requests=new ArrayList<>();
        this.postsId=new ArrayList<>();
        this.admins.add(primaryAdmin); // Primary admin is automatically an admin
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public List<String> getMembers() {
        return members;
    }

    public List<String> getAdmins() {
        return admins;
    }

    public String getPrimaryAdmin() {
        return primaryAdmin;
    }

    // Methods for promoting/demoting admins
    public void promoteToAdmin(String user) {
        admins.add(user);
    }

    public void demoteAdmin(String user) {
        admins.remove(user);
    }

    public void removeRequest(String requestId) {
        requests.remove(requestId);
    }

    public void addRequest(String requestId) {
        requests.add(requestId);
    }
    
    public void removeMember(String memberId) {
        requests.remove(memberId);
    }
    public void addMember(String memberId) {
        members.add(memberId);
    }

    public void addPost(String postId) {
        postsId.add(postId);
    }
    
    public void removePost(String postId){
        postsId.remove(postId);
        //GroupMemberDatabase
        GroupPostsDataBase.removeGroupPostById(postId);
    }
}
