/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines.intrinsics;

import f.b2.c;
import f.h2.s.p;
import f.h2.t.t0;
import f.o0;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
extends RestrictedContinuationImpl {
    public final /* synthetic */ c $completion;
    public final /* synthetic */ Object $receiver$inlined;
    public final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
    private int label;

    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(c c10, c c11, p p10, Object object) {
        this.$completion = c10;
        this.$this_createCoroutineUnintercepted$inlined = p10;
        this.$receiver$inlined = object;
        super(c11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object invokeSuspend(Object object) {
        int n10 = this.label;
        int n11 = 2;
        int n12 = 1;
        if (n10 != 0) {
            if (n10 != n12) {
                String string2 = "This coroutine had already completed".toString();
                object = new IllegalStateException(string2);
                throw object;
            }
        } else {
            this.label = n12;
            o0.n(object);
            object = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(object, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            object = (p)t0.q(object, n11);
            Object object2 = this.$receiver$inlined;
            return object.invoke(object2, this);
        }
        this.label = n11;
        o0.n(object);
        return object;
    }
}

