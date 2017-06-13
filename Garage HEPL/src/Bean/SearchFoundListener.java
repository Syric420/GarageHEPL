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
interface SearchFoundListener extends EventListener {
    public void SearchFoundDetected (SearchFoundEvent e);
}
