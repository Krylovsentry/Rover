

/**
 * Created by Антон on 03.11.2015.
 */
public class GroundVisor {

    private Ground ground;


    public boolean hasObstacles(int x, int y){

        if (ground.getCell(x, y).getState() == CellState.FREE) {

            return false;
        }


        else
        {
            return true;
        }


    }

}
