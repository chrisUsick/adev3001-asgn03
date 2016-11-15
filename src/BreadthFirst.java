import java.util.ArrayList;
import java.util.Map;

/**
 * BreadthFirst - solves a maze using a breadth first algorithm
 *
 * <pre>
 *
 * Assignment: #3
 * Course: ADEV-3001
 * Date Created: November 15, 2016
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
public class BreadthFirst {
    private char[][] maze;

    public BreadthFirst(char[][] maze) {
        this.maze = maze;
    }

    public Stack<Point> breadthFirstSearch(int row, int column) {
        Queue<Point> pointsQueue = new Queue<>();
        Point endingPoint = new Point(row, column);
        pointsQueue.enqueue(endingPoint);
        boolean finished = false;
        while (!pointsQueue.isEmpty()) {
            Point currentPoint = pointsQueue.dequeue();
            finished = validatePoint(currentPoint);
            if (finished) {
                endingPoint = currentPoint;
                break;
            }
            for (Point adjacency: getAdjacencies(currentPoint)) {
                adjacency.setParent(currentPoint);
                pointsQueue.enqueue(adjacency);
            }
        }
        
        Stack<Point> result = new Stack<>();
        if (finished) {
            Point point = endingPoint;
            do {
                result.push(point);
                point = point.getParent();
            } while (point != null);
        }

        
        return reverseStack(result);
    }

    private Stack<Point> reverseStack(Stack<Point> stack) {
        Stack<Point> result = new Stack<>();

        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }
        return result;
    }

    private boolean validatePoint(Point point) {

        boolean done = false;
        if (maze[point.getRow()][point.getColumn()] == MapType.End.toChar()) {
            done = true;
        }
        maze[point.getRow()][point.getColumn()] = MapType.Visited.toChar();
        return done;
    }

    private ArrayList<Point> getAdjacencies(Point point) {
        int[][] movements = {
                {1,0}, {0,1}, {-1,0}, {0,-1}
        };
        ArrayList<Point> points = new ArrayList<>();
        for (int[] movement : movements) {
            int newRow = point.getRow() + movement[0];
            int newColumn = point.getColumn() + movement[1];
            MapType adjacent = MapType.fromChar(maze[newRow][newColumn]);
            if (adjacent == MapType.Blank ||
                    adjacent == MapType.End) {
                points.add(new Point(newRow, newColumn));
            }
        }
        return points;
    }
}
