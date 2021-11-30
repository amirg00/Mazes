import java.awt.*;

public class NodeEdge {

    private Color tag;
    private NodeVertex v1,v2;

    public NodeEdge(NodeVertex v1, NodeVertex v2){
        this.v1 = v1;
        this.v2 = v2;
    }

    public void setTag(Color tag) {
        this.tag = tag;
    }

    public NodeVertex getV1() {
        return v1;
    }

    public NodeVertex getV2() {
        return v2;
    }

    public Color getTag() {
        return tag;
    }

    public String toString(){
        return "\nfirst vertex: "+"\n"+v1.toString()
                +"\nsecond vertex: "+"\n"+v2.toString()
                +"\n"+"edge color: "+tag+"\n" +
                "\n";
    }
}
