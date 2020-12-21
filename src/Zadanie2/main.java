package Zadanie2;

import java.util.concurrent.ThreadLocalRandom;

public class main {
    public static void main(String[] args) {
        Pojemnik pojemnik = new Pojemnik();

        Thread watekProcucent = new Thread(new Producent(pojemnik));
        Thread watekKonsument = new Thread(new Konsument(pojemnik));

        watekProcucent.start();
        watekKonsument.start();

        try{
            watekProcucent.join();
            watekKonsument.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
