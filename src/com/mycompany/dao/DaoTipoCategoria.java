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
}
   
