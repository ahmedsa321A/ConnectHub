/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front_End;

import Back_end.FriendUser;
import Back_end.FriendsHandler;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;


public class FriendsCenter extends javax.swing.JFrame {

private FriendUser you;
   
    public FriendsCenter(FriendUser user) {
        initComponents();
        you=user;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackButton = new javax.swing.JButton();
        FriendsListButton = new javax.swing.JButton();
        RequestsButton = new javax.swing.JButton();
        SuggestionButton = new javax.swing.JButton();

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
        FriendsListButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\ghane\\OneDrive\\Pictures\\4951182.png")); // NOI18N
        FriendsListButton.setText(" My Friends");
        FriendsListButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        FriendsListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriendsListButtonActionPerformed(evt);
            }
        });

        RequestsButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        RequestsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\ghane\\OneDrive\\Pictures\\user.png")); // NOI18N
        RequestsButton.setText("Friend Requests");
        RequestsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        RequestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestsButtonActionPerformed(evt);
            }
        });

        SuggestionButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        SuggestionButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\ghane\\OneDrive\\Pictures\\4856013.png")); // NOI18N
        SuggestionButton.setText("Friend Suggestions");
        SuggestionButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        SuggestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RequestsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FriendsListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SuggestionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(FriendsListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(RequestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(SuggestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void FriendsListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriendsListButtonActionPerformed
       FriendsListGUI friends=new FriendsListGUI(you,"Friends");
       friends.setVisible(true);
    }//GEN-LAST:event_FriendsListButtonActionPerformed

    private void RequestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestsButtonActionPerformed
       FriendRequestsGUI requests=new FriendRequestsGUI(you,"Requests");
       requests.setVisible(true);
    }//GEN-LAST:event_RequestsButtonActionPerformed

    private void SuggestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuggestionButtonActionPerformed
        FriendSuggestionGUI suggestions=new FriendSuggestionGUI(you,"Suggestions");
       suggestions.setVisible(true);
    }//GEN-LAST:event_SuggestionButtonActionPerformed
public static void main(String[] args) {
         FriendUser user = new FriendUser("1", "john@example.com", "JohnDoe", "123456", "01/01/1992", "active", "C:\\Users\\ghane\\OneDrive\\Pictures\\PP.png");
    FriendUser currentUser = new FriendUser("2", "Hazem@example.com", "Hazem", "7891011", "01/01/1990", "active", "C:\\Users\\ghane\\OneDrive\\Pictures\\a3452e2f5910a0e59fbee3762c65061a.jpg");
    List<FriendUser> friendList = new ArrayList<>();
    friendList.add(user);
    friendList.add(currentUser);
    
    java.lang.reflect.Type friendListType = new TypeToken<List<FriendUser>>() {}.getType();
    FriendsHandler<List<FriendUser>> handler = new FriendsHandler<>(friendListType);

    String filePath = "FriendUser.json";
    handler.save(friendList, filePath);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                 String filePath = "FriendUser.json";
                 handler.save(friendList, filePath);
                new FriendsCenter(user).setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton FriendsListButton;
    private javax.swing.JButton RequestsButton;
    private javax.swing.JButton SuggestionButton;
    // End of variables declaration//GEN-END:variables
}
