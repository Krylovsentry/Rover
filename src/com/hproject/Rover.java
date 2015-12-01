package com.hproject;

/**
 * Created by Антон on 13.11.2015.
 */
public class Rover extends GroundVisor implements Moveable,Landable,Turnable,Liftable {

    private Direction direction;
    private Point rover_point;


    @Override
    public String toString() {
        return "Position of com.hproject.Rover { " + rover_point.toString() + "com.hproject.Direction: " + direction.toString() + " }";
    }

    @Override
    public void move() {

        switch (direction){

            case NORTH:

                try {
                    if (!hasObstacles(rover_point.getX(),rover_point.getY()+1)){

                        rover_point.setY(rover_point.getY()+1);
                    }
                } catch (OutOfGroundException e) {
                    this.lift();
                }

                break;
            case SOUTH:
                try {
                    if (!hasObstacles(rover_point.getX(),rover_point.getY()-1)) {

                       rover_point.setY(rover_point.getY()-1);
                   }
                } catch (OutOfGroundException e) {
                    this.lift();
                }
                break;

            case WEST:
                try {
                    if (!hasObstacles(rover_point.getX()-1,rover_point.getY())) {

                       rover_point.setX(rover_point.getX()-1);
                   }
                } catch (OutOfGroundException e) {
                    this.lift();
                }
                break;

            case EAST:

                try {
                    if (!hasObstacles(rover_point.getX()+1,rover_point.getY())) {

                        rover_point.setX(rover_point.getX()+1);

                    }
                } catch (OutOfGroundException e) {
                    this.lift();
                }
                break;
        }

    }

    @Override
    public void land(int x, int y, Direction direction) {


        try {
            if (!hasObstacles(x, y)) {
                this.rover_point = new Point(x, y);
                this.direction = direction;

            }
        } catch (OutOfGroundException e) {

        }

    }


    @Override
    public void turnTo(Direction direction) {

        this.direction = direction;

    }

    @Override
    public void lift() {

        this.direction = null;
        this.rover_point = null;


    }


    public void executeProgramFile(String string){




    }
}
