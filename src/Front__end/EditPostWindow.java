package Front__end;

import Back__end.GroupPost;
import Back__end.GroupPostsDatabase;
import Back__end.Photo;
import javax.swing.JOptionPane;

public class EditPostWindow extends javax.swing.JDialog {

    private GroupPost groupPost;
    private String newPostText;
    private String newPhotoPath;

    public EditPostWindow(java.awt.Frame parent, GroupPost groupPost, boolean modal) {
        super(parent, modal);
        initComponents();
        this.groupPost = groupPost;
        this.newPostText = groupPost.getContentText();
        this.newPhotoPath = groupPost.getImagePath();
        postTextArea.setText(groupPost.getContentText());
        Photo.setPhoto(postPhotoLabel, groupPost.getImagePath());
        this.setVisible(modal);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        postTextArea = new javax.swing.JTextArea();
        postPhotoLabel = new javax.swing.JLabel();
        changPhotoButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Text");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Photo");

        postTextArea.setColumns(20);
        postTextArea.setRows(5);
        jScrollPane1.setViewportView(postTextArea);

        changPhotoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        changPhotoButton.setText("Change Photo");
        changPhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changPhotoButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(changPhotoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(postPhotoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(postPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(changPhotoButton)))
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changPhotoButtonActionPerformed
        try {
            String newPhotoPath = Photo.selectPhoto(postPhotoLabel, this);
            if (!newPhotoPath.equals(null)) {
                Photo.setPhoto(postPhotoLabel, newPhotoPath);
                this.newPhotoPath = newPhotoPath;
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_changPhotoButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        GroupPost groupPost = GroupPostsDatabase.getGroupPostById(this.groupPost.getContentId());
        newPostText = postTextArea.getText();
        groupPost.setImagePath(newPhotoPath);
        groupPost.setContentText(newPostText);
        GroupPostsDatabase.saveToJSON();
        JOptionPane.showMessageDialog(this, "all changes have changed Successfully ","Successful", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    public static void editPost(java.awt.Frame frame, GroupPost post){
        EditPostWindow dialog = new EditPostWindow(frame, post, true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changPhotoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel postPhotoLabel;
    private javax.swing.JTextArea postTextArea;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
