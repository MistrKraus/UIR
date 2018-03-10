package cv3;

public class Heuristika {

    public static void main(String[] args) {

    }
}

class Path {
    public final int city1;
    public final int city2;
    public final int distance;

    public Path(int city1, int city2, int distance) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
    }
}