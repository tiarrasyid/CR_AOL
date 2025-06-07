package org.codingdojo.yatzy3;

import org.codingdojo.Dice;
import org.codingdojo.Score;

public class NumberScorer extends CategoryScorer {
    private final int number;

    public NumberScorer(int number) {
        this.number = number;
    }

    @Override
    public Score calculateScore(Dice dice) {
        return new Score(frequencies(dice).get(number) * number);
    }
}