package org.example;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Main {
    UserInterface ui = new UserInterface();
    public void Run(){
        ui.velkomst();
        ui.menu();
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.Run();
    }
}