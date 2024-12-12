package Front__end;

import Back__end.ContentService;
import Back__end.ContentDatabase;
import Back__end.FriendLoader;
import Back__end.FriendRequests;
import Back__end.FriendSuggestion;
import Back__end.MyButton;
import Back__end.Notification;
import Back__end.NotificationDatabase;
import Back__end.NotificationService;
import Back__end.RelationshipManager;
import Back__end.RelationshipStatus;
import Back__end.SearchResults;
import Back__end.User;
import Back__end.UserRepository;
import Back__end.UserSearch;
import Back__end.UserSearchResults;
import Back__end.userService;
import com.google.gson.reflect.TypeToken;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewsFeedWindow extends javax.swing.JFrame {

    private User user;
    ContentDatabase db = ContentDatabase.getInstance();
    NotificationDatabase ndb = NotificationDatabase.getInstance();
    NotificationService ns = new NotificationService();

    public NewsFeedWindow(User user) {
        initComponents();
        addPlaceholderStyle(UsersSearchBar);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UserRepository.loadUsersFromJson();
                User currentuser = userService.getUser(user.getUserId());
                currentuser.setStatus("offline");
                UserRepository.saveData();
                ndb.loadnotification();
                ndb.savenotifications();
                Login login = new Login();
            }
        });

        this.setVisible(true);
        UserRepository.loadUsersFromJson();
        this.user = userService.getUser(user.getUserId());
        db.loadContent();
        ndb.loadnotification();
        db.deleteExpiredStories();
        ContentDatabase.getInstance().saveContent();
        UserRepository.saveData();
        reloadSuggestionsStatus();
        showPosts(user);
        showFriendsList();
        shownotification();
        showstoryList();
        showSuggestions();

    }
