/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import di.uniba.map.b.silenthouse.main.gameCore.Player;

/**
 *
 * @author user
 */
public class Stobj implements Serializable{
    private String name;
    private String description;
    private Set<String> alias;
    private boolean visible = true;
    private boolean pickupable = false;
    private boolean usable = false;
    
    public Stobj(){}
    
    public Stobj(String name){
        this.name=name;
    }
    
    public Stobj(String name, String description){
        this.name=name;
        this.description=description;
    }
    
    public Stobj(String name, String description, Set<String> alias){
        this.name=name;
        this.description=description;
        this.alias=alias;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isPickupable() {
        return pickupable;
    }

    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }
    
    public void setAlias(String[] sinonimi) {
        this.alias = new HashSet<>(Arrays.asList(sinonimi));
    }
    
    
    
    /**
     * Confronto tra oggetti
     * @param other
     * @return boolean e, true se sono uguali, false altrimenti
     */
    public boolean equals(Object other) {
        boolean e=true;
        if (this == other) {
            e=true;
        }
        if (other == null) {
            e=false;
        }
        if (getClass() != other.getClass()) {
            e=false;
        }
        return e;
    }
    
    
}
