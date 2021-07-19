/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class SeekParameters {
    public static final SeekParameters CLOSEST_SYNC;
    public static final SeekParameters DEFAULT;
    public static final SeekParameters EXACT;
    public static final SeekParameters NEXT_SYNC;
    public static final SeekParameters PREVIOUS_SYNC;
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;

    static {
        SeekParameters seekParameters;
        SeekParameters seekParameters2;
        long l10 = 0L;
        EXACT = seekParameters2 = new SeekParameters(l10, l10);
        long l11 = Long.MAX_VALUE;
        CLOSEST_SYNC = seekParameters = new SeekParameters(l11, l11);
        PREVIOUS_SYNC = seekParameters = new SeekParameters(l11, l10);
        NEXT_SYNC = seekParameters = new SeekParameters(l10, l11);
        DEFAULT = seekParameters2;
    }

    public SeekParameters(long l10, long l11) {
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        boolean bl2 = true;
        l13 = l13 >= 0 ? (long)bl2 : (long)0;
        Assertions.checkArgument((boolean)l13);
        long l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l14 < 0) {
            bl2 = false;
        }
        Assertions.checkArgument(bl2);
        this.toleranceBeforeUs = l10;
        this.toleranceAfterUs = l11;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<SeekParameters> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = SeekParameters.class) == (clazz = object.getClass())) {
            long l10;
            long l11;
            object = (SeekParameters)object;
            long l12 = this.toleranceBeforeUs;
            long l13 = ((SeekParameters)object).toleranceBeforeUs;
            long l14 = l12 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false || (l11 = (l10 = (l12 = this.toleranceAfterUs) - (l13 = ((SeekParameters)object).toleranceAfterUs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = (int)this.toleranceBeforeUs * 31;
        int n11 = (int)this.toleranceAfterUs;
        return n10 + n11;
    }

    public long resolveSeekPositionUs(long l10, long l11, long l12) {
        long l13;
        long l14;
        long l15;
        long l16;
        long l17 = this.toleranceBeforeUs;
        long l18 = 0L;
        long l19 = l17 - l18;
        Object object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (object == false && (l16 = (l15 = (l14 = this.toleranceAfterUs) - l18) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false) {
            return l10;
        }
        l18 = l10;
        l18 = Util.subtractWithOverflowDefault(l10, l17, Long.MIN_VALUE);
        l14 = this.toleranceAfterUs;
        long l20 = Long.MAX_VALUE;
        l17 = l10;
        l17 = Util.addWithOverflowDefault(l10, l14, l20);
        object = l18 == l11 ? 0 : (l18 < l11 ? -1 : 1);
        int n10 = 1;
        object = object <= 0 && (object = l11 == l17 ? 0 : (l11 < l17 ? -1 : 1)) <= 0 ? (Object)n10 : (Object)0;
        Object object2 = l18 == l12 ? 0 : (l18 < l12 ? -1 : 1);
        if (object2 > 0 || (l13 = l12 == l17 ? 0 : (l12 < l17 ? -1 : 1)) > 0) {
            n10 = 0;
        }
        if (object != false && n10 != 0) {
            l18 = Math.abs(l11 - l10);
            long l21 = l18 - (l10 = Math.abs(l12 - l10));
            Object object3 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
            if (object3 <= 0) {
                return l11;
            }
            return l12;
        }
        if (object != false) {
            return l11;
        }
        if (n10 != 0) {
            return l12;
        }
        return l18;
    }
}

