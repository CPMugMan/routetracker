package View;

import Controller.RouteManager;
import Model.InvalidPointException;
import Model.InvalidSegmenException;

import java.io.IOException;
import java.util.Scanner;

public class MainMenuState implements MenuState
{
    private static Scanner input = new Scanner(System.in);

    @Override
    public void showMenu(Menu menu, RouteManager manager) throws IOException, InvalidPointException, InvalidSegmenException
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
                switch (option)
                {
                    case 1:
                        manager.updateRoutes();
                        break;
                    case 2:
                        routeSelector(menu,manager);
                        break;
                    case 3:
                        done = true;
                        break;
                    default:
                        System.out.println("Enter a valid option");
                }

        }


    }

    public void routeSelector(Menu menu, RouteManager manager)
    {
        System.out.println("# Route Tracker - Main Menu - Choose a route you want to go down #");
        manager.displayRoutes();


    }
}
