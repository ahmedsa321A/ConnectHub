package Front__end;

import Back__end.Group;
import Back__end.GroupDatabase;
import Back__end.GroupDatabase;
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
        jLabel3 = new javax.swing.JLabel();
        photoLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        discreptionTextArea = new javax.swing.JTextArea();
        creategroupButton = new Back__end.MyButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Discreption");

        groupNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Photo");

        photoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/nogroup.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        jButton1.setText("Select Photo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        discreptionTextArea.setColumns(20);
        discreptionTextArea.setRows(5);
        jScrollPane1.setViewportView(discreptionTextArea);

        creategroupButton.setBackground(new java.awt.Color(51, 153, 255));
        creategroupButton.setForeground(new java.awt.Color(255, 255, 255));
        creategroupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/create.png"))); // NOI18N
        creategroupButton.setText("Create");
        creategroupButton.setColor(new java.awt.Color(51, 153, 255));
        creategroupButton.setColorover(new java.awt.Color(51, 102, 255));
        creategroupButton.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        creategroupButton.setRedius(50);
        creategroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creategroupButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(groupNameTextField)
                    .addComponent(photoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(creategroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(groupNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel3)
                                        .addGap(41, 41, 41)
                                        .addComponent(jButton1))
                                    .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(61, 61, 61)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(69, 69, 69)))
                .addComponent(creategroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void creategroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creategroupButtonActionPerformed
         String name = groupNameTextField.getText();
        String discreption = discreptionTextArea.getText();
        GroupDatabase.loadGroupsFromJson();
        Group group = new Group(name, discreption, this.photoPath, id);
        GroupDatabase.addGroup(group);
        JOptionPane.showMessageDialog(null, "Group Created Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_creategroupButtonActionPerformed

    public ImageIcon saveImageIconGroup(String photoPath) {
        ImageIcon imgicon;
        if (photoPath.equals("")) {
            imgicon = new javax.swing.ImageIcon(getClass().getResource("/icons/nogroup.png"));
        } else {
            imgicon = new ImageIcon(photoPath);
        }
        Image image = imgicon.getImage();
        Image resizedImage = image.getScaledInstance(350, 250, Image.SCALE_SMOOTH); // Resize to fit
        imgicon = new ImageIcon(resizedImage);
        return imgicon;
    }

    public static void createGroup(java.awt.Frame frame, String userId) {
        CreateGroupWindow dialog = new CreateGroupWindow(frame, userId, true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Back__end.MyButton creategroupButton;
    private javax.swing.JTextArea discreptionTextArea;
    private javax.swing.JTextField groupNameTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel photoLabel;
    // End of variables declaration//GEN-END:variables
}
