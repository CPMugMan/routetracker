package View;

import Controller.InvalidPathFactoryException;


import java.io.IOException;

//Context state for menu state
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

    public void showMenu() throws IOException, InvalidPathFactoryException,InterruptedException
    {
        state.showMenu(this);

    }

    public MenuState getState()
    {
        return state;
    }

}
