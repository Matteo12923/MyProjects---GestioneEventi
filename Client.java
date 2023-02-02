
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class Client {
    String nome;
    String colore;
    Socket connection;
    OutputStream os;
    InputStream is;
    //Valore per il reset del colore di output
    public static final String RESET = "\u001B[0m";
    
   public Client(String nomeDefault, String coloreDefault){
       nome = nomeDefault;
       colore = coloreDefault;
   }
   
   public void connetti(String nomeServer, int portaServer){
       
        try {
           connection = new Socket(nomeServer, portaServer);
           System.out.println(this.colore + "Connessione avvenuta con il server!");
        } 
        catch(UnknownHostException ex){
            System.err.println("Errore DNS!");
        }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore di comunicazione con la scheda di rete");
            ex.printStackTrace();
        }
   
   }
   
  public void scrivi(){
        //input da tastiera
        String messaggio = null;
        messaggio +="ciao \n";
        
        BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
        try {
            messaggio = br.readLine();
           
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            //Scrittura sullo stream di output
            os = connection.getOutputStream();
            os.write(messaggio.getBytes());
            //Invio del messaggio al server
            os.flush();
        }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nella scrittura e/o nell'invio dei dati al server!");
        }
        
   }
   
   public void chiudi(){
        
        try {
             if (connection!=null)
                    connection.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("La connessione con il server è stata chiusa e/o l'applicazione verrà terminata!");
   }   
   
}
