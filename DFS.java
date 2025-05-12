import java.util.*;

class Graph {
    int V;
    LinkedList<Integer>[] Adj;
    int[] pred;
    static int t = 0;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    Graph(int V) {
        this.V = V;
        LinkedList<Integer>[] Adj = new LinkedList[V + 1];
        this.Adj = Adj;
        pred = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            Adj[i] = new LinkedList();
        }
    }

    void add_edge(int a, int b) {
        Adj[a].add(b);
        Adj[b].add(a);
    }

    void printPath(int s, int t) {
        if (s == t) {
            System.out.print(s + "->");
            return;
        }
        printPath(s, pred[t]);
        System.out.print(t + "->");
    }

    void DFS(int s) {
        int[] st = new int[V + 1];
        int[] ft = new int[V + 1];
        char[] c = new char[V + 1];
        for (int i = 0; i <= V; i++) {
            c[i] = 'W';
            pred[i] = -1;
        }
        DFS_visit(s, st, ft, c);
        for (int i = 1; i <= V; i++) {
            System.out.println(i + ", start: " + st[i] + ", finish: " + ft[i]);
        }
        System.out.println("Pred:");
        for (int i = 1; i <= V; i++) {
            System.out.println(i + " " + pred[i]);
        }
    }

    void DFS_visit(int u, int[] st, int[] ft, char[] c) {
        if (c[u] == 'B')
            return;
        c[u] = 'G';
        st[u] = ++t;
        for (int i = 0; i < Adj[u].size(); i++) {
            int v = Adj[u].get(i);
            if (c[v] == 'W') {
                pred[v] = u;
                DFS_visit(v, st, ft, c);
            }
        }
        c[u] = 'B';
        ft[u] = ++t;
    }
}

public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges:");
        int V = sc.nextInt();
        int E = sc.nextInt();
        Graph g = new Graph(V);
        for (int i = 1; i <= E; i++) {
            System.out.println("Enter edge no " + i);
            g.add_edge(sc.nextInt(), sc.nextInt());
        }
        g.DFS(1);

        for (int i = 1; i <= V; i++) {
            g.printPath(1, i);
            System.out.println();
        }

        sc.close();
    }
}