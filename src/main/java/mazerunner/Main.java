package mazerunner;

import mazerunner.MazeGenerator.GraphBasedMazeGenerator;
import mazerunner.MazeGenerator.OptimizedMazeGenerator;
import mazerunner.MazeGenerator.SimpleImperfectMazeGenerator;
import mazerunner.MazeGenerator.SimplePerfectMazeGenerator;

public class Main {
    private static void launchGenerator(ParamVerif pv) {
        if (pv.getMethod() == 1) {
            if(pv.getPerfect())
                new SimplePerfectMazeGenerator(pv.getWidth(), pv.getHeight());
            else
                new SimpleImperfectMazeGenerator(pv.getWidth(), pv.getHeight());
        }
        if (pv.getMethod() == 2) {
            new GraphBasedMazeGenerator(pv.getPerfect(), pv.getWidth(), pv.getHeight());
        }
        if (pv.getMethod() == 3) {
            new OptimizedMazeGenerator(pv.getPerfect(), pv.getWidth(), pv.getHeight());
        }
    }

    public static void main(String[] args) {
        ParamVerif pv = new ParamVerif(args);
        launchGenerator(pv);
    }
}