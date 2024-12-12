
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

public class GroupMemberManger {
     private static NotificationDatabase ndb= NotificationDatabase.getInstance();
    public static void approveRequest(String id,String groupId){   
     Group g =  GroupDataBase.getGroupById(groupId);
     g.addMember(id);   
     g.removeRequest(id);
     Notification notification = new Notification.Builder().setNotificationtype("Approved")
                .setSenderuserid(groupId)
                .setReceiveruserid(id)
                .build();
                ndb.loadnotification();
                ndb.addnotification(notification);
                ndb.savenotifications();
     GroupDataBase.saveGroupsToJson();
    }
    public static void declineRequest(String id,String groupId){
     Group g =  GroupDataBase.getGroupById(groupId);
     g.removeRequest(id);
     GroupDataBase.saveGroupsToJson();
    }
    public static void removeMember(String id,String groupId){
      Group g =  GroupDataBase.getGroupById(groupId);
     g.removeMember(id);
     GroupDataBase.saveGroupsToJson();
    }
        public static void addRequest(String id,String groupId){
     Group g =  GroupDataBase.getGroupById(groupId);
     g.addRequest(id);
     GroupDataBase.saveGroupsToJson();
    }
}

