package com.simbir.words.service;

import java.util.List;
import java.util.TreeMap;

public interface Words {
    TreeMap<String, Integer> getUniqueWordFromUrl(String url);
}
