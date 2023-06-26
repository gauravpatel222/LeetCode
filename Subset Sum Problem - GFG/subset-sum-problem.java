//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static Boolean isSubsetSum(int N, int nums[], int sum) {
        int[][] dp = new int[N + 1][sum + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }

        return rec(nums, 0, sum, N, dp);
    }

    public static boolean rec(int[] nums, int i, int sum, int n, int[][] dp) {
        if (sum == 0) {
            return true;
        }

        if (i == n) {
            return false;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }

        boolean aa1 = false;
        if (sum >= nums[i]) {
            aa1 = rec(nums, i + 1, sum - nums[i], n, dp);
        }

        boolean aa2 = rec(nums, i + 1, sum, n, dp);

        if (aa1 || aa2) {
            dp[i][sum] = 1;
        } else {
            dp[i][sum] = 0;
        }

        return aa1 || aa2;
    }
}
