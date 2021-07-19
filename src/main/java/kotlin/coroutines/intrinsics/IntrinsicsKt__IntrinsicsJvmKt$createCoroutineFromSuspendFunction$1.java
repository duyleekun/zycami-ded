/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines.intrinsics;

import f.b2.c;
import f.h2.s.l;
import f.o0;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
extends RestrictedContinuationImpl {
    public final /* synthetic */ l $block;
    public final /* synthetic */ c $completion;
    private int label;

    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(l l10, c c10, c c11) {
        this.$block = l10;
        this.$completion = c10;
        super(c11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object invokeSuspend(Object object) {
        int n10 = this.label;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                String string2 = "This coroutine had already completed".toString();
                object = new IllegalStateException(string2);
                throw object;
            }
        } else {
            this.label = n11;
            o0.n(object);
            return this.$block.invoke(this);
        }
        this.label = n10 = 2;
        o0.n(object);
        return object;
    }
}

