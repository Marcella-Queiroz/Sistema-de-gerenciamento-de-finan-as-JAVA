package com.mycompany.despesas;

import javax.swing.table.DefaultTableModel;
import com.mycompany.dao.DaoDespesas;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.mycompany.modelo.ModDespesas;
import com.mycompany.utilidades.DadosTemporarios;
import com.mycompany.utilidades.Formularios;
import javax.swing.JFrame;

public class ListDespesas extends javax.swing.JFrame {

    public ListDespesas() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel)tableDespesas.getModel();
    
            TableDespesas.setModel(defaultTableModel);
            
            DaoDespesas daoDespesas = new DaoDespesas();
    
            ResultSet resultSet = daoDespesas.ListarTodos();
        
             defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String categoria_id = resultSet.getString(2);
                String nome = resultSet.getString(3);
                Double valor = resultSet.getDouble(4);
                String vencimento = resultSet.getString(5);
                String pagamento = resultSet.getString(6);

                defaultTableModel.addRow(new Object[]{id, categoria_id, nome, valor, vencimento, pagamento});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public void listarPorId(int pID){
    try{
        DefaultTableModel defaultTableModel = (DefaultTableModel) TableDespesas.getModel();
        
        TableDespesas.setModel(defaultTableModel);
        
        DaoDespesas daoDespesas = new DaoDespesas();
        
        ResultSet resultSet = daoDespesas.listarPorId(pID);
        
        defaultTableModel.setRowCount(0);
        
        while(resultSet.next()){
            String id = resultSet.getString(1);
            String categoria_id = resultSet.getString(2);
            String despesa = resultSet.getString(3);
            Double valor = resultSet.getDouble(4);
            String vencimento = resultSet.getString(5);
            String pagamento = resultSet.getString(6);
            
            defaultTableModel.addRow(new Object[]{id,categoria_id, despesa, valor, vencimento, pagamento});
        }
        
    }catch(Exception e ){
        System.out.println(e.getMessage());
    
        }
    }
    public void listarPorNome(String pNome){
        try{
        DefaultTableModel defaultTableModel = (DefaultTableModel)TableDespesas.getModel();
        
        TableDespesas.setModel(defaultTableModel);
        
            DaoDespesas daoDespesas = new DaoDespesas();
            
            ResultSet resultSet = daoDespesas.ListarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String categoria_id = resultSet.getString(2);
                String despesa = resultSet.getNString(3);
                Double valor = resultSet.getDouble(4);
                String vencimento = resultSet.getString(5);
                String pagamento = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, categoria_id, despesa,valor, vencimento, pagamento});
            } 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableDespesas = new javax.swing.JTable();
        jtfFiltrar = new javax.swing.JComboBox<>();
        jtfLabelRegistro = new javax.swing.JLabel();
        BtnBuscar = new javax.swing.JPanel();
        jcbFiltrar1 = new javax.swing.JComboBox<>();
        jtfButtonBuscar1 = new javax.swing.JButton();
        jtfLabelRegistro1 = new javax.swing.JLabel();
        jtfFiltro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDespesas = new javax.swing.JTable();

        TableDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Categoria", "Despesa", "Valor", "Vencimento", "Pagamento"
            }
        ));
        jScrollPane1.setViewportView(TableDespesas);

        jtfFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nome", "Descrição" }));

        jtfLabelRegistro.setText("Dê dois cliques no registro para editá-lo");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbFiltrar1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nome" }));

        jtfButtonBuscar1.setText("Buscar");
        jtfButtonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfButtonBuscar1ActionPerformed(evt);
            }
        });

        jtfLabelRegistro1.setText("Dê dois cliques no registro para editá-lo");

        tableDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Categoria", "Despesa", "Valor", "Vencimento", "Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDespesasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableDespesas);

        javax.swing.GroupLayout BtnBuscarLayout = new javax.swing.GroupLayout(BtnBuscar);
        BtnBuscar.setLayout(BtnBuscarLayout);
        BtnBuscarLayout.setHorizontalGroup(
            BtnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BtnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BtnBuscarLayout.createSequentialGroup()
                        .addComponent(jcbFiltrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfButtonBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnBuscarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jtfLabelRegistro1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE))
                .addContainerGap())
        );
        BtnBuscarLayout.setVerticalGroup(
            BtnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BtnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFiltrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfButtonBuscar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLabelRegistro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfButtonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfButtonBuscar1ActionPerformed
    switch(jcbFiltrar1.getSelectedIndex()){
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

    private void tableDespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDespesasMouseClicked
       if(evt.getClickCount() == 2){
           ModDespesas modDespesas = new ModDespesas();
           
            modDespesas.setId(Integer.parseInt(String.valueOf(tableDespesas.getValueAt(tableDespesas.getSelectedRow(), 0))));
            modDespesas.setCategoriaId(Integer.parseInt(String.valueOf(tableDespesas.getValueAt(tableDespesas.getSelectedRow(), 1))));
            modDespesas.setNome(String.valueOf(tableDespesas.getValueAt(tableDespesas.getSelectedRow(), 2)));
            modDespesas.setValor(Float.parseFloat(String.valueOf(tableDespesas.getValueAt(tableDespesas.getSelectedRow(), 3))));
           /* 
            String dataVencimento = String.valueOf(tableDespesas.getValueAt(tableDespesas.getSelectedRow(), 4)));
            String dataPagamento = String.valueOf(tableDespesas.getValueAt(tableDespesas.getSelectedRow(), 5)));
            
     
           
            if( dataVencimento== "null"){
                modDespesas.setdata("");
            }else{
                modDespesas.setDataDeLançamento(String.valueOf(tableDespesas.getValueAt(tableDespesas.getSelectedRow(), 4)));
            }
            */
            DadosTemporarios.tempObject = (ModDespesas) modDespesas;
            
            if(Formularios.cadDespesas == null){
                Formularios.cadDespesas = new CadDespesas();
                
            ((CadDespesas)Formularios.cadDespesas).existeDadosTemporarios();
                Formularios.cadDespesas.setVisible(true);
                Formularios.cadDespesas.setExtendedState(JFrame.NORMAL);
            }
       }
    }//GEN-LAST:event_tableDespesasMouseClicked


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListDespesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnBuscar;
    private javax.swing.JTable TableDespesas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbFiltrar1;
    private javax.swing.JButton jtfButtonBuscar1;
    private javax.swing.JComboBox<String> jtfFiltrar;
    private javax.swing.JTextField jtfFiltro;
    private javax.swing.JLabel jtfLabelRegistro;
    private javax.swing.JLabel jtfLabelRegistro1;
    private javax.swing.JTable tableDespesas;
    // End of variables declaration//GEN-END:variables
}
