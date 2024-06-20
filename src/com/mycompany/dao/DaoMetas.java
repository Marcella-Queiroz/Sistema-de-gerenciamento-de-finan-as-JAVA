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
    
    public Boolean inserir(String metas, Double valor, String descricao, String data_inicial, String data_final){
    try{
        sql = "INSERT INTO METAS (NOME, VALOR, DESCRICAO, DATA_INICIAL, DATA_FINAL) VALUES (?,?,?,?,?)";
        
         setStatement(getConexao().prepareStatement(sql));
         
         getStatement().setString(1, metas);
         getStatement().setDouble(2, valor);
         getStatement().setString(3, descricao);
         getStatement().setString(4, data_inicial);
         getStatement().setString(5, data_final);
         
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
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM METAS";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
public ResultSet ListarTodos(){
    try{
        sql = "SELECT ID, NOME, VALOR, DESCRICAO, DATA_INICIAL, DATA_FINAL FROM METAS";

        setStatement(getConexao().prepareStatement(sql));
        
         setResultado(getStatement().executeQuery());  
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return getResultado();
}
   
    public ResultSet listarPorId(int id){
    try{
        sql = "SELECT ID, NOME FROM METAS WHERE ID = ?";
            
        setStatement(getConexao().prepareStatement(sql));
            
        getStatement().setInt(1, id);
            
        setResultado(getStatement().executeQuery());
    }catch(Exception e){
            System.out.println(e.getMessage());
      }
        return getResultado();
    }
    public ResultSet ListarPorNome(String nome){
    try{
        sql = "SELECT ID, NOME FROM METAS WHERE NOME LIKE ?";
        
        setStatement(getConexao().prepareStatement(sql));
        
        getStatement().setString(1, nome+ "%");
        
        setResultado(getStatement().executeQuery());
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return getResultado();
    }
    public Boolean alterar(int ID, String nome, Double valor, String descricao, String data_inicial, String data_final ){
        try{
            sql = "UPDATE METAS SET NOME = ?, VALOR = ?, DESCRICAO = ?,DATA_INICIAL = ?, DATA_FINAL = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            getStatement().setInt(6,ID);
            getStatement().setString(1, nome);
            getStatement().setDouble(2, valor);
            getStatement().setString(3, descricao);
            getStatement().setString(4, data_inicial);
            getStatement().setString(5, data_final);
            
            getStatement().executeQuery();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
}
    public Boolean excluir (int id ){
     try{
         sql = "DELETE FROM METAS WHERE ID = ?";
         setStatement(getConexao().prepareCall(sql));
         getStatement().setInt(1, id);
         getStatement().executeUpdate();
         
         return true;
     }catch(Exception e){
         System.out.println(e.getMessage());
         return false;
     }
     
    }
}
