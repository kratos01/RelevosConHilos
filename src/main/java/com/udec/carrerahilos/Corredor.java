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
 * Esta clase contiene los atributos y metodos del corredor
 */
public class Corredor extends Thread{

    /**
     * Atributo que recibe objeto carril por donde corre cada corredor*/
    private Pista carril;
    /**
     * Atributo que recibe la posicion inicial de cada corredor*/
    private int posicionInicial;
    /*
    *atributo que recibe el color de cada corredor */
    private String color;

    /**
     * Constructor de la clase vacio
     */
    public Corredor() {
    }
    /**
     * Constructor de la clase
     * @param carril pista por donde va el corredor
     * @param posicionInicial posicion inicial del corredor
     * @param color identificador de color del corredor
     */
    public Corredor(Pista carril, int posicionInicial, String color) {
        this.carril = carril;
        this.posicionInicial = posicionInicial;
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
     public void setCarril(Pista equipo) {
        this.carril = equipo;
    }
    public Pista getCarril() {
        return carril;
    }
    public int getPosicionInicial() {
        return posicionInicial;
    }

    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }
    
    public int Correr(){
        int pasos=(int)(Math.random()*3)+1;
        return pasos;
    
    }
    /**
     * Metodo que define el arranque de los hilos.
     */
    @Override
    public void run(){
        if(posicionInicial==0){
            arrancaCorredor1();
            synchronized(carril){
                carril.notifyAll();
            }   
        }else {
            synchronized(carril){
                try {
                        carril.wait();
                }catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
                 if(posicionInicial==33){
                 arrancaCorredor2();
                  synchronized(carril){
                      carril.notifyAll();
                    }   
                 }else{
                   synchronized(carril){
                try {
                    carril.wait();
                }catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
                   if(posicionInicial==66){
                   arrancaCorredor3();
                   }
                 }
            }
        }
}
}
    /**
     * Metodo que incrementa la posicion del corredor uno
     */
    public void arrancaCorredor1(){
    int numPasos;
    do{
                carril.imprimirCiruito(getColor());
                numPasos = Correr();
                carril.setPosCorredor1(carril.getPosCorredor1()+numPasos); 
                if(carril.getPosCorredor1()> 33){
                     carril.setPosCorredor1(33);
                }
            }while(carril.getPosCorredor1()< 33);
    }
    /**
     * Metodo que incrementa la posicion del corredor uno
     */
     public void arrancaCorredor2(){
    int numPasos;
    do{
                carril.imprimirCiruito(getColor());
                numPasos = Correr();
                carril.setPosCorredor2(carril.getPosCorredor2()+numPasos); 
                if(carril.getPosCorredor2()> 66){
                     carril.setPosCorredor2(66);
                }
            }while(carril.getPosCorredor2()< 66);
    }
    /**
     * Metodo que incrementa la posicion del corredor uno
     */
     public void arrancaCorredor3(){
    int numPasos;
    do{
                carril.imprimirCiruito(getColor());
                numPasos = Correr();
                carril.setPosCorredor3(carril.getPosCorredor3()+numPasos); 
                if(carril.getPosCorredor3()> 100){
                     carril.setPosCorredor3(100);
                }
            }while(carril.getPosCorredor3()< 100);
    ganador();
    }
     /**
      * metodo que notifica cual fue el equipo ganador
      */
     public void ganador(){
         
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

