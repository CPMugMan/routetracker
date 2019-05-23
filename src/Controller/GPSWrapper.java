package Controller;

import Model.InvalidPointException;
import Model.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Event source for observers, when new location is received notifies all observers with new location details
public class GPSWrapper extends GPSLocator
{
    private List<GPSObserver> observers;


    public GPSWrapper()
    {
        observers = new ArrayList<>();

    }

    public void notify(Point inLocation)
    {
        for(GPSObserver observer : observers)
        {
            observer.update(inLocation);
        }
    }

    public void attach(GPSObserver observer)
    {
        observers.add(observer);
    }


    @Override
    protected void locationReceived(double latitude, double longitude, double altitude)
    {
        //Invalid points sent by the server are disregarded
        try
        {
            Point point = new Point(longitude,latitude,altitude);
            notify(point);
        }
        catch (InvalidPointException e)
        {
            System.out.println("Point received was out of bounds, not recorded");
        }


    }

    //Fakes Central server sending GPS information if a hiker was going along the mainRoute
    public void fakeTracking() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.96, 115.80, 63.0);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.95, 115.78, 45.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.95, 115.77, 44.8);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.93, 115.76, 43.0);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.93, 115.75, 47.1);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.93, 115.72, 40.01);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 55.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 71.0);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 85.0);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 108.0);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 131.9 );
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.92, 115.74, 128.1);




    }


}
