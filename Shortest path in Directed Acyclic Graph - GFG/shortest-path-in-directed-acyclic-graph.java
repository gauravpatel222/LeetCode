//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
	    ArrayList<ArrayList<Pair>> list = new ArrayList<>();

	    for(int i=0;i<N;i++){
	      ArrayList < Pair > temp = new ArrayList < Pair > ();
                list.add(temp);
	    }
	    for(int i=0;i<edges.length;i++){
	        int u=edges[i][0];
	        int v=edges[i][1];
	        int wt=edges[i][2];
	        list.get(u).add(new Pair(v, wt));
	    }
	   Stack<Integer> stack=new Stack<>();
	   int[] vis=new int[N];
	   for(int i=0;i<vis.length;i++){
	       if(vis[i]==0){
	           toposort(vis,stack,list,i);
	       }
	   }
	   while(stack.peek()!=0){
	       stack.pop();
	   }
	   int[] ans=new int[N];
	   Arrays.fill(ans,214837283);
	   ans[0]=0;
	   while(!stack.isEmpty()){
	       int x=stack.pop();
	       for(int i=0;i<list.get(x).size();i++){
	           int a1=list.get(x).get(i).first;
	           int wt=list.get(x).get(i).second;
	           if(ans[x]+wt<ans[a1]){
	               ans[a1]=ans[x]+wt;
	           }
	       }
	       
	   }
	    for (int i = 0; i < N; i++) {
      if (ans[i] == 214837283) ans[i] = -1;
    }
    return ans;
                
	}
	public static void toposort(int[] vis,Stack<Integer> stack,ArrayList<ArrayList<Pair>> list,int i){
	    vis[i]=1;
	    for(int index=0;index<list.get(i).size();index++){
	        int v = list.get(i).get(index).first;
	        if(vis[v]==0){
	            toposort(vis,stack,list,v);
	        }

	    }
	    stack.push(i);
	}
}
class Pair {
  int first, second;
  Pair(int _first, int _second) {
    this.first = _first;
    this.second = _second;
  }
}
