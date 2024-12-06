package Front__end;

import Back__end.User;
import Back__end.UserRepository;
import Back__end.UserSearch;
import Back__end.userService;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public abstract class FriendsParentGUI extends javax.swing.JFrame {

    protected User currentUser;
    protected JPanel userPanel;
    protected JScrollPane scrollPane;
    protected String title;
    protected UserSearch userSearch;

    public FriendsParentGUI(User user, String title, HashMap<String, User> users) {
        UserRepository.loadUsersFromJson();
        this.currentUser = userService.getUser(user.getUserId());
        this.title = title;
        userSearch = new UserSearch();
        userSearch.setUserMap(users);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(title + " List");

        JLabel titleLabel = new JLabel("Your " + title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS)); // Use vertical layout to list friends

        populateUserList();

        scrollPane = new JScrollPane(userPanel);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UserRepository.saveData();
                dispose();
            }
        });
        setVisible(true);
    }

    protected ImageIcon loadImageIcon(String photoPath) {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(photoPath);
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Resize to fit
            icon = new ImageIcon(resizedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icon;
    }

    protected abstract void populateUserList();

    protected abstract JPanel createUserPanel(User user);

    protected void refreshUI() {
        userPanel.removeAll();
        populateUserList();
        userPanel.revalidate();
        userPanel.repaint();
    }
}
