class Solution {

    public int countTrapezoids(int[][] points) {

        long MOD = 1000000007L;

        java.util.HashMap<Integer, Long> map = new java.util.HashMap<>();

        // Count points by y-coordinate
        for (int i = 0; i < points.length; i++) {
            int y = points[i][1];
            map.put(y, map.getOrDefault(y, 0L) + 1);
        }

        long answer = 0;
        long prefixSum = 0;

        // Combine pairs from different horizontal lines
        for (long count : map.values()) {
            if (count >= 2) {
                long pairs = (count * (count - 1)) / 2;
                pairs %= MOD;

                answer = (answer + pairs * prefixSum) % MOD;
                prefixSum = (prefixSum + pairs) % MOD;
            }
        }

        return (int) answer;
    }
}
