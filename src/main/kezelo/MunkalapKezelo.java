package main.kezelo;

import main.SzervizMain;
import main.modell.Munkalap;
import main.modell.Tetel;
import main.modell.aktor.Szerelo;
import main.modell.aktor.Ugyfel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MunkalapKezelo extends Kezelo<Munkalap> {

    @Override
    public void hozzaad() {
        try {
            Munkalap munkalap = new Munkalap();

            System.out.println("Munkalap azonositoja: ");
            munkalap.setAzonosito(SzervizMain.bekerSzam() );

            System.out.println("Hiba leirasa: ");
            munkalap.setHibaleiras( SzervizMain.bekerSzoveg() );

            System.out.println("Uj ugyfel (i/n)? ");
            String ujUgyfel = SzervizMain.bekerSzoveg();
            if(ujUgyfel.toLowerCase().equals("i")) {
                SzervizMain.getFelhasznaloKezelo().ugyfelHozzaad();
                SzervizMain.getFelhasznaloKezelo().autoHozzaad(
                        SzervizMain.getFelhasznaloKezelo().getUgyfelek().get( SzervizMain.getFelhasznaloKezelo().getUgyfelek().size() - 1 )
                );
            }

            for(int i = 0; i < SzervizMain.getFelhasznaloKezelo().getUgyfelek().size(); i++) {
                System.out.println((i+1) + ": " + SzervizMain.getFelhasznaloKezelo().getUgyfelek().get(i));
            }
            System.out.println("Ugyfel sorszama: ");
            Ugyfel ugyfel = SzervizMain.getFelhasznaloKezelo().getUgyfelek().get(SzervizMain.bekerSzam()-1);
            for(int i = 0; i < ugyfel.getAutok().size(); i++) {
                System.out.println((i+1) + ": " + ugyfel.getAutok().get(i));
            }
            System.out.printf("Auto sorszama: ");
            munkalap.setAuto( ugyfel.getAutok().get( SzervizMain.bekerSzam() - 1 ) );

            for(int i = 0; i < SzervizMain.getFelhasznaloKezelo().getSzerelok().size(); i++) {
                System.out.println( (i+1) + ": " + SzervizMain.getFelhasznaloKezelo().getSzerelok().get(i) );
            }
            System.out.println("Szerelo sorszama: ");
            munkalap.setSzerelo( SzervizMain.getFelhasznaloKezelo().getSzerelok().get( SzervizMain.bekerSzam() - 1 ) );

            System.out.println("Sikeresen felvette a munkalapot!");
            egyedek.add(munkalap);
        } catch (Exception ex) {
            System.out.println("A munkalap felvetele soran hiba keletkezett.");
        }
    }

    public List<Munkalap> keszMunkalapok(Munkalap.MunkalapAllapot allapot) {
        return egyedek
                .stream()
                .filter(item -> item.getAllapot().equals(allapot))
                .collect(Collectors.toList());
    }

    public void szerkeszt() {
        try {
            List<Munkalap> szerkesztheto = egyedek;

            for(int i = 0; i < szerkesztheto.size(); i++) {
                System.out.println((i+1) + ": " + szerkesztheto.get(i).getHibaleiras());
            }

            int szam = SzervizMain.bekerSzam();
            Munkalap munkalap = egyedek.get(szam - 1);

            System.out.println("Allapot modositasa (i/n)? ");
            String modAllpot = SzervizMain.bekerSzoveg();
            if( modAllpot.toLowerCase().equals("i") ) {
                System.out.println("Allapot [1] Folyamatban [2] Kesz");
                String ujAllapot = SzervizMain.bekerSzoveg();
                if( ujAllapot.equals("1") ) {
                    munkalap.setAllapot(Munkalap.MunkalapAllapot.FOLYAMATBAN);
                } else if( ujAllapot.equals("2") ) {
                    munkalap.setAllapot(Munkalap.MunkalapAllapot.KESZ);
                }
            }

            System.out.println("Ido modositasa (i/n)?");
            String modIdo = SzervizMain.bekerSzoveg();
            if(modIdo.toLowerCase().equals("i")) {
                int ujIdo = SzervizMain.bekerSzam();
                munkalap.setIdo( ujIdo );
            }

            String modTetel;
            do {
                System.out.println("Uj tetel hozzaadasa (i/n)?");
                modTetel = SzervizMain.bekerSzoveg();
                if( modTetel.toLowerCase().equals("i") ) {
                    Tetel tetel = new Tetel();
                    System.out.println("Megnevezes: ");
                    tetel.setMegnevezes( SzervizMain.bekerSzoveg() );
                    System.out.println("Leiras: ");
                    tetel.setLeiras( SzervizMain.bekerSzoveg() );
                    System.out.println("Ar: ");
                    tetel.setAr( SzervizMain.bekerSzam() );

                    munkalap.getTetelek().add(tetel);
                }
            } while(modTetel.toLowerCase().equals("i"));


        } catch (Exception ex) {
            System.out.println( SzervizMain.HIBAUZENET );
        }
    }

    public void kiir(int index) {
        System.out.println(egyedek.get(index));
    }

    @Override
    public void torol() {

    }

    @Override
    public void listaz() {
        for(int i = 0; i < egyedek.size(); i++) {
            System.out.println((i+1) + ": " + egyedek.get(i).getHibaleiras());
        }
    }

    @Override
    public List<Munkalap> kereses() {
        return null;
    }

    public void setEgyedek(ArrayList<Munkalap> munkalaps) {
        this.egyedek = munkalaps;
    }

    public List<Munkalap> getMunkalapok() {
        return egyedek;
    }
}
