package View;

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

    public MenuState getState()
    {
        return state;
    }

}
