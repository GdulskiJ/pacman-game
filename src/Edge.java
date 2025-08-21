
public class Edge {
    Vertex source; // wierzchołek źródłowy krawędzi
    Vertex destination; // wierzchołek docelowy krawędzi


    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;

    }

    @Override
    public String toString() {
        return "Edge{" +

                '}';
    }

}
