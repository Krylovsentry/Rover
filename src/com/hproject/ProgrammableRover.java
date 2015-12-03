package com.hproject;

/**
 * Created by Антон on 28.11.2015.
 */
public class ProgrammableRover extends Rover {




    public void executeProgram(String string){


        RoverCommandParser parser = new RoverCommandParser(this, string);


    }
}
