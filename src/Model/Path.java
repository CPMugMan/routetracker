package Model;

//Common superclass between Segment and Route to enable composite pattern
public abstract class Path
{
    private Point start;
    private Point end;


    public Path(Point inStart, Point inEnd)
    {
        this.start = inStart;
        this.end = inEnd;

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

    public double horizontalDistance()
    {
        //TODO add stub method to calc distance here
        return 5.0;
    }



}
