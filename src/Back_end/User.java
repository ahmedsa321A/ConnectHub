package Back_end;


import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userId")
    private String userId;
    
    @SerializedName("email")
    private String email;
    
    @SerializedName("username")
    private String username;
    
    @SerializedName("password")
    private String password; 
    
    @SerializedName("dateOfBirth")
    private String dateOfBirth;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("photoPath")
    private String photoPath;
    
    public User(String userId, String email, String username, String password, String dateOfBirth, String status,String photoPath) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.photoPath=photoPath;
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
      public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public String toString() {
        return "User{" +
               "userId='" + userId + '\'' +
               ", email='" + email + '\'' +
               ", username='" + username + '\'' +
               ", dateOfBirth='" + dateOfBirth + '\'' +
               ", status='" + status + '\'' +
               ", photoPath='" + photoPath + '\'' +
               '}';
    }
}