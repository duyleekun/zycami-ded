/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.j0.b;

import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment;
import java.util.Comparator;

public final class a
implements Comparator {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final int compare(Object object, Object object2) {
        object = (SlowMotionData$Segment)object;
        object2 = (SlowMotionData$Segment)object2;
        return SlowMotionData$Segment.a((SlowMotionData$Segment)object, (SlowMotionData$Segment)object2);
    }
}

