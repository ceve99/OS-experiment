import java.net.*;
import java.io.*;
import java.util.*;

public class Server{
    public static void main(String [] args){
        try(Socket socket = new Socket("localhost",8080)){
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            if(in.readLine()!=null) System.out.println("ciao");
            
        }catch(IOException e){}
    }
}