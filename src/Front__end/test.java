/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front__end;

import Back__end.Group;
import Back__end.GroupManager;

/**
 *
 * @author ahmed
 */
public class test {
      public static void main(String[] args) {
        Group g= GroupManager.getGroupByMemberOrAdminId("123");
        GroupManager.removeAdmin("123","sddsd",g);
          
    }
}
