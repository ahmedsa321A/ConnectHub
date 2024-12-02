/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front__end;

import Back__end.Content;
import Back__end.ContentDatabase;
import java.awt.Image;
import java.io.File;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author hazembarakat
 */
public class PostGui extends javax.swing.JFrame {

    private static String photopath = "";

    /**
     * Creates new form PostGui
     */
    public PostGui() {
        initComponents();
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
        addPhoto.setIcon(new javax.swing.ImageIcon("/Users/hazembarakat/Downloads/addphoto.png")); // NOI18N
        addPhoto.setBorder(null);
        addPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPhotoActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(242, 242, 242));
        back.setIcon(new javax.swing.ImageIcon("/Users/hazembarakat/Downloads/1103738-200-2.png")); // NOI18N
        back.setBorder(null);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        pic.setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancel)
                        .addGap(18, 18, 18)
                        .addComponent(publish)
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
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancel)
                            .addComponent(publish))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addphoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(378, 378, 378)
                        .addComponent(addPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void publishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishActionPerformed
        ContentDatabase db = new ContentDatabase();
        String text = posttext.getText();
        if (text.equals("Write Here...")) {
            JOptionPane.showMessageDialog(this, "Please Write Post text", "Invalid File", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Content post = new Content(UUID.randomUUID().toString(), "Postowner", text, photopath, false);
        db.addContent(post);
        db.saveContent();
        JOptionPane.showMessageDialog(this, "Post Published Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_publishActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void addphotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addphotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addphotoActionPerformed

    private void addPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPhotoActionPerformed
        if (evt.getSource() == addPhoto) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showOpenDialog(null);
            File f = filechooser.getSelectedFile();
            if (f != null) {
                if (f.getAbsolutePath() != null) {
                    if (!f.getAbsolutePath().endsWith(".png")) {
                        JOptionPane.showMessageDialog(this, "Extension Should be .png", "Invalid File", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                if (response == JFileChooser.APPROVE_OPTION) {
                    photopath = filechooser.getSelectedFile().getAbsolutePath();
                    ImageIcon image = new ImageIcon(photopath);
                    Image scaledImage = image.getImage().getScaledInstance(352, 190, Image.SCALE_SMOOTH);
                    ImageIcon scaledimage = new ImageIcon(scaledImage);
                    pic.setIcon(scaledimage);
                }
            }
        }
    }//GEN-LAST:event_addPhotoActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(PostGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostGui().setVisible(true);
            }
        });
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
    // End of variables declaration//GEN-END:variables
}
