package View;

import Controller.GPSWrapper;
import Controller.InvalidPathFactoryException;
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
        wrapper.attach(trackingProgress);


    }

    @Override
    public void showMenu(Menu menu) throws IOException, InvalidPathFactoryException,InterruptedException
    {
        System.out.println("# Tracking Menu welcome #");
        wrapper.fakeTracking();


    }
}
