import java.net.*;
import java.io.*;


public class Server{
    static PrintWriter out;
    static BufferedReader in;
    public static void main(String [] args){
        try(ServerSocket serversocket = new ServerSocket(8080)){ //creazione del server socket sulla porta 8080
                
            try(Socket client = serversocket.accept()){ //accettazione della connessione da parte del client, se c'è una connessione in attesa, altrimenti rimane in attesa
                    
            out = new PrintWriter(client.getOutputStream(), true); //lettura e scrittura sulla socket specifica del client che si è connesso
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
                while (true) { //ciclo infinito per ricevere i messaggi dal client, lui risponde con una risposta automatica
                    System.out.println("In attesa di un messaggio...");
                    String msg = in.readLine();    
                    if(!msg.equals("")){ 
                        System.out.println("Messaggio ricevuto: " + msg);
                        out.println("Ciao, benvenuto al server!");
                    }
                }
            
            }catch(IOException e){
                e.printStackTrace();
            }
        in.close();
        out.close();
                       
        }catch(IOException e){}
            
    }
}        
    

