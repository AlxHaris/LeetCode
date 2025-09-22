class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
    Set<Character>  set = new HashSet<>();
    for(char ch: allowed.toCharArray()){
        set.add(ch);
    }   
    int c=0;
    for(int i=0;i<words.length;i++){
        String ss=words[i];
        int l=0;
    for(char ccc:ss.toCharArray()){
        if(!set.contains(ccc)){
            break;
        }
        else{
            l++;
        }
    }
    if(l==ss.length()) c++;
    }
    return c;
    }
}