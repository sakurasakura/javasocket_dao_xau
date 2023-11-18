/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketdaoxau.client;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class ClientView extends JFrame {

    JTextField jTextField_input;
    JTextField jTextField_response;
    JButton jButton_send;

    public ClientView() throws HeadlessException {

        setSize(300, 300);
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Xau gui:"));
        jTextField_input = new JTextField();
        add(jTextField_input);
        jButton_send = new JButton("Gui");
        add(jButton_send);
        add(new JButton("Clear"));
        add(new JLabel("Xau nhan:"));
        jTextField_response = new JTextField();
        add(jTextField_response);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setButtonListener(ActionListener listener) {
        jButton_send.addActionListener(listener);
    }

    public String getInput() {
        return jTextField_input.getText();
    }

    public void setResponse(String t) {
        jTextField_response.setText(t);
    }
}
