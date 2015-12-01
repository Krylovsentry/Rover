package com.hproject;

import com.hproject.ground.CellState;
import com.hproject.ground.Ground;

/**
 * Created by Антон on 03.11.2015.
 */
public class GroundVisor {

    private Ground ground;


    public boolean hasObstacles(int x, int y) throws OutOfGroundException {

        if (x < 0 || y < 0 || x > ground.getWidth()-1 || y > ground.getLength()-1 ){

            throw new OutOfGroundException("За границей поверхности. Летим!");

        }
        else if (ground.getCell(x, y).getState() == CellState.FREE) {

            return false;
        }


        return true;

    }

}
