/**
 * Created by Антон on 13.11.2015.
 */
public class Rover extends GroundVisor implements Moveable,Landable,Turnable,Liftable {

    private Direction direction;
    private Point rover_point;


    @Override
    public String toString() {
        return "Position of Rover { " + rover_point.toString() + "Direction: " + direction.toString() + " }";
    }

    @Override
    public void move() {

        switch (direction){

            case NORTH:
                if (isOutBorder(rover_point.getX(),rover_point.getY()+1)){

                    this.lift();
                }
                else if (!hasObstacles(rover_point.getX(),rover_point.getY()+1)){

                    rover_point.setY(rover_point.getY()+1);
                }

                break;
            case SOUTH:
                if (isOutBorder(rover_point.getX(),rover_point.getY()-1)){
                    this.lift();

                }
                else if (!hasObstacles(rover_point.getX(),rover_point.getY()-1)) {

                    rover_point.setY(rover_point.getY()-1);
                }
                break;

            case WEST:
                if (isOutBorder(rover_point.getX()-1,rover_point.getY())){

                    this.lift();
                }

                else if (!hasObstacles(rover_point.getX()-1,rover_point.getY())) {

                    rover_point.setX(rover_point.getX()-1);
                }
                break;

            case EAST:

                if (isOutBorder(rover_point.getX()+1,rover_point.getY())){
                    this.lift();

                }
                else if (!hasObstacles(rover_point.getX()+1,rover_point.getY())) {

                    rover_point.setX(rover_point.getX()+1);

                }
                break;
        }

    }

    @Override
    public void land(int x, int y, Direction direction) {


        if (!hasObstacles(x, y)) {
            this.rover_point = new Point(x, y);
            this.direction = direction;

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


    public Point getRover_point(){

        return rover_point;
    }

}
