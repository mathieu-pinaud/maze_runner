package mazerunner.MazeGenerator;
public class GraphBasedMazeGenerator extends GraphMaze implements MazeGenerator{


    public GraphBasedMazeGenerator(boolean perfect, int width, int height) {
        super(perfect, width, height);
        generateMaze();
        if (!this.isPerfect()) {
            makeImperfect();
        }
        printMaze();
    }
}
