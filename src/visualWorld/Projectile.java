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
public class Projectile extends Circle {
    
    private final int id;
    
    public Projectile(int id, double x, double y) {
        this.id = id;
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(0.5);
        this.setFill(Paint.valueOf("white"));
    }
    
    public int getID() {
        return this.id;
    }
    
    
}
