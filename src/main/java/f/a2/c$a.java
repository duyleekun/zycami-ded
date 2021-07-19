/*
 * Decompiled with CFR 0.151.
 */
package f.a2;

import f.a2.a;
import f.a2.c;
import f.p;
import kotlin.contracts.InvocationKind;

public final class c$a {
    public static /* synthetic */ a a(c object, p p10, InvocationKind invocationKind, int n10, Object object2) {
        if (object2 == null) {
            if ((n10 &= 2) != 0) {
                invocationKind = InvocationKind.UNKNOWN;
            }
            return object.d(p10, invocationKind);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        throw object;
    }
}

