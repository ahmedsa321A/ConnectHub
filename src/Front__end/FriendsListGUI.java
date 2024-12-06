package Front__end;

import Back__end.User;
import Back__end.FriendsList;
import Back__end.userService;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FriendsListGUI extends FriendsParentGUI {
    
    public FriendsListGUI(User user,String title,HashMap<String,User>users) {
        super(user, "Friends",users);
        currentUser = userService.getUser(currentUser.getUserId());
    }
   
   @Override
    protected void populateUserList() {
        List<String> friends = currentUser.getFriendsIdArray(); 

        for (String friendId : friends) {
            User friend=userSearch.getUserById(friendId);
            userPanel.add(createUserPanel(friend)); 
        }
    }
    
    @Override
    protected JPanel createUserPanel(User friend) {
        JPanel friendPanel = new JPanel();
        friendPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        
        JLabel photoLabel = new JLabel();
        ImageIcon photoIcon = loadImageIcon(friend.getProfilePhotoPath());
        photoLabel.setIcon(photoIcon);
        photoLabel.setPreferredSize(new Dimension(50, 50)); 

        
        JLabel nameLabel = new JLabel(friend.getUsername());
        
        JButton removeButton = new JButton("Remove");
        removeButton = new javax.swing.JButton();
            removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
            removeButton.setText("Remove");
        JButton blockButton = new JButton("Block");
        blockButton = new javax.swing.JButton();
            blockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/removefriend.png"))); // NOI18N
            blockButton.setText("Block");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to remove " + friend.getUsername() + " from your friends?",
                    "Confirm Removal", JOptionPane.YES_NO_OPTION);
                
                if (response == JOptionPane.YES_OPTION) {
                    new FriendsList().removeFriend(currentUser, friend);
                    JOptionPane.showMessageDialog(null, friend.getUsername() + " has been removed.");
                    refreshUI(); 
                }
            }
        });

       
        blockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to block " + friend.getUsername() + "?",
                    "Confirm Block", JOptionPane.YES_NO_OPTION);
                
                if (response == JOptionPane.YES_OPTION) {
                    new FriendsList().blockFriend(currentUser, friend);
                    JOptionPane.showMessageDialog(null, friend.getUsername() + " has been blocked.");
                    refreshUI();
                }
            }
        });

        friendPanel.add(photoLabel);
        friendPanel.add(nameLabel);
        friendPanel.add(removeButton);
        friendPanel.add(blockButton);

        return friendPanel;
    }
    
}