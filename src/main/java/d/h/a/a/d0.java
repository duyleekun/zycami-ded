/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d0
implements Supplier {
    public final /* synthetic */ AtomicBoolean a;

    public /* synthetic */ d0(AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    public final Object get() {
        return this.a.get();
    }
}

