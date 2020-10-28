/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualWorld;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author William Kirby
 */
public class Ship extends Circle {
    
    private static final int FIGHTER_ID = 0;
    private static final int CRUISER_ID = 1;
    private static final int BATTLESHIP_ID = 2;
    
    private final int id;
    
    public Ship(int shipType,double x,double y,int id) {
        super();
        this.id = id;
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(2);
        this.setFill(Paint.valueOf(this.getShipColour(shipType))); // black
    }
    
    public int getID() {
        return this.id;
    }
    
    private String getShipColour(int shipType) {
        switch (shipType) {
            case Ship.FIGHTER_ID:
                return "white";
            case Ship.CRUISER_ID:
                return "red";
            case Ship.BATTLESHIP_ID:
                return "blue";
            default:
                return "white";
        }
    }
}
