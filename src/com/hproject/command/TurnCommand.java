package com.hproject.command;

import com.hproject.rover.Direction;
import com.hproject.interfaces.RoverCommand;
import com.hproject.interfaces.Turnable;

/**
 * Created by Антон on 27.11.2015.
 */
public class TurnCommand implements RoverCommand {

    private Turnable turnable;
    private Direction direction;

    @Override
    public void execute() {

        turnable.turnTo(direction);
    }


    public TurnCommand(Turnable turnable, Direction direction){

        this.direction = direction;
        this.turnable = turnable;


    }


}
