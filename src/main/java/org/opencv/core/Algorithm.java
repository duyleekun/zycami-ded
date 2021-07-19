/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.core;

public class Algorithm {
    public final long a;

    public Algorithm(long l10) {
        this.a = l10;
    }

    public static Algorithm a(long l10) {
        Algorithm algorithm = new Algorithm(l10);
        return algorithm;
    }

    private static native void clear_0(long var0);

    private static native void delete(long var0);

    private static native boolean empty_0(long var0);

    private static native String getDefaultName_0(long var0);

    private static native void save_0(long var0, String var2);

    public void b() {
        Algorithm.clear_0(this.a);
    }

    public boolean c() {
        return Algorithm.empty_0(this.a);
    }

    public String d() {
        return Algorithm.getDefaultName_0(this.a);
    }

    public long e() {
        return this.a;
    }

    public void f(String string2) {
        Algorithm.save_0(this.a, string2);
    }

    public void finalize() {
        Algorithm.delete(this.a);
    }
}

