package leetCodeChallenges.arrays;

public class CapturesforRook {
    public static int numRookCaptures(char[][] board) {
        int rookRow = -1;
        int rookColumn = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char rook = 'R';
                if (board[j][i] == rook) {
                    rookRow = i;
                    rookColumn = j;
                    break;
                }
            }
        }

        int current_row = rookRow - 1;
        int attack_count = 0;
        char bishop = 'B';
        char pawn = 'p';

        while (current_row >= 0) {
            char position = board[current_row][rookColumn];
            if (position == pawn) {
                attack_count++;
                break;
            } else if (position == bishop) {
                break;
            } else {
                current_row--;
            }
        }
        return attack_count;
    }
}
