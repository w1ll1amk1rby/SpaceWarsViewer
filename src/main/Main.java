/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import messaging.ClientMessengerConnector;
import messaging.Messenger;
import serverListener.MessageHandler;
import serverListener.ServerListener;
import visualWorld.World;

/**
 *
 * @author William Kirby
 */
public class Main extends Application {
    
    
    private ServerListener serverListener;
    
    @Override
    public void start(Stage primaryStage) {
        World world = new World();
        ClientMessengerConnector conn = new ClientMessengerConnector(2903,"127.0.0.1");
        Messenger messenger = conn.getServerConnection();
        MessageHandler handler = new MessageHandler(world);
        serverListener = new ServerListener(messenger,handler);
        serverListener.start();
        Scene scene = new Scene(world, 0, 0);
        
        primaryStage.setTitle("Space Wars");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }
    
    @Override
    public void stop(){
        serverListener.stopListening();
        try {
            this.serverListener.join();
        } catch (InterruptedException ex) {
            // do nothing
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
