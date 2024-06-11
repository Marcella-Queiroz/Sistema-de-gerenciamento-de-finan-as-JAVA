/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.utilidades.BancoDeDadosMySql;
import java.sql.ResultSet;
/**
 *
 * @author marcella.1963
 */
public class DaoMetas extends BancoDeDadosMySql {
    private String sql;
    
    public Boolean inserir(int id,String metas, int valor, String descricao, String data_inicial, String data_final){
    try{
        sql = "INSERT INTO CAD_METAS (ID, METAS, VALOR, DESCRICAO, DATA_INICIAL, DATA_FINAL) VALUES (?,?,?,?,?,?)";
        
         setStatement(getConexao().prepareStatement(sql));
         
         getStatement().setInt(1, id);
         getStatement().setString(2, metas);
         getStatement().setInt(3, valor);
         getStatement().setString(4, descricao);
         getStatement().setString(5, data_inicial);
         getStatement().setString(6, data_final);
         
         getStatement().executeUpdate();
         
         return true;
         
    }catch(Exception e){
        System.err.println(e.getLocalizedMessage());
        
        return false;
    }
}
    public int buscarProximoID(){
        int id =0;
        try{
            sql = "SELECT INFULL (MAX(ID)) + 1 FROM CAD_METAS";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next();
            
            id = getResultado().getInt(1);         
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return id;
    }
public ResultSet ListarTodos(){
    try
}catch(Exceptio e){

        System.out.println(e.get)
}
