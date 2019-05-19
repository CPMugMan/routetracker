package Controller;

import Model.InvalidPointException;
import Model.InvalidSegmenException;
import Model.Route;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Collection of routes managed via a map with the name of the route being the key
public class RouteManager
{
    private Map<String, Route> routeMap;
    private GeoUtils geoUtils;
    private PathFactory factory;

    public RouteManager(GeoUtils inGeo, PathFactory inFactory)
    {
        this.routeMap = new HashMap<String, Route>();
        this.geoUtils = inGeo;
        this.factory = inFactory;
    }

    public void addRoute(Route inRoute, String inName)
    {
        routeMap.put(inName, inRoute);
    }

    public Route getRoute(String key)
    {
        if(routeMap.containsKey(key))
        {
            return routeMap.get(key);
        }
        return null;
    }

    public void displayRoutes()
    {
        for(String name : routeMap.keySet())
        {
            Route route = routeMap.get(name);
            System.out.println("Route Name : " + route.getName() + "  Horizontal Distance : "
                    + route.getHorizontalDistance(geoUtils) + " Vertical Climbing : " + route.getClimbing() +
                    " Vertical Descent : " + route.getDescent());
        }
    }

    public void updateRoutes() throws IOException, InvalidSegmenException, InvalidPointException
    {
        routeMap = factory.populateMap(geoUtils.retrieveRouteData());
    }
}
