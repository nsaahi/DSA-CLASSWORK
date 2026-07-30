class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];

        if(oldColor == color)
            return image;

        dfs(image, sr, sc, oldColor, color);

        return image;
    }

    private void dfs(int[][] image, int i, int j,
                     int oldColor, int newColor) {

        if(i < 0 || j < 0 ||
           i >= image.length ||
           j >= image[0].length)
            return;

        if(image[i][j] != oldColor)
            return;

        image[i][j] = newColor;

        dfs(image, i - 1, j, oldColor, newColor);
        dfs(image, i + 1, j, oldColor, newColor);
        dfs(image, i, j - 1, oldColor, newColor);
        dfs(image, i, j + 1, oldColor, newColor);
    }
}