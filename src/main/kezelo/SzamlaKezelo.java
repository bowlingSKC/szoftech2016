package main.kezelo;

import main.SzervizMain;
import main.modell.Auto;
import main.modell.Munkalap;
import main.modell.Szamla;
import main.modell.aktor.Felhasznalo;
import main.modell.aktor.Ugyfel;

import java.util.List;

public class SzamlaKezelo extends Kezelo<Szamla> {

    @Override
    public void hozzaad() {
        try {
            List<Munkalap> keszek = SzervizMain.getMunkalapKezelo().keszMunkalapok(Munkalap.MunkalapAllapot.KESZ);
            for(int i = 0; i < keszek.size(); i++) {
                System.out.println((i+1) + ": " + keszek.get(i));
            }

            System.out.println("Melyik munkalapot szeretne szamlazni? ");
            Munkalap szamlazando = keszek.get( SzervizMain.bekerSzam() - 1 );
            Ugyfel ugyfel = null;

            for(Felhasznalo felhasznalo : SzervizMain.getFelhasznaloKezelo().getFelhasznalok()) {
                if( felhasznalo instanceof Ugyfel ) {
                    for(Auto auto : ((Ugyfel) felhasznalo).getAutok()) {
                        if( auto.getRendszam().equals(szamlazando.getAuto().getRendszam()) ) {
                            ugyfel = (Ugyfel) felhasznalo;
                            break;
                        }
                    }
                }
            }

            Szamla szamla = new Szamla();
            szamla.setOsszeg( szamlazando.getMunkalapDij() );
            szamla.setUgyfelNev( ugyfel.getNev() );

            egyedek.add(szamla);
            System.out.println("Szamla kiallitva!");

            ugyfel.setEgyenleg( ugyfel.getEgyenleg() - szamlazando.getMunkalapDij() );
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
