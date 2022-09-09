/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.gameCore;

import di.uniba.map.b.silenthouse.main.base.Room;
import di.uniba.map.b.silenthouse.main.base.Stobj;
import di.uniba.map.b.silenthouse.main.gameInterface.VisibilityManager;
import di.uniba.map.b.silenthouse.main.objectSet.Door;
import di.uniba.map.b.silenthouse.main.parser.*;

/**
 *
 * @author user
 */
/**
 * Classe che traduce i comandi ricevuti in interazione di gioco
 */
public class Story {

    public Story() {
    }

    /**
     * Traduzione dei comandi ottenuti in ingresso già processati dal Parser e
     * contenuti in par. I comandi attivano determinate interazioni di gioco a
     * seconda della posizione nella mappa (Map map), eventualmente modificando
     * attributi del giocatore (Player p) per poi aggiornare l'interfaccia con
     * specifici messaggi tramite i metodi di VisbilityManager (vm)
     *
     * @param par
     * @param p
     * @param map
     * @param vm
     * @return boolean end. True se si è raggiunta l'interazione finale del
     * gioco, false altrimenti
     */
    public boolean nextMove(ParserOutput par, Player p, Map map, VisibilityManager vm) {
        boolean end = false;
        String uitxt = "";
        if (par.getCommand() == null) { //Se il parser non ha riconosciuto il comando inserito
            vm.writeOnScreen("Comando non riconosciuto.");
        } else {
            boolean noroom = false;
            boolean move = false;

            //Se non è presente un mostro le azioni sono effettuabili, altrimenti è necessario prima sconfiggerlo
            if (null != map.getCurrentRoom()) {
                //Inserimento "nord" (o sinonimi). Modifica la stanza corrente con il relativo nord
                if (par.getCommand().getName().equals("nord")) {
                    if (map.getCurrentRoom().getNorth() != null) {
                        map.setPreviousRoom(map.getCurrentRoom());
                        map.setCurrentRoom(map.getCurrentRoom().getNorth());
                        move = true;
                    } else {
                        noroom = true;
                    }
                }

                //Inserimento "sud" (o sinonimi). Modifica la stanza corrente con il relativo sud
                if (par.getCommand().getName().equals("sud")) {
                    if (map.getCurrentRoom().getSouth() != null) {
                        map.setPreviousRoom(map.getCurrentRoom());
                        map.setCurrentRoom(map.getCurrentRoom().getSouth());
                        move = true;
                    } else {
                        noroom = true;
                    }
                }

                //Inserimento "est" (o sinonimi). Modifica la stanza corrente con il relativo est
                if (par.getCommand().getName().equals("est")) {
                    if (map.getCurrentRoom().getEast() != null) {
                        map.setPreviousRoom(map.getCurrentRoom());
                        map.setCurrentRoom(map.getCurrentRoom().getEast());
                        move = true;
                    } else {
                        noroom = true;
                    }
                }

                //Inserimento "ovest" (o sinonimi). Modifica la stanza corrente con il relativo ovest
                if (par.getCommand().getName().equals("ovest")) {
                    if (map.getCurrentRoom().getWest() != null) {
                        map.setPreviousRoom(map.getCurrentRoom());
                        map.setCurrentRoom(map.getCurrentRoom().getWest());
                        move = true;
                    } else {
                        noroom = true;
                    }
                }

                //Inserimento "osserva" o sinonimi. Consente di osservare la stanza corrente, elencandone gli oggetti presenti, o un oggetto specifico (della stanza o nell'inventario). Inoltre raccoglie le monete
                if (par.getCommand().getName().equals("osserva")) {
                    if (par.getObject() == null) {
                        boolean forward = false;
                        uitxt = (map.getCurrentRoom().getDescription() + "\n\nLe direzioni in cui puoi proseguire sono: ");
                        if (map.getCurrentRoom().getNorth() != null) {
                            uitxt = (uitxt + " [Nord] ");
                            forward = true;
                        }
                        if (map.getCurrentRoom().getSouth() != null) {
                            uitxt = (uitxt + " [Sud] ");
                            forward = true;
                        }
                        if (map.getCurrentRoom().getWest() != null) {
                            uitxt = (uitxt + " [Ovest] ");
                            forward = true;
                        }
                        if (map.getCurrentRoom().getEast() != null) {
                            uitxt = (uitxt + " [Est]");
                            forward = true;
                        }
                        if (!forward) {
                            uitxt = (map.getCurrentRoom().getDescription() + "\n\nNon puoi proseguire in nessuna direzione: può darsi che il passaggio sia bloccato.");
                        }
                        if (map.getCurrentRoom().getObjects().size() > 0) {
                            uitxt = (uitxt + "\n\nCio' con cui puoi interagire in questo luogo: ");
                            for (Stobj robj : map.getCurrentRoom().getObjects()) {
                                if (robj.isVisible()) {
                                    uitxt = (uitxt + "\n- " + robj.getName());
                                    if (robj.getName().equals("Porta")) {
                                        switch (((Door) robj).getDirection()) {
                                            case "n":
                                                uitxt = (uitxt + " (verso nord");
                                                break;
                                            case "s":
                                                uitxt = (uitxt + " (verso sud");
                                                break;
                                            case "w":
                                                uitxt = (uitxt + " (verso ovest");
                                                break;
                                            case "e":
                                                uitxt = (uitxt + " (verso est");
                                                break;
                                        }
                                        if (((Door) robj).isOpen()) {
                                            uitxt = (uitxt + ", è aperta)");
                                        } else {
                                            uitxt = (uitxt + ", è chiusa)");
                                        }
                                    }
                                }
                            }
                        }
                    } else if (par.getObject() != null && par.getObject().isVisible()) {
                        int k = -1;
                        for (int i = 0; i < map.getCurrentRoom().getObjects().size() && k == -1; i++) {
                            if (map.getCurrentRoom().getObjects().get(i).getName().equals(par.getObject().getName())) {
                                k = i;
                            }
                        }
                        if (k > -1) {
                            uitxt = (map.getCurrentRoom().getObjects().get(k).getDescription());
                        } else {
                            if (p.getInventory() != null) {
                                for (int i = 0; i < p.getInventory().size() && k == -1; i++) {
                                    if (p.getInventory().get(i).getName().equals(par.getObject().getName())) {
                                        k = i;
                                    }
                                }
                                uitxt = (p.getInventory().get(k).getDescription());
                            }
                        }
                    }
                    vm.writeOnScreen(uitxt);
                }

              
                
                  //Inserimento "raccogli" o sinonimi. Consente di raccogliere l'oggetto specificato se presente nella stanza
               if (par.getCommand().getName().equals("raccogli")) {
                    if (par.getObject() == null) {
                        vm.writeOnScreen("Non ho capito cosa vorresti raccogliere. Specifica cosa raccogliere.");
                    } else {
                        for (int i = 0; i< map.getCurrentRoom().getObjects().size(); i++) {
                            if (map.getCurrentRoom().getObjects().get(i).getName().equals(par.getObject().getName())) {
                                if (map.getCurrentRoom().getObjects().get(i).isPickupable()) {
                                    p.addToInventory(map.getCurrentRoom().getObjects().get(i));
                                    vm.writeOnScreen(map.getCurrentRoom().getObjects().get(i).getName() + " aggiunto al tuo inventario");
                                    map.getCurrentRoom().getObjects().remove(i);
                                    break;
                                } else {
                                    vm.writeOnScreen("Non puoi raccogliere questo oggetto");
                                }
                            }
                        }
                    }
               }

                //Inserimento "apri" o sinonimi (vale solo per le porte)
                if (par.getCommand().getName().equals("apri")) {
                    if (par.getObject() != null) {
                        if (par.getObject().getName().equals("Porta")) {
                            map.getCurrentRoom().openDoor(par.getDir());
                        }
                    } else {
                        vm.writeOnScreen("L'oggetto a cui ti riferisci non esiste, non è apribile o lo hai scritto in modo incorretto.\nSpecifica cosa vorresti aprire");
                    }
                }

                //Inserimento "chiudi" o sinonimi (vale solo per le porte)
                if (par.getCommand().getName().equals("chiudi")) {
                    if (par.getObject() != null) {
                        if (par.getObject().getName().equals("Porta")) {
                            map.getCurrentRoom().closeDoor(par.getDir());
                        }
                    } else {
                        vm.writeOnScreen("L'oggetto a cui ti riferisci non esiste, non è richiudibile o lo hai scritto in modo incorretto.\nSpecifica cosa vorresti chiudere");
                    }
                }

                //Inserimento "Q" per risoluzione di riddle
                if (par.getCommand().getName().equals("calvino")) {
                    map.getCurrentRoom().riddle();
                }
            }

          
            //Inserimento "inventario". Consente di visualizzare l'elenco di ciò che è contenuto nell'inventario
            if (par.getCommand().getName().equals("inventario")) {
                if (!p.getInventory().isEmpty()) {
                    uitxt = ("Oggetti attualmente nel tuo inventario:");
                    for (Stobj inv : p.getInventory()) {
                        uitxt = (uitxt + "\n- " + inv.getName());
                    }
                } else {
                    uitxt = ("Non hai niente nello zaino");
                }
                vm.writeOnScreen(uitxt);
            }

            //Inserimento "indietro" o sinonimi. Porta alla stanza precedente
            if (par.getCommand().getName().equals("indietro")) {
                if (map.getPreviousRoom() != null) {
                    map.back();
                    move = true;
                } else {
                    vm.writeOnScreen("Non puoi tornare indietro.");
                }
            }

            //Inserimento "parla". Attiva l'interazione del dialogo con la persona specificata
            if (par.getCommand().getName().equals("parla")) {
                if (par.getObject() != null) {
                    map.getCurrentRoom().talkTo(p, par.getObject());
                } else {
                    vm.writeOnScreen("Con chi vorresti parlare?");
                }
            }
            
            //inserimento "usa"
            if(par.getCommand().getName().equals("usa")){
                if(par.getObject() != null){
                    map.getCurrentRoom().open(p, par.getObject());
                }else{
                    vm.writeOnScreen("ti manca l'oggetto per aprirlo");
                }
            }

            //Inserimento "leggi"
            if (par.getCommand().getName().equals("leggi")) {
                if (par.getObject() != null) {
                    if (par.getObject().getName().equals("foglio")) {
                        for (Stobj inv : p.getInventory()) {
                            if (inv.getName().equals("foglio")) {
                                vm.writeOnScreen(inv.getDescription());
                                break;
                            }
                        }
                    } else {
                        vm.writeOnScreen("Non puoi leggerlo.");
                    }
                } else {
                    boolean adv = false;
                    for (Stobj inv : p.getInventory()) {
                        if (inv.getName().equals("Foglio")) {
                            adv = true;
                            break;
                        }
                    }
                    if (adv) {
                        vm.writeOnScreen("");
                    } else {
                        vm.writeOnScreen("Non c'è nulla dal leggere");
                    }
                }
            }

          

            //Inserimento "inserisci". Attiva l'interazione per l'inserimento degli oggetti
            if (par.getCommand().getName().equals("inserisci")) {
                map.getCurrentRoom().insert(p);
            }
            
            if(par.getCommand().getName().equals("scegli")){
                map.getCurrentRoom().choose(p, par.getObject(), vm);
            }

           

            if (!map.getCurrentRoom().getMsg().equals("")) { //Fa visualizzare il messaggio accumulato nelle interazioni delle diverse stanze sulla interfaccia
                if (map.getCurrentRoom().getMsg().equals("FINE")) {
                    end = true;
                
                }else {
                    vm.writeOnScreen(map.getCurrentRoom().getMsg());
                    
                    map.getCurrentRoom().setMsg("");
                }
            }

            if (noroom) //In caso fosse impossibile proseguire nella direzione specificata
            {
                vm.writeOnScreen("Non puoi proseguire in quella direzione");
            }
            if (move) { //In caso fosse possibile proseguire nella direzione specificata, ne vengono visualizzati nome e descrizione della stanza di arrivo.
                uitxt = (map.getCurrentRoom().getName() + "\n____________\n\n" + map.getCurrentRoom().getDescription());
                vm.writeOnScreen(uitxt);
            }
        }
        return end;
    }

    public void start(VisibilityManager vm) {
        vm.writeOnScreen("In questa avventura impersonerai il ruolo di un detective che si ritrova a dover affrontare un caso particolare: \n"
        + "una chiamata anonima ti ha implorato di risolvere il mistero di questa casa \nnella quale viene svolto un gioco \n" 
        + "se si riesce ad arrivare alla fine della casa si vince un premio in denaro \nda un milione di euro \n"
                + "il problema è che nessuno è mai tornato... \n"
                + "per scrutare gli elementi e le direzioni dove puoi muoverti puoi OSSERVARE \n"
                + "potrai muoverti all'interno della mappa con i punti cardinali NORD, SUD ,EST, OVEST");
    }

   
    
}
