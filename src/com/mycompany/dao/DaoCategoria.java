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
    
    public ResultSet listarTodosPorIdCategoria(int idTipoCategoria){
        try{
            sql = "SELECT * FROM CATEGORIA WHERE TIPO_CATEGORIA = ?";

            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idTipoCategoria);
            
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
