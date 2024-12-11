/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

public class GroupMemberManger {
    public static void approveRequest(String id,String groupId){   
     Group g =  GroupDatabase.getGroupById(groupId);
     g.addMember(id);
     g.removeRequest(id);
     GroupDatabase.saveGroupsToJson();
    }
    public static void declineRequest(String id,String groupId){
     Group g =  GroupDatabase.getGroupById(groupId);
     g.removeRequest(id);
     GroupDatabase.saveGroupsToJson();
    }
    public static void removeMember(String id,String groupId){
      Group g =  GroupDatabase.getGroupById(groupId);
     g.(id);
     GroupDatabase.saveGroupsToJson();
    }
    
}
