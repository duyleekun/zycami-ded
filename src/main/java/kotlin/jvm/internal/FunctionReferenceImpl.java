/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.r;
import f.m2.d;
import f.m2.h;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;

public class FunctionReferenceImpl
extends FunctionReference {
    public FunctionReferenceImpl(int n10, h h10, String string2, String string3) {
        Object object = CallableReference.NO_RECEIVER;
        Class clazz = ((r)h10).o();
        int n11 = h10 instanceof d ^ 1;
        super(n10, object, clazz, string2, string3, n11);
    }

    public FunctionReferenceImpl(int n10, Class clazz, String string2, String string3, int n11) {
        Object object = CallableReference.NO_RECEIVER;
        super(n10, object, clazz, string2, string3, n11);
    }

    public FunctionReferenceImpl(int n10, Object object, Class clazz, String string2, String string3, int n11) {
        super(n10, object, clazz, string2, string3, n11);
    }
}

