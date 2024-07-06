package com.mycompany.tipoCategoria;

import com.mycompany.dao.DaoTipoCategoria;
import com.mycompany.modelo.ModTipoCategoria;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Formularios;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListTipoCategoria extends javax.swing.JFrame {

    public ListTipoCategoria() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }

    public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableTipoCategoria.getModel();

            tableTipoCategoria.setModel(defaultTableModel);
            
            DaoTipoCategoria daoTipoCategoria = new DaoTipoCategoria();
            
            ResultSet resultSet = daoTipoCategoria.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                
                defaultTableModel.addRow(new Object[]{id, nome});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorID(int pID){
        try{
        
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableTipoCategoria.getModel();
            
            tableTipoCategoria.setModel(defaultTableModel);
            
            DaoTipoCategoria daoTipoCategoria = new DaoTipoCategoria();
            
            ResultSet resultSet = daoTipoCategoria.listarPorId(pID);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                
                defaultTableModel.addRow(new Object[]{id, nome});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNome(String pNome){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableTipoCategoria.getModel();
            
            tableTipoCategoria.setModel(defaultTableModel);
            
            DaoTipoCategoria daoTipoCategoria = new DaoTipoCategoria();
            
            ResultSet resultSet = daoTipoCategoria.listarPorNome(pNome);
        
            defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);

                defaultTableModel.addRow(new Object[]{id,nome});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTipoCategoria = new javax.swing.JTable();
        jtfFiltro = new javax.swing.JTextField();
        jtfButtonBuscar1 = new javax.swing.JButton();
        jcbFiltro = new javax.swing.JComboBox<>();
        jtfLabelRegistro1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableTipoCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Tipo de Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTipoCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTipoCategoriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableTipoCategoria);

        jtfButtonBuscar1.setText("Buscar");
        jtfButtonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfButtonBuscar1ActionPerformed(evt);
            }
        });

        jcbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nome" }));

        jtfLabelRegistro1.setText("Dê dois cliques no registro para editá-lo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jcbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfButtonBuscar1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jtfLabelRegistro1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfButtonBuscar1)
                    .addComponent(jcbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jtfLabelRegistro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableTipoCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTipoCategoriaMouseClicked
        if(evt.getClickCount() == 2){
            ModTipoCategoria modTipoCategoria = new ModTipoCategoria();
            
            modTipoCategoria.setId(Integer.parseInt(String.valueOf(tableTipoCategoria.getValueAt(tableTipoCategoria.getSelectedRow(), 0))));
            modTipoCategoria.setNome(String.valueOf(tableTipoCategoria.getValueAt(tableTipoCategoria.getSelectedRow(), 1)));
            
            DadosTemporarios.tempObject = (ModTipoCategoria) modTipoCategoria;
        
            if(Formularios.cadTipoCategoria == null){
                Formularios.cadTipoCategoria = new CadTipoCategoria();
           
            ((CadTipoCategoria)Formularios.cadTipoCategoria).existeDadosTemporarios();   
                Formularios.cadTipoCategoria.setVisible(true); 
                Formularios.cadTipoCategoria.setExtendedState(JFrame.NORMAL);
            }
        }
    }//GEN-LAST:event_tableTipoCategoriaMouseClicked

    private void jtfButtonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfButtonBuscar1ActionPerformed
        switch(jcbFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorID(Integer.parseInt(jtfFiltro.getText()));
                break;
            case 2:
                listarPorNome(jtfFiltro.getText());
                break;
        }
    }//GEN-LAST:event_jtfButtonBuscar1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListTipoCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbFiltro;
    private javax.swing.JButton jtfButtonBuscar1;
    private javax.swing.JTextField jtfFiltro;
    private javax.swing.JLabel jtfLabelRegistro1;
    private javax.swing.JTable tableTipoCategoria;
    // End of variables declaration//GEN-END:variables
}
