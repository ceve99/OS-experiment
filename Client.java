import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client{
    static PrintWriter out;
    static BufferedReader in;
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8080)){
        
            out = new PrintWriter(socket.getOutputStream(), true); //lettura e scrittura sulla socket 
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String input = "";
            Scanner scanner = new Scanner(System.in);
            
            while(true){ //ciclo infinito per inviare i messaggi al server, lui risponde con una risposta automatica
                input = scanner.nextLine();
                if(input.equals("exit")){
                    break;
                }
                out.println(input);
                System.out.println("In attesa di una risposta dal server...");
                String riga = in.readLine();  
                System.out.println("Risposta dal server: " + riga);
            }
        in.close();
        out.close();
        scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        

    }
}