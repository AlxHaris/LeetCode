import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String curr,
                           int open, int close, int n) {

        // If the current string is complete
        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        // Add '(' if we still can
        if (open < n) {
            backtrack(result, curr + "(", open + 1, close, n);
        }

        // Add ')' only if it won't make it invalid
        if (close < open) {
            backtrack(result, curr + ")", open, close + 1, n);
        }
    }
}

