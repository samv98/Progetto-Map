/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.roomSet;

import di.uniba.map.b.silenthouse.main.base.*;
import di.uniba.map.b.silenthouse.main.gameCore.Player;
import di.uniba.map.b.silenthouse.main.objectSet.Door;


/**
 *
 * @author user
 */
public class Salon extends RoomWDoor {
    
    
    public Salon() {
    
    Stobj mysteriousFigure = new Stobj("Figura misteriosa", "una figura misteriosa che ti attende all'ingresso");
    mysteriousFigure.setAlias(new String[]{"uomo", "figura"});
    Stobj obj = new Stobj();
    Door door = new Door();
    
    obj.setName("chiave");
    obj.setDescription("Una chiave che ha lasciato cadere"
            + "\nla figura misteriosa, chissà cosa apre");
    obj.setPickupable(true);
    this.addObject(obj);
   
    
    door.setName("Porta");
    door.setDescription("Una porta che si affaccia sulla cucina");
    door.setDirection("e");
    door.setOpen(false);
    this.addObject(door);
    
    this.addObject(mysteriousFigure);
    
    
    
}
    //interazione con la figura misteriosa
    
    @Override
    public void talkTo(Player p, Stobj person){
        if(person.getName().equals("Figura misteriosa")){
            this.setMsg("La figura misteriosa è come se fosse pietrificata"
                    + "\nprovi a parlarle ma è tutto inutile");
        }else{
            this.setMsg("");
        }
    }

    

   

   
    
}
