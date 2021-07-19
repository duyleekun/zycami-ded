/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.j0.a;

import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate;

public final class a
implements Id3Decoder$FramePredicate {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final boolean evaluate(int n10, int n11, int n12, int n13, int n14) {
        return Id3Decoder.a(n10, n11, n12, n13, n14);
    }
}

