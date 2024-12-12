package Front__end;

import Back__end.ContentService;
import Back__end.FriendSuggestion;
import Back__end.Group;
import Back__end.GroupDatabase;
import Back__end.GroupMemberManger;
import Back__end.GroupPostsDatabase;
import Back__end.Notification;
import Back__end.RelationshipManager;
import Back__end.RelationshipStatus;
import Back__end.User;
import Back__end.UserRepository;
import Back__end.userService;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GroupWindow extends javax.swing.JFrame {
    
    private Group group;
    private int flag;
    private User user;
    
    public GroupWindow(Group group,User user) {
        initComponents();
         java.awt.Frame frame = this;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                   frame.dispose();

            }
        });
        GroupDatabase.loadGroupsFromJson();
        this.group = GroupDatabase.getGroupById(group.getId());
        this.user = user;
        if (this.group.getPrimaryAdmin().equals(user.getUserId())) {
            flag = 1;
            leaveButton.setVisible(false);
        } else if (this.group.getAdmins().contains(user.getUserId())) {
            flag = 2;
            deleteGroupButton.setVisible(false);
        } else if(this.group.getMembers().contains(user.getUserId())){
            flag = 3;
            deleteGroupButton.setVisible(false);
        } else
        {
            deleteGroupButton.setVisible(false);
            leaveButton.setVisible(false);
            createPostButton.setVisible(false);
            
        }
        creatorLabel.setText(userService.getUser(group.getPrimaryAdmin()).getUsername());
        showUsers((ArrayList<String>) this.group.getMembers(), membersPanel);
        showUsers((ArrayList<String>) this.group.getAdmins(), adminPanel);
        showUsers((ArrayList<String>) this.group.getRequests(), requestPanel);
        showPosts();
        
        this.setVisible(true);
    }
    
    private void refresh() {
        GroupDatabase.loadGroupsFromJson();
        Group group = GroupDatabase.getGroupById(this.group.getId());
        for (Window window : Window.getWindows()) {
            window.dispose();
        }
        GroupWindow groupWindow = new GroupWindow(group, this.user);
    }
    
    private void showPosts() {
        java.awt.Frame frame = this;
        ArrayList<String> groupPostsId = (ArrayList<String>) group.getPostsId();
        ContentService cs = new ContentService();
        if (flag == 1 || flag == 2) {
            for (String postId : groupPostsId) {
                JPanel post = cs.createGroupPostPanel(GroupPostsDatabase.getGroupPostById(postId));
                JButton editButton = new JButton("Edit");
                editButton = new javax.swing.JButton();
                editButton.setText("Edit");
                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        EditPostWindow.editPost(frame, GroupPostsDatabase.getGroupPostById(postId));
                        refresh();
                    }
                });
                post.add(editButton);
                this.postsPanel.add(post);
            }
        } else {
            for (String postId : groupPostsId) {
                JPanel post = cs.createGroupPostPanel(GroupPostsDatabase.getGroupPostById(postId));
                this.postsPanel.add(post);
            }
        }
    }
    
    public void showUsers(ArrayList<String> List, JPanel Panell) {
        for (String id : List) {
            if (id.equals(group.getPrimaryAdmin())) {
                continue;
            }
            ArrayList<String> data = userService.getPathAndName(id);
            boolean nopath = false;
            String name = data.get(0);
            String photoPath = data.get(1);
            JPanel Panel = new JPanel();
            Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            ImageIcon imgicon = new userService().saveImageIconProfile(photoPath);
            JLabel imageLabell = new JLabel(imgicon);
            JLabel nameLabel = new JLabel(name);
            Panel.add(imageLabell);
            Panel.add(nameLabel);
            
            JButton promoteButton = new JButton("Promote");
            promoteButton = new javax.swing.JButton();
            //hitler zawd elicon hina
//            promoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addfriend.png"))); // NOI18N
            promoteButton.setText("Promote");
            
            JButton removeButton = new JButton("Remove");
            removeButton = new javax.swing.JButton();
            //hitler zawd elicon hina
//            removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
            removeButton.setText("Remove");
            
            JButton demoteButton = new JButton("Demote");
            demoteButton = new javax.swing.JButton();
            //hitler zawd elicon hina
//            removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
            demoteButton.setText("Demote");
            
            JButton acceptButton = new JButton("Accept");
            acceptButton = new javax.swing.JButton();
            //hitler zawd elicon hina
//            removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
            acceptButton.setText("Accept");
            
            JButton declineButton = new JButton("Decline");
            declineButton = new javax.swing.JButton();
            //hitler zawd elicon hina
//            removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
            declineButton.setText("Decline");
            
            acceptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GroupMemberManger.approveRequest(id, group.getId());
                    UserRepository.loadUsersFromJson();
                    User u = userService.getUser(id);
                    u.removeGroupFromSuggestion(group.getId());
                    UserRepository.saveData();
                    GroupDatabase.saveGroupsToJson();
                    refresh();
                }
            });
            
            declineButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GroupMemberManger.declineRequest(id, group.getId());
                    GroupDatabase.saveGroupsToJson();
                    refresh();
                }
            });
            
            promoteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GroupMemberManger.promote(id, group.getId());
                    GroupDatabase.saveGroupsToJson();
                    refresh();
                }
            });
            
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GroupMemberManger.removeMember(id, group.getId());
                    UserRepository.loadUsersFromJson();
                    User u = userService.getUser(id);
                    u.addGroupsSuggestion(group.getId());
                    UserRepository.saveData();
               

                    GroupDatabase.saveGroupsToJson();
                    refresh();
                }
            });
            
            demoteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GroupMemberManger.demote(id, group.getId());
                    
                    GroupDatabase.saveGroupsToJson();
                    refresh();
                }
            });
            
            if (flag == 1 && Panell == this.membersPanel) {
                Panel.add(promoteButton);
                Panel.add(removeButton);
            }
            if (flag == 1 && Panell == this.adminPanel) {
                Panel.add(demoteButton);
            }
            if (flag == 2 && Panell == this.membersPanel) {
                Panel.add(promoteButton);
                Panel.add(removeButton);
            }
            if ((flag == 1 || flag == 2) && Panell == this.requestPanel) {
                Panel.add(acceptButton);
                Panel.add(declineButton);
            }
            Panell.add(Panel);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        membersPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        adminPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        requestPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        postsPanel = new javax.swing.JPanel();
        createPostButton = new javax.swing.JButton();
        leaveButton = new javax.swing.JButton();
        deleteGroupButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        creatorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout membersPanelLayout = new javax.swing.GroupLayout(membersPanel);
        membersPanel.setLayout(membersPanelLayout);
        membersPanelLayout.setHorizontalGroup(
            membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        membersPanelLayout.setVerticalGroup(
            membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(membersPanel);
        membersPanel.setLayout(new BoxLayout(membersPanel, BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Members");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Admins");

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(adminPanel);
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Requests");

        javax.swing.GroupLayout requestPanelLayout = new javax.swing.GroupLayout(requestPanel);
        requestPanel.setLayout(requestPanelLayout);
        requestPanelLayout.setHorizontalGroup(
            requestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        requestPanelLayout.setVerticalGroup(
            requestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(requestPanel);
        requestPanel.setLayout(new BoxLayout(requestPanel, BoxLayout.Y_AXIS));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Posts");

        javax.swing.GroupLayout postsPanelLayout = new javax.swing.GroupLayout(postsPanel);
        postsPanel.setLayout(postsPanelLayout);
        postsPanelLayout.setHorizontalGroup(
            postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
        postsPanelLayout.setVerticalGroup(
            postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(postsPanel);
        postsPanel.setLayout(new BoxLayout(postsPanel, BoxLayout.Y_AXIS));

        createPostButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        createPostButton.setText("Create Post");
        createPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPostButtonActionPerformed(evt);
            }
        });

        leaveButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        leaveButton.setText("Leave");
        leaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveButtonActionPerformed(evt);
            }
        });

        deleteGroupButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        deleteGroupButton.setText("Delete Group");
        deleteGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGroupButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Creator");

        creatorLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane2)
                        .addComponent(jLabel3)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(createPostButton))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(leaveButton)
                        .addGap(74, 74, 74)
                        .addComponent(deleteGroupButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(creatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane3)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(creatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(127, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteGroupButton)
                            .addComponent(leaveButton)
                            .addComponent(createPostButton))
                        .addGap(17, 17, 17))))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createPostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPostButtonActionPerformed
        GroupPostGui post = new GroupPostGui(user, group.getId());
        this.dispose();
    }//GEN-LAST:event_createPostButtonActionPerformed

    private void leaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveButtonActionPerformed
        GroupMemberManger.removeMember(user.getUserId(), group.getId());
        GroupDatabase.saveGroupsToJson();
        this.dispose();
        UserRepository.loadUsersFromJson();
        user = userService.getUser(user.getUserId());
        NewsFeedWindow newsfeedwindow = new NewsFeedWindow(user);
    }//GEN-LAST:event_leaveButtonActionPerformed

    private void deleteGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGroupButtonActionPerformed
        GroupDatabase.deleteGroupById(group.getId());
        UserRepository.loadUsersFromJson();
        ArrayList<User> users = UserRepository.userList;
        for(User u : users){
            u.removeGroupFromSuggestion(group.getId());
        }
        this.dispose();
        NewsFeedWindow newsfeedwindow = new NewsFeedWindow(user);
    }//GEN-LAST:event_deleteGroupButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPanel;
    private javax.swing.JButton createPostButton;
    private javax.swing.JLabel creatorLabel;
    private javax.swing.JButton deleteGroupButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton leaveButton;
    private javax.swing.JPanel membersPanel;
    private javax.swing.JPanel postsPanel;
    private javax.swing.JPanel requestPanel;
    // End of variables declaration//GEN-END:variables
}
