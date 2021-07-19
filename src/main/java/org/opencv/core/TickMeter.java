/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.core;

public class TickMeter {
    public final long a;

    public TickMeter() {
        long l10;
        this.a = l10 = TickMeter.TickMeter_0();
    }

    public TickMeter(long l10) {
        this.a = l10;
    }

    private static native long TickMeter_0();

    public static TickMeter a(long l10) {
        TickMeter tickMeter = new TickMeter(l10);
        return tickMeter;
    }

    private static native void delete(long var0);

    private static native long getCounter_0(long var0);

    private static native double getTimeMicro_0(long var0);

    private static native double getTimeMilli_0(long var0);

    private static native double getTimeSec_0(long var0);

    private static native long getTimeTicks_0(long var0);

    private static native void reset_0(long var0);

    private static native void start_0(long var0);

    private static native void stop_0(long var0);

    public long b() {
        return TickMeter.getCounter_0(this.a);
    }

    public long c() {
        return this.a;
    }

    public double d() {
        return TickMeter.getTimeMicro_0(this.a);
    }

    public double e() {
        return TickMeter.getTimeMilli_0(this.a);
    }

    public double f() {
        return TickMeter.getTimeSec_0(this.a);
    }

    public void finalize() {
        TickMeter.delete(this.a);
    }

    public long g() {
        return TickMeter.getTimeTicks_0(this.a);
    }

    public void h() {
        TickMeter.reset_0(this.a);
    }

    public void i() {
        TickMeter.start_0(this.a);
    }

    public void j() {
        TickMeter.stop_0(this.a);
    }
}

