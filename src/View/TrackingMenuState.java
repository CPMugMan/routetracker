package View;

import Controller.GPSWrapper;
import Controller.InvalidPathFactoryException;
import Controller.RouteManager;
import Model.Route;
import Model.TrackingProgress;

import java.io.IOException;

public class TrackingMenuState implements MenuState
{
    private TrackingProgress trackingProgress;
    private GPSWrapper wrapper;


    public TrackingMenuState(TrackingProgress trackingProgress, GPSWrapper wrapper)
    {
        this.trackingProgress = trackingProgress;
        this.wrapper = wrapper;

    }

    @Override
    public void showMenu(Menu menu) throws IOException, InvalidPathFactoryException
    {
        System.out.println("Hello");

    }
}
