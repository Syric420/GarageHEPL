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
interface InStockListener extends EventListener {
    public void InStockEventDetected (InStockEvent e);
}
