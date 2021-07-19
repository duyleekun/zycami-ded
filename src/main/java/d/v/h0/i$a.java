/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 */
package d.v.h0;

import android.media.MediaCodec;
import d.v.h0.a;
import d.v.h0.g;
import d.v.h0.i;
import d.v.h0.k.e;
import d.v.k0.g.d;

public class i$a
implements e {
    public final /* synthetic */ i a;

    public i$a(i i10) {
        this.a = i10;
    }

    private /* synthetic */ void f(String string2, Exception exception) {
        g g10 = i.b(this.a);
        d.h(string2, exception, -2, g10);
    }

    public void b(byte[] byArray, MediaCodec.BufferInfo bufferInfo) {
        i.a(this.a, byArray);
    }

    public void c(String string2, Exception exception) {
        this.a.w();
        a a10 = new a(this, string2, exception);
        d.i(a10);
    }

    public /* synthetic */ void g(String string2, Exception exception) {
        this.f(string2, exception);
    }
}

