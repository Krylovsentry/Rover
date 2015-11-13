/**
 * Created by Антон on 13.11.2015.
 */
public class Rover extends GroundVisor implements Moveable,Landable,Turnable,Liftable {

    private int x;
    private int y;
    private Direction direction;


    @Override
    public void move() {

        switch (direction){

            case NORTH:
                if (!hasObstacles(x,y+1))
                    y +=1;
                break;
            case SOUTH:
                if (!hasObstacles(x,y-1))
                    y -=1;
                break;
            case WEST:
                if (!hasObstacles(x-1,y))
                    x -=1;
                break;
            case EAST:
                if (!hasObstacles(x+1,y))
                    x +=1;
                break;
        }

    }

    @Override
    public void land(int x, int y, Direction direction) {


        if (!hasObstacles(x, y)) {
            this.x = x;
            this.y = y;
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

        //Здесь должен быть взлет
        this.x = -1;
        this.y = -1;

    }

}
