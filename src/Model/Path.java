package Model;

import Controller.GeoUtils;

//Common superclass between Segment and Route to enable composite pattern
public abstract class Path
{
    protected Point start;
    protected Point end;

    public Path(Point inStart, Point inEnd)
    {
            this.start = inStart;
            this.end = inEnd;
    }

    public Path()
    {
        this.start = null;
        this.end = null;
    }

    public void setStart(Point inPoint)
    {
        this.start = inPoint;
    }

    public Point getStart()
    {
        return this.start;
    }

    public Point getEnd()
    {
        return this.end;
    }

    public void setEnd(Point inEndPoint)
    {
        this.end = inEndPoint;

    }

    public abstract double getHorizontalDistance(GeoUtils inGeo);



}
