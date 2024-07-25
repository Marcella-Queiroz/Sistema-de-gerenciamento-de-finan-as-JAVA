/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.categoria;
import com.mycompany.dao.DaoCategoria;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.modelo.ModCategoria;
import com.mycompany.utilidades.Constantes;
import com.mycompany.utilidades.Formularios;
import com.mycompany.utilidades.MyFormatter;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class CadCategoria extends javax.swing.JFrame {

    public CadCategoria() {
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoCategoria daoCategoria = new DaoCategoria();
            
            int id = daoCategoria.buscarProximoID();
            if(id>=0)
                jtfID.setText(String.valueOf(id));
        
            jtfButtonSalvar.setText(Constantes.BTN_SALVAR_TEXT);
            jtfButtonExcluir.setVisible(false);
            jtfID.setText(String.valueOf(daoCategoria.buscarProximoID()));
        }else{
            jtfButtonSalvar.setText(Constantes.BTN_ALTERAR_TEXT);
            jtfButtonExcluir.setVisible(true);
        }   
            

        jtfID.setEnabled(false);

        jcbTipoCategoria.setSelectedIndex(Integer.parseInt(jtfTipoCategoria.getText()) - 1);
        
        setLocationRelativeTo(null);
    }
    public Boolean existeDadosTemporarios(){
        if (DadosTemporarios.tempObject instanceof ModCategoria){

        int id = ((ModCategoria)DadosTemporarios.tempObject).getId();
        int tipoCategoria = ((ModCategoria)DadosTemporarios.tempObject).getTipoCategoria();
        String nome = ((ModCategoria)DadosTemporarios.tempObject).getNome();

        jtfID.setText(String.valueOf(id));
        jtfTipoCategoria.setText(String.valueOf(tipoCategoria));
        jtfNome.setText(nome);

        DadosTemporarios.tempObject = null;
        return true;
    
    }else
        return false;
    }
    
    private void inserir(){
        DaoCategoria daoCategoria = new DaoCategoria();
        
        int Id = Integer.parseInt(jtfID.getText());
        int idTipoCategoria = Integer.parseInt(jtfTipoCategoria.getText());
        String tipoCategoria = jcbTipoCategoria.getItemAt(jcbTipoCategoria.getSelectedIndex());
        String nome = jtfNome.getText();
        
        if(daoCategoria.inserir(Id, idTipoCategoria, nome)){
             JOptionPane.showMessageDialog(null, "Novo tipo de categoria cadastrado! ");
            
            jtfID.setText(String.valueOf(daoCategoria.buscarProximoID()));
            jtfNome.setText("");
          
        }
    }
    
    private void alterar(){        
        DaoCategoria daoCategoria = new DaoCategoria();

        if (daoCategoria.alterar(Integer.parseInt(jtfID.getText()), Integer.parseInt(jtfTipoCategoria.getText()), jtfNome.getText())){
            JOptionPane.showMessageDialog(null, " Alterado com sucesso! ");

            jtfID.setText("");
            jtfNome.setText("");  
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar a categoria! ");
        }

        ((ListCategoria)Formularios.listCategoria).listarTodos();

        dispose();
    }    
     
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfLabelID = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jtfLabelNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jtfButtonSalvar = new javax.swing.JButton();
        jtfButtonExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbTipoCategoria = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jtfTipoCategoria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Categoria");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jtfLabelID.setText("ID");

        jtfLabelNome.setText("Nome");

        jtfButtonSalvar.setText("Salvar");
        jtfButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfButtonSalvarActionPerformed(evt);
            }
        });

        jtfButtonExcluir.setText("Excluir");

        jLabel1.setText("Tipo de Categoria");

        jcbTipoCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Receitas", "Despesas" }));
        jcbTipoCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoCategoriaItemStateChanged(evt);
            }
        });
        jcbTipoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfLabelNome)
                                .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator2)
                                .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbTipoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jtfTipoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTipoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfButtonSalvar)
                    .addComponent(jtfButtonExcluir))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoCategoriaActionPerformed

    private void jcbTipoCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoCategoriaItemStateChanged
        switch (jcbTipoCategoria.getSelectedIndex()) {
            case 0:
                jtfTipoCategoria.setText("1");
                break;
            case 1:
                jtfTipoCategoria.setText("2");
                break;
        }
    }//GEN-LAST:event_jcbTipoCategoriaItemStateChanged

    private void jtfButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfButtonSalvarActionPerformed
               DaoCategoria daoCategoria = new DaoCategoria();
       if(jtfButtonSalvar.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            ((ListCategoria) Formularios.listCategoria).listarTodos();
          jtfID.setText(String.valueOf(daoCategoria.buscarProximoID()));
          jtfNome.setText("");            
        }else if (jtfButtonSalvar.getText() == Constantes.BTN_ALTERAR_TEXT){
             alterar();
            ((ListCategoria) Formularios.listCategoria).listarTodos();
           dispose();
        }
    }//GEN-LAST:event_jtfButtonSalvarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadCategoria = null;
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(CadCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> jcbTipoCategoria;
    private javax.swing.JButton jtfButtonExcluir;
    private javax.swing.JButton jtfButtonSalvar;
    private javax.swing.JTextField jtfID;
    private javax.swing.JLabel jtfLabelID;
    private javax.swing.JLabel jtfLabelNome;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfTipoCategoria;
    // End of variables declaration//GEN-END:variables
}
