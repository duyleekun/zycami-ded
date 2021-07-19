/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.n0.c;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser$Element;
import java.util.Comparator;

public final class a
implements Comparator {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final int compare(Object object, Object object2) {
        object = (WebvttCueParser$Element)object;
        object2 = (WebvttCueParser$Element)object2;
        return WebvttCueParser$Element.a((WebvttCueParser$Element)object, (WebvttCueParser$Element)object2);
    }
}

