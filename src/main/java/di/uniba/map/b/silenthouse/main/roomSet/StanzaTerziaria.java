/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.roomSet;

import di.uniba.map.b.silenthouse.main.base.Stobj;
import di.uniba.map.b.silenthouse.main.gameCore.Player;

/**
 *
 * @author user
 */
public class StanzaTerziaria extends RoomWDoor{
    
    public StanzaTerziaria(){
    
         Stobj obj2 = new Stobj();
        obj2.setName("scrigno");
        obj2.setAlias(new String[]{"scatola", "bauletto", "forziere"});
        obj2.setDescription("uno scrigno decadente \nforse con qualcosa di affilato riuscirei ad aprirlo...");
        this.addObject(obj2);
}
    
    @Override
    public void open(Player p, Stobj obj) {
        if (obj.getName().equals("coltello")) {
            int pm = -1;
            for (int i = 0; i < p.getInventory().size(); i++) {
                if(p.getInventory().get(i).getName().equals("coltello")){
                    pm = i;
                }
            }if(pm > -1){
                Stobj obj2 = new Stobj();
                obj2.setName("gemma");
                obj2.setDescription("una gemma che risplende in maniera accecante");
                p.addToInventory(obj2);
                this.setMsg("con l'aiuto del coltello riesci a forzare lo scrigno\n"
                        + "all'interno trovi una gemma che risplende, \n"
                        + "sembra fatta di diamanti \n"
                        + "prendi la gemma, può sempre servire");
                for(int i = 0; i<getObjects().size();i++){
                    if(getObjects().get(i).getName().equals("scrigno")){
                        getObjects().remove(i);
                        break;
                    }
                }
            }else{
                this.setMsg("non hai niente che ti posso aiutare ad aprire lo scrigno");
            }
        }
    }

    
    
}
