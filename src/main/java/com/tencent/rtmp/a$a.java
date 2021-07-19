/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.q;
import com.tencent.rtmp.a;
import com.tencent.rtmp.a$1;

public class a$a
implements Runnable {
    public final /* synthetic */ a a;
    private int b = 300;

    private a$a(a a10) {
        this.a = a10;
    }

    public /* synthetic */ a$a(a a10, a.1 var2_2) {
        this(a10);
    }

    public void a(int n10) {
        this.b = n10;
    }

    public void run() {
        Object object;
        int n10;
        q q10 = com.tencent.rtmp.a.a(this.a);
        if (q10 != null && (n10 = (q10 = com.tencent.rtmp.a.a(this.a)).c()) != 0) {
            q10 = com.tencent.rtmp.a.a(this.a);
            n10 = q10.i();
            object = com.tencent.rtmp.a.b(this.a);
            if (object != null) {
                object = com.tencent.rtmp.a.b(this.a);
                object.onAudioVolumeEvaluationNotify(n10);
            }
        }
        if ((q10 = com.tencent.rtmp.a.c(this.a)) != null && (n10 = this.b) > 0) {
            q10 = com.tencent.rtmp.a.c(this.a);
            object = com.tencent.rtmp.a.d(this.a);
            int n11 = this.b;
            long l10 = n11;
            q10.postDelayed((Runnable)object, l10);
        }
    }
}

