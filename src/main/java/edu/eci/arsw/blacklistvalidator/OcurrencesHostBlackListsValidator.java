package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class OcurrencesHostBlackListsValidator extends Thread{
    private HostBlacklistsDataSourceFacade skds;
    private String ipaddress;
    private int a, b;

    private static AtomicInteger checkedListsCount = new AtomicInteger(0);
    private static AtomicInteger ocurrencesCount = new AtomicInteger(0);
    private static List<Integer> blackListOcurrences = Collections.synchronizedList(new LinkedList<Integer>());

    public OcurrencesHostBlackListsValidator(int a, int b, String ipaddress, HostBlacklistsDataSourceFacade skds) {
        this.skds = skds;
        this.ipaddress = ipaddress;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run(){
        for (int i = a; i < b; i++){
            if (ocurrencesCount.get() < HostBlackListsValidator.BLACK_LIST_ALARM_COUNT){
                if (skds.isInBlackListServer(i, ipaddress)) addOcurrence(i);
            } else break;
            increaseCheckedListCount();
        }
    }

    static public int getCheckedListsCount() {
        return checkedListsCount.get();
    }

    static public int getOcurrencesCount() {
        return ocurrencesCount.get();
    }

    static public List<Integer> getBlackListOcurrences() {
        return new LinkedList<Integer>(blackListOcurrences);
    }

    synchronized void increaseCheckedListCount(){
        checkedListsCount.incrementAndGet();
    }

    synchronized void addOcurrence(int ocurrence){
        blackListOcurrences.add(ocurrence);
        ocurrencesCount.incrementAndGet();
    }

}
