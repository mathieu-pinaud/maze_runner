package mazerunner.MazeGenerator;

public class OptimizedMazeGenerator extends GraphMaze implements MazeGenerator {

    public OptimizedMazeGenerator(boolean perfect, int width, int height) {
        super(perfect, width, height);
        double i = System.nanoTime();
        generateMaze();
        if (!this.isPerfect()) {
            makeImperfect();
        }
        i = (System.nanoTime() - i) / 1000000;
        printMaze();
        System.out.println("Temps de generation: " + i + " millisecondes");
    } 
}
