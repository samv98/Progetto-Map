/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.gameCore;

import di.uniba.map.b.silenthouse.main.base.Room;
import di.uniba.map.b.silenthouse.main.base.Stobj;
import di.uniba.map.b.silenthouse.main.objectSet.Door;
import di.uniba.map.b.silenthouse.main.roomSet.*;
import java.io.Serializable;

/**
 *
 * @author user
 */
public class Map implements Serializable {

    private Room balcony = new Balcony();
    private Room corridor = new Corridor();
    private Room guestRoom = new GuestRoom();
    private Room manHole = new Room();
    private Room kitchen = new Kitchen();
    private Room salon = new Salon();
    private Room secretRoom = new SecretRoom();
    private Room garden = new RoomWDoor();
    private Room mainRoom = new MainRoom();
    private Room secondaryRoom = new RoomWDoor();
    private Room stanzaTerziaria = new StanzaTerziaria();
   

    private Room currentRoom = new Room();
    private Room previousRoom = null;

    /**
     * in questa parte andiamo a costruire tutta la mappa di gioco
     */
    public Map() {
        Stobj obj = new Stobj();
        Door door = new Door();

        /**
         * qui creiamo tutte le varie stanze e assegniamo gli oggetti
         * interagibili
         */
        //giardino della casa
        garden.setName("GIARDINO");
        garden.setDescription("il giardino della casa, si trovano molte erbacce e erba alta,"
                + "\nsi espande intorno tutta la casa"
                + "\nsicuramente non viene curato molto...");
        door.setName("Porta");
        door.setDescription("l'entrata della casa");
        door.setOpen(false);
        door.setDirection("n");
        garden.addObject(door);
        garden.setNextNorth(salon);

        //salotto della casa
        salon.setName("SALOTTO");
        salon.setDescription("il salotto della casa, è enorme e inquetante"
                + "\nsembra non ci abiti nessuno"
                + "\ntutti i mobili sono pieni di povere");
        salon.setWest(balcony);
        salon.setNextEast(kitchen);
        salon.setNextSouth(garden);
        salon.setNorth(corridor);

        //cucina della casa
        kitchen.setName("CUCINA");
        kitchen.setDescription("la cucina della casa, per essere una casa in disuso è molto fornita");
        kitchen.setWest(salon);

        //balcone della casa
        balcony.setName("BALCONE");
        balcony.setDescription("balcone che si affaccia sul giardino. \nvedendo l'esterno mi sembra di essere in piccoli brividi...");
        balcony.setEast(salon);

        //corridoio della casa
        corridor.setName("CORRIDOIO");
        corridor.setDescription("il corridoio della casa, "
                + "\nsembra come se ci fossero altre stanze che sono state murate"
                + "\ninoltre le pareti sono sporche di sangue");
        corridor.setSouth(salon);
        corridor.setEast(guestRoom);
        corridor.setWest(secondaryRoom);
        corridor.setNextNorth(stanzaTerziaria);
        
        
        //stanza terziaria
       stanzaTerziaria.setName("STANZA TERZIARIA");
       stanzaTerziaria.setDescription("una stanza angosciante"
               + "\nsui muri vedi sangue ovunque e graffi"
               + "\nvedi una scritta scritta con il sangue che recita:"
               + "\nhelp me");
       stanzaTerziaria.setSouth(corridor);
       
        //stanza secondaria
        secondaryRoom.setName("STANZA SECONDARIA");
        secondaryRoom.setDescription("una stanza disastrata"
                + "\na terra ci sono mobili distrutti e pezzi di vetro ovunque");
        obj.setName("fotografia");
        obj.setDescription("una fotografia di una famiglia, è sporca di sangue \n\n probabilmente erano venuti a tentare la fortuna \n\n sicuro di voler prendere la fotografia?");
        obj.setPickupable(true);
        secondaryRoom.addObject(obj);
        secondaryRoom.setEast(corridor);

        //stanza degli ospiti
        guestRoom.setName("STANZA DEGLI OSPITI");
        guestRoom.setDescription("sembra una stanza destinata agli ospiti"
                + "\nstrano in una casa del genere"
                + "\nè l'unica stanza che mi dà una parvenza di normalità....");
        guestRoom.setNextNorth(manHole);
        guestRoom.setWest(corridor);
        
        //bottola per la stanza principale
        manHole.setName("BOTTOLA");
        manHole.setDescription("Una bottola che porta ad un'altra stanza");
        manHole.setSouth(guestRoom);
        manHole.setNorth(mainRoom);

        //stanza "principale"
        mainRoom.setName("STANZA PRINCIPALE");
        mainRoom.setDescription("entrando nella stanza si sente un'odore nauseante, "
                + "\nvedi sangue ovunque"
                + "\nsembra che ci sia stata una carneficina");
        mainRoom.setNextNorth(secretRoom);
        mainRoom.setSouth(manHole);

        //stanza segreta
        secretRoom.setName("STANZA SEGRETA");
        secretRoom.setDescription("nella stanza non ci sono più porte, difronte a te trovi un'uomo che ti fissa ");
        secretRoom.setSouth(mainRoom);
        this.setCurrentRoom(garden);
    }

