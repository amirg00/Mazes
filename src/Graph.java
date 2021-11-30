import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Graph {

    private ArrayList<NodeEdge> edges;
    private ArrayList<NodeVertex> vertices;
    private int rows, columns;


    public Graph(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
        init_Vertices();
        init_Edges();
        Collections.shuffle(this.edges);
        makeEdges();
    }
    /**
     * The method initializes the vertices, when a vertex resembles a (i,j) cell.
     * In addition, it initializes the other vertex's properties as the vertex's id,
     * rows, and columns.
     */
    public void init_Vertices(){
        for (int i = 0, id = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                    vertices.add(new NodeVertex(id++,i,j,rows,columns));
            }
        }
    }
    /**
     * The method initializes the potential edges according to the current vertex's position.
     * A potential edge can be ONLY the (up, down, right, and down) neighbours of the vertex's cell.
     * Therefore, for each vertex the method checks all possible neighbours that we haven't checked earlier,
     * meaning that it goes over the first row, and updates right neighbour connections,
     * goes over the last column updates the down neighbour connections,
     * then finally for each other vertices it makes a right and up neighbour connections.
     */
    public void init_Edges(){
        for (int i = 0; i < vertices.size(); i++) {
                NodeVertex curr = vertices.get(i);
                int x = curr.getPos_x();
                int y = curr.getPos_y();
                if (x == 0 && y != columns-1) {
                    edges.add(new NodeEdge(curr, vertices.get(i + 1)));
                }
                else if (y==columns-1 && x!=rows-1) {
                    edges.add(new NodeEdge(curr, vertices.get(i + columns)));
                }
                else {
                    if (x == rows-1 && y == columns-1) {continue;}
                    edges.add(new NodeEdge(curr, vertices.get(i - columns)));
                    edges.add(new NodeEdge(curr,vertices.get(i + 1)));
                }
        }
    }
    /**
     * This method follows union-find data structure, in order to fulfill exercise's requirements.
     * The method goes over the shuffled edges' order, and get the node's id of both edge's vertices.
     * Afterwards, the method check whether the vertices have the same ancestor,
     * if they do, then we change the color tag to be black since we do want
     * this edge to be drawn, otherwise it means that they are located in the same
     * connected component, so we skip up to the next edge and draw this edge in white,
     * because we don't want to draw it.
     */
    public void makeEdges(){
        UnionFind union = new UnionFind(rows, columns);
        for(NodeEdge edge: edges) {
            int firstVertIndex = edge.getV1().getKey();
            int secVertIndex = edge.getV2().getKey();
            if (union.find(firstVertIndex) != union.find(secVertIndex)) {
                union.union(firstVertIndex, secVertIndex);
                edge.setTag(Color.white);
            }
            else {
                edge.setTag(Color.BLACK);
            }
        }
    }

    public ArrayList<NodeEdge> getEdges() {
        return edges;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

}
