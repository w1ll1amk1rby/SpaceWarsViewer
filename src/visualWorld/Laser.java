/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualWorld;

import javafx.scene.shape.Line;

/**
 *
 * @author William Kirby
 */
public class Laser extends Line {
    private final int id;
    
    public Laser(int id,double startX, double startY, double endX, double endY) {
        super(startX,startY,endX,endY);
        this.setStyle("-fx-stroke: #6D68F0;");
        this.id = id;
    }
    
    public int getID() {
        return this.id;
    }
}
