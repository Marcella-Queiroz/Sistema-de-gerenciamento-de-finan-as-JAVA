package com.mycompany.metas;

import com.mycompany.dao.DaoMetas;
import com.mycompany.modelo.ModMetas;
import com.mycompany.modelo.ModResumoMetas;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Formularios;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author marcella.1963
 */
public class ListMetas extends javax.swing.JFrame {

    /**
     * Creates new form ListMeta
     */
    public ListMetas() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel)TableMetas.getModel();
            
            TableMetas.setModel(defaultTableModel);
            
            DaoMetas daoMetas = new DaoMetas();
            
            ResultSet resultSet= daoMetas.ListarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){  
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                Double valor = resultSet.getDouble(3);
                String meses = resultSet.getString(4);
                String data_inicial = resultSet.getString(5);
                Double valor_depositado = resultSet.getDouble(6);
                
                defaultTableModel.addRow(new Object []{id, nome, valor, meses, data_inicial, valor_depositado});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorId(int pID) {
        try {
            DefaultTableModel defaultTableModel = (DefaultTableModel) TableMetas.getModel();
            defaultTableModel.setRowCount(0); // Limpa a tabela antes de adicionar os resultados

            DaoMetas daoMetas = new DaoMetas();
            ResultSet resultSet = daoMetas.listarPorId(pID);

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                Double valor = resultSet.getDouble(3);
                String meses = resultSet.getString(4);
                String data_inicial = resultSet.getString(5);
                Double valor_depositado = resultSet.getDouble(6);

                defaultTableModel.addRow(new Object[]{id, nome, valor, meses, data_inicial, valor_depositado});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   
    public void listarPorNome(String pNome){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) TableMetas.getModel();
            
            TableMetas.setModel(defaultTableModel);
            
            DaoMetas daoMetas = new DaoMetas();
            
            ResultSet resultSet = daoMetas.ListarPorNome(pNome);
        
            defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                Double valor = resultSet.getDouble(3);
                String meses = resultSet.getString(4);
                String data_inicial = resultSet.getString(5);
                Double valor_depositado = resultSet.getDouble(6);

                defaultTableModel.addRow(new Object[]{id, nome, valor, meses, data_inicial, valor_depositado});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableMetas = new javax.swing.JTable();
        jtfBuscar = new javax.swing.JButton();
        jtfFiltro = new javax.swing.JTextField();
        jcbFiltro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Metas");

        TableMetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor", "Meses", "Data Inicial", "Valor Depositado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMetasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableMetas);

        jtfBuscar.setText("Buscar");
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        jtfFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFiltroActionPerformed(evt);
            }
        });

        jcbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nome" }));
        jcbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroActionPerformed(evt);
            }
        });

        jLabel1.setText("De dois cliques para editá-lo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbFiltro, 0, 86, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscar)
                    .addComponent(jtfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableMetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMetasMouseClicked

        if (evt.getClickCount() == 2) { // Verifica se foi clicado com o botão direito
            int row = TableMetas.rowAtPoint(evt.getPoint());
            if (row >= 0 && row < TableMetas.getRowCount()) {
                TableMetas.setRowSelectionInterval(row, row); // Seleciona a linha clicada

                JPopupMenu jPopupMenu = new JPopupMenu();

                JMenuItem item1 = new JMenuItem("Alterar");
                JMenuItem item2 = new JMenuItem("Visualizar");

                // Adicione ações aos itens do menu aqui
                item1.addActionListener(e -> {
                    enviarParaAlteracao();
                });

                item2.addActionListener(e -> {
                    enviarParavisualizacao();
                });

                jPopupMenu.add(item1);
                jPopupMenu.add(item2);

                jPopupMenu.show(TableMetas, evt.getX(), evt.getY()); // Mostra o menu na posição do clique
            }
        }
        
               
              
    }//GEN-LAST:event_TableMetasMouseClicked

    private void enviarParaAlteracao(){
        ModMetas modMetas = new ModMetas();
            
        modMetas.setId(Integer.parseInt(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 0))));
        modMetas.setNome(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 1)));
        modMetas.setValor(Float.parseFloat(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 2))));
        modMetas.setMeses(Integer.parseInt(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 3))));
        modMetas.setDataInicial(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 4)));
        modMetas.setValor_depositado(Double.parseDouble(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 5))));


        DadosTemporarios.tempObject = (ModMetas) modMetas;

        if(Formularios.cadMetas == null){
            Formularios.cadMetas = new CadMetas();

        ((CadMetas)Formularios.cadMetas).existeDadosTemporarios();   
            Formularios.cadMetas.setVisible(true); 
            Formularios.cadMetas.setExtendedState(JFrame.NORMAL);
            }
    }
    
    private void enviarParavisualizacao(){
        ModResumoMetas modResumoMetas = new ModResumoMetas();
            
        modResumoMetas.setId(Integer.parseInt(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 0))));
        modResumoMetas.setNome(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 1)));
        modResumoMetas.setValor(Float.parseFloat(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 2))));
        modResumoMetas.setMeses(Integer.parseInt(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 3))));
        modResumoMetas.setDataInicial(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 4)));
        modResumoMetas.setValor_depositado(Double.parseDouble(String.valueOf(TableMetas.getValueAt(TableMetas.getSelectedRow(), 5))));
        
        DadosTemporarios.tempObject = (ModResumoMetas) modResumoMetas;

        if(Formularios.resumoMetas == null){
            Formularios.resumoMetas = new ResumoMetas();

            ((ResumoMetas)Formularios.resumoMetas).existeDadosTemporarios();   
            Formularios.resumoMetas.setVisible(true); 
            Formularios.resumoMetas.setExtendedState(JFrame.NORMAL);
        }
    }
    
    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
        switch(jcbFiltro.getSelectedIndex()){
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
    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void jtfFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFiltroActionPerformed

    private void jcbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroActionPerformed
        
    }//GEN-LAST:event_jcbFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(ListMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMetas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableMetas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbFiltro;
    private javax.swing.JButton jtfBuscar;
    private javax.swing.JTextField jtfFiltro;
    // End of variables declaration//GEN-END:variables
}
