
import java.awt.*;

public class MazeGUI {
    /**
     * @implNote  The maze's origin coordinate is (s1,e2), where the last coordinate is (e1,s2).
     */
    private Graph g;
    private final int s1;
    private final int e1;
    private final int s2;
    private final int e2;

    public MazeGUI(Graph g){
        this.g = g;
        this.s1 = -10*this.g.getColumns();
        this.e1= 10*this.g.getColumns();
        this.s2 = -10*this.g.getRows();
        this.e2 = 10*this.g.getRows();
    }


    public void runGui(){
        StdDraw.clear();
        StdDraw.setCanvasSize(750,750);
        int max = Math.max(this.g.getColumns(),this.g.getRows());
        StdDraw.setScale(-12*max,12*max);
        StdDraw.setPenColor(Color.BLACK);
        buildMazeFrame();
        drawMaze();
        StdDraw.show();
    }

    /**
     * This method draws the maze, going over each edge and check if it's a black edge,
     * if it does, then we need to draw it, so we call checkEdgeDirection to draw the
     * edge by its vertices' cell position.
     */
    public void drawMaze(){
        for(NodeEdge edge : this.g.getEdges()){
            if (edge.getTag() == Color.BLACK)
                checkEdgeDirection(edge.getV1(), edge.getV2());
        }
    }

    /**
     * The method takes two vertices, and checks for their position.
     * Then the method checks for four possible cases where:
     *
     *      1. (x1,y1) cell is on the right of (x2,y2).
     *      2. (x1,y1) cell is on the left of (x2,y2).
     *      3. (x1,y1) cell is under (x2,y2).
     *      4. (x1,y1) cell is above (x2,y2)
     *
     * The method draws for each a line.
     *
     * @param v1 first vertex.
     * @param v2 second vertex.
     */
    public void checkEdgeDirection(NodeVertex v1, NodeVertex v2){

        int x1 = v1.getPos_x();
        int y1 = v1.getPos_y();
        int x2 = v2.getPos_x();
        int y2 = v2.getPos_y();

        if (x1==x2 && y1 == y2 + 1)
            StdDraw.line(s1 + y1 * 20 + 20, e2 - x1 * 20, s1 + y1 * 20 + 20, e2 - x1 * 20 - 20);

        else if (x1==x2 && y1 == y2 - 1)
            StdDraw.line(s1 + y2 * 20, e2 - x2 * 20, s1 + y2 * 20, e2 - x2 * 20 - 20);

        else if(x1==x2+1 && y1 == y2)
            StdDraw.line(s1 + y1 * 20, e2 - x1 * 20, s1 + y1 * 20 + 20, e2 - x1 * 20);

        else if (x1==x2-1 && y1 == y2)
            StdDraw.line(s1 + y2 * 20, e2 - x2 * 20, s1 + y2 * 20 + 20, e2 - x2 * 20);


    }

    public void buildMazeFrame(){
        StdDraw.setPenRadius(0.007);
        StdDraw.line(s1,e2,e1,e2);
        StdDraw.line(s1,s2,e1,s2);
        StdDraw.line(s1,s2,s1,e2-20);
        StdDraw.line(e1,s2+20,e1,e2);
    }

}
