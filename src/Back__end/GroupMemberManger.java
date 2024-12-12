
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

public class GroupMemberManger {

    private static NotificationDatabase ndb = NotificationDatabase.getInstance();

    public static void approveRequest(String id, String groupId) {
        Group g = GroupDatabase.getGroupById(groupId);
        g.addMember(id);
        g.removeRequest(id);
        Notification notification = new Notification.Builder().setNotificationtype("Approved")
                .setSenderuserid(groupId)
                .setReceiveruserid(id)
                .build();
        ndb.loadnotification();
        ndb.addnotification(notification);
        ndb.savenotifications();
        GroupDatabase.saveGroupsToJson();
    }

    public static void declineRequest(String id, String groupId) {
        Group g = GroupDatabase.getGroupById(groupId);
        g.removeRequest(id);
        GroupDatabase.saveGroupsToJson();
    }
    
    public static void removeMember(String id, String groupId) {
        Group g = GroupDatabase.getGroupById(groupId);
        g.demoteAdmin(id);
        g.removeMember(id);
        GroupDatabase.saveGroupsToJson();
    }

    public static void addRequest(String id, String groupId) {
        Group g = GroupDatabase.getGroupById(groupId);
        g.addRequest(id);
        GroupDatabase.saveGroupsToJson();
    }

    public static void promote(String id, String groupId) {
        Group g = GroupDatabase.getGroupById(groupId);
        g.promoteToAdmin(id);
        g.removeMember(id);
        GroupDatabase.saveGroupsToJson();
    }

    public static void demote(String id, String groupId) {
        Group g = GroupDatabase.getGroupById(groupId);
        g.demoteAdmin(id);
        g.addMember(id);
        GroupDatabase.saveGroupsToJson();
    }

}
