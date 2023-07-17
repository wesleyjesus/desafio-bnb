package com.bases.utils;

import java.io.File;

public class FileTelasUtils {
    
    public static final String TELA_1 = getFilePath("src/test/resource/telas/teste-1.html");
    public static final String TELA_2 = getFilePath("src/test/resource/telas/teste-2.html");
    public static final String TELA_3 = getFilePath("src/test/resource/telas/teste-3.html");

    private static String getFilePath(String relativePath) {
        File file = new File(relativePath);
        return file.getAbsolutePath();
    }
}
