package com.model.feature.storage;

import java.io.File;

public class StorageConstants {
    public static final String CONNECTION_URL;

    static {
        String homeDirectory = System.getenv().get("HOME");

        String dbFolderPath = homeDirectory + "/.hibernateDz";
        new File(dbFolderPath).mkdirs();

        CONNECTION_URL = "jdbc:h2:" + dbFolderPath + "/db";
    }
}