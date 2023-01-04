import UI.UserInterface;

import java.io.IOException;

public class Main {
    UserInterface ui = new UserInterface();

    public Main() throws IOException {
    }

    public void Run() throws IOException {
        ui.velkomst();
        ui.menu();
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.Run();
    }
}