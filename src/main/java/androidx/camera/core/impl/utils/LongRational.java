/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

public final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    public LongRational(double d10) {
        long l10 = (long)(d10 * 10000.0);
        this(l10, 10000L);
    }

    public LongRational(long l10, long l11) {
        this.mNumerator = l10;
        this.mDenominator = l11;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public double toDouble() {
        double d10 = this.mNumerator;
        double d11 = this.mDenominator;
        return d10 / d11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        long l10 = this.mNumerator;
        stringBuilder.append(l10);
        stringBuilder.append("/");
        l10 = this.mDenominator;
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }
}

