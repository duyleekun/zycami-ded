/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline$1;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.util.Assertions;

public abstract class Timeline {
    public static final Timeline EMPTY;

    static {
        Timeline$1 timeline$1 = new Timeline$1();
        EMPTY = timeline$1;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n11 = object instanceof Timeline;
        if (n11 == 0) {
            return false;
        }
        n11 = ((Timeline)(object = (Timeline)object)).getWindowCount();
        if (n11 == (n10 = this.getWindowCount()) && (n11 = ((Timeline)object).getPeriodCount()) == (n10 = this.getPeriodCount())) {
            int n12;
            int n13;
            Timeline$Window timeline$Window = new Timeline$Window();
            Timeline$Period timeline$Period = new Timeline$Period();
            Object object2 = new Timeline$Window();
            Timeline$Period timeline$Period2 = new Timeline$Period();
            Timeline$Period timeline$Period3 = null;
            for (int i10 = 0; i10 < (n13 = this.getWindowCount()); ++i10) {
                Timeline$Window timeline$Window2;
                Timeline$Window timeline$Window3 = this.getWindow(i10, timeline$Window);
                n13 = (int)(timeline$Window3.equals(timeline$Window2 = ((Timeline)object).getWindow(i10, (Timeline$Window)object2)) ? 1 : 0);
                if (n13 != 0) continue;
                return false;
            }
            timeline$Window = null;
            for (n11 = 0; n11 < (n12 = this.getPeriodCount()); ++n11) {
                object2 = this.getPeriod(n11, timeline$Period, bl2);
                n12 = (int)(((Timeline$Period)object2).equals(timeline$Period3 = ((Timeline)object).getPeriod(n11, timeline$Period2, bl2)) ? 1 : 0);
                if (n12 != 0) continue;
                return false;
            }
            return bl2;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public int getFirstWindowIndex(boolean bl2) {
        void var1_5;
        boolean bl3 = this.isEmpty();
        if (bl3) {
            int n10 = -1;
        } else {
            boolean bl4 = false;
        }
        return (int)var1_5;
    }

    public abstract int getIndexOfPeriod(Object var1);

    /*
     * WARNING - void declaration
     */
    public int getLastWindowIndex(boolean bl2) {
        void var1_5;
        boolean bl3 = this.isEmpty();
        if (bl3) {
            int n10 = -1;
        } else {
            int n11 = this.getWindowCount() + -1;
        }
        return (int)var1_5;
    }

    public final int getNextPeriodIndex(int n10, Timeline$Period timeline$Period, Timeline$Window timeline$Window, int n11, boolean bl2) {
        timeline$Period = this.getPeriod(n10, timeline$Period);
        int n12 = timeline$Period.windowIndex;
        Timeline$Window timeline$Window2 = this.getWindow(n12, timeline$Window);
        int n13 = timeline$Window2.lastPeriodIndex;
        if (n13 == n10) {
            n10 = this.getNextWindowIndex(n12, n11, bl2);
            if (n10 == (n12 = -1)) {
                return n12;
            }
            return this.getWindow((int)n10, (Timeline$Window)timeline$Window).firstPeriodIndex;
        }
        return n10 + 1;
    }

    public int getNextWindowIndex(int n10, int n11, boolean bl2) {
        int n12 = 1;
        if (n11 != 0) {
            if (n11 != n12) {
                int n13 = 2;
                if (n11 == n13) {
                    n11 = this.getLastWindowIndex(bl2);
                    n10 = n10 == n11 ? this.getFirstWindowIndex(bl2) : (n10 += n12);
                    return n10;
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            return n10;
        }
        n11 = this.getLastWindowIndex(bl2);
        n10 = n10 == n11 ? -1 : (n10 += n12);
        return n10;
    }

    public final Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period) {
        return this.getPeriod(n10, timeline$Period, false);
    }

    public abstract Timeline$Period getPeriod(int var1, Timeline$Period var2, boolean var3);

    public Timeline$Period getPeriodByUid(Object object, Timeline$Period timeline$Period) {
        int n10 = this.getIndexOfPeriod(object);
        return this.getPeriod(n10, timeline$Period, true);
    }

    public abstract int getPeriodCount();

    public final Pair getPeriodPosition(Timeline$Window timeline$Window, Timeline$Period timeline$Period, int n10, long l10) {
        return (Pair)Assertions.checkNotNull(this.getPeriodPosition(timeline$Window, timeline$Period, n10, l10, 0L));
    }

    public final Pair getPeriodPosition(Timeline$Window object, Timeline$Period object2, int n10, long l10, long l11) {
        long l12;
        long l13;
        int n11 = this.getWindowCount();
        Assertions.checkIndex(n10, 0, n11);
        this.getWindow(n10, (Timeline$Window)object, l11);
        l11 = -9223372036854775807L;
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n10 == 0 && (n10 = (int)((l13 = (l10 = ((Timeline$Window)object).getDefaultPositionUs()) - l11) == 0L ? 0 : (l13 < 0L ? -1 : 1))) == 0) {
            return null;
        }
        n10 = ((Timeline$Window)object).firstPeriodIndex;
        long l14 = ((Timeline$Window)object).getPositionInFirstPeriodUs() + l10;
        boolean bl2 = true;
        Timeline$Period timeline$Period = this.getPeriod(n10, (Timeline$Period)object2, bl2);
        long l15 = timeline$Period.getDurationUs();
        while ((l12 = l15 == l11 ? 0 : (l15 < l11 ? -1 : 1)) != false && (l12 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1)) >= 0 && n10 < (l12 = (long)((Timeline$Window)object).lastPeriodIndex)) {
            l14 -= l15;
            timeline$Period = this.getPeriod(++n10, (Timeline$Period)object2, bl2);
            l15 = timeline$Period.getDurationUs();
        }
        object = Assertions.checkNotNull(((Timeline$Period)object2).uid);
        object2 = l14;
        return Pair.create((Object)object, (Object)object2);
    }

    public int getPreviousWindowIndex(int n10, int n11, boolean bl2) {
        int n12 = 1;
        if (n11 != 0) {
            if (n11 != n12) {
                int n13 = 2;
                if (n11 == n13) {
                    n11 = this.getFirstWindowIndex(bl2);
                    n10 = n10 == n11 ? this.getLastWindowIndex(bl2) : (n10 -= n12);
                    return n10;
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            return n10;
        }
        n11 = this.getFirstWindowIndex(bl2);
        n10 = n10 == n11 ? -1 : (n10 -= n12);
        return n10;
    }

    public abstract Object getUidOfPeriod(int var1);

    public final Timeline$Window getWindow(int n10, Timeline$Window timeline$Window) {
        return this.getWindow(n10, timeline$Window, 0L);
    }

    public abstract Timeline$Window getWindow(int var1, Timeline$Window var2, long var3);

    public final Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, boolean bl2) {
        return this.getWindow(n10, timeline$Window, 0L);
    }

    public abstract int getWindowCount();

    public int hashCode() {
        int n10;
        Object object = new Timeline$Window();
        Timeline$Period timeline$Period = new Timeline$Period();
        int n11 = this.getWindowCount();
        int n12 = 217 + n11;
        n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.getWindowCount()); ++i10) {
            n12 *= 31;
            Timeline$Window timeline$Window = this.getWindow(i10, (Timeline$Window)object);
            n10 = timeline$Window.hashCode();
            n12 += n10;
        }
        n12 *= 31;
        int n13 = this.getPeriodCount();
        n12 += n13;
        while (n11 < (n13 = this.getPeriodCount())) {
            n12 *= 31;
            object = this.getPeriod(n11, timeline$Period, true);
            n13 = ((Timeline$Period)object).hashCode();
            n12 += n13;
            ++n11;
        }
        return n12;
    }

    public final boolean isEmpty() {
        int n10 = this.getWindowCount();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public final boolean isLastPeriod(int n10, Timeline$Period timeline$Period, Timeline$Window timeline$Window, int n11, boolean bl2) {
        int n12;
        n10 = (n10 = this.getNextPeriodIndex(n10, timeline$Period, timeline$Window, n11, bl2)) == (n12 = -1) ? 1 : 0;
        return n10 != 0;
    }
}

