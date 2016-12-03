package main.kezelo;

import main.SzervizMain;
import main.modell.Munkalap;
import main.modell.Szamla;

import java.util.List;

public class SzamlaKezelo extends Kezelo<Szamla> {

    @Override
    public void hozzaad() {
        try {
            List<Munkalap> keszek = SzervizMain.getMunkalapKezelo().keszMunkalapok();
            for(int i = 0; i < keszek.size(); i++) {
                System.out.println((i+1) + ": " + keszek.get(i));
            }

            System.out.println("Melyik munkalapot szeretne szamlazni? ");
            Munkalap szamlazando = keszek.get( SzervizMain.bekerSzam() - 1 );

            Szamla szamla = new Szamla();
            szamla.setOsszeg( szamlazando.getMunkalapDij() );
            szamla.setUgyfelNev( "Teszt Elemer" );  // TODO átírni valahogy

            egyedek.add(szamla);
            System.out.println("Szamla kiallitva!");

            // TODO ügyféltől levonni az egyenleget
        } catch (Exception ex) {
            System.out.println(SzervizMain.HIBAUZENET);
        }
    }

    @Override
    public void torol() {
        System.out.println("Nem lehet szamlat torolni a rendszerbol!");
    }

    @Override
    public void listaz() {
        for(int i = 0; i < egyedek.size(); i++) {
            System.out.println((i+1) + ": " + egyedek.get(i));
        }
    }

    @Override
    public List<Szamla> kereses() {
        return null;
    }
}
