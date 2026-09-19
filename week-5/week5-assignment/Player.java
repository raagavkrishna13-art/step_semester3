import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Thresholds:
    // 1. matchesPlayed >= 10 automatically qualifies (established player).
    // 2. 5 <= matchesPlayed < 10 qualifies if fit (!injured).
    
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return isDraftable(matchesPlayed) || (matchesPlayed >= 5 && !injured);
    }

    @Override
    public int compareTo(Player other) {
        // Sort descending by battingAverage
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();

        // Filter draftable players using overloaded method rules
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed, p.injured)) {
                draftableList.add(p);
            }
        }

        // Convert list to array and sort using java.util.Arrays.sort
        Player[] draftable = draftableList.toArray(new Player[0]);
        Arrays.sort(draftable);

        // Format string output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ").append(draftable[i].name);
        }

        return sb.toString();
    }
 public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Thresholds:
    // 1. matchesPlayed >= 10 automatically qualifies (established player).
    // 2. 5 <= matchesPlayed < 10 qualifies if fit (!injured).
    
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return isDraftable(matchesPlayed) || (matchesPlayed >= 5 && !injured);
    }

    @Override
    public int compareTo(Player other) {
        // Sort descending by battingAverage
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();

        // Filter draftable players using overloaded method rules
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed, p.injured)) {
                draftableList.add(p);
            }
        }

        // Convert list to array and sort using java.util.Arrays.sort
        Player[] draftable = draftableList.toArray(new Player[0]);
        Arrays.sort(draftable);

        // Format string output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ").append(draftable[i].name);
        }

        return sb.toString();
    }
}