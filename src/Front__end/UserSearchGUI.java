
package Front__end;

import Back__end.FriendSuggestion;
import Back__end.FriendsList;
import Back__end.User;
import Back__end.UserRepository;
import Back__end.userService;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class UserSearchGUI extends javax.swing.JFrame{
  
  private User currentUser;
  private ArrayList<User> results;
  private JPanel resultsPanel;
  protected JScrollPane scrollPane;
  public UserSearchGUI(User user,ArrayList<User> results){
      UserRepository.loadUsersFromJson();
      this.currentUser = userService.getUser(user.getUserId());
      this.results=results;
      initComponents();
  }
    @SuppressWarnings("unchecked")
    private void initComponents() {
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Search Results");
    JLabel titleLabel = new JLabel("Search Results: ", SwingConstants.CENTER);
    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
    resultsPanel = new JPanel();
    resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
    populateUserList();
    
    scrollPane = new JScrollPane(resultsPanel);
    scrollPane.setPreferredSize(new Dimension(600, 400));
    
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(titleLabel, BorderLayout.NORTH);
    getContentPane().add(scrollPane, BorderLayout.CENTER);
    setSize(800, 600);
     setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UserRepository.saveData();
                UserRepository.loadUsersFromJson();
                dispose();
            }
        });
        setVisible(true);

    }
    private JPanel createUserPanel(User result) {
       JPanel resultPanel=new JPanel();
       resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
       JLabel photoLabel = new JLabel();
       String path=result.getProfilePhotoPath();
       ImageIcon imageicon=new userService().saveImageIconProfile(path);
       photoLabel.setIcon(imageicon);
       photoLabel.setPreferredSize(new Dimension(50, 50));
       JLabel nameLabel = new JLabel(result.getUsername());
       JButton addFriendButton = new javax.swing.JButton();
addFriendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addfriend2.png")));
addFriendButton.setText("Add Friend");

JButton removeFriendButton = new javax.swing.JButton();
removeFriendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/removefriend.png")));
removeFriendButton.setText("Remove Friend");

JButton blockButton = new javax.swing.JButton();
blockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/BlockedFriends.png")));
blockButton.setText("Block User");

JButton viewProfileButton = new javax.swing.JButton();
viewProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png")));
viewProfileButton.setText("View Profile");
addFriendButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        new FriendSuggestion().acceptSuggestion(userService.getUser(currentUser.getUserId()),userService.getUser(result.getUserId())); 
        if (!addFriendButton.getText().equals("Request Sent")) {
            addFriendButton.setText("Request Sent");
            addFriendButton.setEnabled(false);
            
            // Show message dialog only once
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
                   
                }              
                    removeFriendButton.setEnabled(false);
                    refreshUI();        
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
       viewProfileButton.addActionListener(new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent e){
           ViewProfileSearchGUI viewProfile=new ViewProfileSearchGUI(result);
           viewProfile.setVisible(true);
          }
       });
       resultPanel.add(photoLabel);
       resultPanel.add(nameLabel);
       if(!currentUser.isFriend(result.getUserId()) &&!result.getReceivedRequests().contains(currentUser.getUserId())) //if they are not friends
       resultPanel.add(addFriendButton); //add friend button
       if(currentUser.isFriend(result.getUserId())) //if they are friends
       resultPanel.add(removeFriendButton);  //remove friend button
       resultPanel.add(blockButton);
       resultPanel.add(viewProfileButton);
       
      return  resultPanel;
    }
     protected void refreshUI() {
        resultsPanel.removeAll();
        populateUserList();
        resultsPanel.revalidate();
        resultsPanel.repaint();
    }
     protected void populateUserList()
     {
        if (results.isEmpty()) {
        JLabel noResultsLabel = new JLabel("Your search didn't return any results !", SwingConstants.CENTER);
        noResultsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        resultsPanel.add(noResultsLabel);
    } else {
        for (User result : results) {
            if (!result.isBlocked(currentUser.getUserId()) && !currentUser.isBlocked(result.getUserId()) &&!currentUser.getUserId().equals(result.getUserId()) ) {
                resultsPanel.add(createUserPanel(result));
            }
      }
    }
  }
}
