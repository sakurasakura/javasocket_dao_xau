/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketdaoxau.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import socketdaoxau.client.ClientView;
import socketdaoxau.model.SocketConnectionModel;

/**
 *
 * @author Admin
 */
public class ClientSocketController implements SocketConnectionModel.SocketConnectionListener{
    
    ClientView view;
    SocketConnectionModel model;

    public ClientSocketController(ClientView view) {
        model= new SocketConnectionModel();
        model.setListener(this);
        view.setButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str= view.getInput();
                System.out.println(str);
                sendMessage(str);
            }
        });
        this.view= view;
    }
    public void sendMessage(String msg) {
        model.sendMessage(msg);
    }
public void connectToServer(String host, int port){
    model.connectToServer(host, port);
    
}
    
    @Override
    public void onMessageReceived(String msg) {
        view.setResponse(msg);
        System.out.println(msg);
    }
    
}
