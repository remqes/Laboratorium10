package Zadanie3;

public class main {
    public static void main(String[] args) {
        Patelnia patelnia = new Patelnia(10);
        Smarowanie smarowanie = new Smarowanie(10, patelnia.usmazone);
        Zawijanie zwijanie = new Zawijanie(10, smarowanie.posmarowane);

        Thread watekSmazenie = new Thread(patelnia);
        Thread watekSmarowanie = new Thread(smarowanie);
        Thread watekZawijanie = new Thread(zwijanie);

        watekSmazenie.start();
        watekSmarowanie.start();
        watekZawijanie.start();

        try{
            watekSmazenie.join();
            watekSmarowanie.join();
            watekZawijanie.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Gotowe naleśniki: " + zwijanie.zwiniete);
    }
}
