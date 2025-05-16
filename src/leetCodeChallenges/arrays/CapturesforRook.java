package leetCodeChallenges.arrays;

/**
 * Link: https://leetcode.com/problems/available-captures-for-rook/submissions/1635865885/?envType=problem-list-v2&envId=array
 * Solves the Available Captures for Rook problem by finding the rook and
 * checking each of the four cardinal directions for attackable pawns.
 * <p>
 * Approach:
 * 1. Find the exact location (row and column) of the single white rook ('R') on the board.
 * 2. Initialize a counter for the number of attacked pawns.
 * 3. Check each of the four cardinal directions (Up, Down, Left, Right) independently from the rook's position.
 * For each direction:
 * a. Start moving one square at a time in that direction.
 * b. At each square, check the piece present:
 * - If a black pawn ('p') is found first, the rook attacks it. Increment the counter and stop checking in this direction.
 * - If a white bishop ('B') or another piece ('p') is found first, it blocks the rook. Stop checking in this direction without incrementing the counter.
 * - If an empty square ('.') is found, continue moving to the next square in the same direction.
 * c. If the edge of the board is reached without encountering a 'p' or 'B', stop checking in this direction (no capture).
 * 4. The total accumulated count after checking all four directions is the answer.
 * <p>
 * A helper method can be used to encapsulate the logic for checking a single direction,
 * making the code cleaner and more reusable. The helper takes the board, the rook's
 * start position, and the direction of movement (e.g., represented as changes in row and column, dr and dc).
 *
 * @param board The 8x8 character matrix representing the chessboard.
 * @return The number of pawns the white rook is attacking.
 */
public class CapturesforRook {

    public static int numRookCaptures(char[][] board) {
        // (Your implementation code for finding the rook and calling the helper methods will go here)
        // ... find rookRow, rookCol ...
        // ... initialize count ...
        // ... call checkDirection 4 times and sum results ...
        // ... return total count ...
        int rookRow = -1;
        int rookColumn = -1;
        boolean isRook = false;

        for (int i = 0; i < 8; i++) {
            if (!isRook) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == 'R') {
                        rookRow = i;
                        rookColumn = j;
                        isRook = true;
                        break;
                    }
                }
            } else {
                break;
            }
        }

        int total_capture = 0;

        total_capture += checkDirection(board, rookRow, rookColumn, -1, 0);
        total_capture += checkDirection(board, rookRow, rookColumn, 1, 0);
        total_capture += checkDirection(board, rookRow, rookColumn, 0, -1);
        total_capture += checkDirection(board, rookRow, rookColumn, 0, 1);

        return total_capture;
    }


    /**
     * Helper method to check for a pawn capture in a single cardinal direction from a starting point.
     * It moves step-by-step in the given direction until a piece ('p' or 'B') or the board edge is encountered.
     *
     * @param board    The 8x8 character matrix.
     * @param startRow The starting row (rook's row).
     * @param startCol The starting column (rook's column).
     * @param dr       The change in row for one step in this direction (-1 for Up, 1 for Down, 0 for Left/Right).
     * @param dc       The change in column for one step in this direction (0 for Up/Down, -1 for Left, 1 for Right).
     * @return 1 if the first piece encountered in this direction is a pawn ('p'), 0 otherwise (blocked by 'B', hits edge first, or no piece in path).
     */
    private static int checkDirection(char[][] board, int startRow, int startCol, int dr, int dc) {
        // (Your implementation code for checking a single direction will go here)
        // ... calculate first step (currentRow = startRow + dr, currentCol = startCol + dc) ...
        // ... while loop (while currentRow and currentCol are on board) ...
        // ... get piece = board[currentRow][currentCol] ...
        // ... if piece is 'p', return 1 ...
        // ... else if piece is 'B', return 0 ...
        // ... else (piece is '.'), update position (currentRow += dr, currentCol += dc) ...
        // ... if loop finishes without returning, return 0 ...
        int current_row = startRow + dr;
        int current_col = startCol + dc;
        int count = 0;

        while (current_row >= 0 && current_row < 8 && current_col >= 0 && current_col < 8) {
            if (board[current_row][current_col] == 'p') {
                count++;
                break;
            } else if (board[current_row][current_col] == 'B') {
                break;
            } else {
                current_row += dr;
                current_col += dc;
            }
        }

        // Complexity Analysis:
        // Time Complexity: O(1) because the board size is fixed at 8x8. We perform a constant number
        //                  of operations (finding the rook is 8*8, each directional check is at most 8 steps).
        //                  For a general N x M board, it would be O(N*M) to find the rook and O(N+M)
        //                  for the checks, overall O(N*M).
        // Space Complexity: O(1) as we only use a few variables to store positions and counts.
        return count;
    }
}
