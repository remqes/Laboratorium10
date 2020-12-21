package Zadanie2;

public class Pojemnik {
    private int wartosc;
    boolean pelny = false;

    synchronized void zapisywanie(int nowaWartosc){
        try{
            while(pelny) wait(); //kiedy jest pelny, czekanko az sie zwolni
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        pelny = true;
        wartosc = nowaWartosc; //jak sie zwolni to mozna jak najbardziej jeszcze jak dopisac
        notifyAll();
    }

    synchronized int pobieranie(){
        try{
            while(!pelny) wait(); //kiedy jest pusty, czekanko az sie zapelni
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        pelny = false;
        int wartoscLokalna = wartosc;
        notifyAll();
        return wartoscLokalna;
    }
}
