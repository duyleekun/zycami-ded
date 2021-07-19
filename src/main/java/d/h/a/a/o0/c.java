/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.o0;

import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.Comparator;

public final class c
implements Comparator {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final int compare(Object object, Object object2) {
        object = (Integer)object;
        object2 = (Integer)object2;
        return DefaultTrackSelector.a((Integer)object, (Integer)object2);
    }
}

