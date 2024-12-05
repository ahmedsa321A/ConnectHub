/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Back__end;

/**
 *
 * @author ahmed
 */
public interface AbstractFactory {
    User createUser(String email, String username, String password, String dateOfBirth);
    Content createContent( String authorId, String contentText, String imagePath, boolean isStory);
}
