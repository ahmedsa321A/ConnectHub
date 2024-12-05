
package Front__End;

import Back_end.BlockedFriends;
import Back_end.FriendUser;
import Back_end.FriendsList;
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


public class BlockedUsersGUI extends FriendsParentGUI {
    
    public BlockedUsersGUI(FriendUser user,String title,HashMap<String,FriendUser>users) {
        super(user, "Blocked",users);
    }
@Override
    protected void populateUserList() {
        List<String> blockedUsers = currentUser.getBlocked(); 

        for (String blockedId : blockedUsers) {
            FriendUser blocked=userSearch.getUserById(blockedId);
            userPanel.add(createUserPanel(blocked)); 
        }
    }
    
    @Override
    protected JPanel createUserPanel(FriendUser blocked) {
        JPanel blockedPanel = new JPanel();
        blockedPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        
        JLabel photoLabel = new JLabel();
        ImageIcon photoIcon = loadImageIcon(blocked.getPhotoPath());
        photoLabel.setIcon(photoIcon);
        photoLabel.setPreferredSize(new Dimension(50, 50)); 

        
        JLabel nameLabel = new JLabel(blocked.getUsername());
        
        JButton UnblockButton = new JButton("Unblock");

        
        UnblockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to Unblock " + blocked.getUsername() + "?",
                    "Confirm UnBlock", JOptionPane.YES_NO_OPTION);
                
                if (response == JOptionPane.YES_OPTION) {
                    new BlockedFriends().unBlockFriend(currentUser, blocked);
                    JOptionPane.showMessageDialog(null, blocked.getUsername() + " has been Unblocked.");
                    refreshUI();
                }
            }
        });

        blockedPanel.add(photoLabel);
        blockedPanel.add(nameLabel);
        blockedPanel.add(UnblockButton);

        return blockedPanel;
    }
    
   

    @Override
    protected void refreshUI() {
        
        this.dispose();
        new BlockedUsersGUI(currentUser,"Blocked",users).setVisible(true); 
    }
}
