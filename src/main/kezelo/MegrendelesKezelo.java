package main.kezelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.SzervizMain;
import main.modell.Megrendeles;
import main.modell.Tetel;

public class MegrendelesKezelo extends Kezelo {

    Raktar raktar;

    public MegrendelesKezelo(Raktar raktar) {
        this.raktar = raktar;
    }

    @Override
    public void hozzaad() {
        raktar.listaz();
        System.out.println("=========Megrendeles felvetele=========");
        int hossz = egyedek.size();

        hossz++; //megrendelesazonosito

        //vadiúj alkatrész esetén előbb a raktárosnak kell majd "bevételezni".
        int partaz;

        int koltseg = 0;
        ArrayList<Tetel> tetelek = new ArrayList<>();
        try {
            boolean akaremeg = true;
            while (akaremeg) {
                Tetel egytetel;
                egytetel = new Tetel();

                System.out.println("Tetel megnevezese:");
                egytetel.setMegnevezes(SzervizMain.bekerSzoveg());
                System.out.println("Kerem adja meg az alkatresz cikszamat: ");
                egytetel.setAlkatresz(raktar.getAlkatresz(SzervizMain.bekerSzam())); //cikkszám
                System.out.println("Adja meg az alkatresz darabszamat: ");
                egytetel.setDarabalkatresz(SzervizMain.bekerSzam());
                System.out.println("Tetel leirasa:");
                egytetel.setLeiras(SzervizMain.bekerSzoveg());
                tetelek.add(egytetel);
                System.out.println("Partnerazonosito: ");
                partaz = SzervizMain.bekerSzam();
                for (int i = 0; i < tetelek.size(); i++) {
                    koltseg = (egytetel.getDarabalkatresz()) * (egytetel.getAlkatresz().getBeszerzesiar());
                }
                Megrendeles uj = new Megrendeles(hossz, partaz, koltseg, tetelek);
                egyedek.add(uj);
                System.out.println("Szeretne-e meg tetelt hozzaadni? (i/n)");
                String igen = SzervizMain.bekerSzoveg();
                if (igen.equalsIgnoreCase("i")) {
                } else {
                    akaremeg = false;
                }
            }

        } catch (IOException e) {
            System.out.println(SzervizMain.HIBAUZENET);
        }

    }

    @Override
    public void torol() {
        listaz();
        System.out.println("Adja meg a torendo megrendeles szamat:");
        try {
            int torol = SzervizMain.bekerSzam();
            egyedek.remove(torol);
            System.out.println("Torles megtortent");
            System.out.println();
        } catch (IOException ex) {
            System.out.println(SzervizMain.HIBAUZENET);
        }
    }

    @Override
    public void listaz() {

        System.out.println("Folyamatban levo megrendelesek:");
        Megrendeles a = null;
       
        for (int i = 0; i < egyedek.size(); i++) {
            a = (Megrendeles) egyedek.get(i);
            }
        a.kiirMegrendeles();

    }

    @Override
    public List kereses() {
        return null;
    }

}
