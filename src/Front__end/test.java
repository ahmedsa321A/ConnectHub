/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front__end;

import Back__end.Group;
import Back__end.GroupDatabase;
import Back__end.GroupMemberManger;

/**
 *
 * @author ahmed
 */
public class test {
      public static void main(String[] args) {
        GroupDatabase.loadGroupsFromJson();
        
        Group g= GroupDatabase.getGroups().get(0);
        GroupMemberManger.approveRequest("dsadasd", g.getId());
        GroupDatabase.saveGroupsToJson();
         //GroupMemberManger.approveRequest(,g.getId());
        
          
    }
}
