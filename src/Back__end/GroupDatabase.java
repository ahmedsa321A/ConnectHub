package Back__end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GroupDatabase {
    private static final String DATABASE_FILE = "groups.json";
    private static List<Group> groupList = new ArrayList<>(); // Static list to store groups

    // Load groups from JSON file
    public static List<Group> loadGroupsFromJson() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(DATABASE_FILE)) {
            Type groupListType = new TypeToken<List<Group>>() {}.getType();
            groupList = gson.fromJson(reader, groupListType);
            if (groupList == null) {
                groupList = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return groupList;
    }

    // Save groups to JSON file
    public static void saveGroupsToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(groupList);
        try (FileWriter writer = new FileWriter(DATABASE_FILE)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a new group to the database
    public static void addGroup(Group group) {
        groupList.add(group);
        saveGroupsToJson();
    }

    // Get all groups
    public static List<Group> getGroups() {
        return groupList;
    }

    // Get a group by ID
    public static Group getGroupById(String id) {
        for (Group group : groupList) {
            if (group.getId().equals(id)) {
                return group;
            }
        }
        return null; // Return null if no group is found with the given ID
    }
    public static void deleteGroupById(String id) {
    Group groupToDelete = null;
    for (Group group : groupList) {
        if (group.getId().equals(id)) {
            groupToDelete = group;
            break;
        }
    }

    if (groupToDelete != null) {
        groupList.remove(groupToDelete);
        saveGroupsToJson(); 
    }
   }
}