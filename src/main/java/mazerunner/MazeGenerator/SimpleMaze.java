package mazerunner.MazeGenerator;

import java.util.Random;
import java.util.Stack;

public class SimpleMaze extends Maze {
    public SimpleMaze(boolean perfect, int width, int height) {
        super(perfect, width, height);
    }

    public void generateMaze() {
        Random rand = new Random();
        Stack<int[]> stack = new Stack<int[]>();

        stack.push(new int[]{0, 0});
        this.maze[0][0][4] = '.';
        
        while (!stack.empty()) {
            int[] current = stack.peek();
            if ((current[0] == this.getHeight() - 1 && current[1] == this.getWidth() - 1) && !this.isPerfect()) {
                break;
            }
            int[][] neighbors = getNeighbors(current[0], current[1]);
            if(neighbors.length > 0) {
                int[] next = neighbors[rand.nextInt(neighbors.length)];
                eraseWalls(current, next);
                this.maze[next[0]][next[1]][4] = '.';
                stack.push(next);
            } else {
                stack.pop();
            }
        }
    }
}
