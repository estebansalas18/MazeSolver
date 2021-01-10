package mazesolver;
import java.util.Stack;

public class Maze {
    private Stack<Path> paths;
    
    public Maze(){
        paths = new Stack<>();
    }

    public void cleanPaths(){
        Stack<Path> totalPath;
        totalPath = new Stack<>();
        totalPath.push(paths.pop());
        for (Path pathN : paths) {
            Path a = pathN;
            if(!containPath(a, totalPath)){
                totalPath.push(a);
            }
        }
        paths = totalPath;
    }

    public boolean containPath(Path b, Stack<Path> a){
        for (Path pathN : a) {
            if(pathN.isEqualTo(b)){
                return true;
            }
        }
        return false;
    }

    public Stack<Path> getPaths(){
        return paths;
    }

    public void findAllPaths(){
        for(int i = 0; i < 200; i++){
            String[][] laberinto = { 
                {"1","i","1","1","1","1","1","1","1","1","1","1","1"},
                {"1","0","0","0","0","1","0","0","0","0","0","0","1"},
                {"1","0","1","1","0","1","1","0","1","1","1","0","1"},
                {"1","0","0","0","0","1","0","0","1","0","0","0","1"},
                {"1","0","1","1","1","1","0","1","1","1","1","0","1"},
                {"1","0","0","1","0","0","0","1","0","0","0","0","1"},
                {"1","1","0","1","1","1","0","0","0","1","1","1","1"},
                {"1","0","0","0","0","0","0","1","0","0","0","0","1"},
                {"1","1","1","1","1","1","1","1","1","1","1","f","1"},
            };
            Mice stuart = new Mice(laberinto);
            stuart.findPaths();
            paths.push(stuart.getPath());
        }
    }

    public void showPaths(){
        for (int i = 0 ; i < paths.size(); i++) {
            printPath(paths.elementAt(i),i);
        }
    }
    
    public void showPaths(int a){
        printPath(paths.elementAt(a), a);
    }

    public void printMaze(String[][] a){
        final String CYAN = "\u001B[36m";
        final String MORADO = "\u001B[35m";
        final String RESET = "\u001B[0m";
        final String BLANCO = "\u001B[37m";
        final String AMARILLO = "\u001B[33m";
        for (int i = 0; i < a.length; i++) { 
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j]=="0"){
                    System.out.print(BLANCO + a[i][j] + RESET + " ");
                }else if(a[i][j]=="1"){
                    System.out.print(MORADO + a[i][j] + RESET + " ");
                }else if(a[i][j]=="2"){
                    System.out.print(CYAN + a[i][j] + RESET + " ");
                }else if(a[i][j]=="i" || a[i][j]=="f"){
                    System.out.print(AMARILLO + a[i][j] + RESET + " ");
                }else{
                    System.out.print(a[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public void shortestPaths(){
        for (int i = 0 ; i < paths.size(); i++) {
            if(paths.elementAt(i).isShortest(paths)){
                printPath(paths.elementAt(i),i);
            }
        }
    }
    
    public void printPath(Path path, int a){
        int x, y;
        System.out.println();
        System.out.println("Camino "+ (a+1));
        System.out.println();
        String[][] laberinto = { 
            {"1","i","1","1","1","1","1","1","1","1","1","1","1"},
            {"1","0","0","0","0","1","0","0","0","0","0","0","1"},
            {"1","0","1","1","0","1","1","0","1","1","1","0","1"},
            {"1","0","0","0","0","1","0","0","1","0","0","0","1"},
            {"1","0","1","1","1","1","0","1","1","1","1","0","1"},
            {"1","0","0","1","0","0","0","1","0","0","0","0","1"},
            {"1","1","0","1","1","1","0","0","0","1","1","1","1"},
            {"1","0","0","0","0","0","0","1","0","0","0","0","1"},
            {"1","1","1","1","1","1","1","1","1","1","1","f","1"},
        };
        for(int i = 0; i < path.getSteps().size(); i++){
            x = path.getSteps().elementAt(i).getX();
            y = path.getSteps().elementAt(i).getY();
            if(laberinto[y][x] != "f"){
                laberinto[y][x] = "2";
            } 
        }
        printMaze(laberinto);
    }
}
