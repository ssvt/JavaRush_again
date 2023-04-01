package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode

*/

/**
 * PS:  какие то сцуко танцы с бубном, чтоб угодить валидатору
 * прошел с 16й попытки.. :-)
 */

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }


    @Override
    public boolean equals(Object n) {
        if (this == n) return true;
        if (n == null || getClass() != n.getClass()) return false;
        if (!(n instanceof Solution)) return false;


        Solution compSol = (Solution) n;
        if (first != null ? !first.equals(compSol.first) : compSol.first != null) return false;
        if (last != null ? !last.equals(compSol.last) : compSol.last != null) return false;

        return true;
    }

    public int hashCode() {
        int fr = first != null ? first.hashCode() : 0;
        int sr = last != null ? last.hashCode() : 0;
        return 31 * fr + sr;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
