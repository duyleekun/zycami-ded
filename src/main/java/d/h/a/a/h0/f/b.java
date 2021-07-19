/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.h0.f;

import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate;

public final class b
implements Id3Decoder$FramePredicate {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final boolean evaluate(int n10, int n11, int n12, int n13, int n14) {
        return Mp3Extractor.b(n10, n11, n12, n13, n14);
    }
}

