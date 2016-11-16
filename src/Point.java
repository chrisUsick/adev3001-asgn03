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
    private int parentRow;
    private int parentColumn;

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
     * Constructs a new point, setting its parent and its own row and column
     * @param row               self row
     * @param column            self column
     * @param parentRow         parent row
     * @param parentColumn      parent column
     */
    public Point(int row, int column, int parentRow, int parentColumn) {
        this(row, column);
        this.parentRow = parentRow;
        this.parentColumn = parentColumn;
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
     * get the row of this point's parent
     * @return  the column
     */
    public int getParentRow() {
        return parentRow;
    }

    /**
     * get the column of this point's parent
     * @return  the column
     */
    public int getParentColumn() {
        return parentColumn;
    }

    /**
     * sets the row of this point's parent
     * @param parentRow     value to set
     */
    public void setParentRow(int parentRow) {
        this.parentRow = parentRow;
    }

    /**
     * sets the column of this point's parent
     * @param parentColumn value to set
     */
    public void setParentColumn(int parentColumn) {
        this.parentColumn = parentColumn;
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
