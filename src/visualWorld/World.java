/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualWorld;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;

/**
 *
 * @author William Kirby
 */
public class World extends Pane {
    
    private static final double HEIGHT = 1080;
    private static final double WIDTH = 1920;
    private final List<Ship> ships;
    private final List<Laser> lasers;
    private final List<Projectile> projectiles;
    
    public World() {
        this.setHeight(HEIGHT);
        this.setWidth(WIDTH);
        this.setStyle("-fx-background-color: black");
        this.ships = new ArrayList<>();
        this.lasers = new ArrayList<>();
        this.projectiles = new ArrayList<>();
    }

    public synchronized void addNewShip(Ship ship) {
        this.ships.add(ship);
        this.getChildren().add(ship);
    }

    public synchronized void removeShip(int shipID) {
       Ship ship = this.getShipWithID(shipID);
       if(ship != null) {
        this.ships.remove(ship);
        this.getChildren().remove(ship);
       }
    }

    public synchronized void updateShipView(int id, double x, double y) {
        Ship ship = this.getShipWithID(id);
        ship.setCenterX(x);
        ship.setCenterY(y);
    }
    
    public synchronized void addLaser(int id, int ownerID, double endX, double endY) {
        Ship ship = this.getShipWithID(ownerID);
        double startX = ship.getCenterX();
        double startY = ship.getCenterY();
        Laser laser = new Laser(id,startX,startY,endX,endY);
        this.getChildren().add(laser);
        this.lasers.add(laser);
    }
    
    public synchronized void removeLaser(int laserID) {
        Laser laser = this.getLaserWithID(laserID);
        if(laser != null) {
            this.lasers.remove(laser);
            this.getChildren().remove(laser);
        }
    }
    
    private synchronized Laser getLaserWithID(int id) {
        for(int x = 0;x < this.lasers.size(); x++) {
            if(this.lasers.get(x).getID() == id) {
                return this.lasers.get(x);
            }
        }
        return null;
    }
    
    
    private synchronized Ship getShipWithID(int id) {
        for(int x = 0;x < this.ships.size();x++) {
            if(this.ships.get(x).getID() == id) {
                return this.ships.get(x);
            }
        }
        return null;
    }

    public void addProjectile(Projectile projectile) {
        this.projectiles.add(projectile);
        this.getChildren().add(projectile);
    }
    
    public void updateProjectile(int id, double x, double y) {
        Projectile projectile = this.getProjectileWithID(id);
        if(projectile != null) {
            projectile.setCenterX(x);
            projectile.setCenterY(y);
        }
    }

    private Projectile getProjectileWithID(int id) {
        for(int x = 0;x < this.projectiles.size();x++) {
            if(this.projectiles.get(x).getID() == id) {
                return this.projectiles.get(x);
            }
        }
        return null;
    }

    public void removeProjectile(int id) {
        Projectile projectile = this.getProjectileWithID(id);
        if(projectile != null) {
            this.getChildren().remove(projectile);
            this.projectiles.remove(projectile);
        }
    }

}
