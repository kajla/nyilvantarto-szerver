/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nyilvantarto;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nyilvantarto.modell.Adatbaziskezeles;

/**
 *
 * @author Ádám
 */
public class NyilvantartoSzerver extends UnicastRemoteObject implements NyilvantartoService {

    private static Adatbaziskezeles adatbazis;
    private static Szallito sz;

    public NyilvantartoSzerver() throws RemoteException {
    }

    public static void main(String[] args) {
        adatbazis = new Adatbaziskezeles();
        sz = new Szallito();
        adatbazis.adatbazisInicializalas();
        adatbazis.aruOlvasas(sz);
        adatbazis.felhasznaloOlvasas(sz);
        try {
            LocateRegistry.createRegistry(1099);
            Naming.bind("NYILVANTARTO", new NyilvantartoSzerver());
            System.out.println("Fut a szerver...");
        } catch (RemoteException ex) {
            Logger.getLogger(NyilvantartoSzerver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(NyilvantartoSzerver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NyilvantartoSzerver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public synchronized boolean aruHozzaad(aru aru) throws RemoteException {
        return adatbazis.aruHozzaad(aru);
    }

    @Override
    public synchronized int aruEllenoriz(aru aru) throws RemoteException {
        return adatbazis.aruEllenoriz(aru);
    }

    @Override
    public synchronized boolean aruTorol(aru aru) throws RemoteException {
        return adatbazis.aruTorol(aru);
    }

    @Override
    public synchronized boolean aruModosit(aru aru) throws RemoteException {
        return adatbazis.aruModosit(aru);
    }

    @Override
    public synchronized boolean naploHozzaad(Naplo naplo) throws RemoteException {
        return adatbazis.naploHozzaad(naplo);
    }

    @Override
    public synchronized void naploTisztitas() throws RemoteException {
        adatbazis.naploTisztitas();
    }

    @Override
    public synchronized boolean felhasznaloHozzaad(Felhasznalo f) throws RemoteException {
        return adatbazis.felhasznaloHozzaad(f);
    }

    @Override
    public synchronized boolean felhasznaloTorol(Felhasznalo f) throws RemoteException {
        return adatbazis.felhasznaloTorol(f);
    }

    @Override
    public synchronized boolean felhasznaloModosit(Felhasznalo f) throws RemoteException {
        return adatbazis.felhasznaloModosit(f);
    }

    @Override
    public synchronized int felhasznaloEllenoriz(Felhasznalo f) throws RemoteException {
        return adatbazis.felhasznaloEllenoriz(f);
    }

    @Override
    public synchronized ArrayList<aru> aruLista() throws RemoteException {
        adatbazis.aruOlvasas(sz);
        return sz.getAruk();
    }

    @Override
    public synchronized int aruMaxID() throws RemoteException {
        return sz.getMaxID();
    }

    @Override
    public synchronized boolean aruImport(ArrayList<aru> al) throws RemoteException {
        sz.setAruk(al);
        boolean allapot = adatbazis.aruImport(sz);
        adatbazis.aruOlvasas(sz);
        return allapot;
    }

    @Override
    public synchronized ArrayList<Naplo> naploOlvasas() throws RemoteException {
        return adatbazis.naploOlvasas();
    }

    @Override
    public synchronized ArrayList<Felhasznalo> felhasznaloLista() throws RemoteException {
        adatbazis.felhasznaloOlvasas(sz);
        return sz.getFelhasznalok();
    }

    @Override
    public synchronized Felhasznalo aktFelhasznalo() throws RemoteException {
        return sz.getAktFelhasznalo();
    }

}
