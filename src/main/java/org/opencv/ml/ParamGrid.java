/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

public class ParamGrid {
    public final long a;

    public ParamGrid(long l10) {
        this.a = l10;
    }

    public static ParamGrid a(long l10) {
        ParamGrid paramGrid = new ParamGrid(l10);
        return paramGrid;
    }

    public static ParamGrid b() {
        return ParamGrid.a(ParamGrid.create_3());
    }

    public static ParamGrid c(double d10) {
        return ParamGrid.a(ParamGrid.create_2(d10));
    }

    private static native long create_0(double var0, double var2, double var4);

    private static native long create_1(double var0, double var2);

    private static native long create_2(double var0);

    private static native long create_3();

    public static ParamGrid d(double d10, double d11) {
        return ParamGrid.a(ParamGrid.create_1(d10, d11));
    }

    private static native void delete(long var0);

    public static ParamGrid e(double d10, double d11, double d12) {
        return ParamGrid.a(ParamGrid.create_0(d10, d11, d12));
    }

    private static native double get_logStep_0(long var0);

    private static native double get_maxVal_0(long var0);

    private static native double get_minVal_0(long var0);

    private static native void set_logStep_0(long var0, double var2);

    private static native void set_maxVal_0(long var0, double var2);

    private static native void set_minVal_0(long var0, double var2);

    public long f() {
        return this.a;
    }

    public void finalize() {
        ParamGrid.delete(this.a);
    }

    public double g() {
        return ParamGrid.get_logStep_0(this.a);
    }

    public double h() {
        return ParamGrid.get_maxVal_0(this.a);
    }

    public double i() {
        return ParamGrid.get_minVal_0(this.a);
    }

    public void j(double d10) {
        ParamGrid.set_logStep_0(this.a, d10);
    }

    public void k(double d10) {
        ParamGrid.set_maxVal_0(this.a, d10);
    }

    public void l(double d10) {
        ParamGrid.set_minVal_0(this.a, d10);
    }
}

