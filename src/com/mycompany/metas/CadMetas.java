/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.metas;

import com.mycompany.modelo.ModMetas;
import com.mycompany.dao.DaoMetas;
import com.mycompany.utilidades.Constantes;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Formularios;
import javax.swing.JOptionPane;


public class CadMetas extends javax.swing.JFrame {

    public CadMetas() {
        initComponents();

        if(!existeDadosTemporarios()){
            DaoMetas daoMetas = new DaoMetas();

            int id = daoMetas.buscarProximoID();
            if(id>=0)
               jtfIdMetas.setText(String.valueOf(id));

            btnSalvar.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
            jtfIdMetas.setText(String.valueOf(daoMetas.buscarProximoID()));
        }else{
            btnSalvar.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }

        DaoMetas daoMetas = new DaoMetas();

        jtfIdMetas.setEnabled(false);

    }

    public Boolean existeDadosTemporarios(){
    if (DadosTemporarios.tempObject instanceof ModMetas){
        int id =((ModMetas) DadosTemporarios.tempObject).getId();
        String nome = ((ModMetas) DadosTemporarios.tempObject).getNome();
        float Valor = ((ModMetas) DadosTemporarios.tempObject).getValor();
        int meses = ((ModMetas) DadosTemporarios.tempObject).getMeses();
        String DataInicial = ((ModMetas) DadosTemporarios.tempObject).getDataInicial();
        
        
        jtfIdMetas.setText(String.valueOf(id));
        jtfNome.setText(nome);
        jtfValor.setText(String.valueOf(Valor));
        jtfMeses.setText(String.valueOf(meses));
        jfDtInicial.setText(DataInicial);
       
        DadosTemporarios.tempObject = null;

        return true;
    }else
        return false;
    }

    private void inserir(){
            DaoMetas daoMetas = new DaoMetas();

            String nome = jtfNome.getText();
            Double valor = Double.valueOf(jtfValor.getText());
            int meses = Integer.parseInt(jtfMeses.getText());
            String dtInicial = jfDtInicial.getText();
            

            if(daoMetas.inserir(nome, valor, meses,dtInicial)){
                JOptionPane.showMessageDialog(null, "Novo tipo de Metas cadastrado com sucesso.");

                jtfIdMetas.setText(String.valueOf(daoMetas.buscarProximoID()));
                jtfNome.setText("");
                jtfValor.setText("");
                jtfMeses.setText("");
                jfDtInicial.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar o tipo de Metas.");
            }
        }
    
    private void alterar(){
        DaoMetas daoMetas = new DaoMetas();

        if(daoMetas.alterar(Integer.parseInt(jtfIdMetas.getText()), jtfNome.getText(), Double.parseDouble(jtfValor.getText()), Integer.parseInt(jtfMeses.getText()), jfDtInicial.getText())){
        
            JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso!");
            
            jtfIdMetas.setText("");
            jtfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a meta!");
        }
        
        ((ListMetas) Formularios.listMetas).listarTodos();
        
      
        dispose();
    }
    
        private void excluir(){
        DaoMetas daoMetas = new DaoMetas();
        
        if (daoMetas.excluir(Integer.parseInt(jtfIdMetas.getText()))){
            JOptionPane.showMessageDialog(null, "Meta" + jtfNome.getText() + " excluída com sucesso!");
            
            jtfIdMetas.setText("");
            jtfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a !");
        }
        
        ((ListMetas) Formularios.listMetas).listarTodos();
        
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtfMeses = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jfDtInicial = new javax.swing.JFormattedTextField();
        jtfIdMetas = new javax.swing.JTextField();
        jtfLabelID = new javax.swing.JLabel();
        jtfLabelDespesa = new javax.swing.JLabel();
        jtfLabelValor = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jtfValor = new javax.swing.JTextField();
        jtfLabelDespesa1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(80, 82, 84));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Gerenciamento de Contas");

        jSeparator1.setBackground(new java.awt.Color(80, 82, 84));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jtfIdMetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdMetasActionPerformed(evt);
            }
        });

        jtfLabelID.setText("ID");

        jtfLabelDespesa.setText("Qual é seu objetivo com essa meta?");

        jtfLabelValor.setText("Em quantos meses você deseja alcançar essa meta?");

        jLabel8.setText("Data Inicial");

        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(80, 82, 84));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Gerenciamento de Contas");

        jSeparator2.setBackground(new java.awt.Color(80, 82, 84));

        jtfValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfValorActionPerformed(evt);
            }
        });

        jtfLabelDespesa1.setText("Valor");

        jLabel3.setText("meses");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfLabelDespesa)
                            .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfIdMetas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(jtfLabelValor)
                            .addComponent(jLabel8)
                            .addComponent(jfDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfLabelDespesa1))))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdMetas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfLabelDespesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfLabelDespesa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jtfLabelValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jfDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIdMetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdMetasActionPerformed
        
    }//GEN-LAST:event_jtfIdMetasActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        DaoMetas daoMetas = new DaoMetas();
        
        if(btnSalvar.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            jtfIdMetas.setText(String.valueOf(daoMetas.buscarProximoID()));
            jtfNome.setText("");
            
        }else if (btnSalvar.getText() == Constantes.BTN_ALTERAR_TEXT){
             alterar();
            ((ListMetas) Formularios.listMetas).listarTodos();
            dispose();
    }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
         Formularios.cadMetas = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir a categoria " + jtfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();                        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed

    private void jtfValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfValorActionPerformed


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
            java.util.logging.Logger.getLogger(CadMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadMetas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JFormattedTextField jfDtInicial;
    private javax.swing.JTextField jtfIdMetas;
    private javax.swing.JLabel jtfLabelDespesa;
    private javax.swing.JLabel jtfLabelDespesa1;
    private javax.swing.JLabel jtfLabelID;
    private javax.swing.JLabel jtfLabelValor;
    private javax.swing.JTextField jtfMeses;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables
}