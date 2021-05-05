package ru.tagirov.tm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalService {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String value;

    public static String service() throws IOException {
        return value = reader.readLine();
    }
}
