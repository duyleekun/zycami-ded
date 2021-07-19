/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.dnn;

public class DictValue {
    public final long a;

    public DictValue(double d10) {
        long l10;
        this.a = l10 = DictValue.DictValue_1(d10);
    }

    public DictValue(int n10) {
        long l10;
        this.a = l10 = DictValue.DictValue_2(n10);
    }

    public DictValue(long l10) {
        this.a = l10;
    }

    public DictValue(String string2) {
        long l10;
        this.a = l10 = DictValue.DictValue_0(string2);
    }

    private static native long DictValue_0(String var0);

    private static native long DictValue_1(double var0);

    private static native long DictValue_2(int var0);

    public static DictValue a(long l10) {
        DictValue dictValue = new DictValue(l10);
        return dictValue;
    }

    private static native void delete(long var0);

    private static native int getIntValue_0(long var0, int var2);

    private static native int getIntValue_1(long var0);

    private static native double getRealValue_0(long var0, int var2);

    private static native double getRealValue_1(long var0);

    private static native String getStringValue_0(long var0, int var2);

    private static native String getStringValue_1(long var0);

    private static native boolean isInt_0(long var0);

    private static native boolean isReal_0(long var0);

    private static native boolean isString_0(long var0);

    public int b() {
        return DictValue.getIntValue_1(this.a);
    }

    public int c(int n10) {
        return DictValue.getIntValue_0(this.a, n10);
    }

    public long d() {
        return this.a;
    }

    public double e() {
        return DictValue.getRealValue_1(this.a);
    }

    public double f(int n10) {
        return DictValue.getRealValue_0(this.a, n10);
    }

    public void finalize() {
        DictValue.delete(this.a);
    }

    public String g() {
        return DictValue.getStringValue_1(this.a);
    }

    public String h(int n10) {
        return DictValue.getStringValue_0(this.a, n10);
    }

    public boolean i() {
        return DictValue.isInt_0(this.a);
    }

    public boolean j() {
        return DictValue.isReal_0(this.a);
    }

    public boolean k() {
        return DictValue.isString_0(this.a);
    }
}

