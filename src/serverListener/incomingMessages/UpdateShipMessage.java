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
public class UpdateShipMessage extends IncomingMessage {
    
    private final static String PREFIX = "UPDATE_SHIP";
    private final int id;
    private final double x;
    private final double y;
    
    public UpdateShipMessage(int id,double x,double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
   
    /**
     * get the expected prefix for the message
     * @return the expected prefix
     */
    public static String getPrefix() {
        return PREFIX;
    }
    
    public static UpdateShipMessage convertStringToMessage(String string) {
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
            return new UpdateShipMessage(id,x,y);
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
    public double getX()  {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
}
