package Controller;

import Model.Point;

//Common interface for all observers in program
public interface GPSObserver
{
    void update(Point inLocation);

}
