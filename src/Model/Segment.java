package Model;

//Represents a segment between two points
public class Segment extends Path
{
    private String description;
    private double vertical;


    public Segment(String inDescription, Point inStart, Point inEnd) throws InvalidSegmenException
    {
        super(inStart,inEnd);
        if(inDescription.charAt(0) == '*')
        {
            throw new InvalidSegmenException("Invalid Description");
        }

        this.description = inDescription;
        this.vertical = super.getEnd().getAltitude() - super.getStart().getAltitude();

    }
    
    public String getDescription()
    {
        return this.description;
    }

}
