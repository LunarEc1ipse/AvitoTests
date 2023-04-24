package com.sobolev.tests;

import com.sobolev.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.Random;

import static java.lang.String.format;

public class TestData {
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);
    public static String searchValue = getRandomArrayValue(new String[]{"Кошки", "Собаки", "Шины"});
    static String login = credentials.login();
    static String password = credentials.password();
    public static String URL =
            format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", login, password);

    private static String getRandomArrayValue(String[] array) {
        int randomValue = new Random().nextInt(array.length);
        return array[randomValue];
    }

}
