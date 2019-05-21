package Model;

import Controller.GPSObserver;
import Controller.GeoUtils;

import java.util.ArrayList;
import java.util.List;

public class TrackingProgress extends GPSObserver
{
    private Point currentLocation;
    private Route chosenRoute;
    private double rHorizontal;
    private double rVerticalClimbing;
    private double rVerticalDescent;
    private GeoUtils geoUtils;

    public TrackingProgress(Route inRoute,GeoUtils geoUtils)
    {
        try
        {
            currentLocation = new Point(0.0,0.0,0.0);
        }
        catch (InvalidPointException e)
        {
            System.out.println("Invalid Point");
        }
        chosenRoute = inRoute;
        rVerticalClimbing = chosenRoute.getClimbing();
        rVerticalDescent = chosenRoute.getDescent();
        this.geoUtils = geoUtils;
        rHorizontal = chosenRoute.getHorizontalDistance(geoUtils);

    }

    public void setCurrentLocation(Point inPoint)
    {
        this.currentLocation = inPoint;
    }


    @Override
    public void update(Point inLocation)
    {
        this.currentLocation = inLocation;
        this.currentLocation.printPoint();

    }
}
