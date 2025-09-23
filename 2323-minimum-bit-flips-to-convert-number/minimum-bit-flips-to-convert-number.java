class Solution {
    public int minBitFlips(int start, int goal) {
        String str1 = Integer.toBinaryString(start);
        String str2 = Integer.toBinaryString(goal);
        int n1 = str1.length();
        int n2 = str2.length();
        int count = 0,i=n1-1,j=n2-1;
        while(i>=0 && j>=0){
            if(str1.charAt(i) != str2.charAt(j)){
                count++;
            }
            i--;
            j--;
        }
        while(i>=0){
            if(str1.charAt(i)=='1'){
                count++;
            }
            i--;
        }
        while(j>=0){
            if(str2.charAt(j)=='1'){
                count++;
            }
            j--;
        }   
        return count;        
    }
}