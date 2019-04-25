package game.gamelogic;

import java.util.Arrays;

public class Profiler {

    public static final int FPS_BUFFER_SIZE = 10;

    private static final Profiler instance = new Profiler();

    protected static Profiler getInstance() {
        return instance;
    }


    private long nanos;
    private long delta = 1;
    private long fps = 1;

    private int fpsBufferPos = 0;
    private final long[] fpsBuffer = new long[FPS_BUFFER_SIZE];

    public void begin() {
        nanos = System.nanoTime();
    }

    public void end() {
        fpsBufferPos += 1;
        if (fpsBufferPos > FPS_BUFFER_SIZE - 1) {
            fpsBufferPos = 0;
        }
        delta = System.nanoTime() - nanos;
        fps = (100000000 / delta);
        fpsBuffer[fpsBufferPos] = fps;
    }

    @Override
    public String toString() {
        return delta + " ns, " + fps + " fps (avg " + Arrays.stream(fpsBuffer).average().getAsDouble() + ")";
    }
}
