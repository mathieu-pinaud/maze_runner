package mazerunner;
// Purpose: Verifies the parameters of the program.

public class ParamVerif {  

    private int width;
    private int height;
    private boolean perfect;
    private int method;

    ParamVerif(String[] args) {
        try {
            if (args.length != 4) {
                throw new Exception("Utilisation : java -jar MazeGenerator [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        try {
            this.width = Integer.parseInt(args[0]);
            this.height = Integer.parseInt(args[1]);
            if (Integer.parseInt(args[1]) < 5 || Integer.parseInt(args[0]) < 5) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5");
            System.exit(1);
        }
        try {
            if (!args[2].equals("perfect") && !args[2].equals("imperfect")) {
                throw new Exception();
            }
            if (!args[3].equals("simple") && !args[3].equals("graph") && !args[3].equals("optimized")) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.");
            System.exit(1);
        }
        if (args[2].equals("perfect")) {
            this.perfect = true;
        } else {
            this.perfect = false;
        }
        if (args[3].equals("simple")) {
            this.method = 1;
        } else if (args[3].equals("graph")) {
            this.method = 2;
        } else {
            this.method = 3;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getPerfect() {
        return this.perfect;
    }

    public int getMethod() {
        return this.method;
    }
}