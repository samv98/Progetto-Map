/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.roomSet;

import di.uniba.map.b.silenthouse.main.base.Room;
import di.uniba.map.b.silenthouse.main.base.Stobj;
import di.uniba.map.b.silenthouse.main.gameCore.Player;

/**
 *
 * @author user
 */
public class Balcony extends RoomWDoor{
     
    public Balcony(){
            Stobj fantasma = new Stobj();
            fantasma.setName("fantasma");
            fantasma.setDescription("una figura che ti osserva da dietro un albero"
                    + "ti senti pervadere dai brividi");
            this.addObject(fantasma);
            
           

    }
    
    public void talkTo(Player p, Stobj person){
        if(person != null){
            Stobj foglio = new Stobj("foglio", "Un foglio di carta che recita una frase"
                    + "\ntrova la gemma");
            foglio.setAlias(new String[]{"biglietto", "bigliettino"});
            foglio.setVisible(true);
            this.setMsg("La figura misteriosa ti lancia un foglietto"
                    + "\nrimane immobile indicando il foglio che ti ha lanciato"
                    + "\nchissa cosa significa"
                    + "\nappena abbassi lo sguardo per prendere il foglio"
                    + "\nil fantasma scompare");
            p.addToInventory(foglio);
            this.getObjects().remove(person);
        }else{
            this.setMsg("il fantasma è come scomparso");
        }
    }

  
    
    
}
