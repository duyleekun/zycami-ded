/*
 * Decompiled with CFR 0.151.
 */
package f.b2.j;

import f.b2.c;
import f.h2.s.l;
import kotlin.NotImplementedError;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

public class b
extends IntrinsicsKt__IntrinsicsJvmKt {
    public static final Object h() {
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    public static /* synthetic */ void i() {
    }

    private static final Object j(l object, c c10) {
        object = new NotImplementedError("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
        throw object;
    }
}

