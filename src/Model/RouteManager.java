package Model;

import java.util.HashMap;
import java.util.Map;

//Collection of routes managed via a map with the name of the route being the key
public class RouteManager
{
    private Map<String,Route> routeMap;

    public RouteManager()
    {
        this.routeMap = new HashMap<String, Route>();
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
}
