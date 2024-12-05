package Front__end;

import Back__end.ContentDatabase;
import Back__end.ContentService;
import Back__end.FriendLoader;
import Back__end.FriendSuggestion;
import Back__end.RelationshipManager;
import Back__end.RelationshipStatus;
import Back__end.User;
import Back__end.UserRepository;
import Back__end.UserSearch;
import Back__end.userService;
import com.google.gson.reflect.TypeToken;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NewsFeedWindow extends javax.swing.JFrame {

    private User user;
   ContentDatabase db=ContentDatabase.getInstance();

    public NewsFeedWindow(User user) {
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    user.setStatus("offline");
                    UserRepository.saveData();
                    Login login = new Login();
            }
        });
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
        this.setVisible(true);
        this.user = user;

        showPosts(user);
        showFriendsList();
       showSuggestions();
    }
private void showFriendsList() {
        ArrayList<String> friendsIdList = (ArrayList<String>) user.getFriendsIdArray();
        for (String friendId : friendsIdList) {
            ArrayList<String> friendData = userService.getPathAndName(friendId);

            String name = friendData.get(0);
            String photoPath = friendData.get(1);

            JPanel friendPanel = new JPanel();
            friendPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            ImageIcon imgicon = null;
            try {
                imgicon = new ImageIcon(photoPath);
                Image image = imgicon.getImage();
                Image resizedImage = image.getScaledInstance(35, 35, Image.SCALE_SMOOTH); // Resize to fit
                imgicon = new ImageIcon(resizedImage);
            } catch (Exception e) {
            }
            JLabel imageLabell = new JLabel(imgicon);
            JLabel nameLabel = new JLabel(name);
            JLabel statusLabel = new JLabel(userService.getStatusofUser(friendId));

            friendPanel.add(imageLabell);
            friendPanel.add(nameLabel);
            friendPanel.add(statusLabel);

            friendListPanel.add(friendPanel);

        }
    }

    private void refreshUI() {
        // Remove all existing components from the panel
        friendSuggestionPanel.removeAll();

        // Refresh the suggestions by calling the method again
        showSuggestions();

        // Revalidate and repaint the panel to reflect changes
        friendSuggestionPanel.revalidate();
        friendSuggestionPanel.repaint();
    }

    public void showSuggestions() {
        UserSearch search = new UserSearch();
        search.setAllMap(UserRepository.userList);
        for (Map.Entry<String, User> entry : search.getMap().entrySet()) {
            User otherUser = entry.getValue();

            if (!user.getUserId().equals(otherUser.getUserId())) {
                RelationshipStatus status = RelationshipManager.getRelationshipStatus(user, otherUser);

                if (status == RelationshipStatus.NOT_FRIENDS) {
                    user.addSuggestion(otherUser.getUserId());
                }
            }
        }
        ArrayList<String> friendsSuggestionIdList = (ArrayList<String>) user.getSuggestions();
        for (String id : friendsSuggestionIdList) {
            ArrayList<String> data = userService.getPathAndName(id);

            String name = data.get(0);
            String photoPath = data.get(1);

            JPanel Panel = new JPanel();
            Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            ImageIcon imgicon = null;
            try {
                imgicon = new ImageIcon(photoPath);
                Image image = imgicon.getImage();
                Image resizedImage = image.getScaledInstance(35, 35, Image.SCALE_SMOOTH); // Resize to fit
                imgicon = new ImageIcon(resizedImage);
            } catch (Exception e) {
            }
            JLabel imageLabell = new JLabel(imgicon);
            JLabel nameLabel = new JLabel(name);

            Panel.add(imageLabell);
            Panel.add(nameLabel);

            JButton addButton = new JButton("Add Friend");
            JButton removeButton = new JButton("Remove");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(userService.getUser(id).getReceivedRequests());
                    new FriendSuggestion().acceptSuggestion(user, userService.getUser(id));
                    UserRepository.saveData();

                    refreshUI();
                }
            });

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new FriendSuggestion().RemoveSuggestion(user, userService.getUser(id));
                    UserRepository.saveData();
                    refreshUI();
                }
            });
            Panel.add(addButton);
            Panel.add(removeButton);

            friendSuggestionPanel.add(Panel);

        }

    }

    private void showPosts(User user) {
        ArrayList<JPanel> posts = ContentService.getPostOfFriends(user);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        friendListPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        friendSuggestionPanel = new javax.swing.JPanel();

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
        friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout friendListPanelLayout = new javax.swing.GroupLayout(friendListPanel);
        friendListPanel.setLayout(friendListPanelLayout);
        friendListPanelLayout.setHorizontalGroup(
            friendListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );
        friendListPanelLayout.setVerticalGroup(
            friendListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(friendListPanel);
        friendListPanel.setLayout(new BoxLayout(friendListPanel, BoxLayout.Y_AXIS));

        javax.swing.GroupLayout friendSuggestionPanelLayout = new javax.swing.GroupLayout(friendSuggestionPanel);
        friendSuggestionPanel.setLayout(friendSuggestionPanelLayout);
        friendSuggestionPanelLayout.setHorizontalGroup(
            friendSuggestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );
        friendSuggestionPanelLayout.setVerticalGroup(
            friendSuggestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(friendSuggestionPanel);
        friendSuggestionPanel.setLayout(new BoxLayout(friendSuggestionPanel, BoxLayout.Y_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(story, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(stories, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stories, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(story, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 570, Short.MAX_VALUE)
                        .addComponent(friends, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        db.loadContent();
        db.deleteExpiredStories();
        for (Window window : Window.getWindows()) {
                    window.dispose();
                }
                NewsFeedWindow newsfeedwindow = new NewsFeedWindow(user);        
    }//GEN-LAST:event_homeActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        db.loadContent();
        db.deleteExpiredStories();
        UserRepository.loadUsersFromJson();
    
        this.user=userService.getUser(user.getUserId());
        newsFeedPanel.removeAll(); 
        showPosts(user);
        newsFeedPanel.revalidate();
        newsFeedPanel.repaint();
    }//GEN-LAST:event_refreshActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
  
    UserRepository.loadUsersFromJson();
    
   this.user=userService.getUser(user.getUserId());
    
    ProfileWindow profile=new ProfileWindow(this.user);
    this.dispose();
    }//GEN-LAST:event_profileActionPerformed

    private void storiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storiesActionPerformed
    StoriesGui post = new StoriesGui(user);      
        this.dispose();
    }//GEN-LAST:event_storiesActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
    user.setStatus("offline");
    UserRepository.saveData();
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

    private void friendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsActionPerformed
    
    FriendLoader load = new FriendLoader();


        java.lang.reflect.Type typeOfT = new TypeToken<List<User>>() {}.getType();


    load.loadFromFile(user, "user_db.json", typeOfT);


    UserSearch search = new UserSearch();
    search.setAllMap(UserRepository.userList);


    for (Map.Entry<String, User> entry : search.getMap().entrySet()) {
        User otherUser = entry.getValue();


        if (!user.getUserId().equals(otherUser.getUserId())) {
            RelationshipStatus status = RelationshipManager.getRelationshipStatus(user, otherUser);

            if (status == RelationshipStatus.NOT_FRIENDS) {
                user.addSuggestion(otherUser.getUserId());
            }
        }
    }
    UserRepository.saveData();

    FriendsCenter friends = new FriendsCenter(user, search.getMap());
    setVisible(false);
    }//GEN-LAST:event_friendsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel friendListPanel;
    private javax.swing.JPanel friendSuggestionPanel;
    private Back__end.MyButton friends;
    private Back__end.MyButton home;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private Back__end.MyButton logout;
    private javax.swing.JPanel newsFeedPanel;
    private Back__end.MyButton post;
    private Back__end.MyButton profile;
    private Back__end.MyButton refresh;
    private Back__end.MyButton stories;
    private Back__end.MyButton story;
    // End of variables declaration//GEN-END:variables
}
