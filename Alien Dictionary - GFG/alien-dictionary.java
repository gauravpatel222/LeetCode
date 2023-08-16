//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<K;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<dict.length-1;i++){
            for(int j=0;j<dict[i].length()&&j<dict[i+1].length();j++){
                if(dict[i].charAt(j)!=dict[i+1].charAt(j)){
                    int x=dict[i].charAt(j)-97;
                    int y=dict[i+1].charAt(j)-97;
                    list.get(x).add(y);
                    break;
                }
            }
        }
        int[] vis=new int[K];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<K;i++){
            if(vis[i]==0){
                rec(stack,vis,list,i);
            }
        }
        String ans="";
        while(!stack.isEmpty()){
            int asciiValue = stack.pop()+97;  // Example ASCII value

// Convert ASCII value to character using type casting
char character = (char) asciiValue;

            ans+=character;
        }
      //  System.out.print(ans+"  ");
        return ans;
        
        
    }
    public static void rec(Stack<Integer> stack,int[] vis,ArrayList<ArrayList<Integer>> list,int i){
        if(vis[i]==1) return ;
        
       vis[i]=1;
        for(int index=0;index<list.get(i).size();index++){
            if(vis[list.get(i).get(index)]==0){
                rec(stack,vis,list,list.get(i).get(index));
            }
        }
        stack.push(i);
    }
}







