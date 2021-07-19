/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.common.base.Supplier;

public final class x
implements Supplier {
    public final /* synthetic */ ExoPlayerImplInternal a;

    public /* synthetic */ x(ExoPlayerImplInternal exoPlayerImplInternal) {
        this.a = exoPlayerImplInternal;
    }

    public final Object get() {
        return this.a.b();
    }
}

