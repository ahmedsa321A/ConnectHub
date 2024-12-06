
package Front__end;
import Back__end.FriendSuggestion;
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

public class FriendSuggestionGUI extends FriendsParentGUI{
    public FriendSuggestionGUI(User user, String title,HashMap<String,User>users) {
        super(user,"Suggestions",users);
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
        ImageIcon photoIcon = loadImageIcon(suggest.getProfilePhotoPath());
        photoLabel.setIcon(photoIcon);
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
                    new FriendSuggestion().acceptSuggestion(currentUser, suggest);
                    refreshUI(); 
            }
        });

       
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new FriendSuggestion().RemoveSuggestion(currentUser, suggest);
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
