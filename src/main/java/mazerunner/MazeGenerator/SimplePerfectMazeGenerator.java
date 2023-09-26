package mazerunner.MazeGenerator;

public class SimplePerfectMazeGenerator extends SimpleMaze implements MazeGenerator {

    public SimplePerfectMazeGenerator(int width, int height) {
        super(true, width, height);
        generateMaze();
        printMaze();
    }
}
