package com.hproject;

import com.hproject.command.RoverCommand;

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

    public List<RoverCommand> readCommands() throws FileNotFoundException {

        commandList = new LinkedList<RoverCommand>();

        Scanner in = new Scanner(new File("program.txt"));

        return commandList;
    }


    public RoverCommandParser(Rover rover,String string){




    }



}
