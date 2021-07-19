/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.o0;

import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.Comparator;

public final class b
implements Comparator {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final int compare(Object object, Object object2) {
        object = (Integer)object;
        object2 = (Integer)object2;
        return DefaultTrackSelector.b((Integer)object, (Integer)object2);
    }
}

