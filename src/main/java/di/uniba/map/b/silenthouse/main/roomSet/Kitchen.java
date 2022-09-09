/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.roomSet;

import di.uniba.map.b.silenthouse.main.base.Room;
import di.uniba.map.b.silenthouse.main.base.Stobj;

/**
 *
 * @author user
 */
public class Kitchen extends RoomWDoor {
    
   public Kitchen(){
       
       Stobj obj = new Stobj();
       obj.setName("coltello");
       obj.setDescription("un grande coltello usato nelle preparazioni culinarie \n\n stranamente è ancora molto affilato...");
       obj.setAlias(new String[]{"lama"});
       obj.setPickupable(true);
       this.addObject(obj);
        
   }
   
   
}
