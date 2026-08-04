import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0)
            return 0;

        // Sort by ending coordinate
        Arrays.sort(points, (a, b) -> Long.compare((long) a[1], (long) b[1]));

        int arrows = 1;
        long arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // Current arrow cannot burst this balloon
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}