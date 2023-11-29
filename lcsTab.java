public class lcsTab {
    public static int lcs(String str1 , String str2, int n , int m,int dp[][]){
       for(int i=1;i<n+1;i++){
        for(int j=1;j<m+1;j++){
            if(str1.charAt(i-1) == str2.charAt(j-1)){//same
                dp[i][j] = dp[i-1][j-1] + 1;
            }else{//different
                int ans1 = dp[i-1][j];
                int ans2 = dp[i][j-1];
                dp[i][j] = Math.max(ans1, ans2);
            }
        }
       }
       return dp[n][m];
    }
    public static void main(String args[]){
        String str1 = "abcdge";
        String str2 = "abedg";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        //initialise
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][0] = 0;
                dp[0][j] = 0;
            }
        }
        System.out.println(lcs(str1, str2, str1.length(), str2.length(),dp));
    }
}
//the time complexity of this code is O(n*m)
