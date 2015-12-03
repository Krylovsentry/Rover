import com.hproject.ground.Ground;
import com.hproject.rover.Direction;
import com.hproject.rover.ProgrammableRover;
import com.hproject.rover.Rover;

import java.io.FileNotFoundException;

/**
 * Created by Антон on 03.12.2015.
 */
public class Test {


    public static void main(String[] args)  {

        Ground ground = new Ground(10,10);

        ProgrammableRover rover = new ProgrammableRover(ground);

        System.out.println(rover.toString());
        rover.lift();
        rover.land(1, 2, Direction.WEST);
        rover.move();

        rover.move();

        rover.move();

        int i = 0;
        while ( i < 10){

            rover.move();
            i++;
        }

        rover.turnTo(Direction.EAST);
        rover.land(2,4,Direction.NORTH);
        rover.land(2, 7, Direction.WEST);
        rover.executeProgramFile("program.txt");

    }
}
