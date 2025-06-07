package org.codingdojo.yatzy3;

import org.codingdojo.YatzyCategory;
import org.codingdojo.Dice;
import org.codingdojo.Score;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public abstract class CategoryScorer {
    private static final List<Integer> DICE_VALUES_DESC = Arrays.asList(6, 5, 4, 3, 2, 1);
    private static final List<Integer> DICE_VALUES_ASC = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    public static CategoryScorer createInstance(YatzyCategory category) {
        if (category == YatzyCategory.CHANCE) return new ChanceScorer();
        if (category == YatzyCategory.YATZY) return new YatzyPointsScorer();
        if (category == YatzyCategory.ONES) return new NumberScorer(1);
        if (category == YatzyCategory.TWOS) return new NumberScorer(2);
        if (category == YatzyCategory.THREES) return new NumberScorer(3);
        if (category == YatzyCategory.FOURS) return new NumberScorer(4);
        if (category == YatzyCategory.FIVES) return new NumberScorer(5);
        if (category == YatzyCategory.SIXES) return new NumberScorer(6);
        if (category == YatzyCategory.PAIR) return new RepeatedCountScorer(2);
        if (category == YatzyCategory.THREE_OF_A_KIND) return new RepeatedCountScorer(3);
        if (category == YatzyCategory.FOUR_OF_A_KIND) return new RepeatedCountScorer(4);
        if (category == YatzyCategory.SMALL_STRAIGHT) return new StraightScorer(1);
        if (category == YatzyCategory.LARGE_STRAIGHT) return new StraightScorer(6);
        if (category == YatzyCategory.TWO_PAIRS) return new TwoPairsScorer();
        if (category == YatzyCategory.FULL_HOUSE) return new FullHouseScorer();
        throw new IllegalArgumentException("Unknown category: " + category);
    }

    public abstract Score calculateScore(Dice dice);

    protected List<Integer> getDiceValuesDescending() {
        return DICE_VALUES_DESC;
    }
    
    protected Stream<Integer> diceValuesDescendingStream() {
        return DICE_VALUES_DESC.stream();
    }

    protected Map<Integer, Integer> frequencies(Dice dice) {
        return dice.getFrequencies();
    }

    protected int sum(Dice dice) {
        return dice.sum();
    }
}