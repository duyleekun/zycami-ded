/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines.jvm.internal;

import f.b2.c;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

public abstract class RestrictedContinuationImpl
extends BaseContinuationImpl {
    public RestrictedContinuationImpl(c object) {
        super((c)object);
        if (object != null) {
            boolean bl2;
            Object object2;
            if ((object = object.getContext()) == (object2 = EmptyCoroutineContext.INSTANCE)) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            if (!bl2) {
                object2 = "Coroutines with restricted suspension must have EmptyCoroutineContext".toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
        }
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}

