package Controller;

import java.io.IOException;

public class GeoUtils
{

    //Throws IOException if cannot reach server
    public String retrieveRouteData() throws IOException
    {
        return  "theClimb Amazing views!\n" +
                "    -31.94,115.75,47.1,Easy start\n" +
                "    -31.94,115.75,55.3,Tricky, watch for drop bears\n" +
                "    -31.94,115.75,71.0,I*feel,like.over-punctuating!@#$%^&*()[]{}<>.?_+\n" +
                "    -31.93,115.75,108.0,Getting there\n" +
                "    -31.93,115.75,131.9\n" +
                "mainRoute Since I was young\n" +
                "    -31.96,115.80,63.0,I knew\n" +
                "    -31.95,115.78,45.3,I'd find you\n" +
                "    -31.95,115.77,44.8,*theStroll\n" +
                "    -31.94,115.75,47.1,But our love\n" +
                "    -31.93,115.72,40.1,Was a song\n" +
                "    -31.94,115.75,47.1,*theClimb\n" +
                "    -31.93,115.75,131.9,Sung by a dying man\n" +
                "    -31.92,115.74,128.1\n" +
                "theStroll Breathe in the light\n" +
                "    -31.95,115.77,44.8,I'll stay here\n" +
                "    -31.93,115.76,43.0,In the shadow\n" +
                "    -31.94,115.75,47.1\n";

    }

    //Measures horizontal distance between two sets of coordinates [Stubbed for now]
    public double calcMetresDistance(double lat1, double long1, double lat2, double long2)
    {
        return 5.0;

    }
}
