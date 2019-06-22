package Model;

import Controller.GeoUtils;
import java.util.ArrayList;
import java.util.List;

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

    //Calculates the horizontal distance between the start and end point given a GeoUtils
    @Override
    public double getHorizontalDistance(GeoUtils inGeo)
    {
        Point end = super.getEnd();
        Point start = super.getStart();

        return inGeo.calcMetresDistance(end.getLatitude(),end.getLongitude(),start.getLatitude(),start.getLongitude());
    }


    //Shows the horizontal and vertical distance between any point and the start/end of this segment
    public void printDiff(Point inPoint,GeoUtils inGeo, boolean end)
    {
        Point start;
        if(end)
        {
            start = super.getEnd();
        }
        else
        {
            start = super.getStart();
        }
        double horizontalDiff = inGeo.calcMetresDistance(start.getLatitude(),start.getLongitude(),inPoint.getLatitude(),inPoint.getLongitude());
        horizontalDiff = Math.floor(horizontalDiff*100)/100;
        double verticalDiff = start.getAltitude() - inPoint.getAltitude();
        verticalDiff = Math.floor(verticalDiff*100)/100;

        if(end)
        {
            System.out.println("Distance to end of segment : " + getDescription() + "\n" + "      Horizontal Distance: " + horizontalDiff + "\n" + "      Vertical Distance: " + verticalDiff );
        }
        else
        {
            System.out.println("Distance from segment : " + getDescription() + "\n" + "      Horizontal Distance: " + horizontalDiff + "\n" + "      Vertical Distance: " + verticalDiff );
        }

    }

    //Returns this segment as a list of segments used in recursive function in routes
    @Override
    public List<Segment> segmentList()
    {
        List<Segment> returnList = new ArrayList<>();
        returnList.add(this);
        return returnList;
    }


}
