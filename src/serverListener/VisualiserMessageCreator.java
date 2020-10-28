/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverListener;

import messaging.IncomingMessage;
import messaging.MessageCreator;
import serverListener.incomingMessages.*;


/**
 * creates the messages that are coming from the server from a given string
 * @author William Kirby
 */
public class VisualiserMessageCreator extends MessageCreator {

    @Override
    public IncomingMessage convertStringToMessage(String string) {
        System.out.println(string);
        String[] brokenString = string.split(" ", 2);
        String prefix = brokenString[0];
        if(UpdateShipMessage.getPrefix().equals(prefix)) {
            return UpdateShipMessage.convertStringToMessage(string);
        }
        if(UpdateProjectileMessage.getPrefix().equals(prefix)) {
            return UpdateProjectileMessage.convertStringToMessage(string);
        }
        else if(AddLaserMessage.getPrefix().equals(prefix)) {
            return AddLaserMessage.convertStringToMessage(string);
        }
        else if(AddProjectileMessage.getPrefix().equals(prefix)) {
            return AddProjectileMessage.convertStringToMessage(string);
        }
        else if(AddShipMessage.getPrefix().equals(prefix)) {
            return AddShipMessage.convertStringToMessage(string);
        }
        else if(RemoveProjectileMessage.getPrefix().equals(prefix)) {
            return RemoveProjectileMessage.convertStringToMessage(string);
        }
        else if(RemoveLaserMessage.getPrefix().equals(prefix)) {
            return RemoveLaserMessage.convertStringToMessage(string);
        }
        else if(RemoveShipMessage.getPrefix().equals(prefix)) {
            return RemoveShipMessage.convertStringToMessage(string);
        }
        else {
            return null;
        }
    }
    
}
