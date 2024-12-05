/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed
 */
public class ConcreteFactory implements AbstractFactory {
        public User createUser(String email, String username, String password, String dateOfBirth){
        String userId = UUID.randomUUID().toString();
            try {
                return new User.Builder(userId, email)
                        .setUsername(username)
                        .setPassword(userService.hashPassword(password))
                        .setDateOfBirth(dateOfBirth)
                        .setStatus("offline")
                        .build();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ConcreteFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
    }

    @Override
    public Content createContent(String userId, String text, String photoPath, boolean isStory) {
        String contentId = UUID.randomUUID().toString();

        return new Content.ContentBuilder(contentId, userId)
                .setContentText(text)
                .setImagePath(photoPath)
                .setIsStory(isStory)
                .build();
    }
}
