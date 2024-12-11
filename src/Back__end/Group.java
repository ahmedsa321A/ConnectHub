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

    // Constructor
    public Group(String name, String description, String groupPhoto, String primaryAdmin) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for the group
        this.name = name;
        this.description = description;
        this.groupPhoto = groupPhoto;
        this.primaryAdmin = primaryAdmin;
        this.admins = new ArrayList<>();
        this.members = new ArrayList<>();
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
        if (members.contains(user) && !admins.contains(user)) {
            admins.add(user);
        }
    }

    public void demoteAdmin(String user) {
        if (!user.equals(primaryAdmin)) {
            admins.remove(user);
        } else {
            System.out.println("Primary admin cannot be demoted.");
        }
    }

    public void deleteGroup() {
        admins.clear();
        members.clear();
        System.out.println("Group deleted.");
    }
}
