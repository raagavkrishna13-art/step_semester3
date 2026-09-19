public class MatchAnalyzer {

    // Helper method to compute the average for one match/row
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Match ").append(i).append(": ").append(classification);
        }

        return sb.toString();
    }
}