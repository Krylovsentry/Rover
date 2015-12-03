package com.hproject.command;

import com.hproject.interfaces.Moveable;
import com.hproject.interfaces.RoverCommand;

/**
 * Created by Антон on 27.11.2015.
 */
public class MoveCommand implements RoverCommand {

    private Moveable moveable;



    @Override
    public void execute() {

        moveable.move();

    }

     public  MoveCommand(Moveable moveable){


         this.moveable = moveable;

     }


}
