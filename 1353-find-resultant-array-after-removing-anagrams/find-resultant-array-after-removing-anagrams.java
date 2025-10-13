class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> l = new ArrayList<>();
        String prev="";
        for(String s:words){
            char arr[]=s.toCharArray();
            Arrays.sort(arr);
            String sorted=new String(arr);
            if(!sorted.equals(prev)){
                l.add(s);
                prev=sorted;
            }
        }
        return l;
        }
    }