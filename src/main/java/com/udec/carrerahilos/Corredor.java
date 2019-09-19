/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerahilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian Perez
 * @author Julian Arias
 */
public class Corredor extends Thread{
/**
 * variables globales de la clase 
 */
    private Pista carril;
    private int posicionInicial;
    private String color;

    public Corredor() {
    }

    /**
     * parametros que recibe el constructor de la clase y los inicializa
     * @param carril
     * @param posicionInicial
     * @param color 
     */
    public Corredor(Pista carril, int posicionInicial, String color) {
        this.carril = carril;
        this.posicionInicial = posicionInicial;
        this.color = color;
    }
    /**
     * 
     * @return captura el color del equipo 
     */
    public String getColor() {
        return color;
    }
/**
 * 
 * @param color retorna el color del equipo
 */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * 
     * @param equipo retorna el carril de cada atleta 
     */
     public void setCarril(Pista equipo) {
        this.carril = equipo;
    }
     /**
      * 
      * @return captura el carril de cada atleta 
      */
    public Pista getCarril() {
        return carril;
    }
    /**
     * 
     * @return captura la posicion inicial por equipo
     */
    public int getPosicionInicial() {
        return posicionInicial;
    }
/**
 * 
 * @param posicionInicial retorna la posicion de cada equipo 
 */
    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }
    
    /**
     * 
     * @return un entero 
     * metodo que retorna numeros aleatorios del 1 al 3
     */
    public int Correr(){
        int pasos=(int)(Math.random()*3)+1;
        return pasos;
    
    }
    /**
     * metodo que hace la logica para cada hilo 
     * e imprime el ganador 
     */
    @Override
    public void run(){
        
        int numPasos;
        if(posicionInicial==0){
                    do{
                        carril.imprimirCiruito(getColor());
                        numPasos = Correr();
                        carril.setPosCorredor1(carril.getPosCorredor1()+numPasos); 
                        if(carril.getPosCorredor1()> 33){
                             carril.setPosCorredor1(33);
                        }
                    }while(carril.getPosCorredor1()< 33);
                    notificarCompañero();
        } else {
             
        synchronized(carril){
        esperaCompañero(); 
        if(posicionInicial==33){
                    do{
                       carril.imprimirCiruito(getColor());
                       numPasos = Correr();
                       carril.setPosCorredor2(carril.getPosCorredor2()+numPasos); 
                       if(carril.getPosCorredor2()> 66){
                            carril.setPosCorredor2(66);
                       }
                    }while(carril.getPosCorredor2()< 66);
                   notificarCompañero();
       }else {  
        synchronized(carril){
        esperaCompañero();
        if(posicionInicial==66){
                    do{
                        carril.imprimirCiruito(getColor());
                        numPasos = Correr();
                        carril.setPosCorredor3(carril.getPosCorredor3()+numPasos); 
                        if(carril.getPosCorredor3()> 100){
                             carril.setPosCorredor3(99);
                        }
                    }while(carril.getPosCorredor3()<100);
                        
                       if("\u001B[31m".equals(color)){
                            System.out.println("EL GANADOR ES: "+ "Rojo"); 
                       }
                       else if ("\u001B[34m".equals(color)){
                       System.out.println("EL GANADOR ES: "+ "Azul");
                       }else{
                       System.out.println("EL GANADOR ES: "+ "Verde");
                       }
                    
                        System.exit(0);
                    } 
                        
                }
            }
        }
    }
        
}
    /**
     * metodo que sincroniza y notifica a los compañeros del mismo carril
     */
    public void notificarCompañero(){
        synchronized(carril){
                carril.notifyAll();
            }      
    }
    /**
     * metodo de espera para el compañero del mismo carril
     */
    public void esperaCompañero(){
                try {
                        carril.wait();
                }catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
}
}