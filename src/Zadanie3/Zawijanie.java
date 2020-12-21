package Zadanie3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Zawijanie implements Runnable{
    public BlockingQueue<Nalesnik> zwiniete = new LinkedBlockingQueue<>();
    public BlockingQueue<Nalesnik> posmarowane;
    private int liczba;

    public final static int SUROWY = 0;
    public final static int USMAZONY = 1;
    public final static int POSMAROWANY = 2;
    public final static int ZWINIETY = 3;

    public Zawijanie(int liczba, BlockingQueue posmarowane){
        this.liczba = liczba;
        this.posmarowane = posmarowane;
    }

    @Override
    public void run() {
        Nalesnik nalesnik = null;
        for(int i=0; i<liczba; ++i){
            try{
                nalesnik = posmarowane.take();
                Thread.sleep(ThreadLocalRandom.current().nextInt(100));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            nalesnik.stan = ZWINIETY;
            zwiniete.add(nalesnik);
            System.out.println("Zwiniete = " + zwiniete);
        }
    }
}
