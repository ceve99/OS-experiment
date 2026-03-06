import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client{
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8080)){
        
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String input = "";
            Scanner scanner = new Scanner(System.in);

            while(!input.equals("addio")){
                String riga = scanner.nextLine();
                out.println(riga);    
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}