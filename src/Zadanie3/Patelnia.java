package Zadanie3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Patelnia implements Runnable{
    public BlockingQueue<Nalesnik> usmazone = new LinkedBlockingQueue<>();
    private int liczba;

    public final static int SUROWY = 0;
    public final static int USMAZONY = 1;
    public final static int POSMAROWANY = 2;
    public final static int ZWINIETY = 3;

    public Patelnia(int liczba){
        this.liczba = liczba;
    }
    @Override
    public void run() {
        for(int i=0; i<liczba; ++i){
            Nalesnik nalesnik = new Nalesnik(i);
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(100));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            nalesnik.stan = USMAZONY;
            usmazone.add(nalesnik);
            System.out.println("Usmażone = " + usmazone);
        }
    }
}
