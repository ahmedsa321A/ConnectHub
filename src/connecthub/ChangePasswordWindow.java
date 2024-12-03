
package connecthub;

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
        oldPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        changeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        oldPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        oldPasswordLabel.setText("Enter Old Password");

        newPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        newPasswordLabel.setText("Enter New Password");

        oldPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        newPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        changeButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        changeButton.setText("Change");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oldPasswordLabel)
                    .addComponent(newPasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(oldPasswordField))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(changeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPasswordLabel)
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordLabel)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
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
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JPasswordField oldPasswordField;
    private javax.swing.JLabel oldPasswordLabel;
    // End of variables declaration//GEN-END:variables
}
