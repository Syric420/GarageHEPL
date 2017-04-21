/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author Vince
 */
public class ExUtilisateurInconnu extends Exception {

    /**
     * Creates a new instance of <code>ExUtilisateurInconnu</code> without
     * detail message.
     */
    public ExUtilisateurInconnu() {
    }

    /**
     * Constructs an instance of <code>ExUtilisateurInconnu</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExUtilisateurInconnu(String msg) {
        super(msg);
    }
}
