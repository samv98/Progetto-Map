/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.objectSet;

import di.uniba.map.b.silenthouse.main.base.Stobj;

/**
 *
 * @author user
 */
public class Door extends Stobj {

    private String direction;
    private boolean open;

    public void setDirection(String d) {
        this.direction = d;
    }

    public String getDirection() {
        return this.direction;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
