package Model;

import java.util.LinkedList;
import java.util.List;

//Reprsents routes within the system which can be made up of many routes
public class Route extends Path
{
    private String description;
    private String name;

    private List<Path> route;

    public Route(String inName, String inDescription, Path inSegment)
    {
        //Sets start and end point of route as start and end point of the first segment
        super(inSegment.getStart(),inSegment.getEnd());
        route = new LinkedList<Path>();
        route.add(inSegment);
        this.description = inDescription;
        this.name = inName;

    }

    public void addPath(Path inPath)
    {
        route.add(inPath);
        super.setEnd(inPath.getEnd());
    }

    @Override
    public double horizontalDistance()
    {
        double distance = 0.0;
        for(Path path : route)
        {
            distance += path.horizontalDistance();
        }
        return distance;
    }


}
