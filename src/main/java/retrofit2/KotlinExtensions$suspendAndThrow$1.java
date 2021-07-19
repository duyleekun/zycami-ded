/*
 * Decompiled with CFR 0.151.
 */
package retrofit2;

import f.b2.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import retrofit2.KotlinExtensions;

public final class KotlinExtensions$suspendAndThrow$1
extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public KotlinExtensions$suspendAndThrow$1(c c10) {
        super(c10);
    }

    public final Object invokeSuspend(Object object) {
        int n10;
        this.result = object;
        this.label = n10 = this.label | -1 << -1;
        return KotlinExtensions.e(null, this);
    }
}

