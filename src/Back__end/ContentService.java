package Back__end;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//import static Back__end.userService.getPathAndName;
import Front__end.ViewProfileSearchGUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ahmed
 */
public class ContentService {

    static ContentDatabase content = ContentDatabase.getInstance();

    public ContentService() {
    }

    public static ArrayList<JPanel> getPosts(User user) {
        content.loadContent();
        ArrayList<JPanel> posts = new ArrayList<>();
        for (Content c : content.getContents()) {
            if (c.getAuthorId().equals(user.getUserId()) && !c.isStory()) {
                posts.add(new ContentService().createContentPanel(c));

            }
        }
        return posts;
    }

    public static ArrayList<JPanel> getPostOfFriends(User user) {
        ArrayList<JPanel> posts = new ArrayList<>();
        content.loadContent();
        for (String id : user.getFriendsIdArray()) {
            for (Content c : content.getContents()) {
                if (c.getAuthorId().equals(id) && !c.isStory()) {
                    posts.add(new ContentService().createContentPanel(c));
                }
            }
        }
        return posts;
    }

    public static ArrayList<JPanel> getPostsOfGroupsByUserId(String userId) {
        ArrayList<JPanel> posts = new ArrayList<>();
        GroupDatabase.loadGroupsFromJson();
        GroupPostsDatabase.loadFromJSON();
        for (Group group : GroupDatabase.getGroups()) {
            if (group.getPrimaryAdmin().equals(userId) || group.getAdmins().contains(userId) || group.getMembers().contains(userId)) {
                for (String postId : group.getPostsId()) {
                    GroupPost post = GroupPostsDatabase.getGroupPostById(postId);
                    posts.add(new ContentService().createGroupPostPanel(post));
                }
            }
        }
        return posts;
    }

    public static ArrayList<JPanel> getStoriesOfFriend(String freindid) {
        ArrayList<JPanel> stories = new ArrayList<>();
        content.loadContent();

        for (Content c : content.getContents()) {
            if (c.getAuthorId().equals(freindid) && c.isStory()) {
                stories.add(new ContentService().createContentPanel(c));
            }
        }
        return stories;
    }
    
    public JPanel createGroupPostPanel(GroupPost content) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boolean nopath = false;
        // Text content
        ArrayList<String> userandpath = userService.getPathAndName(content.getAuthorId());

        String name = userandpath.get(0);
        String photoPath = null;
        if (!userandpath.get(1).equals("")) {
            photoPath = userandpath.get(1);
        } else {
            nopath = true;
        }

        JPanel authorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Load the image and create a JLabel for it
        ImageIcon imgicon = null;
        try {

            if (nopath) {
                imgicon = new javax.swing.ImageIcon(getClass().getResource("/icons/noprofile.png"));
            } else {
                imgicon = new ImageIcon(photoPath);
            }
            Image image = imgicon.getImage();
            Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Resize to fit
            imgicon = new ImageIcon(resizedImage);

        } catch (Exception e) {
            e.printStackTrace();
        } // Replace with your image path
        GroupDatabase.loadGroupsFromJson();
        GroupPostsDatabase.loadFromJSON();
        String groupId = content.getGroupID();
        Group g = GroupDatabase.getGroupById(groupId);

