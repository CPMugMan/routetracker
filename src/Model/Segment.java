package Model;

import Controller.GeoUtils;

//Represents a segment between two points
public class Segment extends Path
{
    private String description;

    //Represents difference between the end and start points altitude
    private double verticalDif;

    // Will be true if verticalDif is positive and negative is verticalDif is negative
    private boolean polarity;


    public Segment(String inDescription, Point inStart, Point inEnd) throws InvalidSegmentException
    {
        super(inStart,inEnd);
        if(inDescription.charAt(0) == '*')
        {
            throw new InvalidSegmentException("Invalid Description");
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

    @Override
    public double getHorizontalDistance(GeoUtils inGeo)
    {
        Point end = super.getEnd();
        Point start = super.getStart();

        return inGeo.calcMetresDistance(end.getLatitude(),end.getLongitude(),start.getLatitude(),start.getLongitude());
    }

}
