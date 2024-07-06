package com.mycompany.tipoCategoria;

import com.mycompany.dao.DaoTipoCategoria;
import com.mycompany.modelo.ModTipoCategoria;
import com.mycompany.utilidades.Constantes;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Formularios;
import com.mycompany.dao.DaoTipoCategoria;
import javax.swing.JOptionPane;
import jdk.dynalink.linker.support.Guards;

public class CadTipoCategoria extends javax.swing.JFrame {

    public CadTipoCategoria() {
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoTipoCategoria daoTipoCategoria = new DaoTipoCategoria();

            int id = daoTipoCategoria.buscarProximoId();
            if(id>=0)
               jtfTextFieldID.setText(String.valueOf(id));
            
            btnButtonSalvar.setText(Constantes.BTN_SALVAR_TEXT);
            btnButtonExcluir.setVisible(false);
            jtfTextFieldID.setText(String.valueOf(daoTipoCategoria.buscarProximoId()));
        }else{
            btnButtonSalvar.setText(Constantes.BTN_ALTERAR_TEXT);
            btnButtonExcluir.setVisible(true);
        }
        
        DaoTipoCategoria daoTipoCategoria = new DaoTipoCategoria();
        
        jtfTextFieldID.setEnabled(false);
        
    }

    public Boolean existeDadosTemporarios(){
        if (DadosTemporarios.tempObject instanceof ModTipoCategoria){
            int id =((ModTipoCategoria) DadosTemporarios.tempObject).getId();
            String nome = ((ModTipoCategoria) DadosTemporarios.tempObject).getNome();
            
            jtfTextFieldID.setText(String.valueOf(id));
            jtfTipoCategoria.setText(nome);
            
            DadosTemporarios.tempObject = null;
           
            return true;
        }else
            return false;
        }
    
    private void inserir(){
        DaoTipoCategoria daoTipoCategoria = new DaoTipoCategoria();
        
        String nomeTipoCategoria = jtfTipoCategoria.getText();
        
        if(daoTipoCategoria.inserir(nomeTipoCategoria)){
            JOptionPane.showMessageDialog(null, "Novo tipo de categoria cadastrado com sucesso.");
        
            jtfTextFieldID.setText(String.valueOf(daoTipoCategoria.buscarProximoId()));
            jtfTipoCategoria.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o tipo da categoria.");
        }
    }
    
    private void alterar(){
        DaoTipoCategoria daoTipoCategoria = new DaoTipoCategoria();
        
        if (daoTipoCategoria.alterar(Integer.parseInt(jtfTextFieldID.getText()), jtfTipoCategoria.getText())){
            JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso!");
            
            jtfTextFieldID.setText("");
            jtfTipoCategoria.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a categoria!");
        }
        
        ((ListTipoCategoria) Formularios.listTipoCategoria).listarTodos();
        
      
      dispose();
    }
    
        private void excluir(){
        DaoTipoCategoria daoTipoCategoria = new DaoTipoCategoria();
        
        if (daoTipoCategoria.excluir(Integer.parseInt(jtfTextFieldID.getText()))){
            JOptionPane.showMessageDialog(null, "Categoria " + jtfTipoCategoria.getText() + " excluída com sucesso!");
            
            jtfTextFieldID.setText("");
            jtfTipoCategoria.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a categoria!");
        }
        
        ((ListTipoCategoria) Formularios.listTipoCategoria).listarTodos();
        
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfLabelID = new javax.swing.JLabel();
        jtfLabelDespesa = new javax.swing.JLabel();
        jtfTipoCategoria = new javax.swing.JTextField();
        jtfTextFieldID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnButtonSalvar = new javax.swing.JButton();
        btnButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jtfLabelID.setText("ID");

        jtfLabelDespesa.setText("Tipo de Categoria");

        btnButtonSalvar.setText("Salvar");
        btnButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnButtonSalvarActionPerformed(evt);
            }
        });

        btnButtonExcluir.setText("Excluir");
        btnButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLabelDespesa)
                    .addComponent(jtfTipoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelDespesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTipoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnButtonSalvar)
                    .addComponent(btnButtonExcluir))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnButtonSalvarActionPerformed
        DaoTipoCategoria daoTipoCategoria = new DaoTipoCategoria();
        
        if(btnButtonSalvar.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            jtfTextFieldID.setText(String.valueOf(daoTipoCategoria.buscarProximoId()));
            jtfTipoCategoria.setText("");
            
        }else if (btnButtonSalvar.getText() == Constantes.BTN_ALTERAR_TEXT){
             alterar();
            ((ListTipoCategoria) Formularios.listTipoCategoria).listarTodos();
            dispose();
        }
    }//GEN-LAST:event_btnButtonSalvarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadTipoCategoria = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnButtonExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir a categoria " + jtfTipoCategoria.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnButtonExcluirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadTipoCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnButtonExcluir;
    private javax.swing.JButton btnButtonSalvar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jtfLabelDespesa;
    private javax.swing.JLabel jtfLabelID;
    private javax.swing.JTextField jtfTextFieldID;
    private javax.swing.JTextField jtfTipoCategoria;
    // End of variables declaration//GEN-END:variables
}
