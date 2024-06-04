package com.mycompany.dao;

import com.mycompany.utilidades.BancoDeDadosMySql;

public class DaoTipoCategoria extends BancoDeDadosMySql{
    private String sql;
    
    public Boolean inserir(String Nome){
        try{
            sql = "INSERT INTO TIPO_CATEGORIA (NOME) VALUES (?)";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, Nome);

            getStatement().executeUpdate();

            return true;

        }catch(Exception e){
            System.err.println(e.getMessage());

            return false;
        }
    }
    
    public int buscarProximoId(){
        int id = 0;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM TIPO_CATEGORIA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
}
   
