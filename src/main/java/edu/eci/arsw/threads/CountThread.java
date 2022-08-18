/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 * Implementación asíncrona de un hilo
 * @author hcadavid
 * @author Yeison Barreto
 */
public class CountThread extends Thread{
    private int a, b;

    /**
     * Constructor del Thread
     * @param a Límite inferior del intervalo
     * @param b Límite superior del intervalo
     */
    public CountThread (int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run(){
        for (int i = a; i <= b; i++){
            System.out.println(i);
        }
    }
}
