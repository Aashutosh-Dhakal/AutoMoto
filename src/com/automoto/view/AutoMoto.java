/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.automoto.view;

import javax.swing.JOptionPane;

/**
 *
 * @author aashutoshdhakal
 */
public class AutoMoto extends javax.swing.JFrame {

    /**
     * Creates new form AutoMoto
     */
    public AutoMoto() {
        initComponents();
        labelIncorrectCredentials.setVisible(false); // Incorrect Credential Warning (as label) is hide first when the page runs.

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLoginBase = new javax.swing.JPanel();
        pnlLoginBaseCredientials = new javax.swing.JPanel();
        labelLogin = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        fieldUsername = new javax.swing.JTextField();
        buttonLogin = new javax.swing.JButton();
        buttonForgotPassword = new javax.swing.JButton();
        iconUsername = new javax.swing.JLabel();
        iconPassword = new javax.swing.JLabel();
        checkboxShowPassword = new javax.swing.JCheckBox();
        passwordField = new javax.swing.JPasswordField();
        labelIncorrectCredentials = new javax.swing.JLabel();
        iconLoginPageBase = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 750));
        setResizable(false);

        pnlLoginBase.setBackground(new java.awt.Color(34, 40, 49));
        pnlLoginBase.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlLoginBase.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlLoginBase.setPreferredSize(new java.awt.Dimension(1280, 750));
        pnlLoginBase.setLayout(null);

        pnlLoginBaseCredientials.setBackground(new java.awt.Color(255, 255, 255));

        labelLogin.setFont(new java.awt.Font("Marker Felt", 3, 72)); // NOI18N
        labelLogin.setText("Login");

        labelUsername.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelUsername.setText("Username:");

        labelPassword.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelPassword.setText("Password:");

        fieldUsername.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        fieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUsernameActionPerformed(evt);
            }
        });

        buttonLogin.setBackground(new java.awt.Color(255, 51, 51));
        buttonLogin.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Login");
        buttonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLoginMouseClicked(evt);
            }
        });
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonForgotPassword.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        buttonForgotPassword.setForeground(new java.awt.Color(255, 51, 0));
        buttonForgotPassword.setText("Forgot Password?");
        buttonForgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonForgotPasswordActionPerformed(evt);
            }
        });

        iconUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/user.png"))); // NOI18N

        iconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/password.png"))); // NOI18N

        checkboxShowPassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        checkboxShowPassword.setText("Show Password");
        checkboxShowPassword.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkboxShowPasswordItemStateChanged(evt);
            }
        });
        checkboxShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxShowPasswordActionPerformed(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        labelIncorrectCredentials.setForeground(new java.awt.Color(255, 51, 51));
        labelIncorrectCredentials.setText("Incorrect Username or Password. Please Try Again!");

        javax.swing.GroupLayout pnlLoginBaseCredientialsLayout = new javax.swing.GroupLayout(pnlLoginBaseCredientials);
        pnlLoginBaseCredientials.setLayout(pnlLoginBaseCredientialsLayout);
        pnlLoginBaseCredientialsLayout.setHorizontalGroup(
            pnlLoginBaseCredientialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginBaseCredientialsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
            .addGroup(pnlLoginBaseCredientialsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlLoginBaseCredientialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLoginBaseCredientialsLayout.createSequentialGroup()
                        .addComponent(iconUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelUsername)
                        .addGap(18, 18, 18)
                        .addComponent(fieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLoginBaseCredientialsLayout.createSequentialGroup()
                        .addComponent(iconPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPassword)
                        .addGap(18, 18, 18)
                        .addGroup(pnlLoginBaseCredientialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkboxShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginBaseCredientialsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelIncorrectCredentials)
                .addGap(118, 118, 118))
        );
        pnlLoginBaseCredientialsLayout.setVerticalGroup(
            pnlLoginBaseCredientialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginBaseCredientialsLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(labelLogin)
                .addGap(93, 93, 93)
                .addGroup(pnlLoginBaseCredientialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLoginBaseCredientialsLayout.createSequentialGroup()
                        .addGroup(pnlLoginBaseCredientialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlLoginBaseCredientialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIncorrectCredentials)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkboxShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLogin)
                .addGap(12, 12, 12)
                .addComponent(buttonForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pnlLoginBase.add(pnlLoginBaseCredientials);
        pnlLoginBaseCredientials.setBounds(550, 60, 660, 600);

        iconLoginPageBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/loginPage.png"))); // NOI18N
        pnlLoginBase.add(iconLoginPageBase);
        iconLoginPageBase.setBounds(0, 0, 1280, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLoginBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLoginBase, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUsernameActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        //Storing the value of Username and password from the fields.
        String username = fieldUsername.getText();
        String password = passwordField.getText();

        // Checks if Given Username and Password is Correct or Not.
        if (username.equals("admin") && password.equals("admin")) {
            this.setVisible(false);
            new Home().setVisible(true); // new object of home
        } else {
            // Validation for Empty Field
            if (username.isEmpty() || password.isEmpty()) {
                labelIncorrectCredentials.setText("Empty Information! Please fill out the credentials.");
            } else {
                // Validation for incorrect Username or Password
                labelIncorrectCredentials.setText("Incorrect Username or Password. Please Try Again!");
            }
            labelIncorrectCredentials.setVisible(true); // If Credential is wrong then the warning message is displayed.
        }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonForgotPasswordActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Visit http://AutoMoto.forgotPassword/help for further process", "Forgot Password?", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_buttonForgotPasswordActionPerformed

    private void checkboxShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxShowPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxShowPasswordActionPerformed

    private void checkboxShowPasswordItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkboxShowPasswordItemStateChanged
        // TODO add your handling code here:

        if (checkboxShowPassword.isSelected()) {
            passwordField.setEchoChar((char) 0); // Shows the password when checkbox is checked
        } else {
            passwordField.setEchoChar('*'); // Hides the password when checkbox is unchecked
        }

    }//GEN-LAST:event_checkboxShowPasswordItemStateChanged

    private void buttonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLoginMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AutoMoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutoMoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutoMoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutoMoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutoMoto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonForgotPassword;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JCheckBox checkboxShowPassword;
    private javax.swing.JTextField fieldUsername;
    private javax.swing.JLabel iconLoginPageBase;
    private javax.swing.JLabel iconPassword;
    private javax.swing.JLabel iconUsername;
    private javax.swing.JLabel labelIncorrectCredentials;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPanel pnlLoginBase;
    private javax.swing.JPanel pnlLoginBaseCredientials;
    // End of variables declaration//GEN-END:variables

    private void setvisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
