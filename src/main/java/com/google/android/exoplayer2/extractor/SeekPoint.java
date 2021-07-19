/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

public final class SeekPoint {
    public static final SeekPoint START;
    public final long position;
    public final long timeUs;

    static {
        SeekPoint seekPoint;
        long l10 = 0L;
        START = seekPoint = new SeekPoint(l10, l10);
    }

    public SeekPoint(long l10, long l11) {
        this.timeUs = l10;
        this.position = l11;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<SeekPoint> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = SeekPoint.class) == (clazz = object.getClass())) {
            long l10;
            long l11;
            object = (SeekPoint)object;
            long l12 = this.timeUs;
            long l13 = ((SeekPoint)object).timeUs;
            long l14 = l12 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false || (l11 = (l10 = (l12 = this.position) - (l13 = ((SeekPoint)object).position)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = (int)this.timeUs * 31;
        int n11 = (int)this.position;
        return n10 + n11;
    }

    public String toString() {
        long l10 = this.timeUs;
        long l11 = this.position;
        StringBuilder stringBuilder = new StringBuilder(60);
        stringBuilder.append("[timeUs=");
        stringBuilder.append(l10);
        stringBuilder.append(", position=");
        stringBuilder.append(l11);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

