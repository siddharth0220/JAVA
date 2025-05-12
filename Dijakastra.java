import java.util.*;

class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    int getWeight() {
        return this.w;
    }
}

public class Dijakastra {
    int V, E;
    ArrayList<Edge> adjList[];

    @SuppressWarnings("unchecked")
    Dijakastra(int V, int E) {
        this.V = V;
        this.E = E;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adjList[i] = new ArrayList<Edge>();
    }

    void addEdge(int a, int b, int c) {
        Edge e = new Edge(a, b, c);
        adjList[a].add(e);
    }

    void DIJAKASTRA(int src) {
        class Vertex {
            int vid, dist, pre;

            Vertex(int a, int b, int c) {
                vid = a;
                dist = b;
                pre = c;
            }

            int getDistance() {
                return this.dist;
            }
        }
        ArrayList<Vertex> allVertex = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (i == src) {
                Vertex v = new Vertex(i, 0, -1);
                allVertex.add(v);
            } else {
                Vertex v = new Vertex(i, 9999, -1);
                allVertex.add(v);
            }
        }
        PriorityQueue<Vertex> pq = new PriorityQueue<>((ea, eb) -> (ea.getDistance() - eb.getDistance()));
        for (Vertex vertex : allVertex)
            pq.add(vertex);
        while (pq.isEmpty() == false) {
            Vertex curr = pq.poll();
            int cur = curr.vid;
            for (int i = 0; i < adjList[cur].size(); i++) {
                Edge edg = adjList[cur].get(i);
                Vertex t_u = allVertex.get(edg.u);
                Vertex t_v = allVertex.get(edg.v);
                if ((t_u.dist + edg.w) < t_v.dist) {
                    pq.remove(t_v);
                    t_v.pre = t_u.vid;
                    t_v.dist = t_u.dist + edg.w;
                    allVertex.set(t_v.vid, t_v);
                    pq.add(t_v);
                }
            }
        }
        for (int j = 0; j < allVertex.size(); j++) {
            Vertex v = allVertex.get(j);
            System.out.println(v.vid + "\t" + v.pre + "\t" + v.dist);
        }
    }

    public static void main(String[] args) {
        Dijakastra dj = new Dijakastra(4, 5);

        dj.addEdge(0, 1, 10);
        dj.addEdge(0, 2, 5);
        dj.addEdge(1, 2, 1);
        dj.addEdge(1, 3, 2);
        dj.addEdge(2, 3, 8);

        dj.DIJAKASTRA(0);
    }
}