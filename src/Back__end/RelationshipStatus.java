
package Back__end;

//enum for relationships status
public enum RelationshipStatus {
    FRIENDS,
    PENDING,
    NOT_FRIENDS,
    BLOCKED;
    
     @Override
    public String toString() {
        return name().toLowerCase();
    }
}
