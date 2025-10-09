class Solution {
    public int subtractProductAndSum(int n) {
     int mul=1;
     int sum=0;
     while(n!=0){
        int num=n%10;
        sum+=num;
        mul*=num;
        n/=10;
     } 
     return mul-sum;
    }
}