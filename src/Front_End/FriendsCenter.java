
package Front_End;

import Back_end.FriendLoader;
import Back_end.FriendSaver;
import Back_end.FriendUser;
import Back_end.RelationshipManager;
import Back_end.RelationshipStatus;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FriendsCenter extends javax.swing.JFrame {

private FriendUser you;
private HashMap<String,FriendUser>allUsersMap;
    public FriendsCenter(FriendUser user,HashMap<String, FriendUser> allUsersMap) {
        initComponents();
        you=user;
        this.allUsersMap=allUsersMap;
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

        BlockedButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BlockedButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\ghane\\OneDrive\\Pictures\\8109728.png")); // NOI18N
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
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RequestsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FriendsListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SuggestionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BlockedButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
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
public static void main(String[] args) {
    FriendUser user = new FriendUser("1", "john@example.com", "JohnDoe", "123456", "01/01/1992", "active", "C:\\Users\\ghane\\OneDrive\\Pictures\\PP.png");
    FriendUser user2 = new FriendUser("2", "Hitler@example.com", "Hazem", "78911", "01/01/1990", "active", "C:\\Users\\ghane\\OneDrive\\Pictures\\PP.png");
    FriendUser user3 = new FriendUser("3", "Bigm@example.com", "Begad", "8584", "01/01/1998", "active", "C:\\Users\\ghane\\OneDrive\\Pictures\\happy-young-cute-illustration-face-profile-png.png");
    FriendUser user4 = new FriendUser("4", "Ahmed@example.com", "A7ma Saied", "8574", "01/01/1998", "active", null);

    HashMap<String, FriendUser> allUsersMap = new HashMap<>();
    allUsersMap.put(user.getUserId(), user);
    allUsersMap.put(user2.getUserId(), user2);
    allUsersMap.put(user3.getUserId(), user3);
    allUsersMap.put(user4.getUserId(), user4);
    java.lang.reflect.Type friendUserListType = new TypeToken<List<FriendUser>>(){}.getType();
    String filePath = "FriendUser.json";
    for (Map.Entry<String, FriendUser> entry : allUsersMap.entrySet()) {
        FriendUser otherUser = entry.getValue();
        
        if (!user.getUserId().equals(otherUser.getUserId())) {
            RelationshipStatus status = RelationshipManager.getRelationshipStatus(user, otherUser);
            
            if (status == RelationshipStatus.NOT_FRIENDS) {
                user.addSuggestion(otherUser.getUserId()); 
            }
        }
    }
    FriendLoader loader = new FriendLoader();
    FriendSaver saver = new FriendSaver();
    saver.saveToFile(user, filePath);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
 
                new FriendsCenter(user,allUsersMap).setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton BlockedButton;
    private javax.swing.JButton FriendsListButton;
    private javax.swing.JButton RequestsButton;
    private javax.swing.JButton SuggestionButton;
    // End of variables declaration//GEN-END:variables
}
