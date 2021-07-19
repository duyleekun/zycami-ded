/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.h0.i;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;

public final class e
implements ExtractorsFactory {
    public static final /* synthetic */ e a;

    static {
        e e10;
        a = e10 = new e();
    }

    public final Extractor[] createExtractors() {
        return TsExtractor.a();
    }
}

