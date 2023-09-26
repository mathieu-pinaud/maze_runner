package mazerunner.MazeGenerator;

public class Maze {

    private int width;
    private int height;
    private boolean perfect;
    protected char[][][] maze;

    Maze(boolean perfect, int width, int height) {
        this.width = width;
        this.height = height;
        this.perfect = perfect;
        this.maze = new char[height][width][9];
        this.initMaze();
    }

    private void initMaze() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++){
                for (int k = 0; k < 9; k++) {
                    this.maze[i][j][k] = '#';
                    }
                }
            }
        this.maze[0][0][1] = '.';
        this.maze[this.getHeight() - 1][this.getWidth() - 1][7] = '.';
    }

    public void printMaze() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++){
                for (int k = 0; k < 3; k++) {
                    System.out.print(this.maze[i][j][k]);
                }
            }
            System.out.println("");
            for (int j = 0; j < this.getWidth(); j++){
                for (int k = 3; k < 6; k++) {
                    System.out.print(this.maze[i][j][k]);
                }
            }
            System.out.println("");
            for (int j = 0; j < this.getWidth(); j++){
                for (int k = 6; k < 9; k++) {
                    System.out.print(this.maze[i][j][k]);
                }
            }
            System.out.println("");
        }
    }

    public void eraseWalls(int[] current, int[] next) {
        int[] diff = {next[0] - current[0], next[1] - current[1]};
        if (diff[0] == 1) {
            this.maze[current[0]][current[1]][7] = '.';
            this.maze[next[0]][next[1]][1] = '.';
        } else if (diff[0] == -1) {
            this.maze[current[0]][current[1]][1] = '.';
            this.maze[next[0]][next[1]][7] = '.';
        } else if (diff[1] == 1) {
            this.maze[current[0]][current[1]][5] = '.';
            this.maze[next[0]][next[1]][3] = '.';
        } else if (diff[1] == -1) {
            this.maze[current[0]][current[1]][3] = '.';
            this.maze[next[0]][next[1]][5] = '.';
        }
    }

    public int[][] getNeighbors(int i, int j){
        int[][] tmp = new int[4][2];
        int[][] potentialNeighbors = {{i - 1, j}, {i, j + 1}, {i + 1, j}, {i, j - 1}};
        int count = 0;

        for (int[] neighbor : potentialNeighbors) {
            if (neighbor[0] >= 0 && neighbor[0] < this.getHeight() && neighbor[1] >= 0 && neighbor[1] < this.getWidth()) {
               if (this.maze[neighbor[0]][neighbor[1]][4] == '#') {
                    tmp[count] = neighbor;
                    count++;
               }
            }
            }
        int[][] neighbors = new int[count][2];
        for (int k = 0; k < count; k++) {
            neighbors[k] = tmp[k];
        }
        return neighbors;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public boolean isPerfect() {
        return perfect;
    }
    public void setPerfect(boolean perfect) {
        this.perfect = perfect;
    }
}