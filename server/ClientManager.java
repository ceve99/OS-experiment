package server;

import folder.folder;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class ClientManager implements Runnable {
  private String id;
  private PrintWriter out;
  private BufferedReader in;
  private folder folder;

  public ClientManager(String id, PrintWriter out, BufferedReader in, folder folder){
    this.id = id;
    this.out = out;
    this.in = in;
    this.folder = folder;
  }

  @Override
  public void run() {
    System.out.println("Client " + id + " is running.");
    // Simulate client operations here
    try{
      while(true){
        
        String command = in.readLine();
        if(command.equals("read")){
          folder.beforeReading();
          folder.read();
          out.println("Client " + id + " read from folder.");
          folder.afterReading();

        }
        if(command.equals("write")){
          folder.beforeWriting();
          folder.write();
          out.println("Client " + id + " wrote to folder.");
          folder.afterWriting();
        }
        if(command.equals("exit")){
          System.out.println("Client " + id + " is exiting.");
          break;
          
        }  
        
      }
    
      in.close();
      out.close();

    }catch(Exception e){
      e.printStackTrace();
    }

  }
  
}
