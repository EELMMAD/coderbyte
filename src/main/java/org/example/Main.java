package org.example;

import java.util.*;

class Main {

    public static String TreeConstructor(String[] strArr) {
        HashMap<Integer, Integer> parentChildMap = new HashMap<>();

        for (String pair : strArr) {
            String[] nums = pair.replaceAll("[()]", "").split(",");
            int child = Integer.parseInt(nums[0]);
            int parent = Integer.parseInt(nums[1]);

            if (parentChildMap.containsKey(child)) {
                return "false"; // Child already has a parent
            } else {
                parentChildMap.put(child, parent);
            }
        }

        for (int child : parentChildMap.keySet()) {
            int parent = parentChildMap.get(child);
            int count = 0;

            for (int value : parentChildMap.values()) {
                if (value == parent) {
                    count++;
                    if (count > 2) {
                        return "false"; // Parent has more than two children
                    }
                }
            }
        }

        return "true";
    }

    public static void main (String[] args) {
        // keep this function call here

String result =TreeConstructor(new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"});
        System.out.println(result);
    }

}
