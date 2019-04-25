package game;

import java.util.Arrays;

public class Profiler {

    public static final int FPS_BUFFER_SIZE = 10;

    private static final Profiler instance = new Profiler();

    public static Profiler getInstance() {
        return instance;
    }


    public long nanos;
    public long delta = 1;
    public long fps = 1;

    public int fpsBufferPos = 0;
    public final long[] fpsBuffer = new long[FPS_BUFFER_SIZE];

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
        return delta + " ns, " + (100000000 / delta) + " fps (avg " + Arrays.stream(fpsBuffer).average().getAsDouble() + ")";
    }
}
