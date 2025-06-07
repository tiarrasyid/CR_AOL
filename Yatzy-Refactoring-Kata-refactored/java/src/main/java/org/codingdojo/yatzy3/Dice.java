package org.codingdojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Dice {
    private final List<Integer> values;
    
    public Dice(List<Integer> values) {
        if (values.size() != 5) {
            throw new IllegalArgumentException("Dice must contain exactly 5 values");
        }
        if (values.stream().anyMatch(v -> v < 1 || v > 6)) {
            throw new IllegalArgumentException("Dice values must be between 1 and 6");
        }
        this.values = new ArrayList<>(values);
    }
    
    public List<Integer> getValues() {
        return new ArrayList<>(values);
    }
    
    public int sum() {
        return values.stream().mapToInt(Integer::intValue).sum();
    }
    
    public Map<Integer, Integer> getFrequencies() {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            frequencies.put(i, 0);
        }
        for (int die : values) {
            frequencies.put(die, frequencies.get(die) + 1);
        }
        return frequencies;
    }
}