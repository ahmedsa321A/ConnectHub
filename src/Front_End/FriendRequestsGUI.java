
package Front_End;

import Back_end.FriendRequests;
import Back_end.FriendUser;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FriendRequestsGUI extends FriendsParentGUI {
    
    public FriendRequestsGUI(FriendUser user, String title) {
        super(user, "Requests");
    }
    @Override
    protected void populateUserList() {
        List<FriendUser> requests = currentUser.getReceivedRequests();  // Get friend requests list

        for (FriendUser request : requests) {
            userPanel.add(createUserPanel(request));  // Create and add panel for each request
        }
    }

    @Override
    protected JPanel createUserPanel(FriendUser request) {
      JPanel requestPanel = new JPanel();
        requestPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        
        JLabel photoLabel = new JLabel();
        ImageIcon photoIcon = loadImageIcon(request.getPhotoPath());
        photoLabel.setIcon(photoIcon);
        photoLabel.setPreferredSize(new Dimension(50, 50)); 

        
        JLabel nameLabel = new JLabel(request.getUsername());
        
        JButton acceptButton = new JButton("Accept");
        JButton declineButton = new JButton("Decline");

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new FriendRequests().acceptRequest(currentUser, request);
                    refreshUI(); 
            }
        });

       
        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new FriendRequests().declineRequest(currentUser, request);
                    refreshUI();
            }
        });

        requestPanel.add(photoLabel);
        requestPanel.add(nameLabel);
        requestPanel.add(acceptButton);
        requestPanel.add(declineButton);

        return requestPanel;
    }

    @Override
    protected void refreshUI() {
        this.dispose();
        new FriendRequestsGUI(currentUser,"Requests").setVisible(true); 
    }
}
