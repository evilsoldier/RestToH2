package com.rest.ffpojo;

import com.github.ffpojo.FFPojoHelper;
import com.github.ffpojo.exception.FFPojoException;
import com.rest.utils.FileUtils;

import java.io.IOException;

/**
 * @author Georgi Trendafilov
 */
public class FfPojoParser {

    public static void main(String[] args) throws FFPojoException, IOException {
        FFPojoHelper helper = FFPojoHelper.getInstance();
        String input = FileUtils.readFile("flatfile/TestCase18_MJ_ValidMessage_StoreExpected_Ignore_Adjustment_2.txt");
        System.out.println(input);

        FfPojoMessage message = helper.createFromText(FfPojoMessage.class, input);
        System.out.println(message);
        String messageString = helper.parseToText(message);
        System.out.println(messageString);
    }
}
