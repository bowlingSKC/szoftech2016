package main.modell;

import main.modell.aktor.Szerelo;

import java.util.ArrayList;
import java.util.List;

public class Munkalap {

    public static enum MunkalapAllapot {
        UJ("Új"), FOLYAMATBAN("Folyamatban"), KESZ("Kesz");

        private String name;

        MunkalapAllapot(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private int azonosito;
    private String hibaleiras;
    private MunkalapAllapot allapot = MunkalapAllapot.UJ;
    private int ido;                    // megkezdett órák száma
    private List<Tetel> tetelek = new ArrayList<>();
    private Auto auto;
    private Szerelo szerelo;

    public int getMunkalapDij() {
        int osszesen = szerelo.getOraber() * ido;
        for(Tetel tetel : tetelek) {
            osszesen += tetel.getAr();
        }
        return osszesen;
    }

    @Override
    public String toString() {
        String content = azonosito + " munkalap:\n";
        content += "Hiba: " + hibaleiras + "\n";
        content += "Allapot: " + allapot.getName() + "\n";
        content += "Felhasznalt orak szama: " + ido;
        content += "Ugyfel, auto: " + auto.getRendszam() + "\n";
        content += "Szerelo: " + szerelo.getNev() + "\n";
        content += "Szerelesi tetelek:\n";
        for(Tetel tetel : tetelek) {
            content += "\t" + tetel + "\n";
        }
        return content;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(int azonosito) {
        this.azonosito = azonosito;
    }

    public String getHibaleiras() {
        return hibaleiras;
    }

    public void setHibaleiras(String hibaleiras) {
        this.hibaleiras = hibaleiras;
    }

    public MunkalapAllapot getAllapot() {
        return allapot;
    }

    public void setAllapot(MunkalapAllapot allapot) {
        this.allapot = allapot;
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }

    public List<Tetel> getTetelek() {
        return tetelek;
    }

    public void setTetelek(List<Tetel> tetelek) {
        this.tetelek = tetelek;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Szerelo getSzerelo() {
        return szerelo;
    }

    public void setSzerelo(Szerelo szerelo) {
        this.szerelo = szerelo;
    }
}
