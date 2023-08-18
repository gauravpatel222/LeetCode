//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) { // Increase size by 1 to match 1-based indexing
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            list.get(x).add(y);
           list.get(y).add(x);
        }

        int[] dist = new int[n]; // Increase size by 1 to match 1-based indexing
        Arrays.fill(dist, 21456789); // Initialize distances to -1 (unreachable)
        dist[src] = 0; // Distance from source to itself is 0

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

       while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(int it : list.get(node)) {
                if(dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node]; 
                    q.add(it); 
                }
            }
        }

        for (int i = 0; i < n; i++) {
      if (dist[i] == 21456789) dist[i] = -1;
    }
        return dist;
    }
}

