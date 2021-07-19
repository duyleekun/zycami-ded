/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.r0;

import com.google.android.exoplayer2.util.SlidingPercentile;
import com.google.android.exoplayer2.util.SlidingPercentile$Sample;
import java.util.Comparator;

public final class d
implements Comparator {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final int compare(Object object, Object object2) {
        object = (SlidingPercentile$Sample)object;
        object2 = (SlidingPercentile$Sample)object2;
        return SlidingPercentile.b((SlidingPercentile$Sample)object, (SlidingPercentile$Sample)object2);
    }
}

