package mazerunner.MazeGenerator;
public class SimpleImperfectMazeGenerator extends SimpleMaze implements MazeGenerator{

    public SimpleImperfectMazeGenerator(int width, int height) {
        super(false, width, height);
        generateMaze();
        printMaze();
    }
}
