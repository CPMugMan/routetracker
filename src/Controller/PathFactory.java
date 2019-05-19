package Controller;

import Model.*;

import java.util.HashMap;
import java.util.Map;

public class PathFactory
{
    public Map<String, Route> populateMap(String file) throws InvalidPointException,InvalidSegmenException
    {
        //Current Route that is being populated
        Route currentRoute = null;

        //If searching for new route to add
        boolean searching = true;

        Map<String, Route> returnnMap = new HashMap<String,Route>();
        file = file.trim();
        String[] parts = file.split("\n");

        //Finding all name routes and adding them to map
        for(int i = 0 ; i < parts.length ; i++)
        {
            if(!parts[i].contains(","))
            {
                String[] routeInfo = parts[i].split(" ",2);
                Route route = new Route();
                route.setName(routeInfo[0]);
                route.setDescription(routeInfo[1]);
                returnnMap.put(routeInfo[0],route);
            }
        }

        //Populating Routes
        for(int j = 0; j < parts.length ; j++)
        {
            //If searching for a new route to check
            if(searching)
            {
                if(parts[j].trim().length() > 0)
                {
                    String[] routeInfo = parts[j].split(" ",2);
                    currentRoute = returnnMap.get(routeInfo[0]);
                    searching = false;
                }
            }
            else
            {
                String[] point1 = parts[j].split(",",4);
                //If end of route
                if(point1.length == 3)
                {
                    returnnMap.put(currentRoute.getName(),currentRoute);
                    searching = true;
                }
                else
                {
                    //If adding a route withing current route
                    if(point1[3].charAt(0) == '*')
                    {
                        //TODO add checking for existing route
                        String name = point1[3].substring(1);
                        currentRoute.addPath(returnnMap.get(name));
                    }
                    else
                    {
                        String[] point2 = parts[j+1].split(",",4);
                        String description = point1[3];

                        double lat1 = Double.parseDouble(point1[0]);
                        double long1 = Double.parseDouble(point1[1]);
                        double alt1 = Double.parseDouble(point1[2]);

                        double lat2 = Double.parseDouble(point2[0]);
                        double long2 = Double.parseDouble(point2[1]);
                        double alt2 = Double.parseDouble(point2[2]);

                        Point firstPoint = new Point(long1,lat1,alt1);
                        Point secondPoint = new Point(long2,lat2,alt2);

                        Segment segment = new Segment(description,firstPoint,secondPoint);
                        currentRoute.addPath(segment);

                    }

                }
            }
        }

        return returnnMap;


    }

}