        MyButton button = new MyButton();
            button.setIcon(imgicon);
            button.setRedius(50);
            button.setColorover(new java.awt.Color(153, 204, 255));
            button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                     ViewProfileSearchGUI viewProfile=new ViewProfileSearchGUI(userService.getUser(content.getAuthorId()));
                     viewProfile.setVisible(true);    
                    }
                });

        // Create a JLabel for the text
        JLabel textLabel = new JLabel();
        textLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 20));
        textLabel.setText("<html><b>" + g.getName() + "<br>" + name + "</b></html>");

        // Add the image label and text label to the panel
        authorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        authorPanel.add(button);
        authorPanel.add(textLabel);

        JLabel contentText = new JLabel();
        contentText.setFont(new java.awt.Font("Plain", 0, 18));
        contentText.setText(content.getContentText());
        String[] date = content.getTimestamp().split("T");
        String Date = date[0];
        LocalDate D = LocalDate.parse(Date, DateTimeFormatter.ISO_DATE);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        String formattedDate = D.format(outputFormatter);
        JLabel timestamp = new JLabel();
        timestamp.setFont(new java.awt.Font("Plain", 0, 16));
        timestamp.setText(formattedDate);
        // Arrange text in a vertical panel 
        JPanel textPanel = new JPanel();

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(contentText);
        textPanel.add(timestamp);
        // Image content
        ImageIcon icon = new ImageIcon(content.getImagePath());
        Image scaledImage = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledimage = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledimage);

        // Combine text and image in a single panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(authorPanel, BorderLayout.NORTH);
        contentPanel.add(textPanel, BorderLayout.CENTER);
        contentPanel.add(imageLabel, BorderLayout.SOUTH);
        panel.add(contentPanel, BorderLayout.NORTH);

        return panel;
    }

    private JPanel createContentPanel(Content content) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boolean nopath = false;
        // Text content
        ArrayList<String> userandpath = userService.getPathAndName(content.getAuthorId());

        String name = userandpath.get(0);
        String photoPath = null;
        if (!userandpath.get(1).equals("")) {
            photoPath = userandpath.get(1);
        } else {
            nopath = true;
        }

        JPanel authorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Load the image and create a JLabel for it
        ImageIcon imgicon = null;
        try {

            if (nopath) {
                imgicon = new javax.swing.ImageIcon(getClass().getResource("/icons/noprofile.png"));
            } else {
                imgicon = new ImageIcon(photoPath);
            }
            Image image = imgicon.getImage();
            Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Resize to fit
            imgicon = new ImageIcon(resizedImage);

        } catch (Exception e) {
            e.printStackTrace();
        } // Replace with your image path
  
        MyButton button = new MyButton();
            button.setIcon(imgicon);
            button.setRedius(50);
            button.setColorover(new java.awt.Color(153, 204, 255));
            button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                     ViewProfileSearchGUI viewProfile=new ViewProfileSearchGUI(userService.getUser(content.getAuthorId()));
                     viewProfile.setVisible(true);    
                    }
                });
        // Create a JLabel for the text
        JLabel textLabel = new JLabel();
        textLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 20));
        textLabel.setText("<html><b>" + name + "</b></html>");

        // Add the image label and text label to the panel
        authorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        authorPanel.add(button);
        authorPanel.add(textLabel);

        JLabel contentText = new JLabel();
        contentText.setFont(new java.awt.Font("Plain", 0, 18));
        contentText.setText(content.getContentText());
        String[] date = content.getTimestamp().split("T");
        String Date = date[0];
        LocalDate D = LocalDate.parse(Date, DateTimeFormatter.ISO_DATE);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        String formattedDate = D.format(outputFormatter);
        JLabel timestamp = new JLabel();
        timestamp.setFont(new java.awt.Font("Plain", 0, 16));
        timestamp.setText(formattedDate);
        // Arrange text in a vertical panel 
        JPanel textPanel = new JPanel();

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(contentText);
        textPanel.add(timestamp);
        // Image content
        ImageIcon icon = new ImageIcon(content.getImagePath());
        Image scaledImage = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledimage = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledimage);

        // Combine text and image in a single panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(authorPanel, BorderLayout.NORTH);
        contentPanel.add(textPanel, BorderLayout.CENTER);
        contentPanel.add(imageLabel, BorderLayout.SOUTH);
        panel.add(contentPanel, BorderLayout.NORTH);

        return panel;
    }

    public static boolean haveStories(String id) {
        content.loadContent();

        for (Content c : content.getContents()) {
            if (c.getAuthorId().equals(id) && c.isStory()) {
                return true;
            }
        }
        return false;
    }
}
