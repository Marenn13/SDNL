package praktikum6;

public class GarphMain {
    
    public static void main(String[] args) {
        Graph gp = new Graph();
        
        gp.addVertex('A');
        gp.addVertex('B');
        gp.addVertex('C');
        gp.addVertex('D');
        gp.addVertex('E');
        
        gp.addEdge('A', 'B', 1);
        gp.addEdge('A', 'D', 1);
        gp.addEdge('A', 'E', 1);
        gp.addEdge('B', 'C', 1);
        gp.addEdge('C', 'D', 1);
        gp.addEdge('C', 'E', 1);
        
        gp.printAdjcencyMatrix();
        System.out.println();
        System.out.println("DFS : ");
        gp.dfs(0);
    }
    
}
