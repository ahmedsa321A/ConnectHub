package Front__end;

import Back__end.Photo;
import Back__end.User;
import Back__end.userService;
import java.security.NoSuchAlgorithmException;

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
        bioTextArea.setText(profile.getBio());
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
        bioTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        changePictureButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        changePictureButton.setText("Change Picture");
        changePictureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePictureButtonActionPerformed(evt);
            }
        });

        changePhotoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        changePhotoButton.setText("Change Photo");
        changePhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePhotoButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        changePasswordButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        changePasswordButton.setText("Change Password");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Profile picture ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Cover photo ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Bio");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Password");

        coverPhotoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connecthub/noimage.png"))); // NOI18N

        profilePictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connecthub/noprofile.png"))); // NOI18N

        bioTextArea.setColumns(20);
        bioTextArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bioTextArea.setRows(5);
        jScrollPane1.setViewportView(bioTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(109, 109, 109)
                            .addComponent(changePasswordButton))
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(173, 173, 173)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(saveButton)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changePictureButton)
                            .addComponent(jLabel1)
                            .addComponent(changePhotoButton)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profilePictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coverPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(changePictureButton))
                    .addComponent(profilePictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coverPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(changePhotoButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(changePasswordButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addContainerGap())
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
        this.profile.setProfilePhotoPath(newPhotoPath);
        this.profile.setCoverPhotoPath(newCoverPath);
        this.profile.setBio(bioTextArea.getText());
        String hashedPassword;
        try {
            if (!this.newPassword.equals(this.profile.getPassword())) {
                hashedPassword = userService.hashPassword(newPassword);
                this.profile.setPassword(hashedPassword);
            }
        } catch (NoSuchAlgorithmException ex) {
        }
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bioTextArea;
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
