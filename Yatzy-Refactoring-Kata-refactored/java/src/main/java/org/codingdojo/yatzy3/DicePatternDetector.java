package org.codingdojo.yatzy3;

import java.util.Map;

public interface DicePatternDetector {
    boolean matches(Map<Integer, Integer> frequencies);
}