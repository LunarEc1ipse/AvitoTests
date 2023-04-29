package com.sobolev.tests;

import com.sobolev.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.*;

import static java.lang.String.format;

public class TestData {
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);
    public static HashMap<String, String> searchValueMap = createSearchValueMap();
    public static String searchKey = getRandomMapKey(searchValueMap);
    public static String searchValue = searchValueMap.get(searchKey);
    static String login = credentials.login();
    static String password = credentials.password();
    public static String URL =
            format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", login, password);

    public static HashMap<String, String> createSearchValueMap() {
        HashMap<String, String> searchMap = new HashMap<>();
        searchMap.put("Кошки", "Продажа кошек и котят");
        searchMap.put("Собаки", "Продажа собак и щенков");
        searchMap.put("Шины", "Легковые шины");
        return searchMap;
    }
    private static String getRandomMapKey(HashMap<String, String> map) {
        Set<String> keySet = map.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        int size = keyList.size();
        int randIdx = new Random().nextInt(size);
        String randomKey = keyList.get(randIdx);
        return randomKey;
    }
}
