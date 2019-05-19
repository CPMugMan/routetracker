import Controller.GeoUtils;
import Controller.PathFactory;
import Controller.RouteManager;
import Model.InvalidPointException;
import Model.InvalidSegmenException;
import View.MainMenuState;
import View.Menu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidPointException, InvalidSegmenException
    {
        GeoUtils geo = new GeoUtils();
        PathFactory factory = new PathFactory();
        RouteManager routeManager = new RouteManager(geo,factory);
        routeManager.updateRoutes();
        Menu menu = new Menu();

        MainMenuState mainMenu = new MainMenuState();
        mainMenu.showMenu(menu,routeManager);

    }
}
