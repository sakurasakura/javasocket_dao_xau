/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketdaoxau.controller;

import socketdaoxau.model.SocketConnectionModel;
import socketdaoxau.model.StringModifyModel;

/**
 *
 * @author Admin
 */
public class ServerSocketController implements SocketConnectionModel.SocketConnectionListener {

    private SocketConnectionModel model;

    public ServerSocketController() {
        this.model = new SocketConnectionModel();
        model.setListener(this);
    }

    public void startServer(int port) {
        model.startServer(port);
    }

    public void sendMessage(String msg) {
        model.sendMessage(msg);
    }

    @Override
    public void onMessageReceived(String msg) {
        System.out.println(msg);
        String rMsg = StringModifyModel.reverseString(msg);
        System.out.println(rMsg);
        sendMessage(rMsg);
    }

}
