package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer){
        //Create a comparator for sorting strings
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                // First, compare the strings based on their length
                int lengthCompare = Integer.compare(s2.length(), s1.length());
                // If the lengths are equal, sort the strings in reverse alphabetical order
                if (lengthCompare == 0) {
                    return s2.compareTo(s1);
                }
                return lengthCompare;
            }
        };
        TreeSet<String> result = new TreeSet<>(comparator);

        //Same but in other way
//        Set<String> result = new TreeSet<>((p1, p2) -> {
//            int lengthCompare = Integer.compare(p2.length(), p1.length());
//            if (lengthCompare == 0) {
//                return p2.compareTo(p1);  // if the strings are identical, return 0, otherwise -1
//            }
//            return lengthCompare;  // sort in descending order of length
//        });

        // Find projects of the developer
        for (Map.Entry<String, Set<String>> project : projects.entrySet()) {
            if (project.getValue().contains(developer)) {
                result.add(project.getKey());
            }
        }
        return new ArrayList<>(result);
    }
}
