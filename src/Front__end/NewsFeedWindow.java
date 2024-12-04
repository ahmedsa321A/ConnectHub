package Front__end;

import Back__end.ContentDatabase;
import Back__end.User;
import Back__end.userService;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NewsFeedWindow extends javax.swing.JFrame {

    private static User user;

    public NewsFeedWindow(User user) {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
        this.setVisible(true);
        this.user = user;
        showPosts(user);
    }

    private void showPosts(User user) {
        ArrayList<JPanel> posts = userService.getPostsOfFriends(user);
        for (JPanel post : posts) {
            this.newsFeedPanel.add(post);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newsFeedPanel = new javax.swing.JPanel();
        home = new Back__end.MyButton();
        story = new Back__end.MyButton();
        post = new Back__end.MyButton();
        friends = new Back__end.MyButton();
        refresh = new Back__end.MyButton();
        profile = new Back__end.MyButton();
        stories = new Back__end.MyButton();
        logout = new Back__end.MyButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Newfeed");
        setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout newsFeedPanelLayout = new javax.swing.GroupLayout(newsFeedPanel);
        newsFeedPanel.setLayout(newsFeedPanelLayout);
        newsFeedPanelLayout.setHorizontalGroup(
            newsFeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        newsFeedPanelLayout.setVerticalGroup(
            newsFeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(newsFeedPanel);
        newsFeedPanel.setLayout(new BoxLayout(newsFeedPanel, BoxLayout.Y_AXIS));

        home.setForeground(new java.awt.Color(51, 153, 255));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        home.setColorover(new java.awt.Color(153, 204, 255));
        home.setRedius(100);
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        story.setForeground(new java.awt.Color(51, 153, 255));
        story.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/story.png"))); // NOI18N
        story.setColorover(new java.awt.Color(153, 204, 255));
        story.setRedius(100);
        story.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storyActionPerformed(evt);
            }
        });

        post.setForeground(new java.awt.Color(51, 153, 255));
        post.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/post.png"))); // NOI18N
        post.setColorover(new java.awt.Color(153, 204, 255));
        post.setRedius(100);
        post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postActionPerformed(evt);
            }
        });

        friends.setForeground(new java.awt.Color(51, 153, 255));
        friends.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/friends.png"))); // NOI18N
        friends.setColorover(new java.awt.Color(153, 204, 255));
        friends.setRedius(100);

        refresh.setForeground(new java.awt.Color(51, 153, 255));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        refresh.setColorover(new java.awt.Color(153, 204, 255));
        refresh.setRedius(100);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        profile.setForeground(new java.awt.Color(51, 153, 255));
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N
        profile.setColorover(new java.awt.Color(153, 204, 255));
        profile.setRedius(100);
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        stories.setForeground(new java.awt.Color(51, 153, 255));
        stories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stories .png"))); // NOI18N
        stories.setColorover(new java.awt.Color(153, 204, 255));
        stories.setRedius(100);
        stories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storiesActionPerformed(evt);
            }
        });

        logout.setForeground(new java.awt.Color(51, 153, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        logout.setColorover(new java.awt.Color(153, 204, 255));
        logout.setRedius(100);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(stories, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(story, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stories, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(story, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
    ContentDatabase db=new ContentDatabase();
        for (Window window : Window.getWindows()) {
                    window.dispose();
                }
                NewsFeedWindow newsfeedwindow = new NewsFeedWindow(user);        
    }//GEN-LAST:event_homeActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        ContentDatabase db=new ContentDatabase();
    }//GEN-LAST:event_refreshActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
    ProfileWindow profile=new ProfileWindow(user);
    this.dispose();
    }//GEN-LAST:event_profileActionPerformed

    private void storiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storiesActionPerformed
    StoryGui post = new StoryGui(user);      
        this.dispose();
    }//GEN-LAST:event_storiesActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
    user.setStatus("offline");
        for (Window window : Window.getWindows()) {
                    window.dispose();
                }
    JOptionPane.showMessageDialog(this, "logout Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                Login login = new Login();
    }//GEN-LAST:event_logoutActionPerformed

    private void postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postActionPerformed
        PostGui post = new PostGui(user);      
        this.dispose();
    }//GEN-LAST:event_postActionPerformed

    private void storyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storyActionPerformed
StoryGui story = new StoryGui(user);      
        this.dispose();    }//GEN-LAST:event_storyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Back__end.MyButton friends;
    private Back__end.MyButton home;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Back__end.MyButton logout;
    private javax.swing.JPanel newsFeedPanel;
    private Back__end.MyButton post;
    private Back__end.MyButton profile;
    private Back__end.MyButton refresh;
    private Back__end.MyButton stories;
    private Back__end.MyButton story;
    // End of variables declaration//GEN-END:variables
}
