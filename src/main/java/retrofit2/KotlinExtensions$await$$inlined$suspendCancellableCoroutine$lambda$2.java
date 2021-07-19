/*
 * Decompiled with CFR 0.151.
 */
package retrofit2;

import f.h2.s.l;
import k.d;
import kotlin.jvm.internal.Lambda;

public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
extends Lambda
implements l {
    public final /* synthetic */ d $this_await$inlined;

    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(d d10) {
        this.$this_await$inlined = d10;
        super(1);
    }

    public final void invoke(Throwable throwable) {
        this.$this_await$inlined.cancel();
    }
}

