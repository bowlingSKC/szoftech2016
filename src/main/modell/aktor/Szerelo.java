package main.modell.aktor;

import java.io.Serializable;

public class Szerelo extends Alkalmazott implements Serializable {

    public Szerelo() {
    }

    public Szerelo(String szemszam, String nev, String jelszo, String email, int oraber) {
        super(szemszam, nev, jelszo, email, oraber);
    }
}
