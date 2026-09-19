public class FantasyMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Direct index assignment without looping through the array
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }
}