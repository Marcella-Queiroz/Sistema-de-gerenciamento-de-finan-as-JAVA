package com.mycompany.dao;

import com.mycompany.utilidades.BancoDeDadosMySql;
import java.sql.ResultSet;
import java.sql.Types;

public class DaoDespesas extends BancoDeDadosMySql{
    private String sql;
    
    public Boolean inserir(int categoriaId, String nome, Double Valor, String Vencimento, String Pagamento ){
    try{
        sql = "INSERT INTO DESPESAS (CATEGORIA_ID, NOME, VALOR, VENCIMENTO, PAGAMENTO) VALUES (?,?,?,?,?)";
        
         setStatement(getConexao().prepareStatement(sql));
         
         getStatement().setInt(1, categoriaId);
         getStatement().setString(2, nome);
         getStatement().setDouble(3, Valor);
         
        if(Vencimento.equals("")){
            getStatement().setNull(4, Types.DATE);
        }else{
            getStatement().setString(4, Vencimento);
        }
        
        if(Vencimento.equals("")){
            getStatement().setNull(5, Types.DATE);
        }else{
            getStatement().setString(5, Pagamento);
        }
        
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
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM DESPESAS";
            
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
        sql = "SELECT ID, CATEGORIA_ID, NOME, VALOR, VENCIMENTO, PAGAMENTO FROM DESPESAS";
            
        setStatement(getConexao().prepareStatement(sql));
        
         setResultado(getStatement().executeQuery());  
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return getResultado();
}
   
    public ResultSet listarPorId(int id){
    try{
        sql = "SELECT ID, NOME FROM DESPESAS WHERE ID = ?";
            
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
        sql = "SELECT ID, NOME FROM DESPESAS WHERE NOME LIKE ?";
        
        setStatement(getConexao().prepareStatement(sql));
        
        getStatement().setString(1, nome+ "%");
        
        setResultado(getStatement().executeQuery());
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return getResultado();
    }
    public Boolean alterar(int ID, int Categoria_id, String Despesas, Float Valor, String Vencimento, String Pagamento ){
        try{
            sql = "UPDATE DESPESAS SET CATEGORIA_ID = ?, NOME = ?, VALOR = ?, VENCIMENTO = ?, PAGAMENTO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            getStatement().setInt(6,ID);
            getStatement().setInt(1, Categoria_id);
            getStatement().setString(2, Despesas);
            getStatement().setFloat(3, Valor);
            getStatement().setString(4, Vencimento);
            getStatement().setString(5, Pagamento);
            
            if(Vencimento.equals("")){
                getStatement().setNull(4, Types.DATE);
            }else{
                getStatement().setString(4, Vencimento);
            }
        
            if(Vencimento.equals("")){
                getStatement().setNull(5, Types.DATE);
            }else{
                getStatement().setString(5, Pagamento);
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
         sql = "DELETE FROM DESPESAS WHERE ID = ?";
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