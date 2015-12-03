package com.hproject.rover;

import com.hproject.command.LandCommand;
import com.hproject.command.LiftCommand;
import com.hproject.command.MoveCommand;
import com.hproject.command.TurnCommand;
import com.hproject.interfaces.RoverCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Антон on 27.11.2015.
 */
public class RoverCommandParser {

    private List<RoverCommand> commandList;
    private Rover rover;
    private String filePath;

    public List<RoverCommand> readCommands() throws FileNotFoundException {

        commandList = new LinkedList<RoverCommand>();

        Scanner in = new Scanner(new File(filePath));

        while (in.hasNext()){

            String nextLine = in.nextLine();
            if (nextLine.equalsIgnoreCase("move")){

                commandList.add(new MoveCommand(rover));

            }else  if (nextLine.equalsIgnoreCase("lift")){

                commandList.add(new LiftCommand(rover));

            } else if (nextLine.substring(0,5).equalsIgnoreCase("land")){

                String [] sub = nextLine.split(" ");
                commandList.add(new LandCommand(rover,Integer.parseInt(sub[1]),Integer.parseInt(sub[2]),Direction.valueOf(sub[3].toUpperCase())));

            } else  if (nextLine.substring(0,5).equalsIgnoreCase("turn")){

                String [] sub = nextLine.split(" ");

                commandList.add(new TurnCommand(rover,Direction.valueOf(sub[1].toUpperCase())));


            }



        }

        in.close();

        return commandList;
    }


    public RoverCommandParser(Rover rover,String string){

        this.rover = rover;
        this.filePath = string;

    }



}
