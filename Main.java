
import java.util.Scanner;

public class Main {

    static int[][] adjMatrix;
    static int vertices;

    // Add directed edge
    static void addEdge(int source, int destination) {
        adjMatrix[source][destination] = 1;
    }

    // Breadth First Search
    static void BFS(int start) {

        boolean[] visited = new boolean[vertices];
        int[] queue = new int[vertices];

        int front = 0;
        int rear = 0;

        visited[start] = true;
        queue[rear++] = start;

        System.out.print("BFS Traversal: ");

        while (front < rear) {

            int current = queue[front++];

            System.out.print(current + " ");

            for (int i = 0; i < vertices; i++) {

                if (adjMatrix[current][i] == 1 &&
                    !visited[i]) {

                    visited[i] = true;
                    queue[rear++] = i;
                }
            }
        }

        System.out.println();
    }

    // Depth First Search
    static void DFS(int vertex, boolean[] visited) {

        visited[vertex] = true;

        System.out.print(vertex + " ");

        for (int i = 0; i < vertices; i++) {

            if (adjMatrix[vertex][i] == 1 &&
                !visited[i]) {

                DFS(i, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        vertices = sc.nextInt();

        adjMatrix = new int[vertices][vertices];

        System.out.print("Enter number of one-way roads: ");
        int edges = sc.nextInt();

        System.out.println("Enter source and destination of each road:");

        for (int i = 0; i < edges; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();

            if (source >= 0 && source < vertices &&
                destination >= 0 && destination < vertices) {

                addEdge(source, destination);

            } else {
                System.out.println("Invalid city number!");
                i--;
            }
        }

        System.out.print("Enter starting city (0 to " +
                         (vertices - 1) + "): ");

        int start = sc.nextInt();

        if (start < 0 || start >= vertices) {
            System.out.println("Invalid starting city!");
        } else {

            System.out.println("\nAdjacency Matrix:");

            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();

            BFS(start);

            boolean[] visited = new boolean[vertices];

            System.out.print("DFS Traversal: ");
            DFS(start, visited);

            System.out.println();
        }

        sc.close();
    }
}
