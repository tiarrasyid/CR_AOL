package org.codingdojo.yatzy3;

import org.codingdojo.Dice;
import org.codingdojo.Score;

import java.util.Map;

public class FullHouseScorer extends CategoryScorer {
    @Override
    public Score calculateScore(Dice dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        return new Score(PatternDetectors.FULL_HOUSE.matches(frequencies) ? sum(dice) : 0);
    }
}