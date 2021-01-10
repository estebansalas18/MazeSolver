package mazesolver;
import java.util.Scanner;

public class Program{
    
    public static Maze a = new Maze();
    
    public static void main (String[] args){
        a.findAllPaths();
        a.cleanPaths();
        System.out.println(a.getPaths().toString());
        start();  
    };

    public static void print(Object x){
        System.out.println(x);
    }
    
    public static void start(){
        boolean continuar;
        continuar = false;
        print("= = = = = = = = = = = = = = = = =");
        print("             MAZE                ");
        print("            SOLVER               ");
        print("= = = = = = = = = = = = = = = = =");
        print("");
        print("Se han encontrado " + a.getPaths().size() + " soluciones");
        print("para el laberinto: ");
        while(!continuar){
            print("");
            print("= = M E N U  P R I N C I P A L = =");
            print("Escoja como desea visualizarlas: ");
            print("> 1. Ver todas.");
            print("> 2. Ver una solucion.");
            print("> 3. Ver la mas corta.");
            print("> 4. Salir.");
            switch(leerInt("Ingrese el numero de la accion: ")){
                case 1:
                    print("");
                    a.showPaths();
                    break;
                case 2:
                    print("");
                    a.showPaths(leerInt("Digite el numero de la solucion que desea ver:")-1);
                    break;
                case 3:
                    print("");
                    print("El camino mas corto es: ");
                    a.shortestPaths();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    print("Opcion invalida. Intente de nuevo");
                    break;
            }
        }
    }
    
    public static int leerInt(String mensaje){
        System.out.print(mensaje);
        Scanner leer = new Scanner (System.in);
        int x;     
        x = leer.nextInt();
        return x;
    }
}