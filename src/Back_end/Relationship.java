
package Back_end;

import com.google.gson.annotations.SerializedName;


public class Relationship {
     @SerializedName("user1")
    private FriendUser user1;

    @SerializedName("user2")
    private FriendUser user2;

    @SerializedName("status")
    private RelationshipStatus status; //"Pending", "Friends", Not_Friends" & "Blocked"
public Relationship(FriendUser user1, FriendUser user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.status = RelationshipStatus.NOT_FRIENDS; //default
    }

    public FriendUser getUser1() {
        return user1;
    }

    public void setUser1(FriendUser user1) {
        this.user1 = user1;
    }

    public FriendUser getUser2() {
        return user2;
    }

    public void setUser2(FriendUser user2) {
        this.user2 = user2;
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
