
package Back__end;


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
