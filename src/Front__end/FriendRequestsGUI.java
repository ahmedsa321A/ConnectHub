package Front__end;

import Back__end.FriendRequests;
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
import javax.swing.JPanel;

public class FriendRequestsGUI extends FriendsParentGUI {

    public FriendRequestsGUI(User user, String title, HashMap<String, User> users) {
        super(user, "Requests", users);
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
        String path = request.getProfilePhotoPath();
        ImageIcon imageicon;
        if (path.equals("")) {
            imageicon = new javax.swing.ImageIcon(getClass().getResource("/icons/noprofile.png"));
        } else {
            imageicon = loadImageIcon(path);
        }
        Image image = imageicon.getImage();
        Image resizedImage = image.getScaledInstance(35, 35, Image.SCALE_SMOOTH); // Resize to fit
        ImageIcon imgicon = new ImageIcon(resizedImage);
        photoLabel.setIcon(imgicon);
        photoLabel.setPreferredSize(new Dimension(50, 50));

        JLabel nameLabel = new JLabel(request.getUsername());

        JButton acceptButton = new JButton("Accept");

        acceptButton = new javax.swing.JButton();
        acceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/accept.png"))); // NOI18N
        acceptButton.setText("Accept");

        JButton declineButton = new JButton("Decline");
        declineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        declineButton.setText("Decline");
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
