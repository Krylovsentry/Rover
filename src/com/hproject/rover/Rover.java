package com.hproject.rover;

import com.hproject.ground.Ground;
import com.hproject.interfaces.Landable;
import com.hproject.interfaces.Liftable;
import com.hproject.interfaces.Moveable;
import com.hproject.interfaces.Turnable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Антон on 13.11.2015.
 */
public class Rover extends GroundVisor implements Moveable,Landable,Turnable,Liftable {

    private Direction direction = Direction.NORTH;
    private Point rover_point = new Point(0,0);

    public Rover(Ground ground) {
        super(ground);
    }


    @Override
    public String toString() {

        return "Position of Rover { " + rover_point.toString() + " Direction: " + direction.toString() + " }";

    }

    @Override
    public void move() {

        if (rover_point != null) {
            switch (direction) {

                case NORTH:

                    try {
                        if (!hasObstacles(rover_point.getX(), rover_point.getY() + 1)) {

                            rover_point.setY(rover_point.getY() + 1);
                            System.out.println(this.toString());
                        }
                    } catch (OutOfGroundException e) {
                        this.lift();
                    }

                    break;
                case SOUTH:
                    try {
                        if (!hasObstacles(rover_point.getX(), rover_point.getY() - 1)) {

                            rover_point.setY(rover_point.getY() - 1);
                            System.out.println(this.toString());
                        }
                    } catch (OutOfGroundException e) {
                        this.lift();
                    }
                    break;

                case WEST:
                    try {
                        if (!hasObstacles(rover_point.getX() - 1, rover_point.getY())) {

                            rover_point.setX(rover_point.getX() - 1);
                            System.out.println(this.toString());
                        }
                    } catch (OutOfGroundException e) {
                        this.lift();
                    }
                    break;

                case EAST:

                    try {
                        if (!hasObstacles(rover_point.getX() + 1, rover_point.getY())) {

                            rover_point.setX(rover_point.getX() + 1);
                            System.out.println(this.toString());

                        }
                    } catch (OutOfGroundException e) {
                        this.lift();
                    }
                    break;
            }

        }
    }

    @Override
    public void land(int x, int y, Direction direction) {

        if (rover_point == null) {

            try {
                if (!hasObstacles(x, y)) {
                    this.rover_point = new Point(x, y);
                    this.direction = direction;
                    System.out.println(this.toString());

                }
            } catch (OutOfGroundException e) {

                System.out.println("Полет продолжается");
            }
        }

    }


    @Override
    public void turnTo(Direction direction) {

        if ( rover_point != null) {

            this.direction = direction;
            System.out.println(this.toString());

        }
    }

    @Override
    public void lift() {

        this.direction = null;
        this.rover_point = null;

        System.out.println("Взлетаем");

    }


    public void executeProgramFile(String string) throws FileNotFoundException {

        Scanner in = new Scanner(new File(string));
        while (in.hasNext()){

            String nextLine = in.nextLine();
            if (nextLine.equalsIgnoreCase("move")){

                this.move();

            }else  if (nextLine.equalsIgnoreCase("lift")){

                this.lift();

            } else if (nextLine.substring(0,5).equalsIgnoreCase("land")){

                String [] sub = nextLine.split(" ");
                this.land(Integer.parseInt(sub[1]),Integer.parseInt(sub[2]),Direction.valueOf(sub[3].toUpperCase()));

            } else  if (nextLine.substring(0,5).equalsIgnoreCase("turn")){

                String [] sub = nextLine.split(" ");
                this.turnTo(Direction.valueOf(sub[1].toUpperCase()));
            }



        }

        in.close();



    }
}
