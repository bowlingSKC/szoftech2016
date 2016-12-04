package main.modell;

import java.io.Serializable;

public class Tetel implements Serializable {

    private String megnevezes;
    private String leiras;
    private int ar;
    private Alkatresz alkatresz;
    private int darabalkatresz; //csak hogy tudjuk menyni alkatrészt tüntetünk fel

    @Override
    public String toString() {
        return megnevezes + "(oka: " + leiras + ") " + ar + " Ft";
    }

    public int getDarabalkatresz() {
        return darabalkatresz;
    }

    public void setDarabalkatresz(int darabalkatresz) {
        this.darabalkatresz = darabalkatresz;
    }

    
    
    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public Alkatresz getAlkatresz() {
        return alkatresz;
    }

    public void setAlkatresz(Alkatresz alkatresz) {
        this.alkatresz = alkatresz;
    }
}
