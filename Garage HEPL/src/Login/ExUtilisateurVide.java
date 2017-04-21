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
public class ExUtilisateurVide extends Exception {

    /**
     * Creates a new instance of <code>ExUtilisateurVide</code> without detail
     * message.
     */
    public ExUtilisateurVide() {
    }

    /**
     * Constructs an instance of <code>ExUtilisateurVide</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExUtilisateurVide(String msg) {
        super(msg);
    }
}
