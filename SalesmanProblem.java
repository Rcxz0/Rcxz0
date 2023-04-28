
import java.util.ArrayList;

public class SalesmanProblem {

    public static void main(String[] args) {
        int[][] D = {
            {0, 5, 9, 6, 6},
            {5, 0, 7, 4, 3},
            {9, 7, 0, 6, 9},
            {6, 4, 6, 0, 5},
            {6, 3, 9, 5, 0}};

        int[] nodes = {1, 2, 3, 4};
        int[] bestRoute = new int[4];
        int minDistance = Integer.MAX_VALUE;

        ArrayList<int[]> permutations = permute(nodes, 0, nodes.length - 1);

        for (int[] route : permutations) {

            int distance = 0;
            for (int i = 0; i < route.length - 1; i++) {
                distance += D[route[i] - 1][route[i + 1] - 1];
            }
            distance += D[route[route.length - 1] - 1][route[0] - 1]; // return to first node
            if (distance < minDistance) {
                minDistance = distance;
                bestRoute = route;
            }
        }

        // Print the results
        System.out.print("Best Route: ");
        for (int i = 0; i < bestRoute.length; i++) {
            System.out.print(bestRoute[i]);
        }
        System.out.println("1"); // return to first node
        System.out.println("Minimum Distance: " + minDistance);
    
    }
    // Generate all possible permutations of the nodes
    public static ArrayList<int[]> permute(int[] nodes, int start, int end) {
        ArrayList<int[]> permutations = new ArrayList<>();
        if (start == end) {
            int[] route = new int[nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                route[i] = nodes[i];
            }
            permutations.add(route);
        } else {
            for (int i = start; i <= end; i++) {
                nodes = swap(nodes, start, i);
                permutations.addAll(permute(nodes, start + 1, end));
                nodes = swap(nodes, start, i);
            }
        }
        return permutations;
    }

    public static int[] swap(int[] nodes, int i, int j) {
        int temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
        return nodes;
    }

}
