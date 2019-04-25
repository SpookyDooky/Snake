package game;

public class Profiler {

    private static final Profiler instance = new Profiler();

    public static Profiler getInstance() {
        return instance;
    }


    public long nanos;
    public volatile long delta;

    public void begin() {
        nanos = System.nanoTime();
    }

    public void end() {
        delta = System.nanoTime() - nanos;
        System.out.println("END " + delta);
    }

    @Override
    public String toString() {
        return delta + " ns, " + (100000000 / delta) + " fps";
    }
}
