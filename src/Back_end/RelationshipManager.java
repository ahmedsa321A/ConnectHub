
package Back_end;

import java.util.HashMap;
import java.util.Map;


public class RelationshipManager {
     private static Map<String, Relationship> relationships = new HashMap<>();

    public static void setRelationship(FriendUser user1, FriendUser user2, RelationshipStatus status) {
        String key = generateKey(user1, user2);
        relationships.put(key, new Relationship(user1, user2));
        relationships.get(key).setStatus(status);
    }

    public static RelationshipStatus getRelationshipStatus(FriendUser user1, FriendUser user2) {
        String key = generateKey(user1, user2);
        Relationship relationship = relationships.get(key);
        return relationship != null ? relationship.getStatus() : RelationshipStatus.NOT_FRIENDS;
    }

    private static String generateKey(FriendUser user1, FriendUser user2) {
    // if user 1 is friend with user 2 so the opposite is same so we dont want many keys for one relation
        return user1.getUserId().compareTo(user2.getUserId()) < 0 
            ? user1.getUserId() + "-" + user2.getUserId()
            : user2.getUserId() + "-" + user1.getUserId();
    }
}