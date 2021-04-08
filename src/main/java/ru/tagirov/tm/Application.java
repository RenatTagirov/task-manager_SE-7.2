package ru.tagirov.tm;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Application {
    public static void main( String[] args ) throws IOException, NoSuchAlgorithmException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.start();
    }
}
