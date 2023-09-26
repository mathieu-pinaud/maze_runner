package mazerunner.MazeGenerator;
public class OptimizedMazeGenerator extends Maze implements MazeGenerator {

    public OptimizedMazeGenerator(boolean perfect, int width, int height) {
        super(perfect, width, height);
        System.out.println("OptimizedMazeGenerator: perfect = " + this.isPerfect() + ", width = " + this.getWidth() + ", height = " + this.getHeight());
    } 
    public void generateMaze() {
            System.out.println("OptimizedMazeGenerator: generateMaze()");
        }
    
}
