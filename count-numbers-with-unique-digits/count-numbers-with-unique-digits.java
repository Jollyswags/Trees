class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 10;

        
        int ans = 10;
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 10;
        }else{
            int product = 9;
            for(int i = 2; i <= n; i++){
                product = product * (11 - i);
                ans += product;
            }
        }
        return ans;
       
        
    }
}