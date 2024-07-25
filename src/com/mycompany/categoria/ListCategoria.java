/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.categoria;

import com.mycompany.dao.DaoCategoria;
import com.mycompany.modelo.ModCategoria;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Formularios;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JFrame;

/**
 *
 * @author marcella.1963
 */
public class ListCategoria extends javax.swing.JFrame {

    public ListCategoria() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }

        public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel)TableCategoria.getModel();
    
            TableCategoria.setModel(defaultTableModel);
            
            DaoCategoria daocategoria = new DaoCategoria();
    
            ResultSet resultSet = daocategoria.listarTodos();
        
            defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String TipoCategoria = resultSet.getString("tc.nome");
                String nome = resultSet.getString(3);
                String idCategoria = resultSet.getString("tc.id");
               
            
                defaultTableModel.addRow(new Object[]{id, TipoCategoria, nome, idCategoria});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfLabelRegistro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCategoria = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Categoria");

        jtfLabelRegistro.setText("Dê dois cliques no registro para editá-lo");

        TableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tipo Categoria", "Nome", "Id Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCategoria);
        if (TableCategoria.getColumnModel().getColumnCount() > 0) {
            TableCategoria.getColumnModel().getColumn(3).setMinWidth(0);
            TableCategoria.getColumnModel().getColumn(3).setPreferredWidth(0);
            TableCategoria.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jButton1.setText("+ Cadastrar Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfLabelRegistro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfLabelRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Formularios.cadCategoria == null)
        Formularios.cadCategoria = new CadCategoria();
        Formularios.cadCategoria.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCategoriaMouseClicked
        if(evt.getClickCount() == 2){
            ModCategoria modCategoria = new ModCategoria();
            
            modCategoria.setId(Integer.parseInt(String.valueOf(TableCategoria.getValueAt(TableCategoria.getSelectedRow(), 0))));
            modCategoria.setTipoCategoria(Integer.parseInt(String.valueOf(TableCategoria.getValueAt(TableCategoria.getSelectedRow(), 3))));
            modCategoria.setNome(String.valueOf(TableCategoria.getValueAt(TableCategoria.getSelectedRow(), 2)));
        
            DadosTemporarios.tempObject = (ModCategoria) modCategoria;
        
            if(Formularios.cadCategoria == null){
                Formularios.cadCategoria = new CadCategoria();
           
            ((CadCategoria)Formularios.cadCategoria).existeDadosTemporarios();   
                Formularios.cadCategoria.setVisible(true); 
                Formularios.cadCategoria.setExtendedState(JFrame.NORMAL);
            }
        }
        
        
    }//GEN-LAST:event_TableCategoriaMouseClicked

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
            java.util.logging.Logger.getLogger(ListCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListCategoria().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jtfLabelRegistro;
    // End of variables declaration//GEN-END:variables
}
