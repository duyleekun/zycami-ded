/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.h0.g;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;

public final class c
implements ExtractorsFactory {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final Extractor[] createExtractors() {
        return Mp4Extractor.b();
    }
}

