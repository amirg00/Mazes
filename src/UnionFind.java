public class UnionFind {

    private int[] parent, size;

    public UnionFind(int m, int n){
        int vertices = m*n;
        this.parent = new int[vertices];
        this.size = new int[vertices];
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    /**
     * This method finds the ancestor of the disjoint group (in our case: the connected component),
     * and also operates path compression to have optimal time complexity.
     * @param v a vertex's id v.
     * @return the ancestor's id.
     */
    public int find(int v){
        if (parent[v]!=v) {parent[v] = find(parent[v]);}
        return parent[v];
    }
    /**
     * This method unions two disjoint groups (in our case: connected components),
     * following the weight of each to know which ancestor has a bigger weight,
     * so we can connect to him the other ancestor.
     * @param v1 a given vertex.
     * @param v2 a given vertex.
     */
    public void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1!=p2){
            if (size[p1] <= size[p2]){
                parent[p1] = p2;
                size[p2] += size[p1];
            }
            else{
                parent[p2] = p1;
                size[p1] += size[p2];
            }
        }
    }
}
