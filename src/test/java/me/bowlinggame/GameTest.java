package me.bowlinggame;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class GameTest {

    @Test
    public void roll() {
        Game underTest = new Game();

        underTest.roll(10);
    }

    @Test
    public void scoreAll() {
        Game underTest = new Game();

        IntStream.range(0, 20).forEach(v -> underTest.roll(4));

        int result = underTest.score();

        Assert.assertEquals(80, result);
    }

    @Test
    public void scoreWithAllSpares() {
        Game underTest = new Game();

        IntStream.range(0, 20).forEach(v -> underTest.roll(5));

        underTest.roll(5);

        int result = underTest.score();

        Assert.assertEquals(150, result);
    }

    @Test
    public void scoreWith9AndMiss() {
        Game underTest = new Game();

        IntStream.range(0, 10).forEach(v -> {
            underTest.roll(9);
            underTest.roll(0);
        });

        int result = underTest.score();

        Assert.assertEquals(90, result);
    }

    @Test
    public void scoreWith9AndAllStrikes() {
        Game underTest = new Game();

        IntStream.range(0, 20).forEach(v -> underTest.roll(10));

        underTest.roll(10);
        underTest.roll(10);

        int result = underTest.score();

        Assert.assertEquals(300, result);
    }

    @Test
    public void score() {
        Game underTest = new Game();

        //7
        doFrame(underTest, 2, 5);

        //6
        doFrame(underTest, 3, 3);

        //5
        doFrame(underTest, 2, 3);

        //6
        doFrame(underTest, 3, 3);

        //14
        doFrame(underTest, 5, 5);

        //6
        doFrame(underTest, 4, 2);

        //16
        doFrame(underTest, 10, 0);

        //6
        doFrame(underTest, 3, 3);

        //0
        doFrame(underTest, 0, 0);

        //6
        doFrame(underTest, 3, 3);


        int result = underTest.score();

        Assert.assertEquals(72, result);
    }

    private void doFrame(Game game, int firstRoll, int secondRoll) {
        game.roll(firstRoll);
        game.roll(secondRoll);
    }
}