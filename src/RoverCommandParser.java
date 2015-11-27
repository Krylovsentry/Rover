import java.util.LinkedList;
import java.util.List;

/**
 * Created by Антон on 27.11.2015.
 */
public class RoverCommandParser {

    private List<RoverCommand> commandList;

    public List<RoverCommand> readCommands(){
        return commandList;
    }


    public RoverCommandParser(Rover rover,String string){

        commandList = new LinkedList<RoverCommand>();

    }



}
