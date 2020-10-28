/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverListener;

import java.io.IOException;
import messaging.IncomingMessage;
import messaging.Messenger;

/**
 *
 * @author William Kirby
 */
public class ServerListener extends Thread {
    
    private final Messenger messenger;
    private final MessageHandler messageHandler;
    
    public ServerListener(Messenger messenger,MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
        this.messenger = messenger;
        this.messenger.setMessageCreator(new VisualiserMessageCreator());
    }
    
    // listen for incoming messages until a disconnect. 
    @Override
    public void run() {
        while(!this.messenger.isClosed()) {
            try {
                IncomingMessage message = this.messenger.getMessage();
                if(message != null) {
                    this.messageHandler.handleMessage(message);
                }
            } catch (IOException ex) {
                this.messenger.close();
            }
        }
    }
    
    public void stopListening() {
       this.messenger.close();
    }
}
