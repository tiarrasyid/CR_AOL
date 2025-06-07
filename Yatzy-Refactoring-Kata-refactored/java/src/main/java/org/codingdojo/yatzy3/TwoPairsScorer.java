package org.codingdojo.yatzy3;

import org.codingdojo.Dice;
import org.codingdojo.Score;

import java.util.Map;

public class TwoPairsScorer extends CategoryScorer {
    @Override
    public Score calculateScore(Dice dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        return new Score(hasTwoPairs(frequencies) ? calculateTwoPairsScore(frequencies) : 0);
    }

    private boolean hasTwoPairs(Map<Integer, Integer> frequencies) {
        return PatternDetectors.TWO_PAIRS.matches(frequencies);
    }

    private int calculateTwoPairsScore(Map<Integer, Integer> frequencies) {
        return diceValuesDescendingStream()
            .mapToInt(i -> i)
            .filter(i -> frequencies.get(i) >= 2)
            .map(i -> i * 2)
            .sum();
    }
}