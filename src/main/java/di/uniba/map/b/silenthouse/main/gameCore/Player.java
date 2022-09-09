/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.gameCore;

import di.uniba.map.b.silenthouse.main.base.Stobj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Player implements Serializable{
    private List<Stobj> inventory = new ArrayList<>();
  

    

    public void setInventory(List<Stobj> inventory){
        this.inventory = inventory;
    }

    public List<Stobj> getInventory(){
        return this.inventory;
    }

    public void addToInventory(Stobj obj) {
        this.inventory.add(obj);
    }

    public void removeFromInventory(Stobj obj) {
        this.inventory.remove(obj);
    }

    public void removeFromInventory(int i){this.inventory.remove(i);}
    
    public void setPlayer(Player p){
       this.setInventory(p.getInventory());
      
    }

    
    
    }
