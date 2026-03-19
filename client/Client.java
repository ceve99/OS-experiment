package client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  private BufferedReader in;
  private PrintWriter out;
  private Socket socket;
  private Scanner scanner;

  public Client(){
    try{
      socket = new Socket("localhost", 12345);
      scanner = new Scanner(System.in);
      in = new BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      }
      catch(Exception e){ e.printStackTrace();}
    }
    
  public static void main(String[] args) {
    Client client = new Client();
    while (true) {
      System.out.println("Enter command (read/write/exit): ");
      String command = client.scanner.nextLine();
      client.out.println(command);
      if (command.equals("exit")) {
        System.out.println("Exiting client.");
        break;
      }
      
      try {
        String response = client.in.readLine();
        System.out.println("Server response: " + response);
      } catch (Exception e) {
          e.printStackTrace();
        }
    }
     try {
      client.in.close();
      client.out.close();
      client.socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
