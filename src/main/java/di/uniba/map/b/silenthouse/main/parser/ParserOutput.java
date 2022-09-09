/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.silenthouse.main.parser;

import di.uniba.map.b.silenthouse.main.base.Command;
import di.uniba.map.b.silenthouse.main.base.Stobj;

/**
 *
 * @author user
 */
public class ParserOutput {
    private final Command command; //comando
    private final Stobj object;    //oggetto interagibile
    private String dir = "";      //direzione porta
    
    public ParserOutput(Command command, Stobj object) {
        this.command = command;
        this.object = object;
    }

    public ParserOutput(Command command, Stobj object, String dir) {
        this.command = command;
        this.object = object;
        this.dir = dir;
    }
    
    public Command getCommand() {
        return command;
    }

    public Stobj getObject() {
        return object;
    }

    public String getDir() {
        return dir;
    }
}
