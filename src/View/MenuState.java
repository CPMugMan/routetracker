package View;

import Controller.RouteManager;
import Model.InvalidPointException;
import Model.InvalidSegmenException;

import java.io.IOException;

//Menu state interface
public interface MenuState
{
    void showMenu(Menu menu, RouteManager manager) throws IOException, InvalidSegmenException, InvalidPointException;
}
