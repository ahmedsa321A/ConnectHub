
package Front__end;

import Back__end.User;
import java.util.HashMap;


public class FriendsCenter extends javax.swing.JFrame {

private User you;
private HashMap<String,User>allUsersMap;
    public FriendsCenter(User user,HashMap<String, User> allUsersMap) {
        initComponents();
        you=user;
        this.allUsersMap=allUsersMap;
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackButton = new javax.swing.JButton();
        FriendsListButton = new javax.swing.JButton();
        RequestsButton = new javax.swing.JButton();
        SuggestionButton = new javax.swing.JButton();
        BlockedButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Friends Center");

        BackButton.setBackground(new java.awt.Color(204, 204, 255));
        BackButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BackButton.setText("Go Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        FriendsListButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        FriendsListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FriendsList.png"))); // NOI18N
        FriendsListButton.setText(" My Friends");
        FriendsListButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        FriendsListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriendsListButtonActionPerformed(evt);
            }
        });

        RequestsButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        RequestsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FriendRequests.png"))); // NOI18N
        RequestsButton.setText("Friend Requests");
        RequestsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        RequestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestsButtonActionPerformed(evt);
            }
        });

        SuggestionButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        SuggestionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FriendSuggestions.png"))); // NOI18N
        SuggestionButton.setText("Friend Suggestions");
        SuggestionButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        SuggestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestionButtonActionPerformed(evt);
            }
        });

        BlockedButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BlockedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BlockedFriends.png"))); // NOI18N
        BlockedButton.setText("  Blocked Users");
        BlockedButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        BlockedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlockedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SuggestionButton)
                            .addComponent(BlockedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RequestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FriendsListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(FriendsListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RequestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SuggestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BlockedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void FriendsListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriendsListButtonActionPerformed
       FriendsListGUI friends=new FriendsListGUI(you,"Friends",allUsersMap);
       friends.setVisible(true);
    }//GEN-LAST:event_FriendsListButtonActionPerformed

    private void RequestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestsButtonActionPerformed
       FriendRequestsGUI requests=new FriendRequestsGUI(you,"Requests",allUsersMap);
       requests.setVisible(true);
    }//GEN-LAST:event_RequestsButtonActionPerformed

    private void SuggestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuggestionButtonActionPerformed
        FriendSuggestionGUI suggestions=new FriendSuggestionGUI(you,"Suggestions",allUsersMap);
       suggestions.setVisible(true);
    }//GEN-LAST:event_SuggestionButtonActionPerformed

    private void BlockedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlockedButtonActionPerformed
        BlockedUsersGUI blocked= new BlockedUsersGUI(you,"Blocked",allUsersMap);
        blocked.setVisible(true);
    }//GEN-LAST:event_BlockedButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton BlockedButton;
    private javax.swing.JButton FriendsListButton;
    private javax.swing.JButton RequestsButton;
    private javax.swing.JButton SuggestionButton;
    // End of variables declaration//GEN-END:variables
}