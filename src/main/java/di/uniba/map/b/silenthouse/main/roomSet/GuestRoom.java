/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.roomSet;

import di.uniba.map.b.silenthouse.main.base.*;
import di.uniba.map.b.silenthouse.main.objectSet.Door;

/**
 *
 * @author user
 */
public class GuestRoom extends RoomWDoor {

    public GuestRoom() {
        Stobj obj = new Stobj();
        Door door = new Door();

        obj.setName("cartello con enigma");
        obj.setDescription("accanto alla porta chiusa c'è un cartello \nil cartello recita una frase: \nm'iilumino d'immenso \nsembra che devo dare una risposta per aprire la porta ");
        obj.setAlias(new String[]{"cartello", "enigma", "indovinello"});
        this.addObject(obj);

    }
    
    @Override
    public void riddle(){
        this.setMsg("quando pronunci la risposta, "
                + "\nsenti un click provenire dalla porta");
        this.setNorth(this.getNextNorth());
        for(int i=0;i<this.getObjects().size();i++){
            if(this.getObjects().get(i).getName().equals("cartello con enigma")){
                this.getObjects().remove(i);
                break;
            }
        }
        this.setDescription("dopo aver risolto l'enigma la porta si apre da sola e \n"
                + "vedi una bottola in cui puoi entrare");
    }

}
