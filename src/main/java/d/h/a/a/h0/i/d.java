/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.h0.i;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;

public final class d
implements ExtractorsFactory {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final Extractor[] createExtractors() {
        return PsExtractor.a();
    }
}

