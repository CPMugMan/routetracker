package Model;

//Represents a segment between two points
public class Segment extends Path
{
    private String description;

    //Represents difference between the end and start points altitude
    private double verticalDif;

    // Will be true if verticalDif is positive and negative is verticalDif is negative
    private boolean polarity;


    public Segment(String inDescription, Point inStart, Point inEnd) throws InvalidSegmenException
    {
        super(inStart,inEnd);
        if(inDescription.charAt(0) == '*')
        {
            throw new InvalidSegmenException("Invalid Description");
        }

        this.description = inDescription;
        this.verticalDif =  inEnd.getAltitude() - inStart.getAltitude();

        if(verticalDif > 0)
        {
            polarity = true;
        }
        else
        {
            polarity = false;
        }

    }

    public String getDescription()
    {
        return this.description;
    }

    public boolean getPolarity()
    {
        return polarity;
    }

    public double getVerticalDif()
    {
        return verticalDif;
    }

}
