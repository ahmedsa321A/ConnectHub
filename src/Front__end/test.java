/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front__end;

import Back__end.Group;
import Back__end.GroupDataBase;
import Back__end.GroupMemberManger;
import Back__end.GroupPost;
import Back__end.GroupPostManger;
import Back__end.GroupPostsDataBase;

/**
 *
 * @author ahmed
 */
public class test {
      public static void main(String[] args) {
        //  Group p= new Group("das","Dsad","Dsadd","dsada");  
        //                  GroupDataBase.addGroup(p);
        //                  GroupDataBase.saveGroupsToJson();
        GroupDataBase.loadGroupsFromJson();
        GroupPostsDataBase.loadFromJSON();
        Group g=GroupDataBase.getGroups().get(0);
        GroupPost p =GroupPostsDataBase.groupPosts.get(0);
       GroupPostManger.deletePost(g.getId(),p.getContentId());
         //GroupMemberManger.approveRequest(,g.getId());
        
          
    }
}
