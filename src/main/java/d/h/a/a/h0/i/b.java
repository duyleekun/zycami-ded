/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.h0.i;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;

public final class b
implements ExtractorsFactory {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final Extractor[] createExtractors() {
        return Ac4Extractor.a();
    }
}

