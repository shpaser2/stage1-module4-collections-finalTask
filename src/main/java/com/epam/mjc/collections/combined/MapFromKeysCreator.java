package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap){
        Map<Integer, Set<String>> resultMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : sourceMap.entrySet()) {
            String key = entry.getKey();
            int keyLength = key.length();
            if (!resultMap.containsKey(keyLength)) {
                resultMap.put(keyLength, new HashSet<>());
            }
            resultMap.get(keyLength).add(key);
        }
        return resultMap;
    }
}
