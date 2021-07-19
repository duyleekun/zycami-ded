/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines.intrinsics;

import f.b2.c;
import f.h2.s.l;
import f.h2.t.t0;
import f.o0;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
extends RestrictedContinuationImpl {
    public final /* synthetic */ c $completion;
    public final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
    private int label;

    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(c c10, c c11, l l10) {
        this.$completion = c10;
        this.$this_createCoroutineUnintercepted$inlined = l10;
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
            object = this.$this_createCoroutineUnintercepted$inlined;
            String string3 = "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?";
            Objects.requireNonNull(object, string3);
            return ((l)t0.q(object, n11)).invoke(this);
        }
        this.label = n10 = 2;
        o0.n(object);
        return object;
    }
}

