/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.*;

/**
 *
 * @author Vince
 */
public class PrepareOrderBean implements SearchFoundListener {

    
    public PrepareOrderBean()
    {
        
    }
    @Override
    public void SearchFoundDetected(SearchFoundEvent e) {
        Calendar c = Calendar.getInstance();
        Random randomGenerator = new Random();
        int D=randomGenerator.nextInt(10);
        System.out.println("Date calendrier = " + c.getTime());
        
        c.add(Calendar.DAY_OF_MONTH, D);
        
    }
    
}
