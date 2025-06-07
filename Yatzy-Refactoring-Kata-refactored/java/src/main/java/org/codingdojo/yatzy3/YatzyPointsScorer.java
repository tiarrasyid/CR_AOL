package org.codingdojo.yatzy3;

import org.codingdojo.Dice;
import org.codingdojo.Score;

import java.util.Map;

public class YatzyPointsScorer extends CategoryScorer {
    @Override
    public Score calculateScore(Dice dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        return new Score(PatternDetectors.YATZY.matches(frequencies) ? 50 : 0);
    }
}