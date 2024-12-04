
package Front__end;

import javax.swing.JOptionPane;


public class ChangePasswordWindow extends javax.swing.JDialog {
    
    private String newPassword;
    private String oldPassword;

    public ChangePasswordWindow(java.awt.Dialog parent, String oldPassword, boolean modal) {
        super(parent, modal);
        initComponents();
        this.oldPassword=oldPassword;
        this.setVisible(modal);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oldPasswordLabel = new javax.swing.JLabel();
        newPasswordLabel = new javax.swing.JLabel();
        changeButton = new javax.swing.JButton();
        newPasswordField = new Back__end.MyPasswordField();
        oldPasswordField = new Back__end.MyPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        oldPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        oldPasswordLabel.setText("Enter Old Password");

        newPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        newPasswordLabel.setText("Enter New Password");

        changeButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        changeButton.setText("Change");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        newPasswordField.setText("Password");
        newPasswordField.setEchoChar('\u0000');
        newPasswordField.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/password.png"))); // NOI18N

        oldPasswordField.setText("Password");
        oldPasswordField.setEchoChar('\u0000');
        oldPasswordField.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/password.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(oldPasswordLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(changeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newPasswordLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPasswordLabel)
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addComponent(changeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        if(oldPasswordField.getText().isEmpty() || newPasswordField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "There is empty field!","ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if (!oldPasswordField.getText().equals(this.oldPassword)){
            JOptionPane.showMessageDialog(this, "Wrong Password!","ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (newPasswordField.getText().equals(this.oldPassword)){
            JOptionPane.showMessageDialog(this, "Cannot Change Password To The Old One!","ERROR", JOptionPane.ERROR_MESSAGE);
        } else{
            this.newPassword=this.newPasswordField.getText();
            this.dispose();
        }
    }//GEN-LAST:event_changeButtonActionPerformed

    public static String newPassword(java.awt.Dialog frame, String oldPassword){
        ChangePasswordWindow dialog = new ChangePasswordWindow(frame, oldPassword, true);
        return dialog.newPassword;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeButton;
    private Back__end.MyPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLabel;
    private Back__end.MyPasswordField oldPasswordField;
    private javax.swing.JLabel oldPasswordLabel;
    // End of variables declaration//GEN-END:variables
}
