package harcos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class EroComparator implements Comparator<Harcos>, Serializable {

    @Override
    public int compare(Harcos egyik, Harcos masik) {
        return egyik.getEro() - masik.getEro();
    }
}

class UgyessegComparator implements Comparator<Harcos> {

    @Override
    public int compare(Harcos egyik, Harcos masik) {
        return egyik.getUgyesseg() - masik.getUgyesseg();
    }
}

public class Harcos extends Karakter implements Iterable<Eszkoz> {

    private int ero, ugyesseg;

    public static EroComparator EroRendezo() {
        return new EroComparator();
    }

    public static UgyessegComparator UgyessegRendezo() {
        return new UgyessegComparator();
    }

    public Harcos(int ero, int ugyesseg, String nev, String faj) {
        super(nev, faj);
        this.ero = ero;
        this.ugyesseg = ugyesseg;
    }

    public Harcos(int ero, int ugyesseg, String nev) {
        this(ero, ugyesseg, nev, "ember");
    }

    public int getEro() {
        return ero;
    }

    public int getUgyesseg() {
        return ugyesseg;
    }

    @Override
    public void eszkozFelvesz(Eszkoz e) {
        eszkozok.add(e);
    }

    @Override
    public void eszkozEldob(int index) {
        eszkozok.remove(index);
    }

    @Override
    public void eszkozEldob(Eszkoz eszkoz) {
        eszkozEldob(eszkozok.indexOf(eszkoz));
    }

    @Override
    public List<Eszkoz> eszkozRendez() {
        Collections.sort(eszkozok);
        return Collections.unmodifiableList(eszkozok);
    }

    @Override
    public Iterator<Eszkoz> iterator() {
        return eszkozok.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Harcos{" + "\nnev=" + this.getNev() + "\nfaj=" + this.getFaj());
        sb.append("\nerő=" + ero + "\nügyesség=" + ugyesseg + "\neszkozok=");
        sb.append(eszkozRendez() + "\n}");
        return sb.toString();
    }

    public void kiir() {
        try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("harcos.bin"))) {
            objKi.writeObject(this);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Harcos beolvas(String fajlNev) {
        Harcos harcos = new Harcos(1, 1, "harcos");
        try (ObjectInputStream objBe = new ObjectInputStream(new FileInputStream(fajlNev))) {
            harcos = (Harcos) objBe.readObject();
            return harcos;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return harcos;
    }
}
