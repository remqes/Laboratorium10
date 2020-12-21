package Zadanie3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Smarowanie implements Runnable{
    public BlockingQueue<Nalesnik> posmarowane = new LinkedBlockingQueue<>();
    public BlockingQueue<Nalesnik> usmazone;
    private int liczba;

    public final static int SUROWY = 0;
    public final static int USMAZONY = 1;
    public final static int POSMAROWANY = 2;
    public final static int ZWINIETY = 3;

    public Smarowanie(int Liczba, BlockingQueue usmazone){
        this.liczba = liczba;
        this.usmazone = usmazone;
    }

    @Override
    public void run() {
        Nalesnik nalesnik = null;
        for(int i=0; i<liczba; ++i){
            try{
                nalesnik = usmazone.take();
                Thread.sleep(ThreadLocalRandom.current().nextInt(100));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            nalesnik.stan = POSMAROWANY;
            posmarowane.add(nalesnik);
            System.out.println("Posmarowane = " + posmarowane);
        }
    }
}
