package Front_End;

import Back_end.FriendUser;
import Back_end.FriendsList;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FriendsListGUI extends FriendsParentGUI {
    
    public FriendsListGUI(FriendUser user,String title) {
        super(user, "Friends");
    }
   
   @Override
    protected void populateUserList() {
        List<FriendUser> friends = currentUser.getFriends(); 

        for (FriendUser friend : friends) {
            userPanel.add(createUserPanel(friend)); 
        }
    }
    
    @Override
    protected JPanel createUserPanel(FriendUser friend) {
        JPanel friendPanel = new JPanel();
        friendPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        
        JLabel photoLabel = new JLabel();
        ImageIcon photoIcon = loadImageIcon(friend.getPhotoPath());
        photoLabel.setIcon(photoIcon);
        photoLabel.setPreferredSize(new Dimension(50, 50)); 

        
        JLabel nameLabel = new JLabel(friend.getUsername());
        
        JButton removeButton = new JButton("Remove");
        JButton blockButton = new JButton("Block");

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
    
   

    @Override
    protected void refreshUI() {
        
        this.dispose();
        new FriendsListGUI(currentUser,"Friends").setVisible(true); 
    }
}