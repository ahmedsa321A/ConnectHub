
package Back__end;

import com.google.gson.annotations.SerializedName;


public class Relationship {
     @SerializedName("user1")
    private User user1;

    @SerializedName("user2")
    private User user2;

    @SerializedName("status")
    private RelationshipStatus status; //"Pending", "Friends", Not_Friends" & "Blocked"
public Relationship(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.status = RelationshipStatus.NOT_FRIENDS; //default
    }

    public RelationshipStatus getStatus() {
        return status;
    }

    public void setStatus(RelationshipStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Relationship{" +
               "user1=" + user1 +
               ", user2=" + user2 +
               ", status=" + status +
               '}';
    }
}
