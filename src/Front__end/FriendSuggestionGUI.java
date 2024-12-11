
package Front__end;
import Back__end.FriendSuggestion;
import Back__end.Notification;
import Back__end.NotificationDatabase;
import Back__end.User;
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
import javax.swing.JPanel;

public class FriendSuggestionGUI extends FriendsParentGUI{
    NotificationDatabase ndb= NotificationDatabase.getInstance();
    public FriendSuggestionGUI(User user, String title,HashMap<String,User>users) {
        super(user,"Suggestions",users);
        ndb.loadnotification();
    }
    @Override
    protected void populateUserList() {
        List<String> suggestions = currentUser.getSuggestions();  
        for (String suggest : suggestions) {
            User suggestedUser = userSearch.getUserById(suggest);
            userPanel.add(createUserPanel(suggestedUser)); 
        }
    }
    @Override
    protected JPanel createUserPanel(User suggest) {
      JPanel suggestPanel = new JPanel();
        suggestPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        JLabel photoLabel = new JLabel();
         String path=suggest.getProfilePhotoPath();
        ImageIcon imageicon=new userService().saveImageIconProfile(path);
        photoLabel.setIcon(imageicon);
        photoLabel.setPreferredSize(new Dimension(50, 50));
        
        JLabel nameLabel = new JLabel(suggest.getUsername());
        
            JButton addButton = new JButton("Add Friend");
            addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addfriend.png")));
            addButton.setText("Add Friend");
            JButton removeButton = new JButton("Remove");
            removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png")));
            removeButton.setText("Remove");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new FriendSuggestion().acceptSuggestion(currentUser, userService.getUser(suggest.getUserId()));
                     Notification notification = new Notification(currentUser.getUserId(),suggest.getUserId());
                    ndb.addnotification(notification);
                    ndb.savenotifications();
                    refreshUI(); 
            }
        });

       
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new FriendSuggestion().RemoveSuggestion(currentUser, userService.getUser(suggest.getUserId()));
                    refreshUI();
            }
        });

        suggestPanel.add(photoLabel);
        suggestPanel.add(nameLabel);
        suggestPanel.add(addButton);
        suggestPanel.add(removeButton);

        return suggestPanel;
    }

}
