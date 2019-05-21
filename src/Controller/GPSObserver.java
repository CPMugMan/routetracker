package Controller;

import Model.Point;
import Model.TrackingProgress;

public abstract class GPSObserver
{
    protected GPSWrapper wrapper;
    public abstract void update(Point inLocation);

}
