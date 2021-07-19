/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.q0;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.common.base.Predicate;

public final class d
implements Predicate {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final boolean apply(Object object) {
        return HttpDataSource.a((String)object);
    }
}

