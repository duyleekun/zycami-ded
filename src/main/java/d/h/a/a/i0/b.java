/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.i0;

import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter$Factory;
import com.google.common.base.Supplier;

public final class b
implements Supplier {
    public final /* synthetic */ int a;

    public /* synthetic */ b(int n10) {
        this.a = n10;
    }

    public final Object get() {
        return AsynchronousMediaCodecAdapter$Factory.b(this.a);
    }
}

