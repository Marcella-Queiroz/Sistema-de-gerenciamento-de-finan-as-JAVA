/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 * @author marcella.1963
 */
public class MyFormatter {
    public static String formatDate(String date, String inputFormat, String outputFormat){
        try{
            SimpleDateFormat formatoEntrada = new SimpleDateFormat(inputFormat);
            Date dataDeLancamento = formatoEntrada.parse(date);
            SimpleDateFormat formatoSaida = new SimpleDateFormat(outputFormat);
            String dataFormatada = formatoSaida.format(dataDeLancamento);
            
            return dataFormatada;
        }catch(ParseException e){
            System.err.println(e.getMessage());
            return "";
        }
    }
}
