package ru.tagirov.tm;

import ru.tagirov.tm.init.Bootstrap;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Application {
    public static void main( String[] args ) throws IOException, IllegalAccessException, InstantiationException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.start();
    }
}
