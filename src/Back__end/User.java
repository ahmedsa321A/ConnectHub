/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class User {
    @SerializedName("userId")
    private String userId;
    
    @SerializedName("email")
    private String email;
    
    @SerializedName("username")
    private String username;
    
    @SerializedName("password")
    private String password; // hashed password
    
    @SerializedName("dateOfBirth")
    private String dateOfBirth;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("profilePhotoPath")
    private String profilePhotoPath;
    
    @SerializedName("coverPhotoPath")
    private String coverPhotoPath;
    
    @SerializedName("bio")
    private String bio;
    
    @SerializedName("friends")
    ArrayList<String> friends=new ArrayList<>();
    
    @SerializedName("contentId")
    ArrayList<String> contentId=new ArrayList<>();
    
    
    public User(String userId, String email, String username, String password, String dateOfBirth, String status) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setProfilePhotoPath(String profilePhotoPath){
        this.profilePhotoPath=profilePhotoPath;
    }
    
    public void setCoverPhotoPath(String coverPhotoPath){
        this.coverPhotoPath=coverPhotoPath;
    }
    
    public void setBio(String bio){
        this.bio=bio;
    }
    
    public String getProfilePhotoPath(){
        return this.profilePhotoPath;
    }
    
    public String getCoverPhotoPath(){
        return this.coverPhotoPath;
    }
    
    public String getBio(){
        return this.bio;    
    }
    
    public void addFriend(String name){
        this.friends.add(name);
    }
    
    public void addContentId(String id){
        this.contentId.add(id);
    }
    
}

