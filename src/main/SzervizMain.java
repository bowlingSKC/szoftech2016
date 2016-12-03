package main;

import main.kezelo.FelhasznaloKezelo;
import main.kezelo.MunkalapKezelo;
import main.modell.aktor.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import main.kezelo.FoglalasKezelo;
import main.kezelo.Raktar;

public class SzervizMain {

    public static final String HIBAUZENET = "Hiba tortent az adatok bekerese kozben! Kerem probalja ujra!";

    private Felhasznalo bejelentkezett;     // bejelentkezett felhasználó

    private static List<Szerelo> szerelok = new ArrayList<>();
 
    
    // kezelok
    private static final MunkalapKezelo munkalapKezelo = new MunkalapKezelo();
    private static final FelhasznaloKezelo felhasznaloKezelo = new FelhasznaloKezelo();
    FoglalasKezelo foglalasKezelo = new FoglalasKezelo(bejelentkezett);
    private static final Raktar raktar = new Raktar();
    private void start() {
        udvozletKiir();

        felhasznaloKezelo.getFelhasznalok().add(new Recepcios("aaa", "a", "b", "a", 11));

        //tesztelésnek
       /* foglalasKezelo.hozzaad();
        foglalasKezelo.hozzaad();
        foglalasKezelo.hozzaad();
        foglalasKezelo.torol();
        foglalasKezelo.listaz();
        MegrendelesKezelo megrendeleskezelo = new MegrendelesKezelo(raktar);
        raktar.hozzaad();
        raktar.hozzaad();
        raktar.listaz();
        
        megrendeleskezelo.hozzaad();
        megrendeleskezelo.hozzaad();
        megrendeleskezelo.listaz();*/
        while(true) {
            try {
                menuKiir();

                System.out.print("A valasztott menu: ");
                String menu = bekerSzoveg();
                if("X".equals(menu.toUpperCase())) {
                    // TODO fajlba mentes
                    break;
                } else {
                    menuVegrehajt(menu);
                }
            } catch (Exception ex) {
                System.out.println( HIBAUZENET );
            }
        }

        elkoszonKiir();
    }

    private void udvozletKiir() {
        System.out.println("================== Udvozoljuk a szerviz szolgaltatasunkban ==================");
    }

    private void elkoszonKiir() {
        System.out.println("================== Viszontlatasra! ==================");
    }

    private void menuKiir() {
        if( bejelentkezett == null ) {      // senki sincs bejelentkezve
            MenuKiiro.vendegMenuKiir();
        } else if( bejelentkezett instanceof Ugyfel) {     // ügyfél van bejelentkezve
            MenuKiiro.ugyfelMenuKiir();
        } else if( bejelentkezett instanceof Tulajdonos ) { // tulajdonos van bejelentkezve
            MenuKiiro.tulajdonosMenuKiir();
        } else if( bejelentkezett instanceof Recepcios ) {  // recepcios van bejelentkezve
            MenuKiiro.recepciosMenuKiir();
        } else if( bejelentkezett instanceof Raktaros ) {   // raktaros van bejelentkezve
            MenuKiiro.raktarosMenuKiir();
        } else if( bejelentkezett instanceof Szerelo ) {    // szerelo van bejelentkezve
            MenuKiiro.szereloMenuKiir();
        } else {                                            // ennek sose szabadna lefutnia, ha igen akkor kivetel lesz
            throw new IllegalArgumentException("Valami hiba van a bejelentkezett felhasznalot illetoen!");
        }
    }

    private void menuVegrehajt(String menu) {
        if( bejelentkezett == null ) {      // senki sincs bejelentkezve
            vendegMenuVegrehajt(menu);
        } else if( bejelentkezett instanceof Ugyfel) {     // ügyfél van bejelentkezve
            ugyfelMenuVegrehajt(menu);
        } else if( bejelentkezett instanceof Tulajdonos ) { // tulajdonos van bejelentkezve

        } else if( bejelentkezett instanceof Recepcios ) {  // recepcios van bejelentkezve
            recepciosMenuVegrehajt(menu);
        } else if( bejelentkezett instanceof Raktaros ) {   // raktaros van bejelentkezve

        } else if( bejelentkezett instanceof Szerelo ) {    // szerelo van bejelentkezve

        } else {                                            // ennek sose szabadna lefutnia, ha igen akkor kivetel lesz
            throw new IllegalArgumentException("Valami hiba van a bejelentkezett felhasznalot illetoen!");
        }
    }

    private void recepciosMenuVegrehajt(String menu) {
        if("1".equals(menu)) {
            munkalapKezelo.hozzaad();
        } else if("2".equals(menu)) {
            munkalapKezelo.listaz();

            System.out.println("Melyik munkalapot szeretne megtekinteni? ");
            try {
                munkalapKezelo.kiir( bekerSzam() - 1 );
            } catch (Exception ex) {
                System.out.println(HIBAUZENET);
            }
        } else {
            System.out.println("Nincs ilyen menupont!");
        }
    }

    private void vendegMenuVegrehajt(String menu) {
        if( "1".equals(menu) ) {
            Felhasznalo bejelentkezett = felhasznaloKezelo.bejelentkezes();
            if( bejelentkezett == null ) {
                System.out.println("Hibas felhasznalonev/jelszo!");
            }
            this.bejelentkezett = bejelentkezett;
        } else if( "2".equals(menu) ) {
            felhasznaloKezelo.ugyfelHozzaad();
        } else {
            System.out.println("Nincs ilyen menupont!");
        }
    }
    
    private void ugyfelMenuVegrehajt(String menu) {
        if( "0".equals(menu) ) {
            Felhasznalo bejelentkezett = felhasznaloKezelo.bejelentkezes();
            if( bejelentkezett == null ) {
                System.out.println("Hibas felhasznalonev/jelszo!");
            }
            this.bejelentkezett = bejelentkezett;
        } else if( "2".equals(menu) ) {
            raktar.kereses();
        } else if("X".equals(menu.toUpperCase())){
              // TODO fajlba mentes
            
        } else {
            System.out.println("Nincs ilyen menupont!");
            
        }
    }

    public static String bekerSzoveg() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static Integer bekerSzam() throws IOException {
        return Integer.valueOf(bekerSzoveg());
    }

    public static MunkalapKezelo getMunkalapKezelo() {
        return munkalapKezelo;
    }

    public static FelhasznaloKezelo getFelhasznaloKezelo() {
        return felhasznaloKezelo;
    }

    public static List<Szerelo> getSzerelok() {
        return szerelok;
    }

    public static void main(String[] args) {
        new SzervizMain().start();
    }
    
    
    
}
