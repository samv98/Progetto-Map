/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.roomSet;

import di.uniba.map.b.silenthouse.main.base.Stobj;
import di.uniba.map.b.silenthouse.main.gameCore.Player;
import di.uniba.map.b.silenthouse.main.base.Room;
import di.uniba.map.b.silenthouse.main.gameInterface.*;


/**
 *
 * @author user
 */
public class SecretRoom extends RoomWDoor{
    
    public SecretRoom(){
            Stobj uomo = new Stobj("uomo misterioso", "come è possibile che ci sia una persona in questa stanza");
            uomo.setAlias(new String[]{"uomo", "misterioso", "figura"});
            this.addObject(uomo);
            
        Stobj risposta = new Stobj();
        risposta.setName("prima");
        risposta.setAlias(new String[]{"soldi", "sacrificio"});
        risposta.setDescription("scegli dopo aver parlato con la figura");
        risposta.setVisible(false);
        this.addObject(risposta);
        Stobj obj = new Stobj();
        obj.setName("seconda");
        obj.setDescription("Scegli dopo aver parlato con la figura");
        obj.setAlias(new String[]{"persone", "salvare" });
        obj.setVisible(false);
        this.addObject(obj);
       
        
    }
    
    
    @Override
    public void talkTo(Player p, Stobj person){
        if(person.getName().equals("uomo")){
            
        this.setMsg("");
        }else{
            this.setMsg("l'uomo misterioso ti fissa costantemente \nti pone un quesito"
                + "\nse dovessi scegliere tra: \navere molti soldi però in cambio sacrificare delle persone"
                + "\noppure perdere tutto il guadagno però salveresti molte persone\nScegli:"
                    + "\nprima o seconda opzione?");
        }
        
    }
    
    
    
    public void choose(Player p, Stobj obj, VisibilityManager vm ){
         if(obj.getName().equals("prima")){
            vm.backToMenu();
            vm.writeOnExitScreen("la figura ti pugnala all'improvviso \nti dice che tutti quelli che sono entrati nella casa hanno scelto i soldi"
                    + "\nper questo sono tutti morti "
                    + "\nla figura ti dice di aver creato questo gioco per provare ad eliminare l'avidità"
                    + "\nlentamente ti accasci a terra e inizi a vedere tutto sfocato \nè finita...");
            
        }else if(obj.getName().equals("seconda")){
            vm.backToMenu();
            vm.writeOnExitScreen("l'uomo ti fa i suoi complimenti \ndice che sei la prima persona ad aver scelto la vita umana a discapito dei soldi"
                    + "\nper questo ti lascia andare e ti svela che la casa è stata creata all'unico scopo di eliminare le persone avide"
                    + "\nche per soldi farebbero qualsiasi cosa \nsuccessivamente l'uomo misterioso avvia un timer per distruggere la cosa e rimane dentro"
                    + "\nmentre tu scappi dalla casa \nsei salvo e all'uscita trovi una sacca piena di soldi");
        }else{
            this.setMsg("devi fare una scelta: prima o seconda");
        }
    }
    
    
}
