

/**
 * Created by Антон on 03.11.2015.
 */
public class GroundCell {

    private CellState state;
    private int x;
    private int y;




    public GroundCell(int x, int y, CellState state){
        this.x = x;
        this.y = y;
        this.state = state;

    }

    public void setState(CellState state){

        this.state = state;

    }

    public CellState getState(){

        return  state;

    }

}
