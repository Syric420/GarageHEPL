/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date;

import Gui.InterfaceApplication;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vince
 */
public class ThreadDate extends Thread {
    private InterfaceApplication IA;
    private int FormatDate;
    private Locale Pays;
    private int FormatTemps;

    public ThreadDate(String p, String fd, String ft) {
        setPays(p);
        setFormatDate(fd);
        setFormatTemps(ft);
    }

    @Override
    public String toString() {
        String StringDate;
        StringDate = DateFormat.getDateTimeInstance(FormatDate, FormatTemps, Pays).format(new Date());
        return StringDate;
    }
    
    
    
    @Override
    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(1000);
                getIA().afficheDate(this.toString());
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    /**
     * @return the Pays
     */
    public Locale getPays() {
        return Pays;
    }

    /**
     * @return the FormatDate
     */
    public int getFormatDate() {
        return FormatDate;
    }

    /**
     * @return the FormatTemps
     */
    public int getFormatTemps() {
        return FormatTemps;
    }

    /**
     * @return the IA
     */
    public InterfaceApplication getIA() {
        return IA;
    }

    /**
     * @param IA the IA to set
     */
    public void setIA(InterfaceApplication IA) {
        this.IA = IA;
    }

    /**
     * @param fd
     */
    public void setFormatDate(String fd) {
        //En fonction du format date
        switch(fd)
        {
            case "Full":
                FormatDate = DateFormat.FULL;
                break;
            case "Long":
                FormatDate = DateFormat.LONG;
                break;
            case "Medium":
                FormatDate = DateFormat.MEDIUM;
                break;
            case "Short":
                FormatDate = DateFormat.SHORT;
                break;
        }
    }

    /**
     * @param p
     */
    public void setPays(String p) {
        //En fonction du pays
        switch(p)
        {
            case "France":
                Pays = Locale.FRANCE;
                break;
            case "Royaume Uni":
                Pays = Locale.UK;
                break;
            case "Allemagne":
                Pays = Locale.GERMANY;
                break;
            case "Italie":
                Pays = Locale.ITALY;
                break;
            case "U.S.A.":
                Pays = Locale.US;
                break;
        }
    }

    /**
     * @param ft
     */
    public void setFormatTemps(String ft) {
        //En fonction du format temps
        switch(ft)
        {
            case "Full":
                FormatTemps = DateFormat.FULL;
                break;
            case "Long":
                FormatTemps = DateFormat.LONG;
                break;
            case "Medium":
                FormatTemps = DateFormat.MEDIUM;
                break;
            case "Short":
                FormatTemps = DateFormat.SHORT;
                break;
        }
    }

}
