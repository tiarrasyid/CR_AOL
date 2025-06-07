package org.codingdojo.yatzy3;

import org.codingdojo.Dice;
import org.codingdojo.Score;

import java.util.Map;

public class RepeatedCountScorer extends CategoryScorer {
    private final int count;

    public RepeatedCountScorer(int count) {
        this.count = count;
    }

    @Override
    public Score calculateScore(Dice dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        for (int i : getDiceValuesDescending()) {
            if (frequencies.get(i) >= count) {
                return new Score(i * count);
            }
        }
        return new Score(0);
    }
}