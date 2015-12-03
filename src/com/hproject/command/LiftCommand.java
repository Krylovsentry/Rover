package com.hproject.command;

import com.hproject.interfaces.Liftable;
import com.hproject.interfaces.RoverCommand;

/**
 * Created by Антон on 27.11.2015.
 */
public class LiftCommand implements RoverCommand {

    private Liftable liftable;



    @Override
    public void execute() {


        liftable.lift();
    }



    public LiftCommand(Liftable liftable){

        this.liftable = liftable ;



    }
}
