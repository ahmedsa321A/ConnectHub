package Back__end;


import Back__end.Relationship;
import Back__end.User;
import java.util.HashMap;
import java.util.Map;

public class RelationshipManager {
    private static RelationshipManager instance;
    private Map<String, Relationship> relationships = new HashMap<>();

    private RelationshipManager() {}

    public static RelationshipManager getInstance() {
        if (instance == null) {
            synchronized (RelationshipManager.class) {
                if (instance == null) {
                    instance = new RelationshipManager();
                }
            }
        }
        return instance;
    }

    public void setRelationship(User user1, User user2, RelationshipStatus status) {
        String key = generateKey(user1, user2);
        relationships.put(key, new Relationship(user1, user2));
        relationships.get(key).setStatus(status);
    }

    public RelationshipStatus getRelationshipStatus(User user1, User user2) {
        String key = generateKey(user1, user2);
        Relationship relationship = relationships.get(key);
        return relationship != null ? relationship.getStatus() : RelationshipStatus.NOT_FRIENDS;
    }

    private String generateKey(User user1, User user2) {
        return user1.getUserId().compareTo(user2.getUserId()) < 0
            ? user1.getUserId() + "-" + user2.getUserId()
            : user2.getUserId() + "-" + user1.getUserId();
    }
}