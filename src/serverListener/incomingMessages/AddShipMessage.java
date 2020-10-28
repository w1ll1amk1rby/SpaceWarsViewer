/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverListener.incomingMessages;

import messaging.IncomingMessage;
import visualWorld.Ship;


/**
 *
 * @author William Kirby
 */
public class AddShipMessage extends IncomingMessage {
    
    private final static String PREFIX = "ADD_SHIP";
    private final Ship ship;
    
    public AddShipMessage(Ship ship) {
        this.ship = ship;
    }

    /**
     * get the expected prefix for the message
     * @return the expected prefix
     */
    public static String getPrefix() {
        return PREFIX;
    }
    
    public static AddShipMessage convertStringToMessage(String string) {
        try {
            String[] brokenString = string.split(" ");
            // make sure the message is intended for this class
            if(!brokenString[0].equals(PREFIX)) {
                return null;
            }
            int shipType = Integer.parseInt(brokenString[1]);
            int id = Integer.parseInt(brokenString[2]);
            double x = Double.parseDouble(brokenString[3]);
            double y = Double.parseDouble(brokenString[4]);
            // create a new message
            return new AddShipMessage(new Ship(shipType,x,y,id));
        } 
        // this is catching an out of array index error. ingore its lies
        catch(Exception e) { // if an exception is thrown (unfinished message)
            // then just return null
            return null;
        }
    }
    
    public Ship getShip() {
        return this.ship;
    }
}
