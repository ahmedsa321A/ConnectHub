
package Front__end;

import Back__end.BlockedFriends;
import Back__end.User;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
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
    
    public BlockedUsersGUI(User user,String title,HashMap<String,User>users) {
        super(user, "Blocked",users);
    }
@Override
    protected void populateUserList() {
        List<String> blockedUsers = currentUser.getBlocked(); 

        for (String blockedId : blockedUsers) {
            User blocked=userSearch.getUserById(blockedId);
            userPanel.add(createUserPanel(blocked)); 
        }
    }
    
    @Override
    protected JPanel createUserPanel(User blocked) {
        JPanel blockedPanel = new JPanel();
        blockedPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        JLabel photoLabel = new JLabel();
         String path=blocked.getProfilePhotoPath();
        ImageIcon imageicon;
        if(path.equals("")) imageicon = new javax.swing.ImageIcon(getClass().getResource("/icons/noprofile.png"));
        else imageicon = loadImageIcon(path);
                Image image = imageicon.getImage();
                Image resizedImage = image.getScaledInstance(35, 35, Image.SCALE_SMOOTH); // Resize to fit
        ImageIcon imgicon = new ImageIcon(resizedImage);
        photoLabel.setIcon(imgicon);
        photoLabel.setPreferredSize(new Dimension(50, 50)); 

        
        JLabel nameLabel = new JLabel(blocked.getUsername());
        
        JButton UnblockButton = new JButton("Unblock"); 
            UnblockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/unblock.png"))); 
            UnblockButton.setText("Unblock");
        
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
    

}
