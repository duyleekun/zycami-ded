/*
 * Decompiled with CFR 0.151.
 */
package androidx.exifinterface.media;

public class ExifInterface$Rational {
    public final long denominator;
    public final long numerator;

    public ExifInterface$Rational(double d10) {
        long l10 = (long)(d10 * 10000.0);
        this(l10, 10000L);
    }

    public ExifInterface$Rational(long l10, long l11) {
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false) {
            this.numerator = l12;
            this.denominator = 1L;
            return;
        }
        this.numerator = l10;
        this.denominator = l11;
    }

    public double calculate() {
        double d10 = this.numerator;
        double d11 = this.denominator;
        return d10 / d11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        long l10 = this.numerator;
        stringBuilder.append(l10);
        stringBuilder.append("/");
        l10 = this.denominator;
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }
}

