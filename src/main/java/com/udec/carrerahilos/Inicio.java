/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerahilos;

/**
 *@author Cristian Perez
 * @author Jlian Arias
 * metodo por donde inicia el programa
 */
public class Inicio {
    public static String rojo="\u001B[31m";
    public static String azul="\u001B[34m";
    public static String verde="\u001B[32m";
    
    public Inicio(){
        
        Pista uno=new Pista();
        Pista dos=new Pista();
        Pista tres=new Pista();
        
        Corredor per=new Corredor(uno,0,rojo);
        Corredor per2=new Corredor(uno,33,rojo);
        Corredor per3=new Corredor(uno,66,rojo);
        
        Corredor per4=new Corredor(dos,0,azul);
        Corredor per5=new Corredor(dos,33,azul);
        Corredor per6=new Corredor(dos,66,azul);
        
        Corredor per7=new Corredor(tres,0,verde);
        Corredor per8=new Corredor(tres,33,verde);
        Corredor per9=new Corredor(tres,66,verde);
    
        per.start();
        per2.start();
        per3.start();
        per4.start();
        per5.start();
        per6.start();        
        per7.start();
        per8.start();
        per9.start();
    
    
    
    }
    public static void main(String[] args) {
        Inicio inicio=new Inicio();
       
    }
    
}
