package com.hproject.rover;

import com.hproject.ground.Ground;
import com.hproject.interfaces.RoverCommand;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Антон on 28.11.2015.
 */
public class ProgrammableRover extends Rover {

    private Direction direction;
    private Point rover_point;
    private List<RoverCommand> commandList;

    public ProgrammableRover(Ground ground) {
        super(ground);
    }

    @Override
    public boolean hasObstacles(int x, int y) throws OutOfGroundException {
        return super.hasObstacles(x, y);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void land(int x, int y, Direction direction) {
        super.land(x, y, direction);
    }

    @Override
    public void turnTo(Direction direction) {
        super.turnTo(direction);
    }

    @Override
    public void lift() {
        super.lift();
    }

    public void executeProgram(String string) throws FileNotFoundException {

        commandList = new RoverCommandParser(this,string).readCommands();
        for (RoverCommand roverCommand : commandList){

            roverCommand.execute();

        }


    }
}
