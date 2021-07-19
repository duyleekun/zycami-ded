/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.q0.e;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;

public final class a
implements CacheKeyFactory {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final String buildCacheKey(DataSpec dataSpec) {
        return CacheKeyFactory.a(dataSpec);
    }
}

