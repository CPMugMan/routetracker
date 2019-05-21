import Controller.GeoUtils;
import Controller.InvalidPathFactoryException;
import Controller.PathFactory;
import Controller.RouteManager;
import Model.InvalidPointException;
import Model.TrackingProgress;
import View.MainMenuState;
import View.Menu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidPathFactoryException
    {
        GeoUtils geo = new GeoUtils();
        PathFactory factory = new PathFactory();
        RouteManager routeManager = new RouteManager(geo,factory);
        routeManager.updateRoutes();
        Menu menu = new Menu();
        menu.setState(new MainMenuState(routeManager));
        menu.showMenu();

    }
}
