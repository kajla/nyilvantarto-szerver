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

    private Adatbaziskezeles adatbazis;

    public NyilvantartoSzerver() throws RemoteException {
    }

    public static void main(String[] args) {
        Adatbaziskezeles adatbazis = new Adatbaziskezeles();
        adatbazis.adatbazisInicializalas();
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
    public void aruOlvasas(Nyilvantarto n) throws RemoteException {
        adatbazis.aruOlvasas(n);
    }

    @Override
    public boolean aruHozzaad(aru aru) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int aruEllenoriz(aru aru) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean aruTorol(aru aru) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean aruModosit(aru aru) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean aruImport(Nyilvantarto n) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean naploHozzaad(Naplo naplo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Naplo> naploOlvasas(Nyilvantarto n) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void naploTisztitas() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void felhasznaloOlvasas(Nyilvantarto n) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean felhasznaloHozzaad(Felhasznalo f) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean felhasznaloTorol(Felhasznalo f) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean felhasznaloModosit(Felhasznalo f) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int felhasznaloEllenoriz(Felhasznalo f) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