public void addPlaceholderStyle(JTextField textfield) {
        Font font = textfield.getFont();
        font = font.deriveFont(Font.ITALIC);
        textfield.setFont(font);
        textfield.setForeground(Color.GRAY);

    }

    public void removePlaceholderStyle(JTextField textfield) {
        Font font = textfield.getFont();
        font = font.deriveFont(Font.PLAIN | Font.PLAIN);
        textfield.setFont(font);
        textfield.setForeground(Color.BLACK);

    }
    private void showFriendsList() {
        ArrayList<String> friendsIdList = (ArrayList<String>) user.getFriendsIdArray();
        for (String friendId : friendsIdList) {
            ArrayList<String> friendData = userService.getPathAndName(friendId);
            String name = friendData.get(0);
            String photoPath = friendData.get(1);
            JPanel friendPanel = new JPanel();
            friendPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            ImageIcon imgicon = new userService().saveImageIconProfile(photoPath);
            JLabel imageLabell = new JLabel(imgicon);
            JLabel nameLabel = new JLabel(name);
            ImageIcon status = null;
            try {
                User user = userService.getUser(friendId);
                if (user.getStatus().equals("online")) {
                    status = new javax.swing.ImageIcon(getClass().getResource("/icons/online.png"));
                } else {
                    status = new javax.swing.ImageIcon(getClass().getResource("/icons/offline.png"));
                }
                Image image = status.getImage();
                Image resizedImage = image.getScaledInstance(7, 7, Image.SCALE_SMOOTH); // Resize to fit
                status = new ImageIcon(resizedImage);
            } catch (Exception e) {
            }
            JLabel statusLabel = new JLabel(status);
            friendPanel.add(imageLabell);
            friendPanel.add(nameLabel);
            friendPanel.add(statusLabel);
            friendListPanel.add(friendPanel);
        }
    }

    private void shownotification() {

        notificationcounter.setText("" + ndb.getnumberofnotification(user.getUserId()));
        ns.createfriendrequestnotification(notificationPanel, user.getUserId());

    }

    private void showstoryList() {
        ArrayList<String> friendsIdList = (ArrayList<String>) user.getFriendsIdArray();
        for (String friendId : friendsIdList) {
            if (ContentService.haveStories(friendId)) {
                ArrayList<String> friendData = userService.getPathAndName(friendId);
                String name = friendData.get(0);
                String photoPath = friendData.get(1);
                JPanel storyPanel = new JPanel();
                storyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                ImageIcon imgicon = new userService().saveImageIconProfile(photoPath);
                MyButton button = new MyButton();
                button.setIcon(imgicon);
                button.setText(name);
                storyPanel.add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new StoriesGui(friendId);
                        refreshUI();
                    }
                });
                storiesPanel.add(storyPanel);
            }
        }
    }

    private void refreshUI() {
        // Remove all existing components from the panel
        friendSuggestionPanel.removeAll();

        // Refresh the suggestions by calling the method again
        showSuggestions();

        // Revalidate and repaint the panel to reflect changes
        friendSuggestionPanel.revalidate();
        friendSuggestionPanel.repaint();
    }

    public void showSuggestions() {
        UserRepository.loadUsersFromJson();
        user = userService.getUser(user.getUserId());
        UserSearch search = new UserSearch();
        search.setAllMap(UserRepository.userList);
        for (Map.Entry<String, User> entry : search.getMap().entrySet()) {
            User otherUser = entry.getValue();

            if (!user.getUserId().equals(otherUser.getUserId())) {
                RelationshipStatus status = RelationshipManager.getRelationshipStatus(user, otherUser);

                if (status == RelationshipStatus.NOT_FRIENDS) {
                    user.addSuggestion(otherUser.getUserId());
                }
            }
        }
        ArrayList<String> friendsSuggestionIdList = (ArrayList<String>) user.getSuggestions();
        for (String id : friendsSuggestionIdList) {
            ArrayList<String> data = userService.getPathAndName(id);
            boolean nopath = false;
            String name = data.get(0);
            String photoPath = data.get(1);
            JPanel Panel = new JPanel();
            Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            ImageIcon imgicon = new userService().saveImageIconProfile(photoPath);
            JLabel imageLabell = new JLabel(imgicon);
            JLabel nameLabel = new JLabel(name);
            Panel.add(imageLabell);
            Panel.add(nameLabel);
            JButton addButton = new JButton("Add Friend");
            addButton = new javax.swing.JButton();
            addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addfriend.png"))); // NOI18N
            addButton.setText("Add Friend");
            JButton removeButton = new JButton("Remove");
            removeButton = new javax.swing.JButton();
            removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
            removeButton.setText("Remove");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new FriendSuggestion().acceptSuggestion(user, userService.getUser(id));
                    Notification notification = new Notification.Builder().setNotificationtype("Friend")
                            .setSenderuserid(user.getUserId())
                            .setReceiveruserid(id)
                            .build();
                    ndb.addnotification(notification);
                    ndb.savenotifications();
                    UserRepository.saveData();
                    refreshUI();
                }
            });

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new FriendSuggestion().RemoveSuggestion(user, userService.getUser(id));
                    UserRepository.saveData();
                    refreshUI();
                }
            });
            Panel.add(addButton);
            Panel.add(removeButton);
            friendSuggestionPanel.add(Panel);

        }

    }

    private void showPosts(User user) {
        ArrayList<JPanel> posts = ContentService.getPostOfFriends(user);
        for (JPanel post : posts) {
            this.newsFeedPanel.add(post);
        }
    }

    private UserSearch reloadSuggestionsStatus() {
        UserRepository.loadUsersFromJson();
        user = userService.getUser(user.getUserId());
        FriendLoader load = new FriendLoader();

        java.lang.reflect.Type typeOfT = new TypeToken<List<User>>() {
        }.getType();

        load.loadFromFile(user, "user_db.json", typeOfT);

        UserSearch search = new UserSearch();
        search.setAllMap(UserRepository.userList);

        for (Map.Entry<String, User> entry : search.getMap().entrySet()) {
            User otherUser = entry.getValue();

            if (!user.getUserId().equals(otherUser.getUserId())) {
                RelationshipStatus status = RelationshipManager.getRelationshipStatus(user, otherUser);

                if (status == RelationshipStatus.NOT_FRIENDS) {
                    user.addSuggestion(otherUser.getUserId());
                }
            }
        }
        UserRepository.saveData();
        return search;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newsFeedPanel = new javax.swing.JPanel();
        home = new Back__end.MyButton();
        story = new Back__end.MyButton();
        post = new Back__end.MyButton();
        friends = new Back__end.MyButton();
        refresh = new Back__end.MyButton();
        profile = new Back__end.MyButton();
        logout = new Back__end.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        friendListPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        friendSuggestionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        storiesPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        notificationPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        notificationcounter = new javax.swing.JLabel();
        UsersSearchBar = new Back__end.MyTextField();
        myTextField2 = new Back__end.MyTextField();
        UserSearch = new Back__end.MyButton();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Newfeed");
        setBackground(new java.awt.Color(51, 153, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        javax.swing.GroupLayout newsFeedPanelLayout = new javax.swing.GroupLayout(newsFeedPanel);
        newsFeedPanel.setLayout(newsFeedPanelLayout);
        newsFeedPanelLayout.setHorizontalGroup(
            newsFeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        newsFeedPanelLayout.setVerticalGroup(
            newsFeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );

        newsFeedPanel.setPreferredSize(new Dimension(504, 607));

        jScrollPane1.setViewportView(newsFeedPanel);
        newsFeedPanel.setLayout(new BoxLayout(newsFeedPanel, BoxLayout.Y_AXIS));
        jScrollPane1.setPreferredSize(new Dimension(504, 607));

        home.setForeground(new java.awt.Color(51, 153, 255));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        home.setColorover(new java.awt.Color(153, 204, 255));
        home.setRedius(100);
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        story.setForeground(new java.awt.Color(51, 153, 255));
        story.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/story.png"))); // NOI18N
        story.setColorover(new java.awt.Color(153, 204, 255));
        story.setRedius(100);
        story.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storyActionPerformed(evt);
            }
        });

        post.setForeground(new java.awt.Color(51, 153, 255));
        post.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/post.png"))); // NOI18N
        post.setColorover(new java.awt.Color(153, 204, 255));
        post.setRedius(100);
        post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postActionPerformed(evt);
            }
        });

        friends.setForeground(new java.awt.Color(51, 153, 255));
        friends.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/friends.png"))); // NOI18N
        friends.setColorover(new java.awt.Color(153, 204, 255));
        friends.setRedius(100);
        friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsActionPerformed(evt);
            }
        });

        refresh.setForeground(new java.awt.Color(51, 153, 255));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        refresh.setColorover(new java.awt.Color(153, 204, 255));
        refresh.setRedius(100);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        profile.setForeground(new java.awt.Color(51, 153, 255));
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N
        profile.setColorover(new java.awt.Color(153, 204, 255));
        profile.setRedius(100);
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        logout.setForeground(new java.awt.Color(51, 153, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        logout.setColorover(new java.awt.Color(153, 204, 255));
        logout.setRedius(100);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout friendListPanelLayout = new javax.swing.GroupLayout(friendListPanel);
        friendListPanel.setLayout(friendListPanelLayout);
        friendListPanelLayout.setHorizontalGroup(
            friendListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        friendListPanelLayout.setVerticalGroup(
            friendListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(friendListPanel);
        friendListPanel.setLayout(new BoxLayout(friendListPanel, BoxLayout.Y_AXIS));

        javax.swing.GroupLayout friendSuggestionPanelLayout = new javax.swing.GroupLayout(friendSuggestionPanel);
        friendSuggestionPanel.setLayout(friendSuggestionPanelLayout);
        friendSuggestionPanelLayout.setHorizontalGroup(
            friendSuggestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );
        friendSuggestionPanelLayout.setVerticalGroup(
            friendSuggestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(friendSuggestionPanel);
        friendSuggestionPanel.setLayout(new BoxLayout(friendSuggestionPanel, BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FriendSuggestions.png"))); // NOI18N
        jLabel1.setText("Friend Suggestion");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/FriendsList.png"))); // NOI18N
        jLabel2.setText("My Friends");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stories.png"))); // NOI18N
        jLabel3.setText("Stories");

        javax.swing.GroupLayout storiesPanelLayout = new javax.swing.GroupLayout(storiesPanel);
        storiesPanel.setLayout(storiesPanelLayout);
        storiesPanelLayout.setHorizontalGroup(
            storiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        storiesPanelLayout.setVerticalGroup(
            storiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(storiesPanel);
        storiesPanel.setLayout(new BoxLayout(storiesPanel, BoxLayout.X_AXIS));

        notificationPanel.setPreferredSize(new Dimension(438, 251));

        javax.swing.GroupLayout notificationPanelLayout = new javax.swing.GroupLayout(notificationPanel);
        notificationPanel.setLayout(notificationPanelLayout);
        notificationPanelLayout.setHorizontalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        notificationPanelLayout.setVerticalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(notificationPanel);
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.Y_AXIS));
        jScrollPane5.setPreferredSize(new Dimension(438, 251));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("/Users/hazembarakat/Downloads/WhatsApp Image 2024-12-11 at 20.57.17-2.png")); // NOI18N
        jLabel4.add(notificationcounter);
        jLabel4.setText("Notifications");

        notificationcounter.setBackground(new java.awt.Color(204, 0, 0));
        notificationcounter.setOpaque(true);
        notificationcounter.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
        notificationcounter.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        notificationcounter.setForeground(new java.awt.Color(255, 255, 255));
        notificationcounter.setLabelFor(jLabel4);

        UsersSearchBar.setText("Search");
        UsersSearchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UsersSearchBarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UsersSearchBarFocusLost(evt);
            }
        });

        UserSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        jLabel5.setText("Search Users");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(notificationcounter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(UsersSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addComponent(UserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)
                        .addGap(656, 656, 656)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 30, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(story, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(myTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsersSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(story, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(post, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friends, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(myTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(notificationcounter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        db.loadContent();
        db.deleteExpiredStories();
        UserRepository.loadUsersFromJson();
        UserRepository.saveData();
        for (Window window : Window.getWindows()) {
            window.dispose();
        }
        NewsFeedWindow newsfeedwindow = new NewsFeedWindow(user);
    }//GEN-LAST:event_homeActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        db.loadContent();
        db.deleteExpiredStories();
        ndb.loadnotification();
        ContentDatabase.getInstance().saveContent();
        UserRepository.loadUsersFromJson();
        this.user = userService.getUser(user.getUserId());
        UserRepository.saveData();
        newsFeedPanel.removeAll();
        notificationPanel.removeAll();
        friendListPanel.removeAll();
        showPosts(user);
        shownotification();
        showFriendsList();
        newsFeedPanel.revalidate();
        notificationPanel.revalidate();
        friendListPanel.revalidate();
        friendListPanel.repaint();
        newsFeedPanel.repaint();
        notificationPanel.repaint();
    }//GEN-LAST:event_refreshActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed

        UserRepository.loadUsersFromJson();
        this.user = userService.getUser(user.getUserId());
        ProfileWindow profile = new ProfileWindow(this.user);
        this.dispose();
    }//GEN-LAST:event_profileActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        UserRepository.loadUsersFromJson();
        user = userService.getUser(user.getUserId());
        user.setStatus("offline");
        UserRepository.saveData();
        ndb.loadnotification();
        ndb.savenotifications();
        for (Window window : Window.getWindows()) {
            window.dispose();
        }
        JOptionPane.showMessageDialog(this, "logout Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        Login login = new Login();
    }//GEN-LAST:event_logoutActionPerformed

    private void postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postActionPerformed
        PostGui post = new PostGui(user);
        this.dispose();
    }//GEN-LAST:event_postActionPerformed

    private void storyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storyActionPerformed
        StoryGui story = new StoryGui(user);
        this.dispose();
    }//GEN-LAST:event_storyActionPerformed

    private void friendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsActionPerformed
        FriendsCenter friends = new FriendsCenter(user, reloadSuggestionsStatus().getMap());
        setVisible(false);
    }//GEN-LAST:event_friendsActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void UserSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserSearchActionPerformed

        String search = UsersSearchBar.getText().toLowerCase();
        SearchResults<User> userSearch = new UserSearchResults();

        userSearch.searchObjects(search);

        // Retrieve the search results
        ArrayList<User> results = userSearch.getSearchResults();

        UserSearchGUI userSearchWindow = new UserSearchGUI(user, results);
        userSearchWindow.setVisible(true);    }//GEN-LAST:event_UserSearchActionPerformed

    private void UsersSearchBarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsersSearchBarFocusGained
          if (UsersSearchBar.getText().equals("Search")) {
            UsersSearchBar.setText(null);
            UsersSearchBar.requestFocus();
            removePlaceholderStyle(UsersSearchBar);
        }
    }//GEN-LAST:event_UsersSearchBarFocusGained

    private void UsersSearchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsersSearchBarFocusLost
         if (UsersSearchBar.getText().length() == 0) {
            addPlaceholderStyle(UsersSearchBar);
            UsersSearchBar.setText("Search");

        }
    }//GEN-LAST:event_UsersSearchBarFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Back__end.MyButton UserSearch;
    private Back__end.MyTextField UsersSearchBar;
    private javax.swing.JPanel friendListPanel;
    private javax.swing.JPanel friendSuggestionPanel;
    private Back__end.MyButton friends;
    private Back__end.MyButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private Back__end.MyButton logout;
    private Back__end.MyTextField myTextField2;
    private javax.swing.JPanel newsFeedPanel;
    private javax.swing.JPanel notificationPanel;
    private javax.swing.JLabel notificationcounter;
    private Back__end.MyButton post;
    private Back__end.MyButton profile;
    private Back__end.MyButton refresh;
    private javax.swing.JPanel storiesPanel;
    private Back__end.MyButton story;
    // End of variables declaration//GEN-END:variables
}
