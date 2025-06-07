package org.codingdojo;

public class Score {
    private final int value;
    
    public Score(int value) {
        this.value = Math.max(0, value);
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Score score = (Score) obj;
        return value == score.value;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}