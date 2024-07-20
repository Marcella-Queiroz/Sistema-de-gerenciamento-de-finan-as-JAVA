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
public class DaoCategoria extends BancoDeDadosMySql{
    
    String sql;
    public Boolean inserir(int id, int tipoCategoria, String nome  ){
    try{
        sql = "INSERT INTO categoria(ID, TIPO_CATEGORIA, NOME) VALUES (?,?,?)";
        
         setStatement(getConexao().prepareStatement(sql));
         
         getStatement().setInt(1, id);
         getStatement().setInt(2, tipoCategoria);
         getStatement().setString(3, nome);
        
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
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM CATEGORIA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
    
    public ResultSet listarTodos(){
        try{
            sql = "SELECT * FROM CATEGORIA";

            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarTodosPorIdCategoria(int idCategoria){
        try{
            sql = "SELECT * FROM CATEGORIA WHERE CATEGORIA = ?";

            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idCategoria);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT * FROM CATEGORIA WHERE NOME LIKE ?";

            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
}
    

