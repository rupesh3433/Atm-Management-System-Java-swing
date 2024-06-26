/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package atmmanagementsystem_swing;

import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class FundTransferForm extends javax.swing.JFrame {

    /**
     * Creates new form FundTransferForm
     * @param accountNo
     */
    static String accountNo;
    public FundTransferForm(String accountNo) {
        FundTransferForm.accountNo=accountNo;
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

        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        accountNumberField = new javax.swing.JTextField();
        transferAmountField = new javax.swing.JTextField();
        depositAmountField3 = new javax.swing.JTextField();
        accountHolderFrontend = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setBackground(new java.awt.Color(0, 153, 51));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Submit");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 120, 30));

        jButton9.setBackground(new java.awt.Color(0, 153, 153));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Back");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 120, 30));

        jButton2.setBackground(new java.awt.Color(204, 0, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Log Out");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 110, 30));

        accountNumberField.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        accountNumberField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        accountNumberField.setOpaque(true);
        accountNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNumberFieldActionPerformed(evt);
            }
        });
        getContentPane().add(accountNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 160, 30));

        transferAmountField.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        transferAmountField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        transferAmountField.setOpaque(true);
        transferAmountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferAmountFieldActionPerformed(evt);
            }
        });
        getContentPane().add(transferAmountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 160, 30));

        depositAmountField3.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        depositAmountField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        depositAmountField3.setOpaque(true);
        depositAmountField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositAmountField3ActionPerformed(evt);
            }
        });
        getContentPane().add(depositAmountField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 160, 30));

        accountHolderFrontend.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        accountHolderFrontend.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        accountHolderFrontend.setOpaque(true);
        accountHolderFrontend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountHolderFrontendActionPerformed(evt);
            }
        });
        getContentPane().add(accountHolderFrontend, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 160, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Confirm Amount:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 130, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Account Number:");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 130, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Transfer Amount:");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 130, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Account Holder:");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 130, -1));

        jLabel6.setBackground(new java.awt.Color(102, 0, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Receiver Information:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 300, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fund Transfer");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 300, -1));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 300, 210));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atmmanagementsystem_swing/resourses_images/MainPageBackground.jpg"))); // NOI18N
        jLabel2.setText("Please select your transaction");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
      // Retrieve input values from the frontend
    String senderAccountNumber = accountNo;
    String receiverAccountNumber = accountNumberField.getText().trim();
    String transferAmountStr = transferAmountField.getText().trim();
    double transferAmount;

    // Validate and parse transfer amount
    try {
        transferAmount = Double.parseDouble(transferAmountStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid transfer amount. Please enter a valid number.",
                                      "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Fetch receiver account information and perform transfer
    if (DB_Handler.validateAccount(receiverAccountNumber)) {
        String receiverAccountHolder_DB = DB_Handler.getAccountHolder(receiverAccountNumber);
        String receiverAccountHolder_Frontend = accountHolderFrontend.getText().trim();

        // Verify account holder names match
        if (!receiverAccountHolder_Frontend.equals(receiverAccountHolder_DB)) {
            JOptionPane.showMessageDialog(this, "Sender and receiver account holders do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        boolean senderUpdateSuccess = DB_Handler.updateBalanceAfterWithdrawal(senderAccountNumber, transferAmount);

        if (senderUpdateSuccess) {
            boolean receiverUpdateSuccess = DB_Handler.updateBalanceAfterDeposit(receiverAccountNumber, transferAmount);

            if (receiverUpdateSuccess) {
                // Record transactions for sender and receiver
                DB_Handler.recordTransaction(senderAccountNumber, transferAmount, "Transfer Sent");
                DB_Handler.recordTransaction(receiverAccountNumber, transferAmount, "Transfer Received");

                JOptionPane.showMessageDialog(this, "Transfer successful.",
                                              "Success", JOptionPane.INFORMATION_MESSAGE);
                new BalanceEnquiryForm(accountNo).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update receiver's balance.",
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update sender's balance.",
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Receiver account not found.",
                                      "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new MainPageForm(accountNo).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void accountHolderFrontendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountHolderFrontendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountHolderFrontendActionPerformed

    private void accountNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountNumberFieldActionPerformed

    private void transferAmountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferAmountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transferAmountFieldActionPerformed

    private void depositAmountField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositAmountField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositAmountField3ActionPerformed

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
            java.util.logging.Logger.getLogger(FundTransferForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FundTransferForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FundTransferForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FundTransferForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FundTransferForm(accountNo).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountHolderFrontend;
    private javax.swing.JTextField accountNumberField;
    private javax.swing.JTextField depositAmountField3;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField transferAmountField;
    // End of variables declaration//GEN-END:variables
}
