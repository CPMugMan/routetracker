package View;

import Controller.InvalidPathFactoryException;
import Controller.RouteManager;
import Model.InvalidPointException;

import java.io.IOException;

//Menu state interface
public interface MenuState
{
    void showMenu(Menu menu) throws IOException, InvalidPathFactoryException,InterruptedException;
}
