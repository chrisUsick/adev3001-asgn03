import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * MazeData - Parses data out of a maze file and provides convenient getters
 *
 * <pre>
 *
 * Assignment: #2
 * Course: ADEV-3001
 * Date Created: October 25, 2016
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
public class MazeData {

    private char[][] maze;
    private Point startingPoint;

    /**
     * Constructs a MazeData object. Reads the file specified to populate properties
     * @param filename  file to read
     */
    public MazeData(String filename) throws IOException {
        try {
            Path file = Paths.get(filename);
            ArrayList<String> content = new ArrayList<String>(Files.readAllLines(file));
            String sizeString = content.remove(0);
            String startingString = content.remove(0);
            int[] starting = parseIntArray(startingString);
            startingPoint = new Point(starting[0], starting[1]);
            maze = generateArray(sizeString, content);
        } catch (IOException e ) {
            System.out.println("Error loading map");
            throw new IOException("Error loading map", e);
        }
    }

    /**
     * Create char[][] to represent the maze
     * @param sizeString    the string value of the dimensions of the maze
     * @param rows          list of rows of the maze
     * @return              2d array representing the maze
     */
    private static char[][] generateArray(String sizeString, ArrayList<String> rows) {
        try {
            int[] size = parseIntArray(sizeString);
            char[][] maze = new char[size[0]][size[1]];
            for (int i = 0; i < rows.size(); i++) {
                String row = rows.get(i);
                maze[i] = row.toCharArray();
            }

            return maze;
        } catch (Exception e) {
            System.out.println("Error parsing app");
            return null;
        }
    }

    /**
     * Transform space separated string into an array of int values
     * @param stringValue   space separated string
     * @return              parsed integers array
     */
    private static int[] parseIntArray(String stringValue) {
        String[] values = stringValue.split(" ");
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            result[i] = Integer.parseInt(value);
        }
        return result;
    }

    /**
     * Gets the maze
     * @return  the maze in the char[][] format
     */
    public char[][] getMaze() {
        return maze;
    }

    /**
     * Gets the starting point
     * @return the starting point of the maze
     */
    public Point getStartingPoint() {
        return startingPoint;
    }
}
