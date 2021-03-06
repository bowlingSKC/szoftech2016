package main.modell.aktor;

import java.io.Serializable;

public class Alkalmazott extends Felhasznalo implements Serializable {

    protected int oraber;

    public Alkalmazott() {

    }

    public Alkalmazott(String szemszam, String nev, String jelszo, String email, int oraber) {
        super(szemszam, nev, jelszo, email);
        this.oraber = oraber;
    }

    public int getOraber() {
        return oraber;
    }

    public void setOraber(int oraber) {
        this.oraber = oraber;
    }

    @Override
    public String toString() {
        return nev + "(" + szemszam + "): " + email + " (" +getClass().getName() + ")";
    }
}
