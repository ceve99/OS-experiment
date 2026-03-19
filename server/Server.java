package server;

import folder.folder;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  ServerSocket serverSocket;
  folder folder;
  PrintWriter out;
  BufferedReader in;
  
  public Server(int port, String path) {
    try {
      serverSocket = new ServerSocket(port);
      folder = new folder(path);
      System.out.println("Server is running on port " + port);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    int port = 12345; // Default port
    String path = "shared_folder"; // Default folder path

    Server server = new Server(port, path);
    while (true) {
      try {
        System.out.println("Waiting for clients to connect...");
        Socket clientSocket = server.serverSocket.accept();
        String id = clientSocket.getInetAddress().toString();
        System.out.println("Client connected: " + id);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new java.io.InputStreamReader(clientSocket.getInputStream()));
        ClientManager clientManager = new ClientManager(id, out, in, server.folder);
        new Thread(clientManager).start();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
