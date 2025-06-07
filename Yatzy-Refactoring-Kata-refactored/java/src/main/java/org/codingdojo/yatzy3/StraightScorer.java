package org.codingdojo.yatzy3;

import org.codingdojo.Dice;
import org.codingdojo.Score;

import java.util.Map;

public class StraightScorer extends CategoryScorer {
    private final int straightIncludes;

    public StraightScorer(int straightIncludes) {
        this.straightIncludes = straightIncludes;
    }

    @Override
    public Score calculateScore(Dice dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        return new Score(isStraight(frequencies) && frequencies.get(straightIncludes) != 0 ? sum(dice) : 0);
    }

    private boolean isStraight(Map<Integer, Integer> frequencies) {
        return PatternDetectors.STRAIGHT.matches(frequencies);
    }
}