
package Back__end;


public class Profile {
    private String profilePhotoPath;
    private String coverPhotoPath;
    private String bio;
    private String password;

    public void setProfilePhotoPath(String profilePhotoPath){
        this.profilePhotoPath=profilePhotoPath;
    }
    
    public void setCoverPhotoPath(String coverPhotoPath){
        this.coverPhotoPath=coverPhotoPath;
    }
    
    public void setBio(String bio){
        this.bio=bio;
    }
    
    public void setPassword(String password){
        this.password=password;
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
    
    public String getPassword(){
        return this.password;
    }
}
