/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

public final class CachedContent$Range {
    public final long length;
    public final long position;

    public CachedContent$Range(long l10, long l11) {
        this.position = l10;
        this.length = l11;
    }

    public boolean contains(long l10, long l11) {
        long l12;
        long l13;
        long l14 = this.length;
        long l15 = -1;
        Object object = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        boolean bl2 = true;
        if (object == false) {
            l11 = this.position;
            long l16 = l10 - l11;
            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 < 0) {
                bl2 = false;
            }
            return bl2;
        }
        Object object3 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1);
        if (object3 == false) {
            return false;
        }
        l15 = this.position;
        long l17 = l15 - l10;
        object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object > 0 || (l13 = (l12 = (l10 += l11) - (l15 += l14)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            bl2 = false;
        }
        return bl2;
    }

    public boolean intersects(long l10, long l11) {
        long l12;
        long l13;
        long l14 = this.position;
        Object object = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1);
        boolean bl2 = false;
        boolean bl3 = true;
        long l15 = -1;
        if (object <= 0) {
            long l16;
            long l17;
            l11 = this.length;
            long l18 = l11 - l15;
            object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object == false || (l17 = (l16 = (l14 += l11) - l10) == 0L ? 0 : (l16 < 0L ? -1 : 1)) > 0) {
                bl2 = bl3;
            }
            return bl2;
        }
        object = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1);
        if (object == false || (l13 = (l12 = (l10 += l11) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            bl2 = bl3;
        }
        return bl2;
    }
}

