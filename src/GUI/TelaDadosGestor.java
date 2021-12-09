/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import Controller.UserController;
import Controller.JtextFieldSomenteLetras;
import Controller.UserController;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edmilson Nhabinde
 */
public class TelaDadosGestor extends javax.swing.JFrame {

    /**
     * Creates new form TelaDadosGestor
     */
    public TelaDadosGestor() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new JtextFieldSomenteLetras(30);
        lblNome = new javax.swing.JLabel();
        lblApelido = new javax.swing.JLabel();
        txtApelido = new JtextFieldSomenteLetras(30);
        txtNomeUS = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jpfConfirmSenha = new javax.swing.JPasswordField();
        lblConfirmSenha = new javax.swing.JLabel();
        jbContinuar = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Building 2.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Sylfaen", 2, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("SIG");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Sitka Subheading", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("ADMINISTRADOR");

        txtNome.setFont(new java.awt.Font("Sitka Subheading", 0, 18)); // NOI18N
        txtNome.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Sitka Subheading", 0, 19)); // NOI18N
        lblNome.setForeground(new java.awt.Color(102, 102, 102));
        lblNome.setText("Nome");

        lblApelido.setFont(new java.awt.Font("Sitka Subheading", 0, 19)); // NOI18N
        lblApelido.setForeground(new java.awt.Color(102, 102, 102));
        lblApelido.setText("Apelido");

