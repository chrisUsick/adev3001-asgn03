/**
 * Point - Representation of a 2D point
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
public class Point {
    private int row;
    private int column;
    private Point parent;

    /**
     * Constructs a new point, setting the row and column
     * @param currentRow        the current row
     * @param currentColumn     the current column
     */
    public Point(int currentRow, int currentColumn){
        row = currentRow;
        column = currentColumn;
    }

    /**
     * Constructs a new point, setting its parent and its row and column
     * @param row               self row
     * @param column            self column
     * @param parent            the parent
     */
    public Point(int row, int column, Point parent) {
        this(row, column);
        this.parent = parent;
    }

    /**
     * gets the row of this point
     * @return  the row
     */
    public int getRow() {
        return row;
    }

    /**
     * get the column of this point
     * @return  the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * gets the parent point
     * @return the parent
     */
    public Point getParent() {
        return parent;
    }

    /**
     * sets the parent
     * @param parent the new parent
     */
    public void setParent(Point parent) {
        this.parent = parent;
    }

    /**
     * make a string representation of the point
     * @return  a string representing the point
     */
    @Override
    public String toString() {
        return String.format("[%d, %d]", row, column);
    }
}
