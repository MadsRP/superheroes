package org.example;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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