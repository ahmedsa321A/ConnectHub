/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

public class GroupPostManger {
    
    public static void addPost(String groupPostId, String groupId){
        Group group = GroupDatabase.getGroupById(groupId);
        group.addPost(groupPostId);
        GroupPostsDataBase.saveToJSON();
        GroupDatabase.saveGroupsToJson();
    }
    
    public static void editPost(String groupPostId,String text,String photo, String groupId){
        GroupPost groupPost = GroupPostsDataBase.getGroupPostById(groupPostId);
        groupPost.setContentText(text);
        groupPost.setImagePath(photo);
        GroupPostsDataBase.saveToJSON();
    }
    
    public static void deletePost(String groupId){
        Group group = GroupDatabase.getGroupById(groupId);
        group.removePost(groupId);
    }
}
