/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date;

import java.text.*;
import java.util.*;

/**
 *
 * @author Vince
 */
public class ThreadDate extends Thread {
    private String Pays;
    private String FormatDate;
    private String FormatTemps;
    private String StringDate;

    public ThreadDate(String Pays, String FormatDate, String FormatTemps) {
        this.Pays = Pays;
        this.FormatDate = FormatDate;
        this.FormatTemps = FormatTemps;
    }

    
    public void createStringDate()
    {
        switch(FormatDate)
        {
            case "Full":
                break;
            case "Long":
                break;
            case "Medium":
                break;
            case "Short":
                break;
            
        }
        //DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, MIN_PRIORITY)
    }

    /**
     * @return the Pays
     */
    public String getPays() {
        return Pays;
    }

    /**
     * @param Pays the Pays to set
     */
    public void setPays(String Pays) {
        this.Pays = Pays;
    }

    /**
     * @return the FormatDate
     */
    public String getFormatDate() {
        return FormatDate;
    }

    /**
     * @param FormatDate the FormatDate to set
     */
    public void setFormatDate(String FormatDate) {
        this.FormatDate = FormatDate;
    }

    /**
     * @return the FormatTemps
     */
    public String getFormatTemps() {
        return FormatTemps;
    }

    /**
     * @param FormatTemps the FormatTemps to set
     */
    public void setFormatTemps(String FormatTemps) {
        this.FormatTemps = FormatTemps;
    }

    /**
     * @return the StringDate
     */
    public String getStringDate() {
        return StringDate;
    }

    @Override
    public String toString() {
        return StringDate;
    }
    
    

}
