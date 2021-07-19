/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.o0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import java.util.Comparator;

public final class a
implements Comparator {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final int compare(Object object, Object object2) {
        object = (Format)object;
        object2 = (Format)object2;
        return BaseTrackSelection.a((Format)object, (Format)object2);
    }
}

