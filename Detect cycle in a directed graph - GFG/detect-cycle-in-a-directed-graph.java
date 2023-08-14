//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> list) {
        int[] vis = new int[V];
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (rec(i, list, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean rec(int i, ArrayList<ArrayList<Integer>> list, int[] vis) {
        vis[i] = 1;
        
        for (int neighbor : list.get(i)) {
            if (vis[neighbor] == 1) {
                return true; // Cycle detected
            }
            if (vis[neighbor] == 0 && rec(neighbor, list, vis)) {
                return true; // Cycle detected in neighbor's subtree
            }
        }
        
        vis[i] = 2; // Mark as visited
        return false;
    }
}
