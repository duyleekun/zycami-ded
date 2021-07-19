/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.rtmp.b;
import com.tencent.rtmp.b$1;

public class b$a
implements Runnable {
    public final /* synthetic */ b a;
    private int b = 300;

    private b$a(b b10) {
        this.a = b10;
    }

    public /* synthetic */ b$a(b b10, b.1 var2_2) {
        this(b10);
    }

    public void a(int n10) {
        this.b = n10;
    }

    public void run() {
        int n10;
        Object object;
        Object object2 = this.a;
        boolean n102 = ((b)object2).m();
        if (n102) {
            object2 = TXCAudioEngine.getInstance();
            int n11 = ((TXCAudioEngine)object2).getSoftwareCaptureVolumeLevel();
            object = com.tencent.rtmp.b.c(this.a);
            if (object != null) {
                object = com.tencent.rtmp.b.c(this.a);
                object.onAudioVolumeEvaluationNotify(n11);
            }
        }
        if ((object2 = com.tencent.rtmp.b.d(this.a)) != null && (n10 = this.b) > 0) {
            object2 = com.tencent.rtmp.b.d(this.a);
            object = com.tencent.rtmp.b.e(this.a);
            int n12 = this.b;
            long l10 = n12;
            object2.postDelayed((Runnable)object, l10);
        }
    }
}

