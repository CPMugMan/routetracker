package Model;

import Controller.GeoUtils;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

//Reprsents routes within the system which can be made up of many segments and/or subroutes
public class Route extends Path
{
    private String description;
    private String name;

    //sum of all the altitudes in this route that are positive
    private double climbing;

    //Sum of all the altitudes in this route that are negative
    private double descent;

    private List<Path> route;

    public Route(String inName, String inDescription, Path inSegment)
    {
        //Sets start and end point of route as start and end point of the first segment/path passed in
        super(inSegment.getStart(),inSegment.getEnd());
        route = new LinkedList<Path>();
        route.add(inSegment);
        this.description = inDescription;
        this.name = inName;

        climbing = 0.0;
        descent = 0.0;

        addVerticalDistance(inSegment);
    }

    public Route()
    {
        start = null;
        end = null;
        climbing = 0.0;
        descent = 0.0;
        name = null;
        description = null;
        route = new LinkedList<Path>();
    }

    public void setName(String inName)
    {
        this.name = inName;
    }

    public void setDescription(String inDescription)
    {
        this.description = inDescription;
    }

    public void addPath(Path inPath)
    {
        route.add(inPath);
        if(route.size() == 1)
        {
            super.setStart(inPath.getStart());
        }
        addVerticalDistance(inPath);
        super.setEnd(inPath.getEnd());
    }

    public String getName()
    {
        return this.name;
    }

    public double getClimbing()
    {
        return Math.floor(climbing*100)/100;
    }

    public double getDescent()
    {
        return Math.floor(descent*100)/100;
    }

    @Override
    public double getHorizontalDistance(GeoUtils inGeo)
    {
        double horizontalDistance = 0.0;
        for(Path path : route)
        {
            horizontalDistance += path.getHorizontalDistance(inGeo);

        }
        return horizontalDistance;
    }



    //Checks added path to see if should add vertical distance to climbing or descent
    public void addVerticalDistance(Path inPath)
    {
        if(inPath instanceof Segment)
        {
            if(((Segment) inPath).getPolarity())
            {
                climbing += ((Segment) inPath).getVerticalDif();
            }
            else
            {
                descent += Math.abs(((Segment)inPath).getVerticalDif());
            }
        }
        else
        {
            climbing +=((Route)inPath).getClimbing();
            descent +=((Route)inPath).getDescent();
        }

    }



}
