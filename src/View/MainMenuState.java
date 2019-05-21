package View;

import Controller.GPSWrapper;
import Controller.InvalidPathFactoryException;
import Controller.RouteManager;
import Model.TrackingProgress;

import java.io.IOException;
import java.util.Scanner;


public class MainMenuState implements MenuState
{
    private static Scanner input = new Scanner(System.in);
    private RouteManager manager;

    public MainMenuState(RouteManager inManager)
    {
        this.manager = inManager;
    }

    @Override
    public void showMenu(Menu menu) throws IOException,InvalidPathFactoryException
    {
        boolean done = false;
        while(!done)
        {
                int option;
                System.out.println("# Route Tracker - Main Menu #");
                System.out.println("1: Update Routes");
                System.out.println("2: Choose Routes");
                System.out.println("3: Exit");

                option = input.nextInt();
                input.nextLine();
                switch (option)
                {
                    case 1:
                        System.out.println("Updating Routes from server.........");
                        System.out.println("Updated Routes ! \n");
                        manager.updateRoutes();
                        break;
                    case 2:
                        routeSelector(menu);
                        done = true;
                        break;
                    case 3:
                        done = true;
                        break;
                    default:
                        System.out.println("Enter a valid option");
                }

        }


    }

    public void routeSelector(Menu menu) throws IOException,InvalidPathFactoryException
    {
        String search;
        boolean done = false;
        System.out.println("# Route Tracker - Main Menu #\n");
        manager.displayRoutes();
        System.out.println("# Choose what route you want to take\n");
        while(!done)
        {
            search = input.nextLine();
            if(manager.containsRoute(search))
            {
                TrackingProgress trackingProgress = new TrackingProgress(manager.getRoute(search),manager.getGeoUtils());
                GPSWrapper wrapper = new GPSWrapper(trackingProgress);
                TrackingMenuState trackingMenuState = new TrackingMenuState(trackingProgress,wrapper);
                menu.setState(trackingMenuState);
                menu.showMenu();
                done = true;

            }
            else
            {
                System.out.println("Invalid Route name, Enter Valid Route name");

            }

        }



    }
}
