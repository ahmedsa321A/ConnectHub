
package Back__end;

//abstract factory design pattern for obtaining Open-close principle in user and content creation
public interface AbstractFactory {
    User createUser(String email, String username, String password, String dateOfBirth);
    Content createContent( String authorId, String contentText, String imagePath, boolean isStory);
}
