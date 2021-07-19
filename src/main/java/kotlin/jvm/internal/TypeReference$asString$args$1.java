/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.s.l;
import f.h2.t.f0;
import f.m2.t;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeReference;

public final class TypeReference$asString$args$1
extends Lambda
implements l {
    public final /* synthetic */ TypeReference this$0;

    public TypeReference$asString$args$1(TypeReference typeReference) {
        this.this$0 = typeReference;
        super(1);
    }

    public final CharSequence invoke(t t10) {
        f0.p(t10, "it");
        return TypeReference.d(this.this$0, t10);
    }
}

