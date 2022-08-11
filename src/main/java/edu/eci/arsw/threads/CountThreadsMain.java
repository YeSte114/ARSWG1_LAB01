/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

import java.util.ArrayList;

/**
 * Implementación para el manejo de los hilos de CountThread
 * @author hcadavid
 * @author Yeison Barreto
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        ArrayList<CountThread> threads = new ArrayList<>();
        threads.add(new CountThread(0,99));
        threads.add(new CountThread(99,199));
        threads.add(new CountThread(200, 299));
        for (CountThread thread : threads) thread.run();
    }
    
}