        txtApelido.setFont(new java.awt.Font("Sitka Subheading", 0, 18)); // NOI18N
        txtApelido.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtApelido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApelidoFocusGained(evt);
            }
        });
        txtApelido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApelidoKeyPressed(evt);
            }
        });

        txtNomeUS.setFont(new java.awt.Font("Sitka Subheading", 0, 18)); // NOI18N
        txtNomeUS.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtNomeUS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeUSFocusGained(evt);
            }
        });
        txtNomeUS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeUSKeyPressed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Sitka Subheading", 0, 19)); // NOI18N
        lblUser.setForeground(new java.awt.Color(102, 102, 102));
        lblUser.setText("Email");

        lblSenha.setFont(new java.awt.Font("Sitka Subheading", 0, 19)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(102, 102, 102));
        lblSenha.setText("Senha");

        jpfSenha.setFont(new java.awt.Font("Sitka Subheading", 0, 18)); // NOI18N
        jpfSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpfSenhaFocusGained(evt);
            }
        });
        jpfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpfSenhaKeyPressed(evt);
            }
        });

        jpfConfirmSenha.setFont(new java.awt.Font("Sitka Subheading", 0, 18)); // NOI18N
        jpfConfirmSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpfConfirmSenhaFocusGained(evt);
            }
        });

        lblConfirmSenha.setFont(new java.awt.Font("Sitka Subheading", 0, 19)); // NOI18N
        lblConfirmSenha.setForeground(new java.awt.Color(102, 102, 102));
        lblConfirmSenha.setText("Confime a Senha");

        jbContinuar.setBackground(new java.awt.Color(153, 153, 153));
        jbContinuar.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        jbContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/proceed.png"))); // NOI18N
        jbContinuar.setText("Continuar");
        jbContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbContinuarActionPerformed(evt);
            }
        });

        jbCancel.setBackground(new java.awt.Color(153, 153, 153));
        jbCancel.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jbCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cancelar.png"))); // NOI18N
        jbCancel.setText("Cancelar");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addComponent(jbContinuar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbCancel))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(lblNome))
                                        .addComponent(lblApelido))
                                    .addGap(101, 101, 101))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblConfirmSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jpfConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomeUS, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lblNome))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApelido)
                            .addComponent(txtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUser)
                            .addComponent(txtNomeUS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSenha)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpfConfirmSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmSenha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(941, 533));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbContinuarActionPerformed
        if (new UserController().recebeGestor(this.txtNome.getText(), this.txtApelido.getText(), this.txtNomeUS.getText(), this.jpfSenha.getText(), this.jpfConfirmSenha.getText())) {
            try {
                dispose();
                new TelaPrincipal().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(TelaDadosGestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbContinuarActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        this.dispose();
        new TelaWellcome().setVisible(true);
    }//GEN-LAST:event_jbCancelActionPerformed
    /*
    abaixo os eventos FocusGained da classe para colocar 
    frases-exemplos nas textField's
     */
    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        // TODO add your handling code here:
        txtNome.setFont(new java.awt.Font("Italic", 2, 16));
        txtNome.setText(" Ex: Joao");
        txtNome.getText();
        if (txtNome.getText().equals(" ")) {
            txtNome.setText(" Ex: Joao");
        } else {
            txtNome.getText();
        }
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
        // TODO add your handling code here:
        /*txtNome.setFont(new java.awt.Font("Italic", 2, 16));
        txtNome.setForeground(new java.awt.Color(102, 102, 102));
        txtNome.setText("'ex: Introduza o Nome'");
        txtNome.getText();
        if  (txtNome.getText().equals(" ")){
         txtNome.setText("'ex: Introduza o Nome'");
        }
        txtNome.getText();*/
    }//GEN-LAST:event_txtNomeFocusLost

    private void txtApelidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApelidoFocusGained
        // TODO add your handling code here:
        txtApelido.setFont(new java.awt.Font("Italic", 2, 16));
        txtApelido.setText(" Ex: Metambo");
        txtApelido.getText();
        if (txtApelido.getText().equals(" ")) {
            txtApelido.setText(" Ex: Metambo");
        } else {
            txtApelido.getText();
        }
    }//GEN-LAST:event_txtApelidoFocusGained

    private void txtNomeUSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeUSFocusGained
        // TODO add your handling code here:
        txtNomeUS.setFont(new java.awt.Font("Italic", 2, 16));
        txtNomeUS.setText(" Ex: jmetambo@gmail.com");
        txtNomeUS.getText();
        if (txtNomeUS.getText().equals(" ")) {
            txtNomeUS.setText(" Ex: jmetambo@gmail.com");
        } else {
            txtNomeUS.getText();
        }
    }//GEN-LAST:event_txtNomeUSFocusGained

    private void jpfSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfSenhaFocusGained
        // TODO add your handling code here:
        jpfSenha.setFont(new java.awt.Font("Italic", 2, 16));
        jpfSenha.setText(" Ex: 123456");;
        jpfSenha.getText();
        if (jpfSenha.getText().equals(" ")) {
            jpfSenha.setText(" Ex: 123456");
        } else {
            jpfSenha.getText();
        }
    }//GEN-LAST:event_jpfSenhaFocusGained

    private void jpfConfirmSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfConfirmSenhaFocusGained
        // TODO add your handling code here:
        jpfConfirmSenha.setFont(new java.awt.Font("Italic", 2, 16));
        jpfConfirmSenha.setText(" Ex: 123456");
        jpfConfirmSenha.getText();
        if (jpfConfirmSenha.getText().equals(" ")) {
            jpfConfirmSenha.setText(" Ex: 123456");
        } else {
            jpfConfirmSenha.getText();
        }
    }//GEN-LAST:event_jpfConfirmSenhaFocusGained

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtApelido.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtApelidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelidoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNomeUS.requestFocus();
        }
    }//GEN-LAST:event_txtApelidoKeyPressed

    private void txtNomeUSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeUSKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jpfSenha.requestFocus();
        }
    }//GEN-LAST:event_txtNomeUSKeyPressed

    private void jpfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfSenhaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jpfConfirmSenha.requestFocus();
        }
    }//GEN-LAST:event_jpfSenhaKeyPressed
    //fim dos eventos Focus da classe TelaDadosGestor;

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
            java.util.logging.Logger.getLogger(TelaDadosGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDadosGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDadosGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDadosGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDadosGestor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JButton jbCancel;
    public static javax.swing.JButton jbContinuar;
    private javax.swing.JPasswordField jpfConfirmSenha;
    private javax.swing.JPasswordField jpfSenha;
    public static javax.swing.JLabel lblApelido;
    public static javax.swing.JLabel lblConfirmSenha;
    public static javax.swing.JLabel lblNome;
    public static javax.swing.JLabel lblSenha;
    public static javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtApelido;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeUS;
    // End of variables declaration//GEN-END:variables
}
