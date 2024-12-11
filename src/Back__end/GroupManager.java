package Back__end;
import java.util.List;

public class GroupManager {

    // Add a new group to the database
    public static void addGroup(Group group) {
        List<Group> groupList = GroupDatabase.loadGroupsFromJson();
        groupList.add(group);
        GroupDatabase.saveGroupsToJson();
    }

    // Get all groups
    public static List<Group> getGroups() {
        return GroupDatabase.loadGroupsFromJson();
    }

    // Get a group by member or admin ID
    public static Group getGroupByMemberOrAdminId(String userId) {
        List<Group> groupList = GroupDatabase.loadGroupsFromJson();
        for (Group group : groupList) {
            if (group.getMembers().contains(userId) || group.getAdmins().contains(userId)) {
                return group;
            }
        }
        return null; // Return null if no group is found for the user
    }

    // Add a member to the group (only admins can add members)
    public static boolean addMember(String userId, String newMemberId, Group group) {
        if (group.getAdmins().contains(userId)) { // Ensure the user trying to add is an admin
            group.getMembers().add(newMemberId); // Add the new member without checking if they exist
            GroupDatabase.saveGroupsToJson();
            System.out.println("Member added successfully.");
            return true; // Return true when the member is added
        } else {
            System.out.println("Only admins can add members.");
            return false; // Return false if the user is not an admin
        }
    }

    // Remove a member from the group (only admins can remove members)
    public static boolean removeMember(String userId, String memberId, Group group) {
        if (group.getAdmins().contains(userId)) { // Ensure the user trying to remove is an admin
            if (group.getMembers().contains(memberId)) {
                group.getMembers().remove(memberId); // Remove the member without checking if they exist
                group.getAdmins().remove(memberId); // If the member is an admin, also remove from admins
                GroupDatabase.saveGroupsToJson();
                System.out.println("Member removed successfully.");
                return true; // Return true when the member is removed
            } else {
                System.out.println("User is not a member of the group.");
                return false; // Return false if the user is not a member
            }
        } else {
            System.out.println("Only admins can remove members.");
            return false; // Return false if the user is not an admin
        }
    }

    // Add an admin to the group (only the primary admin can add other admins)
    public static boolean addAdmin(String userId, String newAdminId, Group group) {
        if (group.getPrimaryAdmin().equals(userId)) { // Ensure the user trying to add is the primary admin
            if (!group.getAdmins().contains(newAdminId)) {
                group.getAdmins().add(newAdminId); // Add the new admin
                GroupDatabase.saveGroupsToJson();
                System.out.println("Admin added successfully.");
                return true; // Return true when the admin is added
            } else {
                System.out.println("User is already an admin.");
                return false; // Return false if the user is already an admin
            }
        } else {
            System.out.println("Only the primary admin can add other admins.");
            return false; // Return false if the user is not the primary admin
        }
    }

    // Remove an admin (only the primary admin can remove admins)
    public static boolean removeAdmin(String userId, String adminId, Group group) {
        if (group.getPrimaryAdmin().equals(userId)) { // Ensure the user trying to remove is the primary admin
            if (group.getAdmins().contains(adminId)) {
                group.demoteAdmin(adminId);
                GroupDatabase.saveGroupsToJson();
                System.out.println("Admin removed successfully.");
                return true; // Return true when the admin is removed
            } else {
                System.out.println("User is not an admin.");
                return false; // Return false if the user is not an admin
            }
        } else {
            System.out.println("Only the primary admin can remove admins.");
            return false; // Return false if the user is not the primary admin
        }
    }

    // Delete a group (only the primary admin can delete the group)
    public static boolean deleteGroup(String userId, Group group) {
        if (group.getPrimaryAdmin().equals(userId)) { // Ensure the user trying to delete is the primary admin
            group.deleteGroup();
            List<Group> groupList = GroupDatabase.loadGroupsFromJson();
            groupList.remove(group);
            GroupDatabase.saveGroupsToJson();
            System.out.println("Group deleted successfully.");
            return true; // Return true when the group is deleted
        } else {
            System.out.println("Only the primary admin can delete the group.");
            return false; // Return false if the user is not the primary admin
        }
    }
}