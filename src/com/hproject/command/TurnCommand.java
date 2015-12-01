package com.hproject.command;

import com.hproject.Direction;
import com.hproject.Turnable;
import com.hproject.command.RoverCommand;

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
