package praktikum6;

import java.util.Stack;

public class Graph {

    public static final int MAX_SIZE = 20;
    private int maxVertex = 10;
    private int[][] adjacencyMatrix;
    private Vertex[] vertList;
    private int countVert = 0;

    public Graph() {
        adjacencyMatrix = new int[MAX_SIZE][MAX_SIZE];
        vertList = new Vertex[MAX_SIZE];
        countVert = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                } else {
                    adjacencyMatrix[i][j] = -1;
                }
            }
        }
    }

    public void addVertex(char node) {
        vertList[countVert++] = new Vertex(node);
    }

    public void addEdge(int a, int b, int c) {
        adjacencyMatrix[a][b] = c;
        adjacencyMatrix[b][a] = c;
    }

    public int indexVertex(char label) {
        for (int i = 0; i < vertList.length; i++) {
            if (vertList[i] != null) {
                if (vertList[i].getLabel() == label) {
                    return i;
                }

            }
        }
        return -1;
    }

    public void addEdge(char a, char b, int c) {
        addEdge(indexVertex(a), indexVertex(b), c);
    }

    public void printAdjcencyMatrix() {
        for (int i = 0; i < countVert; i++) {
            for (int j = 0; j < countVert; j++) {
                System.out.print(adjacencyMatrix[i][j] + "\t");
            }
            System.out.println(" ");
        }
    }

    public void dfs() {
        int seed = 0;
        dfs(seed);
    }

    public void dfs(int seed) {
        Stack<Integer> s = new Stack();
        s.push(seed);

        while (!s.isEmpty()) {
            int x = s.pop();

            if (vertList[x].flagVisited == false) {
                System.out.println(vertList[x].getLabel() + " ");
                vertList[x].flagVisited = true;

                for (int i = vertList.length - 1; i >= 0; i--) {
                    if (adjacencyMatrix[x][i] >= 1 && vertList[i].flagVisited == false) {
                        s.push(i);
                    }
                }

            }
        }
    }
}