    public void setCurrentRoom(Room r) {
        this.currentRoom = r;
    }

    /**
     *
     * @return
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setPreviousRoom(Room r) {
        this.previousRoom = r;
    }

    public Room getPreviousRoom() {
        return this.previousRoom;
    }
    

    public void setMap(Map m) {
        this.setBalcony(m.getBalcony());
        this.setCorridor(m.getCorridor());
        this.setCurrentRoom(m.getCurrentRoom());
        this.setGarden(m.getGarden());
        this.setGuestRoom(m.getGuestRoom());
        this.setManHole(m.getManHole());
        this.setKitchen(m.getKitchen());
        this.setMainRoom(m.getMainRoom());
        this.setPreviousRoom(m.getPreviousRoom());
        this.setSalon(m.getSalon());
        this.setSecondaryRoom(m.getSecondaryRoom());
        this.setSecretRoom(m.getSecretRoom());
        this.setStanzaTerziaria(m.getStanzaTerziaria());
    }

    public Room getStanzaTerziaria() {
        return stanzaTerziaria;
    }

    public void setStanzaTerziaria(Room stanzaTerziaria) {
        this.stanzaTerziaria = stanzaTerziaria;
    }

    
    

    public Room getManHole() {
        return manHole;
    }

    public void setManHole(Room manHole) {
        this.manHole = manHole;
    }
    
    

    public Room getBalcony() {
        return balcony;
    }

    public void setBalcony(Room balcony) {
        this.balcony = balcony;
    }

    public Room getCorridor() {
        return corridor;
    }

    public void setCorridor(Room corridor) {
        this.corridor = corridor;
    }

    public Room getGuestRoom() {
        return guestRoom;
    }

    public void setGuestRoom(Room guestRoom) {
        this.guestRoom = guestRoom;
    }

    public Room getKitchen() {
        return kitchen;
    }

    public void setKitchen(Room kitchen) {
        this.kitchen = kitchen;
    }

    public Room getSalon() {
        return salon;
    }

    public void setSalon(Room salon) {
        this.salon = salon;
    }

    public Room getSecretRoom() {
        return secretRoom;
    }

    public void setSecretRoom(Room secretRoom) {
        this.secretRoom = secretRoom;
    }

    public Room getGarden() {
        return garden;
    }

    public void setGarden(Room garden) {
        this.garden = garden;
    }

    public Room getMainRoom() {
        return mainRoom;
    }

    public void setMainRoom(Room mainRoom) {
        this.mainRoom = mainRoom;
    }

    public Room getSecondaryRoom() {
        return secondaryRoom;
    }

    public void setSecondaryRoom(Room secondaryRoom) {
        this.secondaryRoom = secondaryRoom;
    }

    //tornare alla stanza precedente
    public void back() {
        Room tmp = this.getCurrentRoom();
        this.setCurrentRoom(this.getPreviousRoom());
        this.setPreviousRoom(tmp);
    }
}
