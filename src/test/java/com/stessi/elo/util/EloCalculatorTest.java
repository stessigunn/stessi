package com.stessi.elo.util;

import com.stessi.elo.model.Player;
import com.stessi.elo.model.PlayerStanding;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author palmithor
 * @since 20.3.2017.
 */
public class EloCalculatorTest {


    @Test
    public void calculateExpected() throws Exception {
        double v = EloCalculator.calculateExpected(0, 0);
        assertThat(v, is(0.5));
    }

    @Test
    public void testCalculateScoreDifference() throws Exception {
        double winnerDifference = EloCalculator.calculateScoreDifference(25, 1, 0.5);
        double looserDifference = EloCalculator.calculateScoreDifference(25, 0, 0.5);
        assertThat(winnerDifference, is(12.5));
        assertThat(looserDifference, is(-12.5));
    }

    @Test
    public void testGetGameScore() {
        assertThat(EloCalculator.getGamePoints(true, MatchResultEnum.HOME_WIN), is(1.0));
        assertThat(EloCalculator.getGamePoints(true, MatchResultEnum.DRAW), is(0.5));
        assertThat(EloCalculator.getGamePoints(true, MatchResultEnum.AWAY_WIN), is(0.0));

        assertThat(EloCalculator.getGamePoints(false, MatchResultEnum.HOME_WIN), is(0.0));
        assertThat(EloCalculator.getGamePoints(false, MatchResultEnum.DRAW), is(0.5));
        assertThat(EloCalculator.getGamePoints(false, MatchResultEnum.AWAY_WIN), is(1.0));
    }


    @Test
    public void testCalculateNewScore() {
        assertThat(EloCalculator.calculateNewScore(0, 12.5, 0), is(13));
        assertThat(EloCalculator.calculateNewScore(100, 1000, 1000), is(200));
        assertThat(EloCalculator.calculateNewScore(100, -1000, 1000), is(0));
    }

    @Test
    public void testCalculateScoreTeamOfOne() {
        final PlayerStanding homeTeam = PlayerStanding.create().score(100).build();
        final PlayerStanding awayTeam = PlayerStanding.create().score(100).build();
        List<PlayerStanding> playerStandings = EloCalculator.calculateScore(Collections.singletonList(homeTeam), Collections.singletonList(awayTeam), MatchResultEnum.HOME_WIN, 25);
        assertThat(playerStandings.size(), is(2));
        assertThat(playerStandings.get(0).getRating(), is(113));
        assertThat(playerStandings.get(1).getRating(), is(88));
    }
}