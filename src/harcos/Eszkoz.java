package harcos;

import java.io.Serializable;
import java.text.Collator;
import java.util.Objects;

public class Eszkoz implements Comparable<Eszkoz>, Serializable{
    private String nev;
    private double suly;

    public Eszkoz(String nev, double suly) {
        this.nev = nev;
        this.suly = suly;
    }
    
    @Override
    public int compareTo(Eszkoz e) {
        Collator col = Collator.getInstance();
        return col.compare(this.nev, e.nev);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nev);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Eszkoz other = (Eszkoz) obj;
        if (!Objects.equals(this.nev, other.nev)) {
            return false;
        }
        return true;
    }    

    @Override
    public String toString() {
        return  "\n\tnev=" + nev + ", suly=" + suly ;
    }
}
