package mazerunner.MazeGenerator;
public class GraphBasedMazeGenerator extends Maze implements MazeGenerator{


    public GraphBasedMazeGenerator(boolean perfect, int width, int height) {
        super(perfect, width, height);
        System.out.println("GraphBasedMazeGenerator: perfect = " + this.isPerfect() + ", width = " + this.getWidth() + ", height = " + this.getHeight());
        this.printMaze();
    }

    public void generateMaze() {
        System.out.println("GraphBasedMazeGenerator: generateMaze()");
    }
}
