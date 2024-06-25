/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.despesas;

import com.mycompany.dao.DaoCategoria;
import com.mycompany.dao.DaoDespesas;
import com.mycompany.modelo.ModDespesas;
import com.mycompany.utilidades.Constantes;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Formularios;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class CadDespesas extends javax.swing.JFrame {

    public CadDespesas() {
        initComponents();

        if(!existeDadosTemporarios()){
            DaoDespesas daoMetas = new DaoDespesas();

            int id = daoMetas.buscarProximoID();
            if(id>=0)
               jtfIdDespesas.setText(String.valueOf(id));

            btnSalvar.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
            jtfIdDespesas.setText(String.valueOf(daoMetas.buscarProximoID()));
        }else{
            btnSalvar.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }

        DaoDespesas daoMetas = new DaoDespesas();

        jtfIdDespesas.setEnabled(false);
        
        try{
            ResultSet resultSet = new DaoCategoria().listarTodos(2);
        
            while(resultSet.next()){
                jcbCategoria.addItem(resultSet.getString("Nome"));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
        jtfIdCategoria.setVisible(false);
    }
    
    public Boolean existeDadosTemporarios(){
        if (DadosTemporarios.tempObject instanceof ModDespesas){
        int id =((ModDespesas)DadosTemporarios.tempObject).getId();
        String nome = ((ModDespesas)DadosTemporarios.tempObject).getNome();
        double valor = ((ModDespesas) DadosTemporarios.tempObject).getValor();
        String Vencimento = ((ModDespesas) DadosTemporarios.tempObject).getVencimento();
        String Pagamento =((ModDespesas) DadosTemporarios.tempObject).getPagamento();
        
        jtfIdDespesas.setText(String.valueOf(id));
        jtfDespesas.setText(nome);
        jtfVencimento.setText(Vencimento);
        jtfPagamento.setText(Pagamento);
        jtfValor.setText(String.valueOf(valor));
        
        DadosTemporarios.tempObject = null;
        return true;
        
        }else
            return false;
    }
        private void inserir(){
            DaoDespesas daoDespesas = new DaoDespesas();
            
            int categoriaId = Integer.parseInt(jtfIdCategoria.getText());
            String despesas =jtfDespesas.getText();
            Double valor = Double.valueOf(jtfValor.getText());
            String vencimento = jtfVencimento.getText();
            String pagamento = jtfPagamento.getText();
            
            if (daoDespesas.inserir(categoriaId, despesas, valor, vencimento, pagamento)){
                JOptionPane.showMessageDialog(null, "Novo tipo de depesa cadastrado! ");
                
                jtfIdCategoria.setText(String.valueOf(daoDespesas.buscarProximoID()));
                jtfDespesas.setText("");
                
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a despesa");
              }
        }
        private void alterar(){
            DaoDespesas daoDespesas = new DaoDespesas();
            
            if (daoDespesas.alterar(Integer.parseInt(jtfIdDespesas.getText()), jtfIdCategoria.getText(), jtfDespesas.getText(), Double.parseDouble(jtfValor.getText()), jtfVencimento.getText(), jtfPagamento.getText())){
                JOptionPane.showMessageDialog(null, " Excluido com sucesso! ");
                
                jtfIdDespesas.setText("");
                jtfDespesas.setText("");
        }else{
        JOptionPane.showMessageDialog(null, "Não foi possivel excluir a despesa! ");
    }
            ((ListDespesas)Formularios.listDespesas).listarTodos();
            
            dispose();
        }
    
//    private void inserir
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtfVencimento = new javax.swing.JFormattedTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jtfPagamento = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnExcluir = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jtfLabelID = new javax.swing.JLabel();
        jcbCategoria = new javax.swing.JComboBox<>();
        jtfIdDespesas = new javax.swing.JTextField();
        jtfLabelDespesa = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jtfDespesas = new javax.swing.JTextField();
        jtfValor = new javax.swing.JTextField();
        jtfLabelValor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfLabelCategoria = new javax.swing.JLabel();
        jtfIdCategoria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Pagamento");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");

        jtfLabelID.setText("ID");

        jcbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCategoriaItemStateChanged(evt);
            }
        });
        jcbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCategoriaActionPerformed(evt);
            }
        });

        jtfLabelDespesa.setText("Despesa");

        jtfLabelValor.setText("Valor");

        jLabel1.setText("Vencimento");

        jtfLabelCategoria.setText("Categoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtfLabelValor)
                    .addComponent(jtfLabelDespesa)
                    .addComponent(jSeparator2)
                    .addComponent(jtfDespesas)
                    .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1)
                    .addComponent(jtfIdDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLabelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jtfLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelDespesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jtfVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jtfPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCategoriaActionPerformed
        
    }//GEN-LAST:event_jcbCategoriaActionPerformed

    private void jcbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCategoriaItemStateChanged
        try{
            ResultSet resultSet = new DaoCategoria().listarPorNome(jcbCategoria.getItemAt(jcbCategoria.getSelectedIndex()));
        
            resultSet.next();
            
            jtfIdCategoria.setText(resultSet.getString("ID"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jcbCategoriaItemStateChanged

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        DaoDespesas daoDespesas = new DaoDespesas();
        if(btnSalvar.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            jtfIdDespesas.setText(String.valueOf(daoDespesas.buscarProximoID()));
            jtfDespesas.setText("");            
        }else if (btnSalvar.getText() == Constantes.BTN_ALTERAR_TEXT){
             alterar();
            ((ListDespesas) Formularios.listMetas).listarTodos();
            dispose();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadDespesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JTextField jtfDespesas;
    private javax.swing.JTextField jtfIdCategoria;
    private javax.swing.JTextField jtfIdDespesas;
    private javax.swing.JLabel jtfLabelCategoria;
    private javax.swing.JLabel jtfLabelDespesa;
    private javax.swing.JLabel jtfLabelID;
    private javax.swing.JLabel jtfLabelValor;
    private javax.swing.JFormattedTextField jtfPagamento;
    private javax.swing.JTextField jtfValor;
    private javax.swing.JFormattedTextField jtfVencimento;
    // End of variables declaration//GEN-END:variables
}
