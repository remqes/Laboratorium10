package Zadanie2;

import java.util.concurrent.ThreadLocalRandom;

public class Producent implements Runnable{
    Pojemnik pojemnik;

    public Producent(Pojemnik pojemnik){
        this.pojemnik = pojemnik;
    }
    @Override
    public void run() {
        for(int i=0; i<2; ++i){
            int nowaLiczba = ThreadLocalRandom.current().nextInt(100);
            System.out.println("Nowy numer "+ nowaLiczba + " został przypisany");
            pojemnik.zapisywanie(nowaLiczba);
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(100));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Producent kończy pracę.");
            pojemnik.zapisywanie(0);
        }
    }
}
