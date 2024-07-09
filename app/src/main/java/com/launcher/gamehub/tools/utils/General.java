package com.launcher.gamehub.tools.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class General {
    public static Logger log = Logger.getLogger("DEV_DEBUG");

    public static void getLog(String value) {
        log.log(Level.INFO,value);
    }
}
