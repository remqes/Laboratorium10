package Zadanie1;

public class main {
    public static void main(String[] args) {
        final int obroty = 3;
        Thread faden1 = new Thread(new Losowanie(1, obroty));
        Thread faden2 = new Thread(new Losowanie(2, obroty));
        Thread faden3 = new Thread(new Losowanie(3, obroty));
        Thread faden4 = new Thread(new Losowanie(4, obroty));

        faden1.start();
        faden2.start();
        faden3.start();
        faden4.start();

        try{
            faden1.join();
            faden2.join();
            faden3.join();
            faden4.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
