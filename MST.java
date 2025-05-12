import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Graph {
    int vertices;
    ArrayList<Edge> edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public ArrayList<Edge> kruskalMST() {
        ArrayList<Edge> result = new ArrayList<>();
        Collections.sort(edges);

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int edgeCount = 0;
        int index = 0;
        while (edgeCount < vertices - 1) {
            Edge nextEdge = edges.get(index++);
            int x = find(parent, nextEdge.source);
            int y = find(parent, nextEdge.destination);

            if (x != y) {
                result.add(nextEdge);
                union(parent, x, y);
                edgeCount++;
            }
        }
        return result;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}

public class MST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices and edges :");
        int vertices = sc.nextInt();
        Graph graph = new Graph(vertices);

        int edges = sc.nextInt();

        System.out.println("Enter source, destination and weight of edges:");
        for (int i = 0; i < edges; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        ArrayList<Edge> mst = graph.kruskalMST();
        System.out.println("Edges in MST:");
        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + ": " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Minimum cost of the tree : " + totalWeight);
        sc.close();
    }
}
