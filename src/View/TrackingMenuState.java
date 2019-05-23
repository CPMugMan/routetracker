package View;

import Controller.GPSWrapper;
import Controller.InvalidPathFactoryException;
import Controller.PathFactory;
import Controller.RouteManager;
import Controller.TrackingProgress;
import java.io.IOException;
import java.util.Scanner;

//Tracking state responsible for displaying information while a user is on a track
public class TrackingMenuState implements MenuState
{
    private TrackingProgress trackingProgress;
    private GPSWrapper wrapper;
    private static Scanner input = new Scanner(System.in);


    public TrackingMenuState(TrackingProgress trackingProgress, GPSWrapper wrapper)
    {
        this.trackingProgress = trackingProgress;
        this.wrapper = wrapper;
        wrapper.attach(trackingProgress);

    }

    //This menu displays information while the user is hiking through the chosen track
    @Override
    public void showMenu(Menu menu) throws IOException, InvalidPathFactoryException,InterruptedException
    {
        String waypoint;
        System.out.println("# Tracking Menu - Starting Track  #");
        while(!trackingProgress.isFinished())
        {
            System.out.println("Manually enter name of waypoint reached ");
            wrapper.fakeTracking();
            waypoint = input.nextLine();
            if(trackingProgress.containsSegment(waypoint))
            {
                trackingProgress.updateManually(waypoint);

            }
            else
            {
                System.out.println("Invalid Waypoint that is not in the route");
            }


        }

        stateSelection(menu);


    }

    //Menu that gets displayed after user has gone through track
    public void stateSelection(Menu menu) throws IOException, InvalidPathFactoryException,InterruptedException
    {
        boolean done = false;
        while(!done)
        {
            int option;
            System.out.println("# Tracking Menu - State Selection # ");
            System.out.println("1: Do it again");
            System.out.println("2: Go back to main menu");
            System.out.println("3: Exit");

            option = input.nextInt();
            input.nextLine();
            switch (option)
            {
                case 1:
                    trackingProgress.reset();
                    menu.showMenu();
                    done = true;
                    break;
                case 2:
                    PathFactory factory = new PathFactory();
                    RouteManager routeManager = new RouteManager(trackingProgress.getGeoUtils(),factory);
                    routeManager.updateRoutes();
                    menu.setState(new MainMenuState(routeManager));
                    menu.showMenu();
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
}
