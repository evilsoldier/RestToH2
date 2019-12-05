package com.rest.utils;

import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Georgi Trendafilov
 */
public final class FileUtils {

    private FileUtils() {
    }

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(ResourceUtils.getFile("classpath:" + fileName).toPath()));
    }
}
