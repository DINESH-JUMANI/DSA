package Graphs;
// LEETCODE 733
class FloodFillAlgorithm {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor)
            dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void dfs(int[][] image, int row, int column, int oldColor, int newColor) {
        if (row < 0 || column < 0 || row >= image.length || column >= image[0].length || image[row][column] != oldColor) return;
        image[row][column] = newColor;
        dfs(image, row, column - 1, oldColor, newColor);
        dfs(image, row, column + 1, oldColor, newColor);
        dfs(image, row - 1, column, oldColor, newColor);
        dfs(image, row + 1, column, oldColor, newColor);
    }
}