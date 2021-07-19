/*
 * Decompiled with CFR 0.151.
 */
package d.q.a.h0;

import com.uber.autodispose.lifecycle.TestLifecycleScopeProvider;
import com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$TestLifecycle;
import d.q.a.h0.e;

public final class d
implements e {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final Object apply(Object object) {
        return TestLifecycleScopeProvider.g((TestLifecycleScopeProvider$TestLifecycle)((Object)object));
    }
}

