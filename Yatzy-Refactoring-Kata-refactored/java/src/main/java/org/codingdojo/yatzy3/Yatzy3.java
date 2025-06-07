package org.codingdojo.yatzy3;

import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;
import org.codingdojo.Dice;
import org.codingdojo.Score;

import java.util.Arrays;
import java.util.List;

public class Yatzy3 implements YatzyCalculator {
    @Override
    public List<YatzyCategory> validCategories() {
        return Arrays.asList(YatzyCategory.values());
    }

    @Override
    public Score score(Dice dice, YatzyCategory category) {
        return CategoryScorer.createInstance(category).calculateScore(dice);
    }
}