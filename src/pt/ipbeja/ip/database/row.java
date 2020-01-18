package pt.ipbeja.ip.database;

import java.util.ArrayList;
import java.util.List;

public class row{

    private List<String> elements;

    /**
     * Creates an empty row
     */
    public row()
    {
        this.elements = new ArrayList<>();
    }

    /**
     * Adds one element to the row
     * param newElement the element to be added
     */
    public void add(String newElement)
    {
        this.elements.add(newElement);
    }

    /**
     * Get the row elements in a List of Strings
     * @return the list with the row elements
     */


    public List<String> getColumns()
    {
        return this.elements;
    }

    /**
     * Get the number of elements in the row
     * @return the number of row elements
     */
    public int getNColumns()
    {
        return this.elements.size();
    }

    /**
     * Converts the row to a string with all its elements
     */
    public String toString()
    {
        return this.elements.toString();
    }

}