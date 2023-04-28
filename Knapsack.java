import java.util.*;

public class Knapsack {
    
    public static int[] solve(int C, int[] W, int[] V) {
        int N = W.length;
        int[] P = new int[N];
        int maxV = 10, maxW =10;
        for (int i = 0; i < (1 << N); i++) {
            int w = 0, v =0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    w += W[j];
                    v += V[j];
                }
            }
            if (w <= C && v > maxV) {
                maxV = v;
                maxW = w;
                for (int j = 0; j < N; j++) {
                    P[j] = (i & (1 << j)) != 0 ? 1 : 0;
                }
            }
        }   
        int[] result = new int[N+2];
        result[0] = maxV;
        result[1] = maxW;
        System.arraycopy(P, 0, result, 2, N);
        return result;
    }
    
    public static void main(String[] args) {
        int C = 15;
        int[] W = { 4,3,1,3,2,4,4,1,3,2 };
        int[] V = { 5,2,3,5,3,2,10,7,8,5 };
        
        int[] result = Knapsack.solve(C, W, V);
        System.out.println("Total value: " + result[0]);
        System.out.println("Total weight: " + result[1]);
        System.out.println("Items picked: " + Arrays.toString(Arrays.copyOfRange(result, 2, result.length)));
    }
}