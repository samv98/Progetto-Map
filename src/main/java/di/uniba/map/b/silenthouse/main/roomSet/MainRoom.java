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
public class MainRoom extends RoomWDoor {

    public MainRoom() {

        Door door = new Door();
        Stobj obj = new Stobj();
        obj.setName("fessura");
        obj.setAlias(new String[]{"buco", "apertura"});
        obj.setDescription("piccola fessura nel muro, sembra manchi qualcosa...");
        this.addObject(obj);

    }

    @Override
    public void insert(Player p) {
        boolean g = false;
        int k = -1;
        for (int i = 0; i < p.getInventory().size(); i++) {
            if (p.getInventory().get(i).getName().equals("gemma") ) {
                g = true;
                k = i;
            }
           
        }
        if (g) {
            this.setMsg("la gemma entra perfettamente nel muro"
                    + "\nsi sente il rumore di una serratura che si apre"
                    + "\nla porta si spalanca da sola"
                    + "\nora puoi avanzare");
            p.removeFromInventory(k);
            this.getObjects().removeIf(obj -> obj.getName().equals("fessura"));
            this.setNorth(this.getNextNorth());
            
        } else {
            this.setMsg("non hai nulla da inserire");
        }
    }

    
}
