package Front__end;

import Back__end.Content;
import Back__end.ContentDatabase;
import Back__end.Photo;
import Back__end.User;
import Back__end.userService;
import java.util.UUID;
import javax.swing.JOptionPane;

public class PostGui extends javax.swing.JFrame {

    private static String photopath = "";
    private static String userid;

    public PostGui() {
        initComponents();
        setVisible(true);
        removeButton1.setVisible(false);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        publish = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        posttext = new javax.swing.JTextArea();
        cancel = new javax.swing.JButton();
        addphoto = new javax.swing.JButton();
        addPhoto = new javax.swing.JButton();
        back = new javax.swing.JButton();
        pic = new javax.swing.JLabel();
        removeButton1 = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Post");

        publish.setBackground(new java.awt.Color(51, 153, 255));
        publish.setText("Publish");
        publish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishActionPerformed(evt);
            }
        });

        posttext.setColumns(20);
        posttext.setRows(5);
        posttext.setText("Write Here...");
        posttext.setToolTipText("");
        jScrollPane1.setViewportView(posttext);

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        addphoto.setBackground(new java.awt.Color(242, 242, 242));
        addphoto.setBorder(null);
        addphoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addphotoActionPerformed(evt);
            }
        });

        addPhoto.setBackground(new java.awt.Color(242, 242, 242));
        addPhoto.setBorder(null);
        addPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPhotoActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(242, 242, 242));
        back.setBorder(null);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        pic.setRequestFocusEnabled(false);

        removeButton1.setText("Remove photo");
        removeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(cancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(publish)))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
                        .addGap(53, 53, 53)))
                .addComponent(addphoto))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(378, 378, 378)
                        .addComponent(addPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cancel)
                                    .addComponent(publish))
                                .addGap(7, 7, 7)
                                .addComponent(removeButton1))
                            .addComponent(addphoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void publishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishActionPerformed
        ContentDatabase db = new ContentDatabase();
        String text = posttext.getText();
        if (text.equals("Write Here...")) {
            JOptionPane.showMessageDialog(this, "Please Write Post text", "Invalid Text", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (text.equals("")) {
            JOptionPane.showMessageDialog(this, "Can't Write Post Without text", "Invalid Text", JOptionPane.ERROR_MESSAGE);
            return;
        } else{
        Content post = new Content(UUID.randomUUID().toString(), "userid", text, photopath, false);
        db.addContent(post);
        db.saveContent();
        JOptionPane.showMessageDialog(this, "Post Published Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        for(User u : userService.userList){
            if(u.getUserId().equals(this.userid)){
                u.addContentId(post.getContentId());
            }
        }
        }
    }//GEN-LAST:event_publishActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void addphotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addphotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addphotoActionPerformed

    private void addPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPhotoActionPerformed

        photopath = Photo.selectPhoto(pic, this);
        Photo.setPhoto(pic, photopath);
        if (!photopath.equals(null)) {
            removeButton1.setVisible(true);
        }

    }//GEN-LAST:event_addPhotoActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void removeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton1ActionPerformed
        if (evt.getSource() == removeButton1) {
            pic.setIcon(null);
            photopath = "";
            removeButton1.setVisible(false);
        }
    }//GEN-LAST:event_removeButton1ActionPerformed

    public static void main(String args[]) {
        PostGui post = new PostGui();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPhoto;
    private javax.swing.JButton addphoto;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pic;
    private javax.swing.JTextArea posttext;
    private javax.swing.JButton publish;
    private javax.swing.JButton removeButton1;
    // End of variables declaration//GEN-END:variables
}
