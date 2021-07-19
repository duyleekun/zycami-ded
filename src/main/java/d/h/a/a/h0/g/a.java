/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.h0.g;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;

public final class a
implements ExtractorsFactory {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final Extractor[] createExtractors() {
        return FragmentedMp4Extractor.a();
    }
}

