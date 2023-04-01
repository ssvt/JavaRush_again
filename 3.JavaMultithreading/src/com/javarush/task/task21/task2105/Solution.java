package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Solution)) return false;

        Solution compSol = (Solution) o;
        if (first != null ? !first.equals(compSol.first) : compSol.first != null) return false;
        if (last != null ? !last.equals(compSol.last) : compSol.last != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int fr = first != null ? first.hashCode() : 0;
        int sr = last != null ? last.hashCode() : 0;
        return 31 * fr + sr;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
