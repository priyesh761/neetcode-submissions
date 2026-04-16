/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    private Node construct(int[][] grid, int stx, int sty, int enx, int eny) {
        if(stx==enx && sty==eny) return new Node(grid[stx][sty]==1, true);

        int nx = stx+(enx-stx)/2;
        int ny = sty+(eny-sty)/2;

        Node topLeft = construct(grid, stx, sty, nx, ny);
        Node topRight = construct(grid, stx, ny+1, nx, eny);
        Node bottomLeft = construct(grid, nx+1, sty, enx, ny);
        Node bottomRight = construct(grid, nx+1, ny+1, enx, eny);

        boolean isLeaf = topLeft.isLeaf
            && topRight.isLeaf
            && bottomLeft.isLeaf
            && bottomRight.isLeaf
            && topLeft.val == topRight.val
            && topLeft.val == bottomLeft.val
            && topLeft.val == bottomRight.val;
        if(isLeaf) {
            return new Node(grid[stx][sty]==1, true);
        }
        return new Node(false, false,
            topLeft, topRight, bottomLeft, bottomRight);
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        
        return construct(grid, 0, 0, n-1, n-1);
    }
}