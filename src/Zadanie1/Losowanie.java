package Zadanie1;

import java.util.Random;

public class Losowanie implements Runnable {
    private final int numer;
    private final int liczbaobrotow;
    static Random rand = new Random();

    public Losowanie(int numer, int liczbaobrotow) {
        this.numer = numer;
        this.liczbaobrotow = liczbaobrotow;
    }

    @Override
    public void run() {
        rand.setSeed(0);
        System.out.println("Fadennummer "+ numer + " hat begonnen zu arbeiten.");
        for(int i=0; i<liczbaobrotow; ++i){
            System.out.println("Fadennummer "+ numer + " zieht Nummer "+ rand.nextInt(101) + ".");
        }
    }
}
