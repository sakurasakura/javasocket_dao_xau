/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketdaoxau.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SocketConnectionModel {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private SocketConnectionListener listener;

    public interface SocketConnectionListener {

        void onMessageReceived(String msg);
    }

    public SocketConnectionModel() {
    }

    public void setListener(SocketConnectionListener listener) {
        this.listener = listener;
    }

    public void startServer(int port) {
    try {
        serverSocket = new ServerSocket(port);
        System.out.println("Server running...");

        while (true) {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream());

            // Create a separate thread for each connected client
            Thread receiveThread = new Thread(() -> {
                System.out.println("start thread");
                try {
                    System.out.println("start thread");
                    String message;
//                    System.out.println(reader.readLine()+"hi");
System.out.println(reader.ready());
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Received: " + message);
                        listener.onMessageReceived(message);
                    }
                } catch (IOException ex) {
                    // Handle IO exceptions
                    ex.printStackTrace();
                }
            });
            receiveThread.start();
//            writer.close();
//            reader.close();
        }
    } catch (IOException ex) {
        // Handle IO exceptions
        ex.printStackTrace();
    }
}

    public void connectToServer(String host, int port) {
        try {
            clientSocket = new Socket(host, port);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            System.out.println("Connect to server at port " + port);
            Thread thread = new Thread(() -> {
                try {
                    String respondFromServer;
                    while ((respondFromServer = reader.readLine()) != null) {
                        System.out.println("Receive respond");
                        listener.onMessageReceived(respondFromServer);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(SocketConnectionModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            thread.start();
//            writer.close();
//            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        if (writer != null) {
            writer.println(msg);
          
            writer.flush();
            System.out.println("Send: "+msg);
        }
    }
}
