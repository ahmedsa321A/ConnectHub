package Front__end;

import Back__end.ConcreteFactory;
import Back__end.Content;
import Back__end.ContentDatabase;
import Back__end.Photo;
import Back__end.User;
import Back__end.userService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StoryGui extends javax.swing.JFrame {

    private static String photopath;
    private static String userid;
    private static User user;
    ContentDatabase db =ContentDatabase.getInstance();
    public StoryGui(User user) {
        initComponents();
        this.user = user;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
        setVisible(true);
        addPlaceholderStyle(storytext);
        removeButton1.setVisible(false);
    }

    public void addPlaceholderStyle(JTextArea areafield) {
        Font font = areafield.getFont();
        font = font.deriveFont(Font.ITALIC);
        areafield.setFont(font);
        areafield.setForeground(Color.GRAY);

    }

    public void removePlaceholderStyle(JTextArea areafield) {
        Font font = areafield.getFont();
        font = font.deriveFont(Font.PLAIN | Font.PLAIN);
        areafield.setFont(font);
        areafield.setForeground(Color.BLACK);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        myTextArea1 = new Back__end.MyTextArea();
        myTextArea2 = new Back__end.MyTextArea();
        myTextArea3 = new Back__end.MyTextArea();
        publish = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        pic = new javax.swing.JLabel();
        removeButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        storytext = new Back__end.MyTextArea();
        addphoto = new Back__end.MyButton();
        back = new Back__end.MyButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Story");
        setBackground(new java.awt.Color(51, 153, 255));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        publish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/publish.png"))); // NOI18N
        publish.setText("Publish");
        publish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishActionPerformed(evt);
            }
        });

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        pic.setRequestFocusEnabled(false);

        removeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        removeButton1.setText("Remove photo");
        removeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton1ActionPerformed(evt);
            }
        });

        storytext.setColumns(20);
        storytext.setRows(5);
        storytext.setText("Write Here.....");
        storytext.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/write.png"))); // NOI18N
        storytext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                storytextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                storytextFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(storytext);

        addphoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addphoto.png"))); // NOI18N
        addphoto.setColorover(new java.awt.Color(255, 255, 255));
        addphoto.setRedius(100);
        addphoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addphotoActionPerformed(evt);
            }
        });

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        back.setColorover(new java.awt.Color(255, 255, 255));
        back.setRedius(100);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(addphoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(publish, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(publish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(addphoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(removeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void publishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishActionPerformed
        db.loadContent();
        db.deleteExpiredStories();
        String text = storytext.getText();
        if (text.equals("Write Here.....")) {
            JOptionPane.showMessageDialog(this, "Can't Write Post Without text", "Invalid Text", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
    ConcreteFactory contentFactory = new ConcreteFactory();
    
    // Use the factory to create a Content object with isStory set to true
    Content post = contentFactory.createContent(user.getUserId(), text, photopath, true);
            db.addContent(post);
            db.saveContent();
            JOptionPane.showMessageDialog(this, "Post Published Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_publishActionPerformed

    private void removeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton1ActionPerformed
        if (evt.getSource() == removeButton1) {
            pic.setIcon(null);
            photopath = "";
            removeButton1.setVisible(false);
        }
    }//GEN-LAST:event_removeButton1ActionPerformed

    private void addphotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addphotoActionPerformed

        photopath = Photo.selectPhoto(pic, this);
        if (photopath != null) {
            Photo.setPhoto(pic, photopath);
        } else {
            photopath = "";
        }
        if (!photopath.equals("")) {
            removeButton1.setVisible(true);
        }
    }//GEN-LAST:event_addphotoActionPerformed

    private void storytextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_storytextFocusGained
        if (storytext.getText().equals("Write Here.....")) {
            storytext.setText(null);
            storytext.requestFocus();
            removePlaceholderStyle(storytext);
        }
    }//GEN-LAST:event_storytextFocusGained

    private void storytextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_storytextFocusLost
        if (storytext.getText().length() == 0) {
            addPlaceholderStyle(storytext);
            storytext.setText("Write Here.....");

        }
    }//GEN-LAST:event_storytextFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();    }//GEN-LAST:event_formWindowGainedFocus

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        NewsFeedWindow newsfeedwindow = new NewsFeedWindow(user);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        NewsFeedWindow newsfeedwindow = new NewsFeedWindow(user);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Back__end.MyButton addphoto;
    private Back__end.MyButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private Back__end.MyTextArea myTextArea1;
    private Back__end.MyTextArea myTextArea2;
    private Back__end.MyTextArea myTextArea3;
    private javax.swing.JLabel pic;
    private javax.swing.JButton publish;
    private javax.swing.JButton removeButton1;
    private Back__end.MyTextArea storytext;
    // End of variables declaration//GEN-END:variables
}
