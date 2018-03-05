package cv3;

public class Damy {

    public static void main(String[] args) {
        Chessboard ch = new Chessboard(4);
        ch.addDama(0, 0);
        ch.printChessboard();

        ch = new Chessboard(4);
        ch.addDama(0, 1);
        ch.printChessboard();

        ch = new Chessboard(4);
        ch.addDama(0, 2);
        ch.printChessboard();

        ch = new Chessboard(4);
        ch.addDama(0, 3);
        ch.printChessboard();
    }
}

class Chessboard {


    private int[][] matrix;
    private final int n;
    private final static int queen = 1;

    public Chessboard(int n) {
        this.n = n;
        matrix = new int[n][n];

    }

    public void addDama(int y, int x) {
        int row;
        int column;

        // spatne
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row = y - i;
                column = x - j;

                if(!isFree(row, column))
                    return;

                matrix[row][column] = 1;
            }
        }


    }
    
    private boolean isFree(int y, int x) {
        if (y < 0 || y >= n || x < 0 || y >= n)
            return false;

        return matrix[y][x] == 0;
    }

    public void printChessboard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
