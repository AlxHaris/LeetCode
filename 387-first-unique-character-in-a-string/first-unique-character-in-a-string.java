class Solution {
    public int firstUniqChar(String s) {
    for(int i=0;i<s.length();i++){
        boolean found = false;
        for(int j=0;j<s.length();j++){
            if(s.charAt(i)==s.charAt(j) && i!=j) {
             found = true;;
             break;
        }
            
        }
        if(!found) return i;
    }
    return -1;
    }
}