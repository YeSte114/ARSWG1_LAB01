/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]){

        Runtime vjm = Runtime.getRuntime();
        int numberCores = vjm.availableProcessors();

        System.out.println("\nNumber of Threads: "+numberCores);
        System.out.println("Performance: " + testByThreadsNumber("202.24.34.55", numberCores));
        System.out.println();

        numberCores *= 2;

        System.out.println("\nNumber of Threads: "+numberCores);
        System.out.println("Performance: " + testByThreadsNumber("202.24.34.55", numberCores));
        System.out.println();
    }

    public static String testByThreadsNumber(String ipaddress, int threadsNumber){

        HostBlackListsValidator hblv=new HostBlackListsValidator();

        long t1 = System.currentTimeMillis(), performance;
        List<Integer> blackListOcurrences = hblv.checkHost(ipaddress,threadsNumber);
        performance = System.currentTimeMillis() - t1;
        System.out.println("The host was found in the following blacklists:" + blackListOcurrences);

        return "" + performance + "ms";

    }
    
}
