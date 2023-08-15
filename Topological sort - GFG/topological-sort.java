//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> nums) 
    
    {
        int[] indeg=new int[n];
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                indeg[nums.get(i).get(j)]+=1;
            }
        }
        int[] ans=new int[n];
        
        bfs(nums,indeg,ans);
        return ans;

    }
    public static void bfs(ArrayList<ArrayList<Integer>> nums,int[] indeg,int[] ans){
            Queue<Integer> q=new LinkedList<>();
            for(int i=0;i<indeg.length;i++){
                if(indeg[i]==0){
                    q.add(i);
                }
            }
            int index=0;
            while(!q.isEmpty()){
                int ss=q.poll();
                ans[index++]=ss;
                for(int i=0;i<nums.get(ss).size();i++){
                    indeg[nums.get(ss).get(i)]-=1;
                    if(indeg[nums.get(ss).get(i)]==0){
                        q.add(nums.get(ss).get(i));
                    }
                }
            }
    }
}



/*        int[] vis=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                rec(nums,stack,vis,i);
            }
        }
        int[] ans=new int[n];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++]=stack.pop();
        }
        return ans;
    }
    public static void rec(ArrayList<ArrayList<Integer>> nums,Stack<Integer> stack,int[] vis,int i){
        vis[i]=1;
        for(int index=0;index<nums.get(i).size();index++){
            if(vis[nums.get(i).get(index)]==0){
                rec(nums,stack,vis,nums.get(i).get(index));
                
            }
           
        }
         stack.push(i);*/