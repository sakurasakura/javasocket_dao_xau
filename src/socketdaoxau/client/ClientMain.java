/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socketdaoxau.client;

import socketdaoxau.controller.ClientSocketController;

/**
 *
 * @author Admin
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClientView view= new ClientView();
        ClientSocketController  controller= new ClientSocketController(view);
        controller.connectToServer("Trang", 90);
    }
    
}
