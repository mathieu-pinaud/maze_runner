package mazerunner.MazeGenerator;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class GraphMaze extends Maze  {

    protected Stack<int[][]> graph = new Stack<>();
    private int[][] cellWeight = new int[this.getHeight()][this.getWidth()];

    GraphMaze(boolean perfect, int width, int height) {
        super(perfect, width, height);
        initWeights();
        generateGraph();
    }

    void makeImperfect() {
        Random rand = new Random();
        int i = rand.nextInt(1, this.getHeight() - 1);
        int j = rand.nextInt(1, this.getWidth() - 1);
        int[] current = {i, j};
        while (!hasWall(current)) {
            i = rand.nextInt(1, this.getHeight() - 1);
            j = rand.nextInt(1, this.getWidth() - 1);
            current = new int[]{i, j};
        }
        eraseWalls(current, new int[]{i, j + 1});
        eraseWalls(current, new int[]{i + 1, j});
        eraseWalls(current, new int[]{i, j - 1});
        eraseWalls(current, new int[]{i - 1, j});
    }

    boolean hasWall(int[] cell) {
        if (this.maze[cell[0]][cell[1]][1] == '#' || this.maze[cell[0]][cell[1]][3] == '#' || this.maze[cell[0]][cell[1]][5] == '#' || this.maze[cell[0]][cell[1]][7] == '#') {
            return true;
        }
        return false;
    }

    void initWeights() {
        int k = 0;
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++){
                this.cellWeight[i][j] = k;
                k += 1;
            }
        }
    }

    private void updateWeights(int oldWeight, int newWeight) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++){
                if (this.cellWeight[i][j] == oldWeight) {
                    this.cellWeight[i][j] = newWeight;
                }
            }
        }
    }

    public void generateMaze() {
        while (!this.graph.empty()) {
            int[][] edge = this.graph.pop();
            if (this.cellWeight[edge[0][0]][edge[0][1]] != this.cellWeight[edge[1][0]][edge[1][1]]) {
                eraseWalls(edge[0], edge[1]);
                updateWeights(this.cellWeight[edge[0][0]][edge[0][1]], this.cellWeight[edge[1][0]][edge[1][1]]);
                this.maze[edge[0][0]][edge[0][1]][4] = '.';
                this.maze[edge[1][0]][edge[1][1]][4] = '.';
            }
        }
    }
    
    private void generateGraph() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++){
                if (j < this.getWidth() - 1) {
                    this.graph.push(new int[][]{{i, j}, {i, j + 1}});
                }
                if (i < this.getHeight() - 1) {
                    this.graph.push(new int[][]{{i, j}, {i + 1, j}});
                }
            }
        }
        Collections.shuffle(this.graph);
    }
}
