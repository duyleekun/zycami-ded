/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.q0.e;

import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import java.util.Comparator;

public final class b
implements Comparator {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final int compare(Object object, Object object2) {
        object = (CacheSpan)object;
        object2 = (CacheSpan)object2;
        return LeastRecentlyUsedCacheEvictor.a((CacheSpan)object, (CacheSpan)object2);
    }
}

