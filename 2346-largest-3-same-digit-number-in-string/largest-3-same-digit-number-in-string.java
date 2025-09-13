class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
    for(int i=0;i<num.length()-2;i++){
    char ch = num.charAt(i);
    if(ch==num.charAt(i+1) && ch==num.charAt(i+2)){
        String sub = num.substring(i,i+3);
       if(max.isEmpty() || sub.compareTo(max)>0){
        max = sub;
       } 
    }
    } 
    return max;
    }
}