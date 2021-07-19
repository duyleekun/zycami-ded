/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.r0;

import com.google.android.exoplayer2.util.SlidingPercentile;
import com.google.android.exoplayer2.util.SlidingPercentile$Sample;
import java.util.Comparator;

public final class c
implements Comparator {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final int compare(Object object, Object object2) {
        object = (SlidingPercentile$Sample)object;
        object2 = (SlidingPercentile$Sample)object2;
        return SlidingPercentile.a((SlidingPercentile$Sample)object, (SlidingPercentile$Sample)object2);
    }
}

