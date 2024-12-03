package Front__end;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.swing.*;
import java.awt.*;
import Back__end.Content;
import Back__end.ContentDatabase;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class newfeed {
    private static ContentDatabase dp=new ContentDatabase();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Newsfeed");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 800);

            // Main container panel with BorderLayout
            JPanel containerPanel = new JPanel(new BorderLayout());
            // Main content panel
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            JScrollPane scrollPane = new JScrollPane(mainPanel);
            
            // Load content from JSON
            // Add each content as a panel
          //  for (Content content : dp.getContents()) {
           //     mainPanel.add(createContentPanel(content));
          // }
            // Button panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            // Create buttons
            JButton refreshButton = new JButton();
            JButton profileButton = new JButton();
            JButton friendsButton = new JButton();
            JButton homeButton = new JButton();
            JButton storyButton = new JButton();
            JButton postButton = new JButton();
            // Add action listeners for buttons
            refreshButton.setBackground(new java.awt.Color(242, 242, 242));
            refreshButton.setIcon(new javax.swing.ImageIcon("refresh.png")); 
            refreshButton.setBorder(null);
            profileButton.setBackground(new java.awt.Color(242, 242, 242));
            profileButton.setIcon(new javax.swing.ImageIcon("profile.png")); 
            profileButton.setBorder(null);
            friendsButton.setBackground(new java.awt.Color(242, 242, 242));
            friendsButton.setIcon(new javax.swing.ImageIcon("friends.png")); 
            friendsButton.setBorder(null);
            homeButton.setBackground(new java.awt.Color(242, 242, 242));
            homeButton.setIcon(new javax.swing.ImageIcon("home.png")); 
            homeButton.setBorder(null);
            storyButton.setBackground(new java.awt.Color(242, 242, 242));
            storyButton.setIcon(new javax.swing.ImageIcon("story.png")); 
            storyButton.setBorder(null);
            postButton.setBackground(new java.awt.Color(242, 242, 242));
            postButton.setIcon(new javax.swing.ImageIcon("post.png")); 
            postButton.setBorder(null);
            refreshButton.addActionListener(e -> {
              JOptionPane.showMessageDialog(frame, "Refreshing content..."); 
            });
            profileButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame, "profile content...");
            });
            friendsButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame, "friends content...");
            });
            homeButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame, "home content...");
            });
            storyButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame, "story content...");
            });
            postButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame, "post content...");
            });
            // Add buttons to the button panel
            buttonPanel.add(homeButton);
            buttonPanel.add(profileButton);
            buttonPanel.add(storyButton);
            buttonPanel.add(postButton);
            buttonPanel.add(friendsButton);
            buttonPanel.add(refreshButton);
            // Add components to the container panel
            containerPanel.add(buttonPanel, BorderLayout.SOUTH); // Add buttons at the top
            containerPanel.add(scrollPane, BorderLayout.CENTER); // Add scrollable content in the center
            // Add container panel to the frame
            frame.add(containerPanel);
            frame.setVisible(true);
        });
    }

}
