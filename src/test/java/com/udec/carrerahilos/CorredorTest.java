/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.carrerahilos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class CorredorTest {
    
    public CorredorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Correr method, of class Corredor.
     */
    @Test
    public void testCorrer() {
        System.out.println("Test Random");
        Corredor c = new Corredor();
        int result =c.Correr() ;
        switch (result) {
            case 1:
                System.out.println("Numero generado "+result);
                assertEquals(1, result);
                break;
            case 2:
                System.out.println("Numero generado "+result);
                assertEquals(2, result);
                break;
            case 3:
                System.out.println("Numero generado "+result);
                assertEquals(3, result);
                break;
            default:
                System.out.println("Numero generado "+result);
                fail("numero fuera del rango de 1 a 3");
                break;
        }
    }
    
}
