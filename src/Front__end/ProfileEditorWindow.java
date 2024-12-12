package Front__end;

import Back__end.Photo;
import Back__end.User;
import Back__end.UserRepository;
import Back__end.userService;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class ProfileEditorWindow extends javax.swing.JDialog {

    private User profile;
    private String newPhotoPath;
    private String newCoverPath;
    private String newPassword;

    public ProfileEditorWindow(java.awt.Frame parent, User profile, boolean modal) {
        super(parent, modal);
        initComponents();
        this.profile = profile;
        this.newPhotoPath = this.profile.getProfilePhotoPath();
        this.newCoverPath = this.profile.getCoverPhotoPath();
        this.newPassword = this.profile.getPassword();
        if (!profile.getProfilePhotoPath().equals("")) {
            Photo.setPhoto(profilePictureLabel, profile.getProfilePhotoPath());
        }
        if (!profile.getCoverPhotoPath().equals("")) {
            Photo.setPhoto(coverPhotoLabel, profile.getCoverPhotoPath());
        }
        bioTextArea2.setText(profile.getBio());
        this.setVisible(modal);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changePictureButton = new javax.swing.JButton();
        changePhotoButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        coverPhotoLabel = new javax.swing.JLabel();
        profilePictureLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioTextArea2 = new Back__end.MyTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Profile change");
        setBackground(new java.awt.Color(51, 153, 255));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        changePictureButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        changePictureButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editprofile.png"))); // NOI18N
        changePictureButton.setText("Change Picture");
        changePictureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePictureButtonActionPerformed(evt);
            }
        });

        changePhotoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        changePhotoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        changePhotoButton.setText("Change Photo");
        changePhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePhotoButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        changePasswordButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        changePasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup password.png"))); // NOI18N
        changePasswordButton.setText("Change Password");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Profile picture ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cover photo ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Bio");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Password");

        coverPhotoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noimage.png"))); // NOI18N

        profilePictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noprofile.png"))); // NOI18N

        bioTextArea2.setColumns(20);
        bioTextArea2.setRows(5);
        bioTextArea2.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bio.png"))); // NOI18N
        bioTextArea2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bioTextArea2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bioTextArea2FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(bioTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel4)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(changePhotoButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(changePictureButton)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(coverPhotoLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(profilePictureLabel)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(profilePictureLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changePictureButton)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(changePhotoButton)
                        .addGap(118, 118, 118)
                        .addComponent(jLabel3)
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(coverPhotoLabel)
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changePictureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePictureButtonActionPerformed
        try {
            String newPhotoPath = Photo.selectPhoto(profilePictureLabel, this);
            if (!newPhotoPath.equals(null)) {
                Photo.setPhoto(profilePictureLabel, newPhotoPath);
                this.newPhotoPath = newPhotoPath;
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_changePictureButtonActionPerformed

    private void changePhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePhotoButtonActionPerformed
        try {
            String newCoverPath = Photo.selectPhoto(coverPhotoLabel, this);
            if (!newCoverPath.equals(null)) {
                Photo.setPhoto(coverPhotoLabel, newCoverPath);
                this.newCoverPath = newCoverPath;
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_changePhotoButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        User user=userService.getUser(this.profile.getUserId());
        user.setProfilePhotoPath(newPhotoPath);
        user.setCoverPhotoPath( newCoverPath);
        user.setBio(bioTextArea2.getText());
        String hashedPassword;
        try {
            if (!this.newPassword.equals(this.profile.getPassword())) {
                hashedPassword = userService.hashPassword(newPassword);
                user.setPassword(hashedPassword);
            }
        } catch (NoSuchAlgorithmException ex) {
        }
         UserRepository.saveData();
         JOptionPane.showMessageDialog(this, "all changes have changed Successfully ","Successful", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        try {
            String newPassword = ChangePasswordWindow.newPassword(this, profile.getPassword());
            if (!newPassword.equals(null)) {
                this.newPassword = newPassword;
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    private void bioTextArea2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bioTextArea2FocusGained

    }//GEN-LAST:event_bioTextArea2FocusGained

    private void bioTextArea2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bioTextArea2FocusLost
 
    }//GEN-LAST:event_bioTextArea2FocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
 
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

    }//GEN-LAST:event_formWindowLostFocus


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Back__end.MyTextArea bioTextArea2;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton changePhotoButton;
    private javax.swing.JButton changePictureButton;
    private javax.swing.JLabel coverPhotoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel profilePictureLabel;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
