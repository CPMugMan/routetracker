package Controller;

import Model.InvalidPointException;
import Model.Point;
import Model.Route;
import Model.Segment;

import java.util.List;

//Class that keeps track of the user while they are tracking through the chosen route implements GPSObserver as
//it gets updated when GPSWrapper when new locations come in
public class TrackingProgress implements GPSObserver
{
    private Point currentLocation;
    private GeoUtils geoUtils;
    private List<Segment> segmentList;
    private int currentSegment;
    private boolean finished;
    private String routeName;

    public TrackingProgress(Route inRoute, GeoUtils geoUtils,String inRouteName)
    {
        try
        {
            currentLocation = new Point(0,0,0);
        }
        catch (InvalidPointException e)
        {
            System.out.println("Invalid Point");
        }

        this.geoUtils = geoUtils;
        segmentList = inRoute.segmentList();
        currentSegment = 0;
        finished = false;
        routeName = inRouteName;

    }

    @Override
    public void update(Point inLocation)
    {
        this.currentLocation = inLocation;
        wayPointCheck();
        if(currentSegment == segmentList.size())
        {
            System.out.println("You have completed your trip goodbye");
            finished = true;
        }
        else
        {
            System.out.print("Persons location : ");
            this.currentLocation.printPoint();
            System.out.println("Current Segment : " + segmentList.get(currentSegment).getDescription());
            showSegmentInformation(inLocation);
        }

    }

    //Checks to see if the user has reached the end of the current segment
    public void wayPointCheck()
    {
        Point segmentPoint = segmentList.get(currentSegment).getEnd();
        double hDiff = geoUtils.calcMetresDistance(segmentPoint.getLatitude(),segmentPoint.getLongitude(),
                currentLocation.getLatitude(),currentLocation.getLongitude());
        double vDiff = segmentPoint.getAltitude() - currentLocation.getAltitude();

        //Should be && but || for testing purposes as horizontal diff function provides huge change even if diff between
        //Lat and long is 0.1
        if(Math.abs(hDiff) < 10.0 || Math.abs(vDiff) < 2.0)
        {
                System.out.println("User has reached next waypoint");
                currentSegment++;

        }
    }

    public boolean isFinished()
    {
        return finished;
    }

    //Displays information about how far the user is from remaining segments in the route
    public void showSegmentInformation(Point inLocation)
    {
        segmentList.get(currentSegment).printDiff(inLocation,geoUtils,true);

        for(int i = currentSegment +1 ; i < segmentList.size() ; i++)
        {
            segmentList.get(i).printDiff(inLocation,geoUtils,false);
        }
        System.out.print("\n");

    }

    //For manual user input checks if entered name is part of this routes segment
    public boolean containsSegment(String inString)
    {
        for(Segment segment : segmentList)
        {
            if(segment.getDescription().equals(inString))
            {
                return true;
            }
        }
        return false;
    }

    //Updates location manually when user enters input rather than from GPSWrapper
    public void updateManually(String inSegment)
    {
        for(Segment segment: segmentList)
        {
            if(segment.getDescription().equals(inSegment))
            {
                update(segment.getEnd());
            }
        }
    }

    public void reset()
    {
        currentSegment = 0;
        finished = false;
    }

    public GeoUtils getGeoUtils()
    {
        return geoUtils;
    }

    public String getRouteName()
    {
        return routeName;
    }






}
