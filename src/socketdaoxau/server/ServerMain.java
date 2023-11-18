/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socketdaoxau.server;

import socketdaoxau.controller.ServerSocketController;

/**
 *
 * @author Admin
 */
public class ServerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocketController controller= new ServerSocketController();
        controller.startServer(90);
    }
    
}
