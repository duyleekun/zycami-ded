/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.n0.c;

import com.google.android.exoplayer2.text.webvtt.WebvttCueInfo;
import com.google.android.exoplayer2.text.webvtt.WebvttSubtitle;
import java.util.Comparator;

public final class b
implements Comparator {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final int compare(Object object, Object object2) {
        object = (WebvttCueInfo)object;
        object2 = (WebvttCueInfo)object2;
        return WebvttSubtitle.a((WebvttCueInfo)object, (WebvttCueInfo)object2);
    }
}

