/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

public class GroupPostManger {
    private static NotificationDatabase ndb= NotificationDatabase.getInstance();
    public static void addPost(GroupPost p, String groupId){
        GroupDatabase.loadGroupsFromJson();
        Group group = GroupDatabase.getGroupById(groupId);
        GroupPostsDataBase.addPost(p);
        group.addPost(p.getContentId());
        Notification notification = new Notification.Builder().setNotificationtype("Post")
                .setSenderuserid(groupId)
                .setReceiveruserid(p.getAuthorId())
                .build();
                ndb.loadnotification();
                ndb.addnotification(notification);
                ndb.savenotifications();
        GroupDatabase.saveGroupsToJson();
    }
    
    public static void editPost(String groupPostId,String text,String photo, String groupId){
        GroupPost groupPost = GroupPostsDataBase.getGroupPostById(groupPostId);
        groupPost.setContentText(text);
        groupPost.setImagePath(photo);
        GroupPostsDataBase.saveToJSON();
    }
    
    public static void deletePost(String groupId,String postID){
        Group group = GroupDatabase.getGroupById(groupId);
        group.removePost(postID);
    }
}
