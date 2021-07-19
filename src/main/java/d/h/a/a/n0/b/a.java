/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.n0.b;

import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.cea.Cea708Decoder$Cea708CueInfo;
import java.util.Comparator;

public final class a
implements Comparator {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final int compare(Object object, Object object2) {
        object = (Cea708Decoder$Cea708CueInfo)object;
        object2 = (Cea708Decoder$Cea708CueInfo)object2;
        return Cea708Decoder.a((Cea708Decoder$Cea708CueInfo)object, (Cea708Decoder$Cea708CueInfo)object2);
    }
}

