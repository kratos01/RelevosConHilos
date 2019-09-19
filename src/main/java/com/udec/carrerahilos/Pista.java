/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerahilos;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian Perez
 * @author Julian Arias
 * constructor de la clase que inicializa las variables 
 */

public class Pista {
    private int posCorredor1=0;
    private int posCorredor2=33;
    private int posCorredor3=66;
    private String pista = "";
    /**
     * 
     * @return la pocision de corredor 1 
     */
    public int getPosCorredor1() {
        return posCorredor1;
    }
/**
 * 
 * @param posCorredor1 captur al aposicion del corredor 1
 */
    public void setPosCorredor1(int posCorredor1) {
        this.posCorredor1 = posCorredor1;
    }
/**
 * 
 * @return retorna la posicion del corredor 2 
 */
    public int getPosCorredor2() {
        return posCorredor2;
    }
/**
 * 
 * @param posCorredor2 captura la posicion del corresor 2 
 */
    public void setPosCorredor2(int posCorredor2) {
        this.posCorredor2 = posCorredor2;
    }
/**
 * 
 * @return retorna la posicion del corredor 3
 */
    public int getPosCorredor3() {
        return posCorredor3;
    }
/**
 * 
 * @param posCorredor3 captrura la posicion del corredor 3 
 */
    public void setPosCorredor3(int posCorredor3) {
        this.posCorredor3 = posCorredor3;
    }
    /**
     * 
     * @param color recibe este parametro 
     * el metodo imprime en consola el circuito
     */
    public void imprimirCiruito(String color){
   
        for (int i = 0; i < 100; i++) {
            if(i == posCorredor1){
                pista += "¥";
            }
            if(i == posCorredor2){
                pista += "¥";
            }
            if(i == posCorredor3){
                pista += "¥";
            } pista += "_";            
        }  
        System.out.println(color+ pista);
        pista="";
       
        limpiarPantalla();
        try {
            if("\u001B[31m".equals(color)){
            Thread.sleep(800);
            }
            else if ("\u001B[34m".equals(color)){
                Thread.sleep(800);
            }else{
            Thread.sleep(800);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
/**
 * metodo que imprime espacios en consola 
 */
    public void limpiarPantalla(){
        int saltos=5;
        for (int j = 0; j < saltos; j++) {
            System.out.println("");
        }
      }
    
 
}