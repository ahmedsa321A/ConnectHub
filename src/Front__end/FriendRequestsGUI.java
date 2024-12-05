
package Front__end;

import Back__end.FriendRequests;
import Back__end.User;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FriendRequestsGUI extends FriendsParentGUI {
    
    public FriendRequestsGUI(User user, String title,HashMap<String,User>users) {
        super(user, "Requests",users);
    }
    @Override
    protected void populateUserList() {
        List<String> requests = currentUser.getReceivedRequests();  // Get friend requests list
        for (String request : requests) {
            User requestUser = userSearch.getUserById(request);
            userPanel.add(createUserPanel(requestUser));  // Create and add panel for each request
        }
    }

    @Override
    protected JPanel createUserPanel(User request) {
      JPanel requestPanel = new JPanel();
        requestPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        
        JLabel photoLabel = new JLabel();
        ImageIcon photoIcon = loadImageIcon(request.getProfilePhotoPath());
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


}