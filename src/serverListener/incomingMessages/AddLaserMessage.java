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
public class AddLaserMessage extends IncomingMessage {
    
    private final static String PREFIX = "ADD_LASER";
    
    private final int id;
    private final int ownerID;
    private final double endX;
    private final double endY;
    
    /**
     * 
     * @param id: id of the laser
     * @param ownerID: owner id
     * @param endX: the end point x axis
     * @param endY: the end point y axis
     */
    private AddLaserMessage(int id, int ownerID, double endX, double endY) {
        this.id = id;
        this.ownerID = ownerID;
        this.endX = endX;
        this.endY = endY;
    }
    
    /**
     * get the expected prefix for the message
     * @return the expected prefix
     */
    public static String getPrefix() {
        return PREFIX;
    }
    
    public static AddLaserMessage convertStringToMessage(String string) {
        try {
            String[] brokenString = string.split(" ");
            // make sure the message is intended for this class
            if(!brokenString[0].equals(PREFIX)) {
                return null;
            }
            int id = Integer.parseInt(brokenString[1]);
            int ownerID = Integer.parseInt(brokenString[2]);
            double endX = Double.parseDouble(brokenString[3]);
            double endY = Double.parseDouble(brokenString[4]);
            return new AddLaserMessage(id,ownerID,endX,endY);
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
    
    public int getOwnerID() {
        return this.ownerID;
    }
    
    public double getEndX() {
        return this.endX;
    }
    
    public double getEndY() {
        return this.endY;
    }
}
