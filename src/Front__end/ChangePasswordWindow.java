
package Front__end;

import Back__end.userService;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        setTitle("Change Password");
        setBackground(new java.awt.Color(51, 153, 255));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        oldPasswordLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        oldPasswordLabel.setText("Enter Old Password");

        newPasswordLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        newPasswordLabel.setText("Enter New Password");

        changeButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        changeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        changeButton.setText("Change");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        newPasswordField.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new password.png"))); // NOI18N
        newPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newPasswordFieldFocusLost(evt);
            }
        });

        oldPasswordField.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/currentpassword.png"))); // NOI18N
        oldPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                oldPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                oldPasswordFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordLabel)
                    .addComponent(oldPasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(changeButton)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed

        try {
            String oldhashed=userService.hashPassword(oldPasswordField.getText());
            if(oldPasswordField.getText().isEmpty() || newPasswordField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "There is empty field!","ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if (!oldhashed.equals(this.oldPassword)){
            JOptionPane.showMessageDialog(this, "Wrong Password!","ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (newPasswordField.getText().equals(oldPasswordField.getText())&&oldhashed.equals(this.oldPassword)){
            JOptionPane.showMessageDialog(this, "Cannot Change Password To The Old One!","ERROR", JOptionPane.ERROR_MESSAGE);
        } else{
            this.newPassword=this.newPasswordField.getText();
            JOptionPane.showMessageDialog(this, "Password has changed Successfully ","Successful", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChangePasswordWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_changeButtonActionPerformed

    private void oldPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldPasswordFieldFocusGained
  
    }//GEN-LAST:event_oldPasswordFieldFocusGained

    private void newPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordFieldFocusGained

    }//GEN-LAST:event_newPasswordFieldFocusGained

    private void oldPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldPasswordFieldFocusLost
         
    }//GEN-LAST:event_oldPasswordFieldFocusLost

    private void newPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordFieldFocusLost
    
    }//GEN-LAST:event_newPasswordFieldFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

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
