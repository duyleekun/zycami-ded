/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.e;

import d.v.d.g.e.e;
import java.util.concurrent.ThreadFactory;

public final class b
implements ThreadFactory {
    public final /* synthetic */ e a;

    public /* synthetic */ b(e e10) {
        this.a = e10;
    }

    public final Thread newThread(Runnable runnable) {
        return this.a.g(runnable);
    }
}

