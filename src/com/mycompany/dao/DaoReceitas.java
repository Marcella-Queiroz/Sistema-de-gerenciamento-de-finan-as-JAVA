package com.mycompany.dao;

import com.mycompany.utilidades.BancoDeDadosMySql;
import java.sql.ResultSet;
import java.sql.Types;


public class DaoReceitas extends BancoDeDadosMySql {
    private String sql;
    
    public Boolean inserir(int categoriaId, String Nome, Double Valor, String Data_de_Lançamento){
        try{
        sql = "INSERT INTO RECEITAS (CATEGORIA_ID, NOME, VALOR, DATA_DE_LANCAMENTO) VALUES (?,?,?,?)";
    
        setStatement(getConexao().prepareCall(sql));
        
        getStatement().setInt(1, categoriaId);
        getStatement().setString(2, Nome);
        getStatement().setDouble(3, Valor);
        getStatement().setString(4, Data_de_Lançamento);
        
       
        if(Data_de_Lançamento.equals("")){
            getStatement().setNull(4, Types.DATE);
        }else{
            getStatement().setString(4, Data_de_Lançamento);
        }
        
        getStatement().executeUpdate();
        
        return true;
    }catch(Exception e){
        System.err.println(e.getLocalizedMessage());
    }
        return false;
     
}

    public int buscarProximoId(){
        int id =0;
        try{
            sql = "SELECT IFNULL (MAX(ID), 0)+ 1 FROM RECEITAS";
            
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
    try{
    sql = "SELECT ID, CATEGORIA_ID, NOME, VALOR, DATA_DE_LANCAMENTO FROM RECEITAS";
    
    setStatement(getConexao().prepareCall(sql));
    
    setResultado(getStatement().executeQuery());
    
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return getResultado();
}
    public ResultSet listarPorId(int id){
    try{
        sql = "SELECT ID, CATEGORIA_ID, NOME, VALOR, DATA_DE_LANCAMENTO FROM RECEITAS WHERE ID = ?";
            
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
        sql = "SELECT ID, CATEGORIA_ID, NOME, VALOR, DATA_DE_LANCAMENTO FROM RECEITAS WHERE NOME LIKE ?";
        
        setStatement(getConexao().prepareStatement(sql));
        
        getStatement().setString(1, nome+ "%");
        
        setResultado(getStatement().executeQuery());
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return getResultado();
}
    public Boolean alterar(int ID, int Categoria_id, String Nome, Double Valor, String Data_de_Lançamento ){
        try{
            sql = "UPDATE RECEITAS SET CATEGORIA_ID = ?, NOME = ?, VALOR = ?, DATA_DE_LANCAMENTO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            getStatement().setInt(5,ID);
            getStatement().setInt(1, Categoria_id);
            getStatement().setString(2, Nome);
            getStatement().setDouble(3, Valor);
            
            if(Data_de_Lançamento.equals("")){
                getStatement().setNull(4, Types.DATE);
            }else{
                getStatement().setString(4, Data_de_Lançamento);
            }

            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
}
    public Boolean excluir (int id ){
     try{
         sql = "DELETE FROM RECEITAS WHERE ID = ?";
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