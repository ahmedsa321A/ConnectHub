/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front__end;

import Back__end.User;
import Back__end.userService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ahmed
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        addPlaceholderStyle(emailtext);
        addPlaceholderStyle(Password);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
        this.setVisible(true);
        setVisible(true);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailtext = new Back__end.MyTextField();
        Password = new Back__end.MyPasswordField();
        login = new Back__end.MyButton();
        signup = new Back__end.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("login");
        setBackground(new java.awt.Color(51, 153, 255));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel1.setText("     Email");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel2.setText("      Password");

        emailtext.setText("Email");
        emailtext.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/email.png"))); // NOI18N
        emailtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailtextFocusLost(evt);
            }
        });
        emailtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtextActionPerformed(evt);
            }
        });

        Password.setText("Password");
        Password.setEchoChar('\u0000');
        Password.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/password.png"))); // NOI18N
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFocusLost(evt);
            }
        });

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login.png"))); // NOI18N
        login.setColor(new java.awt.Color(153, 0, 255));
        login.setRedius(50);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup.png"))); // NOI18N
        signup.setColor(new java.awt.Color(255, 255, 255));
        signup.setRedius(40);
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailtext, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailtext, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtextActionPerformed

    private void emailtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailtextFocusGained
        if (emailtext.getText().equals("Email")) {
            emailtext.setText(null);
            emailtext.requestFocus();
            removePlaceholderStyle(emailtext);
        }
    }//GEN-LAST:event_emailtextFocusGained

    private void emailtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailtextFocusLost
        if (emailtext.getText().length() == 0) {
            addPlaceholderStyle(emailtext);
            emailtext.setText("Email");

        }
    }//GEN-LAST:event_emailtextFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    private void PasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusGained
        if (Password.getText().equals("Password")) {
            Password.setText(null);
            Password.requestFocus();
            Password.setEchoChar('*');
            removePlaceholderStyle(Password);
        }
    }//GEN-LAST:event_PasswordFocusGained

    private void PasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusLost
        if (Password.getText().length() == 0) {
            addPlaceholderStyle(Password);
            Password.setText("Password");
            Password.setEchoChar('\u0000');
        }    }//GEN-LAST:event_PasswordFocusLost

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String email = emailtext.getText();
        char[] pass = Password.getPassword();
        String password = new String(pass);
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
        } else try {
            User user = userService.login(email, password);
            if (user != null) {
                user.setStatus("online");
                JOptionPane.showMessageDialog(this, "login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                for (Window window : Window.getWindows()) {
                    window.dispose();
                }
                NewsFeedWindow newsfeedwindow = new NewsFeedWindow(user);
            } else {
                JOptionPane.showMessageDialog(this, "incorrect email or password", "incorrect", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, "Error in hashing password", ex);
            JOptionPane.showMessageDialog(this, "Error during login. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        Signup signup = new Signup();
    }//GEN-LAST:event_signupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Back__end.MyPasswordField Password;
    private Back__end.MyTextField emailtext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private Back__end.MyButton login;
    private Back__end.MyButton signup;
    // End of variables declaration//GEN-END:variables
}
