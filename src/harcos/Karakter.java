package harcos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Karakter implements Serializable{

    private String nev, faj;
    final ArrayList<Eszkoz> eszkozok;

    public Karakter(String nev, String faj) {
        this.nev = nev;
        this.faj = faj;
        eszkozok = new ArrayList<>();

        if (nev.length() < 3) {
            throw new ArithmeticException("A névnek minimum 3 betűnek kell lennie");
        }
    }

    public String getNev() {return nev;}
    public String getFaj() {return faj;}

    public abstract void eszkozFelvesz(Eszkoz e);
    public abstract void eszkozEldob(int index);
    public abstract void eszkozEldob(Eszkoz eszkoz);
    public abstract List<Eszkoz> eszkozRendez();

    @Override
    public abstract String toString();
    
    
    
}
