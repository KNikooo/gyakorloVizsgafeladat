package harcos;

import java.util.ArrayList;
import java.util.Collections;

public class HarcosProgram {

    public static void main(String[] args) {
        Harcos h1 = new Harcos(10, 6, "Coco", "elf");
        Harcos h2 = new Harcos(9, 7, "Lulu", "elf");
        Harcos h3 = new Harcos(8, 8, "Liem");
        //Harcos h4 = new Harcos(10, 6, "Co", "elf");
        h1.eszkozFelvesz(new Eszkoz("kard", 500));
        h1.eszkozFelvesz(new Eszkoz("kés", 100));
        h1.eszkozFelvesz(new Eszkoz("sál", 60));
        System.out.println(h1);
        h1.eszkozEldob(2);
        System.out.println(h1);

        h1.kiir();
        Harcos h5 = Harcos.beolvas("harcos.bin");
        System.out.println(h5);

        System.out.print("\nHarcos eszközei:");
        for (Eszkoz eszkoz : h5) {
            System.out.print(eszkoz);
        }
        System.out.println("");

        ArrayList<Harcos> harcosokLista = new ArrayList<>();
        harcosokLista.add(h1);
        harcosokLista.add(h2);
        harcosokLista.add(h3);

        Collections.sort(harcosokLista, Harcos.EroRendezo());
        for (Harcos harcos : harcosokLista) {
            System.out.println(harcos);
        }
        Collections.sort(harcosokLista, Harcos.UgyessegRendezo());
        for (Harcos harcos : harcosokLista) {
            System.out.println(harcos);
        }
    }
}
