package Front__end;

import Back__end.Group;
import Back__end.GroupMemberManger;
import Back__end.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GroupSearchGUI extends SearchParentGUI<Group> {

 

    public GroupSearchGUI(User currentUser, ArrayList<Group> results) {
        super(currentUser,"Group Search", results);
        this.currentUser = currentUser;
    }

    @Override
    protected JPanel createPanel(Group group) {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Photo Label
        JLabel photoLabel = new JLabel();
        ImageIcon groupIcon = saveImageIconGroup(group.getPhoto());
        photoLabel.setIcon(groupIcon);
        photoLabel.setPreferredSize(new Dimension(60, 45));

        // Name Label
        JLabel nameLabel = new JLabel(group.getName());
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Buttons
        JButton joinButton = new JButton("Join Group");
        joinButton.setIcon(new ImageIcon(getClass().getResource("/icons/JoinGroup.png")));
        
        JButton leaveButton = new JButton("Leave Group");
        leaveButton.setIcon(new ImageIcon(getClass().getResource("/icons/RemoveGroup.png")));
        
        JButton viewGroupButton = new JButton("View Group");
        viewGroupButton.setIcon(new ImageIcon(getClass().getResource("/icons/ViewGroup.png")));

        // Button Logic
        if (group.getMembers().contains(currentUser)) {
            resultPanel.add(leaveButton);
        } else {
            resultPanel.add(joinButton);
        }
        resultPanel.add(viewGroupButton);

        // Button Actions
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GroupMemberManger.addRequest(currentUser.getUserId(), group.getId());
                if(!joinButton.getText().equals("Request Sent"))
                {
                    joinButton.setText("Request Sent");
                    joinButton.setEnabled(false);
                  JOptionPane.showMessageDialog(null, "Request sent to " + group.getName());
                }
              
            }
        });

        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to leave the group " + group.getName() + "?",
                        "Confirm Leave", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    GroupMemberManger.removeMember(currentUser.getUserId(), group.getId());
                    JOptionPane.showMessageDialog(null, "You left the group " + group.getName());
                    refreshUI();
                }
            }
        });

        viewGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Placeholder for opening group details
                JOptionPane.showMessageDialog(null, "Viewing group: " + group.getName());
            }
        });

        resultPanel.add(photoLabel);
        resultPanel.add(nameLabel);

        return resultPanel;
    }

    @Override
    protected void populateResults() {
        if (results.isEmpty()) {
            JLabel noResultsLabel = new JLabel("No groups found!", SwingConstants.CENTER);
            noResultsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            resultsPanel.add(noResultsLabel);
        } else {
            for (Object result : results) {
                Group group = (Group) result;
                resultsPanel.add(createPanel(group));
            }
        }
    }

    public ImageIcon saveImageIconGroup(String photoPath) {
        ImageIcon imgicon;
        if (photoPath == null || photoPath.isEmpty()) {
            imgicon = new ImageIcon(getClass().getResource("/icons/nogroup.png"));
        } else {
            imgicon = new ImageIcon(photoPath);
        }
        Image image = imgicon.getImage();
        Image resizedImage = image.getScaledInstance(60, 45, Image.SCALE_SMOOTH); // Resize to fit
        imgicon = new ImageIcon(resizedImage);
        return imgicon;
    }
}
