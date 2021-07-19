/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.opengl.i$a;
import com.tencent.liteav.videoencoder.TXCSWVideoEncoder;

public class TXCSWVideoEncoder$1
implements i$a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TXCSWVideoEncoder c;

    public TXCSWVideoEncoder$1(TXCSWVideoEncoder tXCSWVideoEncoder, boolean bl2, int n10) {
        this.c = tXCSWVideoEncoder;
        this.a = bl2;
        this.b = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10) {
        TXCSWVideoEncoder tXCSWVideoEncoder = this.c;
        synchronized (tXCSWVideoEncoder) {
            int n11;
            TXCSWVideoEncoder tXCSWVideoEncoder2 = this.c;
            Object object = tXCSWVideoEncoder2.mListener;
            if (object != null) {
                n11 = tXCSWVideoEncoder2.mStreamType;
                object.h(n11);
            }
            if ((n11 = (int)(this.a ? 1 : 0)) != 0) {
                object = this.c;
                long l10 = TXCSWVideoEncoder.access$000((TXCSWVideoEncoder)object);
                int n12 = this.b;
                tXCSWVideoEncoder2 = this.c;
                int n13 = tXCSWVideoEncoder2.mOutputWidth;
                int n14 = tXCSWVideoEncoder2.mOutputHeight;
                long l11 = TXCSWVideoEncoder.access$100(tXCSWVideoEncoder2);
                TXCSWVideoEncoder.access$200((TXCSWVideoEncoder)object, l10, n12, n13, n14, l11);
            } else {
                object = this.c;
                long l12 = TXCSWVideoEncoder.access$000((TXCSWVideoEncoder)object);
                int n15 = this.b;
                tXCSWVideoEncoder2 = this.c;
                int n16 = tXCSWVideoEncoder2.mOutputWidth;
                int n17 = tXCSWVideoEncoder2.mOutputHeight;
                long l13 = TXCSWVideoEncoder.access$100(tXCSWVideoEncoder2);
                TXCSWVideoEncoder.access$300((TXCSWVideoEncoder)object, l12, n15, n16, n17, l13);
            }
            return;
        }
    }
}

