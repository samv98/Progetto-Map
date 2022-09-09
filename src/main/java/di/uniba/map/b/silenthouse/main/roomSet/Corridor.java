/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.roomSet;

import di.uniba.map.b.silenthouse.main.base.Room;
import di.uniba.map.b.silenthouse.main.base.Stobj;
import di.uniba.map.b.silenthouse.main.gameCore.Player;

import di.uniba.map.b.silenthouse.main.objectSet.Door;

/**
 *
 * @author user
 */
public class Corridor extends RoomWDoor {
    
    public Corridor(){
        
        
        Stobj obj = new Stobj();
        
        obj.setName("porta con serratura");
        obj.setAlias(new String[]{"porta", "serratura"});
        obj.setDescription("una porta che si può aprire solo con una chiave");
        this.addObject(obj);
    }
    
    @Override
    public void insert(Player p) {
        boolean g = false;
        int k = -1;
        for (int i = 0; i < p.getInventory().size(); i++) {
            if (p.getInventory().get(i).getName().equals("chiave") ) {
                g = true;
                k = i;
            }
           
        }
        if (g) {
            this.setMsg("la chiave entra perfettamente,"
                    + "\ngiri la chiave e la porta si apre");
            p.removeFromInventory(k);
            this.getObjects().removeIf(obj -> obj.getName().equals("porta con serratura"));
            this.setNorth(this.getNextNorth());
            
        } else {
            this.setMsg("non hai nulla da inserire o la chiave per aprire");
        }
    }
    
}
