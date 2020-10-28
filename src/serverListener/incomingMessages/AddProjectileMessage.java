/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverListener.incomingMessages;

import visualWorld.Projectile;
import messaging.IncomingMessage;



/**
 *
 * @author William Kirby
 */
public class AddProjectileMessage extends IncomingMessage {

    
    private final static String PREFIX = "ADD_PROJECTILE";
    private final Projectile projectile;
    
    public AddProjectileMessage(Projectile projectile) {
        this.projectile = projectile;
    }

    /**
     * get the expected prefix for the message
     * @return the expected prefix
     */
    public static String getPrefix() {
        return PREFIX;
    }
    
    public static AddProjectileMessage convertStringToMessage(String string) {
        try {
            String[] brokenString = string.split(" ");
            // make sure the message is intended for this class
            if(!brokenString[0].equals(PREFIX)) {
                return null;
            }
            int id = Integer.parseInt(brokenString[1]);
            double x = Double.parseDouble(brokenString[2]);
            double y = Double.parseDouble(brokenString[3]);
            // create a new message
            return new AddProjectileMessage(new Projectile(id,x,y));
        } 
        // this is catching an out of array index error. ingore its lies
        catch(Exception e) { // if an exception is thrown (unfinished message)
            // then just return null
            return null;
        }
    }
    
    public Projectile getProjectile() {
        return this.projectile;
    }
}
