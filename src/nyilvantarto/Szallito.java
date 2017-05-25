/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nyilvantarto;

import java.util.ArrayList;

/**
 *
 * @author Ádám
 */
public class Szallito {

    private Felhasznalo aktFelhasznalo;
    private ArrayList<Felhasznalo> felhasznalok;
    private ArrayList<aru> aruk;
    private int maxID = 0;

    public Szallito() {
    }

    public Felhasznalo getAktFelhasznalo() {
        return aktFelhasznalo;
    }

    public void setaktFelhasznalo(Felhasznalo aktFelhasznalo) {
        this.aktFelhasznalo = aktFelhasznalo;
    }

    public ArrayList<Felhasznalo> getFelhasznalok() {
        return felhasznalok;
    }

    public void setFelhasznalok(ArrayList<Felhasznalo> felhasznalok) {
        this.felhasznalok = felhasznalok;
    }

    public ArrayList<aru> getAruk() {
        return aruk;
    }

    public void setAruk(ArrayList<aru> aruk) {
        this.aruk = aruk;
    }

    public int getMaxID() {
        return maxID;
    }

    public void setMaxID(int maxID) {
        this.maxID = maxID;
    }

}
