package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class DesDataLogger {
    private String permutation;
    private String left;
    private String right;
    private List<String> rounds = new ArrayList<>();

    public String getPermutation() {
        return permutation;
    }

    public void setPermutation(String permutation) {
        this.permutation = permutation;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public List<String> getRounds() {
        return rounds;
    }

    public void setRounds(List<String> rounds) {
        this.rounds = rounds;
    }
}
