/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverListener;

import javafx.application.Platform;
import visualWorld.World;
import messaging.IncomingMessage;
import serverListener.incomingMessages.*;

/**
 * handles messages and executes them when necessary
 * @author William Kirby
 */
public class MessageHandler {

    private final World world;
        
    /**
     * Basic constructor
     * @param world
    */
    public MessageHandler(World world) {
        this.world = world;
    }
    
    /**
     * handles the given message defined by child class.
     * is called when deal with message is called if not a server defined message
     * @param message: message to handle.
     */
    public void handleMessage(IncomingMessage message) {
        Platform.runLater(() -> {
            if(message instanceof UpdateShipMessage) {
                UpdateShipMessage shipMessage = (UpdateShipMessage) message;
                world.updateShipView(shipMessage.getID(),shipMessage.getX(),shipMessage.getY());
            }
            else if(message instanceof UpdateProjectileMessage) {
                UpdateProjectileMessage pmessage = (UpdateProjectileMessage) message;
                world.updateProjectile(pmessage.getID(), pmessage.getX(), pmessage.getY());
            }
            else if(message instanceof AddLaserMessage) {
                AddLaserMessage laserMessage = (AddLaserMessage) message;
                world.addLaser(laserMessage.getID(),laserMessage.getOwnerID(),
                        laserMessage.getEndX(),laserMessage.getEndY());
            }
            else if(message instanceof AddProjectileMessage) {
                AddProjectileMessage projectileMessage = (AddProjectileMessage) message;
                world.addProjectile(projectileMessage.getProjectile());
            }
            else if(message instanceof RemoveLaserMessage) {
                RemoveLaserMessage laserMessage = (RemoveLaserMessage) message;
                world.removeLaser(laserMessage.getLaserID());
            }
            else if(message instanceof RemoveProjectileMessage) {
                RemoveProjectileMessage pMessage = (RemoveProjectileMessage) message;
                world.removeProjectile(pMessage.getID());
            }
            else if(message instanceof RemoveShipMessage) {
                RemoveShipMessage shipMessage = (RemoveShipMessage) message;
                world.removeShip(shipMessage.getShipID());
            }
            else if(message instanceof AddShipMessage) {
                AddShipMessage shipMessage = (AddShipMessage) message;
                world.addNewShip(shipMessage.getShip());
            }
        });
    }
}
