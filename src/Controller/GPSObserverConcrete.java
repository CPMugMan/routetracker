package Controller;

import Model.Point;
import Model.TrackingProgress;

public class GPSObserverConcrete extends GPSObserver
{
    public GPSObserverConcrete(GPSWrapper inGPSWrapper)
    {
        this.wrapper = inGPSWrapper;
        this.wrapper.attach(this);
    }

    @Override
    public void update(Point inLocation)
    {

    }
}
