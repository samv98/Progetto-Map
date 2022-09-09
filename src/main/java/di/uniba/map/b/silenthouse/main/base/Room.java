/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.base;

import di.uniba.map.b.silenthouse.main.gameCore.Player;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import di.uniba.map.b.silenthouse.main.gameInterface.*;

/**
 *
 * @author user
 */
public class Room implements Serializable {

    private String name;
    private String description;
    private Room south = null;
    private Room north = null;
    private Room east = null;
    private Room west = null;
    private List<Stobj> objects = new ArrayList<>();
    private Room nextNorth = null;
    private Room nextEast = null;
    private Room nextWest = null;
    private Room nextSouth = null;
    private String msg = "";

    public Room() {
    }

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.objects = new ArrayList<>();
    }

    public Room(String name, String description, List<Stobj> objects) {
        this.name = name;
        this.description = description;
        this.objects = objects;
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

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public List<Stobj> getObjects() {
        return objects;
    }

    public void setObject(List<Stobj> objects) {
        this.objects = objects;
    }
    //serve ad aggiungere un oggetto alla lista degli oggetti della stanza

    public void addObject(Stobj object){
        this.objects.add(object);
    }
    
    public void addObject(String name, String description) {
        Stobj obj = new Stobj(name, description);
        this.objects.add(obj);
    }

    public void addObject(String name, String description, String[] sinonimi) {
        Stobj obj = new Stobj(name, description);
        obj.setAlias(sinonimi);
        this.objects.add(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass();
    }

    public void setNextNorth(Room nextNorth) {
        this.nextNorth = nextNorth;
    }

    public Room getNextNorth() {
        return this.nextNorth;
    }

    public void setNextWest(Room nextWest) {
        this.nextWest = nextWest;
    }

    public Room getNextWest() {
        return this.nextWest;
    }

    public void setNextEast(Room nextEast) {
        this.nextEast = nextEast;
    }

    public Room getNextEast() {
        return this.nextEast;
    }

    public void setNextSouth(Room nextSouth) {
        this.nextSouth = nextSouth;
    }

    public Room getNextSouth() {
        return this.nextSouth;
    }
    
     /**
     * Interazione di base dell'apertura delle porte.
     * @param idir 
     */
    public void openDoor(String idir){};

    /**
     * Interazione di base per la chiusura delle porte
     * @param idir 
     */
    public void closeDoor(String idir){};

    /**
     * Interazione di base per la risoluzione dell'enigma
     */
    public void riddle(){}

    /**
     * Interazione di base per i dialoghi
     * @param p
     * @param person 
     */
    public void talkTo(Player p, Stobj person){
        this.setMsg("Non c'è nessuno con cui parlare");
    }
    
    public void open(Player p, Stobj person){
        
    }

    /**
     * Interazione di base per l'attivazione di oggetti (leve)
     * @param lever
     * @param p 
     */
    public void activate(String lever, Player p){
        this.setMsg("Non sta nulla da attivare ");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    

    /**
     * Interazione di base per l'inserimento di oggetti
     * @param player 
     */
    public void insert(Player player){
        this.setMsg("Non hai nulla da inserire ne nulla in cui inserire :(");
    }
    
        public void give(Player p, Stobj obj){
            this.setMsg("Non puoi dare niente a nessuno");
        }

    public void choose(Player p, Stobj obj, VisibilityManager vm ) {
       
    }
        


}
