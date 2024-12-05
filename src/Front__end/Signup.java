package Front__end;

import Back__end.userService;
import java.awt.Color;
import java.awt.Font;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Signup extends javax.swing.JFrame {

    public Signup() {
        initComponents();
        addPlaceholderStyle(emailtext);
        addPlaceholderStyle(password);
        addPlaceholderStyle(password2);
        addPlaceholderStyle(usernametext);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usernametext = new Back__end.MyTextField();
        emailtext = new Back__end.MyTextField();
        password = new Back__end.MyPasswordField();
        password2 = new Back__end.MyPasswordField();
        signup = new Back__end.MyButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Signup");
        setBackground(new java.awt.Color(51, 153, 255));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel4.setText("Date of birth");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel5.setText("Confirm Password");

        usernametext.setText("Username");
        usernametext.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/username.png"))); // NOI18N
        usernametext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernametextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernametextFocusLost(evt);
            }
        });

        emailtext.setText("Email");
        emailtext.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup email.png"))); // NOI18N
        emailtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailtextFocusLost(evt);
            }
        });

        password.setText("Password");
        password.setEchoChar('\u0000');
        password.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup password.png"))); // NOI18N
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });

        password2.setText("Confirm Password");
        password2.setEchoChar('\u0000');
        password2.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup password.png"))); // NOI18N
        password2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                password2FocusLost(evt);
            }
        });

        signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup.png"))); // NOI18N
        signup.setColor(new java.awt.Color(255, 255, 255));
        signup.setRedius(50);
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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailtext, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(password2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(usernametext, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernametext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailtext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernametextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernametextFocusGained
        if (usernametext.getText().equals("Username")) {
            usernametext.setText(null);
            usernametext.requestFocus();
            removePlaceholderStyle(usernametext);
        }    }//GEN-LAST:event_usernametextFocusGained

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        if (password.getText().equals("Password")) {
            password.setText(null);
            password.requestFocus();
            password.setEchoChar('*');
            removePlaceholderStyle(password);
        }
    }//GEN-LAST:event_passwordFocusGained

    private void password2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password2FocusGained
        if (password2.getText().equals("Confirm Password")) {
            password2.setText(null);
            password2.requestFocus();
            password2.setEchoChar('*');
            removePlaceholderStyle(password2);
        }
    }//GEN-LAST:event_password2FocusGained

    private void emailtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailtextFocusGained
       if (emailtext.getText().equals("Email")) {
            emailtext.setText(null);
            emailtext.requestFocus();
            removePlaceholderStyle(emailtext);
        }
    }//GEN-LAST:event_emailtextFocusGained

    private void usernametextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernametextFocusLost
         if (usernametext.getText().length() == 0) {
            addPlaceholderStyle(usernametext);
            usernametext.setText("Username");
        }
    }//GEN-LAST:event_usernametextFocusLost

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
         if (password.getText().length() == 0) {
            addPlaceholderStyle(password);
            password.setText("Password");
            password.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_passwordFocusLost

    private void password2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password2FocusLost
         if (password2.getText().length() == 0) {
            addPlaceholderStyle(password2);
            password2.setText("Confirm Password");
            password2.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_password2FocusLost

    private void emailtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailtextFocusLost
         if (emailtext.getText().length() == 0) {
            addPlaceholderStyle(emailtext);
            emailtext.setText("Email");

        }
    }//GEN-LAST:event_emailtextFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
String username = usernametext.getText();
        char[] pass1 = password.getPassword();
        String password1 = new String(pass1);
        char[] pass2 = password2.getPassword(); // Second password field
        String password2 = new String(pass2);
        String email = emailtext.getText();
        Date selectedDate = jDateChooser1.getDate();
        String date = "";

        if (selectedDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.format(selectedDate);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a date.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (username.isEmpty() || password1.isEmpty() || password2.isEmpty() || email.isEmpty() || date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!password1.equals(password2)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!userService.isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (userService.checkIfUserExists(email)) {
            JOptionPane.showMessageDialog(this, "email already exists", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                userService.signup(email, username, password2, date);
                JOptionPane.showMessageDialog(this, "Sign Up Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
          
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, "Error in hashing password", ex);
                JOptionPane.showMessageDialog(this, "Error during signup. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, "Unexpected error during signup", ex);
                JOptionPane.showMessageDialog(this, "Unexpected error. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        }    }//GEN-LAST:event_signupActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Back__end.MyTextField emailtext;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private Back__end.MyPasswordField password;
    private Back__end.MyPasswordField password2;
    private Back__end.MyButton signup;
    private Back__end.MyTextField usernametext;
    // End of variables declaration//GEN-END:variables
}
