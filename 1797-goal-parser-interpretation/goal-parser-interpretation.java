class Solution {
    public String interpret(String command) {
    String s = command.replace("()","o");
    String ss = s.replace("(al)","al");
    return ss;
    }
}