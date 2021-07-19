/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.h0.g;

import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.common.base.Function;

public final class b
implements Function {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final Object apply(Object object) {
        object = (Track)object;
        Mp4Extractor.a((Track)object);
        return object;
    }
}

