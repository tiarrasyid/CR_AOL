package org.codingdojo.yatzy3;

import org.codingdojo.Dice;
import org.codingdojo.Score;

public class ChanceScorer extends CategoryScorer {
    @Override
    public Score calculateScore(Dice dice) {
        return new Score(sum(dice));
    }
}