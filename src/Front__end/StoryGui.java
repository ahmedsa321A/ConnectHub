package Front__end;

import Back__end.Content;
import Back__end.ContentDatabase;
import Back__end.Photo;
import java.util.UUID;
import javax.swing.JOptionPane;

public class StoryGui extends javax.swing.JFrame {

    private static String photopath = "";
    private static String userid;

    public StoryGui() {
        initComponents();
        setVisible(true);
        removeButton1.setVisible(false);

    }

    @SuppressWarnings("unchecked")
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
        setTitle("Create Story");

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancel)
                                .addGap(18, 18, 18)
                                .addComponent(publish)
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(removeButton1)
                                .addGap(84, 84, 84)))))
                .addComponent(addphoto))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancel)
                            .addComponent(publish))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton1)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addphoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                        .addComponent(addPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void publishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishActionPerformed
        ContentDatabase db = new ContentDatabase();
        String text = posttext.getText();
        if (text.equals("Write Here...")) {
            JOptionPane.showMessageDialog(this, "Please Write Story text", "Invalid Text", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (text.equals("")) {
            JOptionPane.showMessageDialog(this, "Can't Write Story Without text", "Invalid Text", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Content post = new Content(UUID.randomUUID().toString(), "userid", text, photopath, true);
        db.addContent(post);
        db.saveContent();
        JOptionPane.showMessageDialog(this, "Story Published Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
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
        StoryGui post = new StoryGui();
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
