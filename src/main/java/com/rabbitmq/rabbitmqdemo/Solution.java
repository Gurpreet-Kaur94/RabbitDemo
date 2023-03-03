package com.rabbitmq.rabbitmqdemo;


import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
        public int twoCitySchedCost(int[][] costs) {

            int n = costs.length;
            int a = 0;
            int b = 0;
            int counta = 0;
            int countb = 0;
            int N = n/2;

            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                map.put(i, Math.abs(costs[i][1] - costs[i][0]));
            }

            Map<Integer, Integer> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,
                            (o, ne) -> o, LinkedHashMap::new));



            for(int i : sorted.keySet()) {
                if(costs[i][0] < costs[i][1] && counta < N || countb == N) {
                    a += costs[i][0];
                    counta += 1;
                } else {
                    b += costs[i][1];
                    countb += 1;
                }
            }
            return a + b;
        }

    public int[][] reconstructQueue(int[][] people) {
            int n = people.length;
        int[][] dup = new int[n][3];
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });

        System.out.println(Arrays.deepToString(people));
        List<int[]> result = new ArrayList<>(people.length);



        for (int[] p : people){
            result.add(p[1],p);
        }


        return result.toArray(new int[][]{});

       /* for(int i = 0; i<n; i++) {
            int pos = people[i][1];
            if(dup[pos][2] == 0) {
                dup[pos] = Arrays.copyOf(people[i], 2);
                dup[pos][2] = 1;
            } else {

            }
        }*/



    }

        public static void main(String args[]) {
            Solution s = new Solution();
            int[][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
            //Integer[] arr = {1,2,3};
            List<Integer> res = new ArrayList<>();
            res.add(1);
            res.add(2);
            res.add(3);
            res.add(1,4);
            //s.reconstructQueue(arr);
            //System.out.println(res);
            String val ="2001:0db8:85a3:0:0:8A2E:0370:73341";
            String[] arr1 = val.split(":");
            System.out.println(arr1.length);
            System.out.println(Arrays.toString(arr1));
            String S = "banana";
            int[] arr2 = S.chars().mapToObj(c -> (char) c).mapToInt(i -> i - 97).toArray();
            System.out.println(String.valueOf(arr2));
            System.out.println(Arrays.toString(arr2));
            //System.out.println(s.twoCitySchedCost(arr));

        }

}
