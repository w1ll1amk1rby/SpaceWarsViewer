/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messaging;

import java.io.IOException;
import java.net.Socket;

/**
 * used to connect clients to the server and return a messenger
 * @author William Kirby
 */
public class ClientMessengerConnector {
    
    private final int port;
    private final String ip;
    
    /**
     * basic constructor 
     * @param port: port of connection
     * @param ip: ip to connect too
     */
    public ClientMessengerConnector(int port, String ip) {
        this.ip = ip;
        this.port = port;
    }
    
    /**
     * gets connection from the server in form of a messenger
     * @return a messenger thats connected to the given server
     * null is returned if  a connection couldn't be made.
     */
    public Messenger getServerConnection() {
        try {
            return new Messenger(new Socket(this.ip,this.port));
        }
        catch(IOException exception) { // connection not avaliable then return null
            return null;
        }
    }
    
}