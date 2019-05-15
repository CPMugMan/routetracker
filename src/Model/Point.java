package Model;

public class Point
{
    private Double longitude;
    private Double latitude;
    private Double altitude;

    public Point(double inLong , double inLat, double inAlltitude) throws InvalidPointException
    {
        if(validLongitude(inLat) && validLatitude(inLat))
        {
            this.longitude = inLong;
            this.latitude = inLat;
            this.altitude = inAlltitude;
        }
        else
        {
            throw new InvalidPointException("Coordinates are invalid");
        }

    }

    public Double getLongitude()
    {
        return this.longitude;
    }

    public Double getLatitude()
    {
        return this.latitude;
    }

    public Double getAltitude()
    {
        return this.altitude;
    }



    private boolean validLongitude(double inLongitude)
    {
        if(inLongitude > 180.00 || inLongitude < -180.0)
        {
            return false;
        }

        return true;
    }

    private boolean validLatitude(double inLatitude)
    {
        if(inLatitude > 90.00 || inLatitude < -90.00)
        {
            return false;
        }

        return true;
    }



}
