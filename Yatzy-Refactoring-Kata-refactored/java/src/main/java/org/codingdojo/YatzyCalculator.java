package org.codingdojo;

import java.util.List;

public interface YatzyCalculator {
    List<YatzyCategory> validCategories();
    Score score(Dice dice, YatzyCategory category);
}