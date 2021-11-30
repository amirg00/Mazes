/***********************************************************************
 * @author Amir Gillette
 * @course Algorithms 1
 ***********************************************************************/
import java.util.Scanner;

public class mainMaze {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers (m and n accordingly):");
        int m = input.nextInt();
        int n = input.nextInt();
        Graph g = new Graph(m,n);
        MazeGUI gui = new MazeGUI(g);
        gui.runGui();
    }
}
