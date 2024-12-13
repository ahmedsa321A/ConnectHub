package Front__end;

import Back__end.Group;
import Back__end.GroupDataBase;
import Back__end.Photo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CreateGroupWindow extends javax.swing.JDialog {

    private String id;
    private String photoPath;

    public CreateGroupWindow(java.awt.Frame parent, String userId, boolean modal) {
        super(parent, modal);
        initComponents();
        this.id = userId;
        this.photoPath = "";
        ImageIcon img = saveImageIconGroup(photoPath);
        photoLabel.setIcon(img);
        this.setVisible(modal);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        groupNameTextField = new javax.swing.JTextField();
        createGroupButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        photoLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        discreptionTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Discreption");

        groupNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        createGroupButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        createGroupButton.setText("Create");
        createGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createGroupButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Photo");

        photoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/nogroup.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Select Photo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        discreptionTextArea.setColumns(20);
        discreptionTextArea.setRows(5);
        jScrollPane1.setViewportView(discreptionTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(createGroupButton)
                        .addGap(179, 179, 179))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3)
                            .addComponent(jButton1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(groupNameTextField)
                            .addComponent(photoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(groupNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createGroupButton)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createGroupButtonActionPerformed
        String name = groupNameTextField.getText();
        String discreption = discreptionTextArea.getText();
        GroupDataBase.loadGroupsFromJson();
        Group group = new Group(name, discreption, this.photoPath, id);
        GroupDataBase.addGroup(group);
        JOptionPane.showMessageDialog(null, "Group Created Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_createGroupButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String Path = Photo.selectPhoto(photoLabel, this);
            if (!Path.equals(null)) {
                Photo.setPhoto(photoLabel, Path);
                this.photoPath = Path;
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public ImageIcon saveImageIconGroup(String photoPath) {
        ImageIcon imgicon;
        if (photoPath.equals("")) {
            imgicon = new javax.swing.ImageIcon(getClass().getResource("/icons/nogroup.png"));
        } else {
            imgicon = new ImageIcon(photoPath);
        }
        Image image = imgicon.getImage();
        Image resizedImage = image.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Resize to fit
        imgicon = new ImageIcon(resizedImage);
        return imgicon;
    }

    public static void createGroup(java.awt.Frame frame, String userId) {
        CreateGroupWindow dialog = new CreateGroupWindow(frame, userId, true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createGroupButton;
    private javax.swing.JTextArea discreptionTextArea;
    private javax.swing.JTextField groupNameTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel photoLabel;
    // End of variables declaration//GEN-END:variables
}
