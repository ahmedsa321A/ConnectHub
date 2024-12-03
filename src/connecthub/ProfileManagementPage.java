package connectHub;

import Back__end.Photo;
import Back__end.User;
import javax.swing.ImageIcon;

public class ProfileManagementPage extends javax.swing.JFrame {

    private User profile;

    public ProfileManagementPage(User profile) {
        this.profile = profile;
        initComponents();
        Photo.setPhoto(profilePictureLabel, profile.getProfilePhotoPath());
        Photo.setPhoto(coverPhotoLabel, profile.getCoverPhotoPath());
        bioTextArea.setText(profile.getBio());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changePictureButton = new javax.swing.JButton();
        changePhotoButton = new javax.swing.JButton();
        changeBioButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        coverPhotoLabel = new javax.swing.JLabel();
        profilePictureLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        changeBioButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        changeBioButton.setText("Change Bio");
        changeBioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBioButtonActionPerformed(evt);
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
                            .addGap(173, 173, 173)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4)
                        .addComponent(changePasswordButton)
                        .addComponent(jLabel3)
                        .addComponent(changeBioButton))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(changeBioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(changePasswordButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changePictureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePictureButtonActionPerformed
        try {
            String newPhotoPath = Photo.changePhoto(profilePictureLabel, this);
            if (!newPhotoPath.equals(null)) {
                profile.setProfilePhotoPath(newPhotoPath);
            }
        } catch (NullPointerException ex) {
        }

    }//GEN-LAST:event_changePictureButtonActionPerformed

    private void changePhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePhotoButtonActionPerformed
        try {
            String newPhotoPath = Photo.changePhoto(coverPhotoLabel, this);
            if (!newPhotoPath.equals(null)) {
                profile.setCoverPhotoPath(newPhotoPath);
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_changePhotoButtonActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        try {
            String newPassword = connecthub.ChangePasswordWindow.newPassword(this, profile.getPassword());
            if (!newPassword.equals(null)) {
                profile.setPassword(newPassword);
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    private void changeBioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBioButtonActionPerformed
        String newBio=this.bioTextArea.getText();
        this.profile.setBio(newBio);
    }//GEN-LAST:event_changeBioButtonActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfileManagementPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileManagementPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileManagementPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileManagementPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                User profile = new User("1","s","a","f","g","h");
                profile.setBio("hello iam adham and i hate bananas");
                profile.setProfilePhotoPath("C:\\Users\\adham\\Desktop\\noprofile.png");
                profile.setCoverPhotoPath("C:\\Users\\adham\\Desktop\\noimage.png");
                profile.setPassword("531");
                profile.addFriend("adham");
                profile.addFriend("ahmed");
                profile.addFriend("mohamed");
                profile.addFriend("bigad");
                new ProfileManagementPage(profile).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bioTextArea;
    private javax.swing.JButton changeBioButton;
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
    // End of variables declaration//GEN-END:variables
}
