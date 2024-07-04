/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.receitas;

import com.mycompany.dao.DaoReceitas;
import com.mycompany.modelo.ModDespesas;
import com.mycompany.modelo.ModReceitas;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Formularios;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author marcella.1963
 */
public class ListReceitas extends javax.swing.JFrame {

    /**
     * Creates new form ListReceita
     */
    public ListReceitas() {
        initComponents();
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel)tableReceitas.getModel();
    
            tableReceitas.setModel(defaultTableModel);
            
            DaoReceitas daoReceitas = new DaoReceitas();
    
            ResultSet resultSet = daoReceitas.ListarTodos();
        
             defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String categoria_id = resultSet.getString(2);
                String nome = resultSet.getString(3);
                Double valor = resultSet.getDouble(4);
                String data_de_lançamento = resultSet.getString(5);
                

                defaultTableModel.addRow(new Object[]{id, categoria_id, nome, valor, data_de_lançamento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(int pID){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableReceitas.getModel();

            tableReceitas.setModel(defaultTableModel);

            DaoReceitas DaoReceitas = new DaoReceitas();

            ResultSet resultSet = DaoReceitas.listarPorId(pID);

            defaultTableModel.setRowCount(0);

            while(resultSet.next()){
                String id = resultSet.getNString(1);
                String categoria_id = resultSet.getNString(2);
                String receitas = resultSet.getNString(3);
                Double valor = resultSet.getDouble(4);
                String data_lancamento = resultSet.getNString(5);

                defaultTableModel.addRow(new Object[]{id,categoria_id, receitas, valor,data_lancamento});
            }
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNome(String pNome){
        try{
        DefaultTableModel defaultTableModel = (DefaultTableModel)tableReceitas.getModel();
        
        tableReceitas.setModel(defaultTableModel);
        
            DaoReceitas daoReceitas = new DaoReceitas();
            
            ResultSet resultSet = daoReceitas.ListarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                String id = resultSet.getNString(1);
                String categoria_id = resultSet.getNString(2);
                String receitas = resultSet.getNString(3);
                Double valor = resultSet.getDouble(4);
                String data_lancamento = resultSet.getNString(5);
                
                defaultTableModel.addRow(new Object[]{id,categoria_id, receitas, valor, data_lancamento});
            } 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfFiltrar1 = new javax.swing.JComboBox<>();
        jtfFiltro = new javax.swing.JTextField();
        jtfButtonBuscar1 = new javax.swing.JButton();
        jtfLabelRegistro1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableReceitas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtfFiltrar1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nome", "Descrição" }));

        jtfButtonBuscar1.setText("Buscar");
        jtfButtonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfButtonBuscar1ActionPerformed(evt);
            }
        });

        jtfLabelRegistro1.setText("Dê dois cliques no registro para editá-lo");

        tableReceitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Categoria", "Despesa", "Valor", "Data de lançamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReceitasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableReceitas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfFiltrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfButtonBuscar1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jtfLabelRegistro1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFiltrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfButtonBuscar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelRegistro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableReceitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReceitasMouseClicked
        if(evt.getClickCount() == 2){
            ModReceitas modReceitas = new ModReceitas();
           
            modReceitas.setId(Integer.parseInt(String.valueOf(tableReceitas.getValueAt(tableReceitas.getSelectedRow(), 0))));
            modReceitas.setCategoriaId(Integer.parseInt(String.valueOf(tableReceitas.getValueAt(tableReceitas.getSelectedRow(), 1))));
            modReceitas.setNome(String.valueOf(tableReceitas.getValueAt(tableReceitas.getSelectedRow(), 2)));
            modReceitas.setValor(Float.parseFloat(String.valueOf(tableReceitas.getValueAt(tableReceitas.getSelectedRow(), 3))));
            
            String dataLancamento = String.valueOf(tableReceitas.getValueAt(tableReceitas.getSelectedRow(), 4));

            if(dataLancamento == "null"){
                modReceitas.setDataDeLançamento("");
            }else{
                modReceitas.setDataDeLançamento(String.valueOf(tableReceitas.getValueAt(tableReceitas.getSelectedRow(), 4)));
            }
            
            DadosTemporarios.tempObject = (ModReceitas) modReceitas;
            
            if(Formularios.cadReceitas == null){
                Formularios.cadReceitas = new CadReceitas();
                
            ((CadReceitas)Formularios.cadReceitas).existeDadosTemporarios();
                Formularios.cadReceitas.setVisible(true);
                Formularios.cadReceitas.setExtendedState(JFrame.NORMAL);
            }
       }
    }//GEN-LAST:event_tableReceitasMouseClicked

    private void jtfButtonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfButtonBuscar1ActionPerformed
    switch(jtfFiltrar1.getSelectedIndex()){
        case 0:
            listarTodos();
            break;
        case 1:
            listarPorId(Integer.parseInt(jtfFiltro.getText()));
            break;
        case 2:
            listarPorNome(jtfFiltro.getText());
            break;
        }        
                                           
    }//GEN-LAST:event_jtfButtonBuscar1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(ListReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListReceitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jtfButtonBuscar1;
    private javax.swing.JComboBox<String> jtfFiltrar1;
    private javax.swing.JTextField jtfFiltro;
    private javax.swing.JLabel jtfLabelRegistro1;
    private javax.swing.JTable tableReceitas;
    // End of variables declaration//GEN-END:variables
}
