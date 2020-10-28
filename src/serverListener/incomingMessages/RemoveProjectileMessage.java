/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverListener.incomingMessages;

import messaging.IncomingMessage;

/**
 *
 * @author William Kirby
 */
public class RemoveProjectileMessage extends IncomingMessage {
    
    private final static String PREFIX = "REMOVE_PROJECTILE";
    private final int id;
    
    public RemoveProjectileMessage(int id) {
        this.id = id;
    }
    
    /**
     * get the expected prefix for the message
     * @return the expected prefix
     */
    public static String getPrefix() {
        return PREFIX;
    }
    
    public static RemoveProjectileMessage convertStringToMessage(String string) {
        try {
            String[] brokenString = string.split(" ");
            // make sure the message is intended for this class
            if(!brokenString[0].equals(PREFIX)) {
                return null;
            }
            int id = Integer.parseInt(brokenString[1]);
            // create a new message
            return new RemoveProjectileMessage(id);
        } 
        // this is catching an out of array index error. ingore its lies
        catch(Exception e) { // if an exception is thrown (unfinished message)
            // then just return null
            return null;
        }
    }
    
    public int getID() {
        return this.id;
    }
}
