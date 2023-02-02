
import java.net.ServerSocket;

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
public class MainServer {
     /**
     * Metodo statico per l'avvio della classe.
     * @param args argomenti da linea di comando
     */
    public static void main(String[] args) {
        Server s = new Server(2000);
        if (s != null) {
            ServerSocket connection = s.connection;
            s.attendi();
            s.leggi();
                // s.chiudi();
            }
    }
}
