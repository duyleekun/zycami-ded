/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import g.h0.h.a;
import g.h0.q.e;
import g.h0.q.i;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.ByteString;

public final class e$h
extends a {
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ e g;
    public final /* synthetic */ i h;
    public final /* synthetic */ ByteString i;
    public final /* synthetic */ Ref$ObjectRef j;
    public final /* synthetic */ Ref$IntRef k;
    public final /* synthetic */ Ref$ObjectRef l;
    public final /* synthetic */ Ref$ObjectRef m;
    public final /* synthetic */ Ref$ObjectRef n;
    public final /* synthetic */ Ref$ObjectRef o;

    public e$h(String string2, boolean bl2, String string3, boolean bl3, e e10, i i10, ByteString byteString, Ref$ObjectRef ref$ObjectRef, Ref$IntRef ref$IntRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
        this.e = string2;
        this.f = bl2;
        this.g = e10;
        this.h = i10;
        this.i = byteString;
        this.j = ref$ObjectRef;
        this.k = ref$IntRef;
        this.l = ref$ObjectRef2;
        this.m = ref$ObjectRef3;
        this.n = ref$ObjectRef4;
        this.o = ref$ObjectRef5;
        super(string3, bl3);
    }

    public long f() {
        this.g.cancel();
        return -1;
    }
}

