package cv2;

import java.util.Iterator;

public class HanojskeVeze {

    public static void main(String[] args) {
        int n = 3;

        new Tower(n);
    }
}

class Tower {

    private final int n;
    private char[][] state;

    public Tower(int n) {
        this.n = n;
        this.state = new char[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    this.state[i][j] = (char)(65 + i);
                } else {
                    this.state[i][j] = ':';
                }
            }
        }

        printTower(state);
        move(0, 1);
        printTower(state);
        move(0, 1);
        printTower(state);
        move(0, 1);
        printTower(state);
        move(0, 1);
        printTower(state);
        move(0, 1);
        printTower(state);
    }

    public Tower(int n, char[][] state) {
        this.n = n;
        this.state = state;

    }

    public char[][] move(int from, int to) {
        if (from < 0 || from >= state[1].length || to < 0 || to >= state[1].length)
            return state;

        int x = 0;
        while (x < state.length - 1)
            if (state[x][from] == ':')
                x++;
            else
                break;

        char value = state[x][from];
        if (value == ':') {
            System.err.println("Nelze presunout - Chybi kotouc k presunuti.");
            return state;
        }
        state[x][from] = ':';

        x = 0;
        while (x < state.length)
            if (state[x][to] == ':')
                x++;
            else
                break;
        x--;

        if (x < state.length - 1) {
            if ((int)value > ((int)state[x+1][to])) {
                System.err.println("Nelze presunout - Spodni kotouc je mensi nez presouvany.");
                return state;
            }
        }

        state[x][to] = value;

        return state;
    }

    public void printTower(char[][] state) {
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Tower getTowerCopy() {
        char[][] ret = new char[this.n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                ret[i][j] = this.state[i][j];
            }
        }

        return new Tower(this.n, ret);
    }
}