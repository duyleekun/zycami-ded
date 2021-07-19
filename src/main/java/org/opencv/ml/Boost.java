/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import org.opencv.ml.DTrees;

public class Boost
extends DTrees {
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;

    public Boost(long l10) {
        super(l10);
    }

    public static Boost N(long l10) {
        Boost boost = new Boost(l10);
        return boost;
    }

    public static Boost O() {
        return Boost.N(Boost.create_0());
    }

    public static Boost S(String string2) {
        return Boost.N(Boost.load_1(string2));
    }

    public static Boost T(String string2, String string3) {
        return Boost.N(Boost.load_0(string2, string3));
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native int getBoostType_0(long var0);

    private static native int getWeakCount_0(long var0);

    private static native double getWeightTrimRate_0(long var0);

    private static native long load_0(String var0, String var1);

    private static native long load_1(String var0);

    private static native void setBoostType_0(long var0, int var2);

    private static native void setWeakCount_0(long var0, int var2);

    private static native void setWeightTrimRate_0(long var0, double var2);

    public int P() {
        return Boost.getBoostType_0(this.a);
    }

    public int Q() {
        return Boost.getWeakCount_0(this.a);
    }

    public double R() {
        return Boost.getWeightTrimRate_0(this.a);
    }

    public void U(int n10) {
        Boost.setBoostType_0(this.a, n10);
    }

    public void V(int n10) {
        Boost.setWeakCount_0(this.a, n10);
    }

    public void W(double d10) {
        Boost.setWeightTrimRate_0(this.a, d10);
    }

    public void finalize() {
        Boost.delete(this.a);
    }
}

