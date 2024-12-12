package Front__end;

import Back__end.Group;
import Back__end.GroupDatabase;
import Back__end.GroupMemberManger;
import Back__end.MyButton;
import Back__end.Photo;
import Back__end.User;
import Back__end.UserRepository;
import Back__end.userService;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GroupSuggestionWindow extends javax.swing.JDialog {

    private User user;

    public GroupSuggestionWindow(java.awt.Frame parent, User user, boolean modal) {
        super(parent, modal);
        initComponents();
        UserRepository.loadUsersFromJson();
        this.user=userService.getUser(user.getUserId());
        showGroupSuggestions(this.user.getGroupSuggestions());
        this.setVisible(modal);
    }

    private void showGroupSuggestions(List<String> groupList) {
        GroupDatabase.loadGroupsFromJson();
        for (String groupId : groupList) {
            Group group = GroupDatabase.getGroupById(groupId);
            JPanel grouppanel = new JPanel();
            grouppanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            MyButton button = new MyButton();
//            JLabel imgLabel = new JLabel();
//            Photo.setPhoto(imgLabel, group.getGroupPhotoPath());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    user.removeGroupFromSuggestion(groupId);
                    GroupMemberManger.addRequest(user.getUserId(), groupId);
                    GroupDatabase.saveGroupsToJson();
                    UserRepository.saveData();
                    GroupDatabase.loadGroupsFromJson();
                    UserRepository.loadUsersFromJson();
                    User u = userService.getUser(user.getUserId());
                    groupSuggestionPanel.removeAll();
                    showGroupSuggestions(u.getGroupSuggestions());
                    groupSuggestionPanel.revalidate();
                    groupSuggestionPanel.repaint();
                }
            });
            JLabel nameLabel = new JLabel(group.getName());
            button.setText("Request");
//            grouppanel.add(imgLabel);
            grouppanel.add(nameLabel);
            grouppanel.add(button);
            groupSuggestionPanel.add(grouppanel);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        groupSuggestionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout groupSuggestionPanelLayout = new javax.swing.GroupLayout(groupSuggestionPanel);
        groupSuggestionPanel.setLayout(groupSuggestionPanelLayout);
        groupSuggestionPanelLayout.setHorizontalGroup(
            groupSuggestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        groupSuggestionPanelLayout.setVerticalGroup(
            groupSuggestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(groupSuggestionPanel);
        groupSuggestionPanel.setLayout(new BoxLayout(groupSuggestionPanel, BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Group Suggestion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel groupSuggestionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
