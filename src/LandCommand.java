/**
 * Created by Антон on 27.11.2015.
 */
public class LandCommand implements RoverCommand{

    private Landable landable;
    private int x ;
    private int y;
    private Direction direction;


    @Override
    public void execute() {


        landable.land(x,y,direction);


    }

    public LandCommand(Landable landable,int x, int y, Direction direction){


        this.direction = direction;
        this.x = x;
        this.y = y;
        this.landable = landable;

    }
}
