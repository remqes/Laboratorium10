package Zadanie2;

import java.util.concurrent.ThreadLocalRandom;

public class Konsument implements Runnable {
    Pojemnik pojemnik;

    public Konsument(Pojemnik pojemnik){
        this.pojemnik = pojemnik;
    }

    @Override
    public void run() {
        int liczba = pojemnik.pobieranie();
        while(liczba != 0){
            System.out.println("Otrzymano liczbę " + liczba + ".");
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(100)+1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            liczba = pojemnik.pobieranie();
        }
        System.out.println("Konsument kończy pracę.");
    }
}
