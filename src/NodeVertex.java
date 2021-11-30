import java.awt.*;

public class NodeVertex {

    private int key, pos_x, pos_y;
    private Color tag;

    public NodeVertex(int key, int x, int y, int rows, int columns){
        this.key = key;
        this.pos_x = x;
        this.pos_y = y;
        if (pos_x == 0 && pos_y == 0 || pos_x==rows-1 && pos_y == columns-1)
              this.tag = Color.BLACK;
        else
            this.tag = Color.white;
    }


    public Color getTag() {
        return this.tag;
    }

    public int getPos_x() {
        return this.pos_x;
    }

    public int getPos_y() {
        return this.pos_y;
    }

    public int getKey() { return key;}

    public String toString(){
        return "Pos: "+this.pos_x+", "+this.pos_y + "\n" + "Color: "+this.tag;
    }
}
