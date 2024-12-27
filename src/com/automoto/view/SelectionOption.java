/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.automoto.view;


/**
 *
 * @author aashutoshdhakal
 */
public class SelectionOption extends javax.swing.JFrame {

    /**
     * Creates new form SelectionOption
     */
    public SelectionOption() {
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

        pnlSelectonOptionBase = new javax.swing.JPanel();
        panelAsButtonForQuickAction = new javax.swing.JPanel();
        LabelQuickAction = new javax.swing.JLabel();
        panelAsButtonForAdminPanel = new javax.swing.JPanel();
        labelAdminPanel = new javax.swing.JLabel();
        buttonBack = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        labelChooseAnOption = new javax.swing.JLabel();
        iconBaseSelectionOption = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1200));

        pnlSelectonOptionBase.setMaximumSize(new java.awt.Dimension(1920, 1200));
        pnlSelectonOptionBase.setMinimumSize(new java.awt.Dimension(1920, 1200));
        pnlSelectonOptionBase.setPreferredSize(new java.awt.Dimension(1920, 1200));
        pnlSelectonOptionBase.setLayout(null);

        panelAsButtonForQuickAction.setBackground(new java.awt.Color(240, 84, 84));
        panelAsButtonForQuickAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAsButtonForQuickActionMouseClicked(evt);
            }
        });

        LabelQuickAction.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        LabelQuickAction.setForeground(new java.awt.Color(255, 255, 255));
        LabelQuickAction.setText("Quick Action");

        javax.swing.GroupLayout panelAsButtonForQuickActionLayout = new javax.swing.GroupLayout(panelAsButtonForQuickAction);
        panelAsButtonForQuickAction.setLayout(panelAsButtonForQuickActionLayout);
        panelAsButtonForQuickActionLayout.setHorizontalGroup(
            panelAsButtonForQuickActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsButtonForQuickActionLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(LabelQuickAction)
                .addGap(39, 39, 39))
        );
        panelAsButtonForQuickActionLayout.setVerticalGroup(
            panelAsButtonForQuickActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsButtonForQuickActionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LabelQuickAction)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnlSelectonOptionBase.add(panelAsButtonForQuickAction);
        panelAsButtonForQuickAction.setBounds(460, 800, 380, 110);

        panelAsButtonForAdminPanel.setBackground(new java.awt.Color(240, 84, 84));
        panelAsButtonForAdminPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAsButtonForAdminPanelMouseClicked(evt);
            }
        });

        labelAdminPanel.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        labelAdminPanel.setForeground(new java.awt.Color(255, 255, 255));
        labelAdminPanel.setText("Admin Panel");

        javax.swing.GroupLayout panelAsButtonForAdminPanelLayout = new javax.swing.GroupLayout(panelAsButtonForAdminPanel);
        panelAsButtonForAdminPanel.setLayout(panelAsButtonForAdminPanelLayout);
        panelAsButtonForAdminPanelLayout.setHorizontalGroup(
            panelAsButtonForAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsButtonForAdminPanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(labelAdminPanel)
                .addGap(42, 42, 42))
        );
        panelAsButtonForAdminPanelLayout.setVerticalGroup(
            panelAsButtonForAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsButtonForAdminPanelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(labelAdminPanel)
                .addGap(26, 26, 26))
        );

        pnlSelectonOptionBase.add(panelAsButtonForAdminPanel);
        panelAsButtonForAdminPanel.setBounds(1080, 800, 380, 110);

        buttonBack.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonBack.setText("Back");
        buttonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBackMouseClicked(evt);
            }
        });
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        pnlSelectonOptionBase.add(buttonBack);
        buttonBack.setBounds(30, 1100, 120, 60);

        buttonExit.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        buttonExit.setText("Exit");
        buttonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonExitMouseClicked(evt);
            }
        });
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        pnlSelectonOptionBase.add(buttonExit);
        buttonExit.setBounds(1770, 1100, 120, 60);

        labelChooseAnOption.setFont(new java.awt.Font("Skia", 1, 56)); // NOI18N
        labelChooseAnOption.setText("Choose An Option");
        pnlSelectonOptionBase.add(labelChooseAnOption);
        labelChooseAnOption.setBounds(720, 130, 510, 60);

        iconBaseSelectionOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/automoto/resources/selectionPage.png"))); // NOI18N
        pnlSelectonOptionBase.add(iconBaseSelectionOption);
        iconBaseSelectionOption.setBounds(0, 0, 1920, 1200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSelectonOptionBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSelectonOptionBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_buttonBackMouseClicked

    private void buttonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_buttonExitMouseClicked

    private void panelAsButtonForQuickActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAsButtonForQuickActionMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new QuickAction().setVisible(true);
    }//GEN-LAST:event_panelAsButtonForQuickActionMouseClicked

    private void panelAsButtonForAdminPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAsButtonForAdminPanelMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new AdminPanel().setVisible(true);
    }//GEN-LAST:event_panelAsButtonForAdminPanelMouseClicked

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
            java.util.logging.Logger.getLogger(SelectionOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectionOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectionOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectionOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectionOption().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelQuickAction;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonExit;
    private javax.swing.JLabel iconBaseSelectionOption;
    private javax.swing.JLabel labelAdminPanel;
    private javax.swing.JLabel labelChooseAnOption;
    private javax.swing.JPanel panelAsButtonForAdminPanel;
    private javax.swing.JPanel panelAsButtonForQuickAction;
    private javax.swing.JPanel pnlSelectonOptionBase;
    // End of variables declaration//GEN-END:variables
}
