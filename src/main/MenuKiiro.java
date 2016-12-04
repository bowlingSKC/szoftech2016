package main;

public class MenuKiiro {

    // X menu legyen mindig a kilepes!

    public static void vendegMenuKiir() {
        System.out.println("X. Kilepes");
        System.out.println("1. Bejelentkezes");
        System.out.println("2. Regisztracio");
    }

    public static void ugyfelMenuKiir() {
        System.out.println("X. Kilepes");
        System.out.println("0. Kijelentkezes");
        System.out.println("2. ...");
        System.out.println("3. Foglalas hozzaadasa");
        System.out.println("4. Foglalas Modositasa");
        System.out.println("9. Kijelentkezes");
    }

    public static void tulajdonosMenuKiir() {
        System.out.println("X. Kilepes");
        System.out.println("0. Kijelentkezes");
        System.out.println("1. Megrenedeles keszitese");
    }

    public static void recepciosMenuKiir() {
        System.out.println("X. Kilepes");
        System.out.println("0. Kijelentkezes");
        System.out.println("1. Uj munkalap felvetele");
        System.out.println("2. Munkalapok megtekintese");
        System.out.println("3. Megrendeles felvetele");
        System.out.println("4. Szamla kiallitasa");
        System.out.println("5. Foglalasok listazasa");
        System.out.println("6. Szamlak listazasa");
    }

    public static void raktarosMenuKiir() {
        System.out.println("X. Kilepes");
        System.out.println("0. Kijelentkezes");
        System.out.println("1. Alkatreszek listazasa");
        System.out.println("2. Kereses");
        System.out.println("3. Alkatresz hozzaadasa");
        System.out.println("4. Alkatresz torlese");
        System.out.println("5. Megrenedeles keszitese");
        

    }

    public static void szereloMenuKiir() {
        System.out.println("X. Kilepes");
        System.out.println("0. Kijelentkezes");
        System.out.println("2. Munkalapok megtekintese");
        System.out.println("3. Munkalap szerkesztese");

        System.out.println("9. Kijelentkezes");
    }
    
    public static void keresesMenuKiir() {
        System.out.println("X. Kilepes");
        System.out.println("1. Cikkszam alapjan");
        System.out.println("2. Nev alapjan");
    }
}
