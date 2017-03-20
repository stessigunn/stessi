package com.stessi.elo.util;

import com.stessi.elo.model.PlayerStanding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author palmithor
 * @since 12.3.2017.
 */
public class EloCalculator {

    public static final double INTEGER_ROUNDING = 0.5;

    public static List<PlayerStanding> calculateScore(final List<PlayerStanding> homeTeam,
                                                      final List<PlayerStanding> awayTeam,
                                                      final MatchResultEnum result,
                                                      final int kFactor) {
        int homeTeamTotalRating = homeTeam.stream().mapToInt(PlayerStanding::getRating).sum();
        int awayTeamTotalRating = awayTeam.stream().mapToInt(PlayerStanding::getRating).sum();

        double homeExpectedResult = calculateExpected(homeTeamTotalRating, awayTeamTotalRating);
        double awayExpectedResult = calculateExpected(awayTeamTotalRating, homeTeamTotalRating);

        final double homeTeamRatingDifference = calculateScoreDifference(kFactor, getGamePoints(true, result), homeExpectedResult);
        final double awayTeamRatingDifference = calculateScoreDifference(kFactor, getGamePoints(false, result), awayExpectedResult);

        final List<PlayerStanding> homeTeamCalculated = homeTeam.stream().map(playerStanding -> PlayerStanding.copy(playerStanding).score(calculateNewScore(playerStanding.getRating(), homeTeamRatingDifference, homeTeamTotalRating)).build()).collect(Collectors.toList());
        final List<PlayerStanding> awayTeamCalculated = awayTeam.stream().map(playerStanding -> PlayerStanding.copy(playerStanding).score(calculateNewScore(playerStanding.getRating(), awayTeamRatingDifference, awayTeamTotalRating)).build()).collect(Collectors.toList());

        return Stream.concat(homeTeamCalculated.stream(), awayTeamCalculated.stream()).collect(Collectors.toList());
    }

    static Integer calculateNewScore(final Integer rating, final double ratingDifference, final int teamTotalRating) {
        double ratio;
        if (teamTotalRating != 0) {
            ratio = (double) rating / (double) teamTotalRating;
        } else {
            ratio = 1.0;
        }
        int newScore = (int) Math.round(rating + (ratingDifference * ratio));
        return newScore < 0 ? 0 : newScore;
    }

    static double getGamePoints(final boolean isHomeTeam, final MatchResultEnum result) {
        final double drawResults = 0.5;
        if (MatchResultEnum.DRAW.equals(result)) {
            return drawResults;
        }

        final int teamLostResult = 0;
        final int teamWonResults = 1;
        if (isHomeTeam) {
            if (MatchResultEnum.HOME_WIN.equals(result)) {
                return teamWonResults;
            } else {
                return teamLostResult;
            }
        } else {
            if (MatchResultEnum.AWAY_WIN.equals(result)) {
                return teamWonResults;
            } else {
                return teamLostResult;
            }
        }
    }

    static double calculateScoreDifference(final int kFactor, final double gamePoints, final double expectedResults) {
        return (kFactor * (gamePoints - expectedResults));
    }


    static double calculateExpected(final int teamScore, final int otherTeamScore) {
        return (1.0 / (1.0 + Math.pow(10, ((teamScore - otherTeamScore) / 400))));
    }

}
