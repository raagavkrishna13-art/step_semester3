import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] predefinedPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"}; // Demo inputs
        
        int totalRounds = 5;
        String[][] roundHistory = new String[totalRounds][4];
        
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < totalRounds; i++) {
            String playerMove = predefinedPlayerMoves[i];
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            roundHistory[i][0] = String.valueOf(i + 1);
            roundHistory[i][1] = playerMove;
            roundHistory[i][2] = computerMove;
            roundHistory[i][3] = result;
        }

        // Print Round-by-Round Summary Table
        System.out.println("=================== MATCH SUMMARY ===================");
        System.out.printf("%-7s | %-12s | %-13s | %-13s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-----------------------------------------------------");
        for (String[] round : roundHistory) {
            System.out.printf("%-7s | %-12s | %-13s | %-13s%n", round[0], round[1], round[2], round[3]);
        }
        System.out.println("=====================================================");

        // Scoreboard Statistics
        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.printf("Final Summary (after %d rounds)%n", totalRounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }
}