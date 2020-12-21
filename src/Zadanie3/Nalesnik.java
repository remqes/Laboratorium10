package Zadanie3;

public class Nalesnik {
    public final static int SUROWY = 0;
    public final static int USMAZONY = 1;
    public final static int POSMAROWANY = 2;
    public final static int ZWINIETY = 3;

    public int stan = SUROWY;
    public int numer;

    public Nalesnik(int numer){
        this.numer = numer;
    }

    @Override
    public String toString() {
        String stanString = "surowy";
        switch(stan){
            case USMAZONY:
                stanString = "usmażony";
                break;
            case POSMAROWANY:
                stanString = "posmarowany";
                break;
            case ZWINIETY:
                stanString = "zwiniety";
                break;
        }
        return "Naleśnik " + numer + " jest " + stanString + "{ " + stan + "}.";
    }
}
