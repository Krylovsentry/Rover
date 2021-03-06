package com.hproject.rover;

import com.hproject.ground.CellState;
import com.hproject.ground.Ground;

/**
 * Created by Антон on 03.11.2015.
 */
public class GroundVisor {

    private Ground ground;


    public GroundVisor(Ground ground){

        this.ground = ground;

    }

    public boolean hasObstacles(int x, int y) throws OutOfGroundException {

        if (x < 0 || y < 0 || x > ground.getWidth()-1 || y >= ground.getLength()-1 ){


            throw new OutOfGroundException("Граница");

        }
        else if (ground.getCell(x, y).getState() == CellState.FREE) {

            return false;

        }

        System.out.println("Обнаружено препятсвие");
        return true;



    }



}
