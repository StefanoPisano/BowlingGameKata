package me.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Roll> rolls;

    public Game() {
        rolls = new ArrayList<>();
    }

    public void roll(int knockedDown) {
        Roll roll = new Roll(rolls.size(), knockedDown);

        rolls.add(roll);
    }

    public int score() {
        int score = 0;
        boolean wasSpare = false;
        boolean wasStrike = false;
        for (int i = 0; i < 20; i++) {
            if (wasSpare || wasStrike) {
                wasSpare = false;
                wasStrike = false;

                continue;
            }

            Roll current = rolls.get(i);
            if (isStrike(current)) {
                score += sumStrike(current);

                wasStrike = true;
            } else if (isSpare(current)) {
                score += sumSpare(i);

                wasSpare = true;
            } else {
                score += current.getKnocked();
            }
        }

        return score;
    }

    private boolean isSpare(Roll roll) {
        if (roll.getIndex() % 2 == 0) {
            return roll.getKnocked() + rolls.get(roll.getIndex() + 1).getKnocked() == 10;
        } else {
            return false;
        }
    }

    public boolean isStrike(Roll roll) {
        return roll.getKnocked() == 10;
    }

    private int sumSpare(int index) {
        return 10 + rolls.get(index + 2).getKnocked();
    }

    private int sumStrike(Roll roll) {
        return 10 + rolls.get(roll.getIndex() + 2).getKnocked() + rolls.get(roll.getIndex() + 3).getKnocked();
    }
}