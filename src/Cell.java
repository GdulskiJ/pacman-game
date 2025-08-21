import java.util.*;

public class Cell {
    static ArrayList<Cell> Cell = new ArrayList<>();

    String name;

    int id;
    static int counter = 1;
    int predkosc;
    Vertex poczatek;
    Vertex koniec;
    List<Vertex> path = new ArrayList<>();

    double calkowitydystans;




    public Cell(String name,
                Vertex poczatek, Vertex koniec) {

        this.name = name;
        this.id = counter;
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.path = findPath(poczatek, koniec);
        this.calkowitydystans = getPathLength(path);
        Cell.add(this);
        counter++;
    }














//                " " +
//                ", maxCarts=" + maxCarts +
//                ", maxWeight=" + maxWeight +
//                ", maxElectricityCarts=" + maxElectricityCarts +
//                ", predkosc=" + predkosc +
//                ", calkowitydystans=" + calkowitydystans + " "+
//                LokomotywaList
//                ;

public String dopasowanie(double a){
        String spacje = "";
    int doodjecia = Double.toString(a).length();

        for(int i =0; i<18-doodjecia;i++){
            spacje=spacje+" ";
        }
spacje=spacje+"|";
        return spacje;
}
    public String dopasowanie(String a){
        String spacje = "";
        int doodjecia = a.length();

        for(int i =0; i<18-doodjecia;i++){
            spacje=spacje+" ";
        }
        spacje=spacje+"|";
        return spacje;
    }
    public String dopasowanie(int a){
        String spacje = "";
        int doodjecia = Integer.toString(a).length();

        for(int i =0; i<18-doodjecia;i++){
            spacje=spacje+" ";
        }
        spacje=spacje+"|";
        return spacje;
    }

//    static public List<Vertex> findPath(Vertex start, Vertex end) {
//        List<Vertex> path = new ArrayList<>();
//        Vertex posredni=start;
//        path.add(start);
//        while (posredni.equals(end)){
//         posredni=   posredni.stacjezpolaczenim.get(0);
//         path.add(posredni);
//
//        }
//        return path;
//    }



    static public List<Vertex> findPath(Vertex start, Vertex end) {
        Queue<Vertex> queue = new LinkedList<>();
        Map<Vertex, Vertex> parent = new HashMap<>();

        queue.add(start);
        start.visited = true;

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current == end) {
                break;
            }

            for (Edge edge : current.edges) {
                Vertex neighbor = edge.destination;

                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                    parent.put(neighbor, current);
                }
            }
        }

        List<Vertex> path = new ArrayList<>();

        if (parent.containsKey(end)) {
            Vertex current = end;

            while (current != start) {
                path.add(current);
                current = parent.get(current);
            }

            path.add(start);
            Collections.reverse(path);
        }

        // reset visited flag for all vertices
        for (Vertex vertex : parent.keySet()) {
            vertex.visited = false;
        }


        start.visited = false;
        end.visited = false;

        return path;
    }

    public static int getPathLength(List<Vertex> path) {
        int length = 0;

        // Przechodzenie po kolejnych wierzchołkach na ścieżce i sumowanie kosztów krawędzi
        for (int i = 0; i < path.size() - 1; i++) {
            Vertex current = path.get(i);
            Vertex next = path.get(i + 1);

            for (Edge edge : current.edges) {
                if (edge.destination == next) {

                    break;
                }
            }
        }

        return length;
    }

    public void pathshow() {

        if (path.isEmpty()) {
            System.out.println("Nie znaleziono trasy.");
        } else {
            System.out.print("Trasa: ");

            for (Vertex vertex : path) {
                System.out.print(vertex.id + " ");
            }
        }
    }





    public String toStringDetails() {
        return "Lokomotywa{" +
                ", calkowitydystans=" + calkowitydystans +
                '}';
    }
}