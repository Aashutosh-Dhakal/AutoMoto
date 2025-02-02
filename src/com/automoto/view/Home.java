/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.automoto.view;

/**
 *
 * @author aashutoshdhakal
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEnterOption = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pnlBase = new javax.swing.JPanel();
        pnlBaseGreeting = new javax.swing.JPanel();
        lableWelcomGreeting = new javax.swing.JLabel();
        buttonEnter = new javax.swing.JButton();
        labelDescription = new javax.swing.JLabel();
        iconBase = new javax.swing.JLabel();

        pnlEnterOption.setBackground(new java.awt.Color(249, 250, 250));

        jButton1.setBackground(new java.awt.Color(240, 84, 84));
        jButton1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jButton1.setText("Quick Action");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 84, 84));
        jButton2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jButton2.setText("Statistics Overview");

        jButton3.setBackground(new java.awt.Color(240, 84, 84));
        jButton3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jButton3.setText("Admin Panel");

        javax.swing.GroupLayout pnlEnterOptionLayout = new javax.swing.GroupLayout(pnlEnterOption);
        pnlEnterOption.setLayout(pnlEnterOptionLayout);
        pnlEnterOptionLayout.setHorizontalGroup(
            pnlEnterOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnterOptionLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        pnlEnterOptionLayout.setVerticalGroup(
            pnlEnterOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnterOptionLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(pnlEnterOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1200));

        pnlBase.setBackground(new java.awt.Color(48, 71, 94));
        pnlBase.setMaximumSize(new java.awt.Dimension(1920, 1200));
        pnlBase.setMinimumSize(new java.awt.Dimension(1920, 1200));
        pnlBase.setPreferredSize(new java.awt.Dimension(1920, 1200));
        pnlBase.setLayout(null);

        pnlBaseGreeting.setBackground(new java.awt.Color(249, 250, 250));
        pnlBaseGreeting.setLayout(null);

        lableWelcomGreeting.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        lableWelcomGreeting.setText("Welcome to AutoMoto!");
        pnlBaseGreeting.add(lableWelcomGreeting);
        lableWelcomGreeting.setBounds(570, 20, 530, 70);

        buttonEnter.setBackground(new java.awt.Color(240, 84, 84));
        buttonEnter.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        buttonEnter.setText("Enter");
        buttonEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEnterMouseClicked(evt);
            }
        });
        buttonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnterActionPerformed(evt);
            }
        });
        pnlBaseGreeting.add(buttonEnter);
        buttonEnter.setBounds(600, 140, 440, 60);

        labelDescription.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelDescription.setText("“Welcome to AutoMoto! Your seamless solution for managing bike rentals, returns, and inventory—all in one place. Simplify your operations.");
        pnlBaseGreeting.add(labelDescription);
        labelDescription.setBounds(250, 80, 1120, 50);

        pnlBase.add(pnlBaseGreeting);
        pnlBaseGreeting.setBounds(150, 880, 1620, 240);

        iconBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/AutoMoto.png"))); // NOI18N
        pnlBase.add(iconBase);
        iconBase.setBounds(0, 0, 1920, 1200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEnterMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEnterMouseClicked

    private void buttonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnterActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);   //Set the visible of current frame to false
        new ActionFrame().setVisible(true); // Creation of New object of ActionFrame and its visible is set True.
    }//GEN-LAST:event_buttonEnterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEnter;
    private javax.swing.JLabel iconBase;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel lableWelcomGreeting;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlBaseGreeting;
    private javax.swing.JPanel pnlEnterOption;
    // End of variables declaration//GEN-END:variables
}
