package Front__end;

import Back__end.FriendSuggestion;
import Back__end.FriendsList;
import Back__end.Notification;
import Back__end.NotificationDatabase;
import Back__end.User;
import Back__end.userService;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class UserSearchGUI extends SearchParentGUI<User> {
     NotificationDatabase ndb= NotificationDatabase.getInstance();
    public UserSearchGUI(User user, ArrayList<User> results) {
        super(user, "User", results);
    }

    @Override
    protected JPanel createPanel(User result) {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 

        // Profile photo
        JLabel photoLabel = new JLabel();
        String path = result.getProfilePhotoPath();
        ImageIcon imageIcon = new userService().saveImageIconProfile(path);
        photoLabel.setIcon(imageIcon);
        photoLabel.setPreferredSize(new Dimension(50, 50));

        // Username label
        JLabel nameLabel = new JLabel(result.getUsername());

        // Buttons
        JButton addFriendButton = new JButton("Add Friend");
        addFriendButton.setIcon(new ImageIcon(getClass().getResource("/icons/addfriend2.png")));

        JButton removeFriendButton = new JButton("Remove Friend");
        removeFriendButton.setIcon(new ImageIcon(getClass().getResource("/icons/removefriend2.png")));

        JButton blockButton = new JButton("Block User");
        blockButton.setIcon(new ImageIcon(getClass().getResource("/icons/BlockedFriends.png")));

        JButton viewProfileButton = new JButton("View Profile");
        viewProfileButton.setIcon(new ImageIcon(getClass().getResource("/icons/profile.png")));

        addFriendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FriendSuggestion().acceptSuggestion(userService.getUser(currentUser.getUserId()), userService.getUser(result.getUserId()));
                 Notification notification = new Notification.Builder().setNotificationtype("Friend")
                .setSenderuserid(currentUser.getUserId())
                .setReceiveruserid(result.getUserId())
                .build();
                
                    ndb.addnotification(notification);
                    ndb.savenotifications();
                
                if (!addFriendButton.getText().equals("Request Sent")) {
                    
                    addFriendButton.setText("Request Sent");
                    addFriendButton.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Friend request sent!");
                }
            }
        });

        removeFriendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to remove " + result.getUsername() + " from your friends?",
                    "Confirm Removal", JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    new FriendsList().removeFriend(currentUser, userService.getUser(result.getUserId()));
                    JOptionPane.showMessageDialog(null, result.getUsername() + " has been removed.");
                    removeFriendButton.setEnabled(false);
                    refreshUI();
                }
            }
        });

        blockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to block " + result.getUsername() + "?",
                    "Confirm Block", JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    new FriendsList().blockFriend(currentUser, userService.getUser(result.getUserId()));
                    JOptionPane.showMessageDialog(null, result.getUsername() + " has been blocked.");
                }
                refreshUI();
            }
        });

        viewProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewProfileSearchGUI viewProfile = new ViewProfileSearchGUI(result);
                viewProfile.setVisible(true);
            }
        });

        resultPanel.add(photoLabel);
        resultPanel.add(nameLabel);

        // Add appropriate buttons
        if (!currentUser.isFriend(result.getUserId()) && !result.getReceivedRequests().contains(currentUser.getUserId())) {
            resultPanel.add(addFriendButton);
        }
        if (currentUser.isFriend(result.getUserId())) {
            resultPanel.add(removeFriendButton);
        }
        resultPanel.add(blockButton);
        resultPanel.add(viewProfileButton);

        return resultPanel;
    }

    @Override
    protected void populateResults() {
        if (results.isEmpty()) {
            JLabel noResultsLabel = new JLabel("Your search didn't return any results!", SwingConstants.CENTER);
            noResultsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            resultsPanel.add(noResultsLabel);
        } else {
            for (User result : results) {
                if (!result.isBlocked(currentUser.getUserId()) && !currentUser.isBlocked(result.getUserId()) && !currentUser.getUserId().equals(result.getUserId())) {
                    resultsPanel.add(createPanel(result));
                }
            }
        }
    }
}
