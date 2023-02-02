/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MC
 * @version dic 2022
 */
public class MainClient {
    
    /**
     * Metodo statico per l'avvio della classe.
     * @param args argomenti da linea di comando
     */
    public static void main(String[] args) {
        Client c1 = new Client("MC", "\u001b[34;1m");
        c1.connetti("localhost", 2000);
        c1.scrivi();
        c1.chiudi();
    }
    
}
