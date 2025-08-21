import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Vertex {
static ArrayList<Vertex> listastacje = new ArrayList<>();

    ArrayList<Vertex> stacjezpolaczenim=new ArrayList<>();
    static int counter=0;
    int id;
    ArrayList<Edge> edges;
    boolean visited;


    public Vertex() {
        this.id = counter;
        this.edges = new ArrayList<>();
        this.visited = false;
        counter++;

        listastacje.add(this);
    }
    public Vertex(String name) {
        this.id = counter;
        this.edges = new ArrayList<>();
        this.visited = false;
        counter++;

        listastacje.add(this);
    }

    public void addEdge(Vertex destination) {

        this.edges.add(new Edge(this, destination));
        this.stacjezpolaczenim.add(destination);
    }

    @Override
    public String toString() {
        return "Vertex{" +

                ", id=" + id +
                ", edges=" + edges +
                ", visited=" + visited +
                '}';
    }

}
