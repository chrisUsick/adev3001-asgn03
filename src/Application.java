import java.io.IOException;
import java.util.ArrayList;

/**
 * Application - the main application for the assignment
 *
 * <pre>
 *
 * Assignment: #2
 * Course: ADEV-3001
 * Date Created: October 24, 2016
 *
 * Revision Log
 * Who          When    Reason
 * --------- ---------- ----------------------------------
 *
 * </pre>
 *
 * @author Chris Usick
 * @version 1.0
 *
 */
public class Application {

    /**
     * Runs the maze finder UI, solves the maze and prints the output
     * @param args  command line arguments
     */
    public static void main(String[] args) throws IOException {
        String filename = P4Utils.choose();

        if (filename != null) {
//            System.out.println("Filename: "  + filename);
//            MazeData mazeData = new MazeData(filename);
//            DepthFirst depthFirst = new DepthFirst(mazeData.getMaze());
//            Point startingPoint = mazeData.getStartingPoint();
//            Stack<Point> solution = depthFirst.depthFirstSearch(startingPoint.getRow(), startingPoint.getColumn());
//            if (solution.size() > 0) {
//                printSolution(mazeData, solution);
//            } else {
//                System.out.println("There was no solution to the maze");
//            }
        } else {
            // user clicked cancel or dismissed the dialog
            System.out.println("no Filename");
        }
    }

    /**
     * Prints the solution to a maze
     * @param mazeData  The maze data
     * @param solution  The stack of points that lead to the solution
     */
    private static void printSolution(MazeData mazeData, Stack<Point> solution) {
        ArrayList<Point> points = new ArrayList<>();
        while (!solution.isEmpty()) {
            Point point = solution.pop();
            points.add(point);
            System.out.println(point.toString());
        }
        printMaze(points, mazeData.getMaze());
    }

    /**
     * Adds the path traveled to the maze array
     * @param points    points traveled to reach the end
     * @param maze      maze 2d array
     */
    private static void printMaze(ArrayList<Point> points, char[][] maze) {
        for (Point point : points) {
            maze[point.getRow()][point.getColumn()] = MapType.Path.toChar();
        }

        System.out.println("Maze: ");
        for (char[] row : maze) {
            System.out.println(new String(row));
        }
    }


}

