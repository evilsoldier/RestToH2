package com.rest.fixedformat4j;

import com.ancientprogramming.fixedformat4j.format.FixedFormatManager;
import com.ancientprogramming.fixedformat4j.format.impl.FixedFormatManagerImpl;
import com.rest.utils.FileUtils;

import java.io.IOException;

/**
 * @author Georgi Trendafilov
 */
public class FixedFormatParser {

    public static void main(String[] args) throws IOException {
        FixedFormatManager manager = new FixedFormatManagerImpl();
        String input = FileUtils.readFile("flatfile/TestCase18_MJ_ValidMessage_StoreExpected_Ignore_Adjustment_2.txt");
        System.out.println(input);

        FixedFormatMessage message = manager.load(FixedFormatMessage.class, input);
        System.out.println(message);

        String export = manager.export(message);
        System.out.println(export);
    }
}
