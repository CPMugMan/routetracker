package View;

import Controller.InvalidPathFactoryException;
import Controller.RouteManager;

import java.io.IOException;

//Context state for menu states
public class Menu
{
    private MenuState state;

    public Menu()
    {
        state = null;
    }

    public void setState(MenuState state)
    {
        this.state = state;
    }

    public void showMenu() throws IOException, InvalidPathFactoryException
    {
        state.showMenu(this);

    }

    public MenuState getState()
    {
        return state;
    }

}
