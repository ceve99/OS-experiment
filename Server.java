import java.net.*;
import java.io.*;
import java.util.*;

public class Server{
    public static void main(String [] args){
        //while (true) {
            
        try(ServerSocket serversocket = new ServerSocket(8080)){
            try(Socket client = serversocket.accept()){
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            if(in.readLine()!=null) System.out.println("ciao");
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }catch(IOException e){

    }
    //}
    }
}