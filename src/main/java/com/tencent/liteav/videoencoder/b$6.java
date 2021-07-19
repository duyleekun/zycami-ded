/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.a;
import com.tencent.liteav.videoencoder.b;
import com.tencent.liteav.videoencoder.c;
import com.tencent.liteav.videoencoder.d;

public class b$6
implements Runnable {
    public final /* synthetic */ b a;

    public b$6(b b10) {
        this.a = b10;
    }

    public void run() {
        int n10;
        Object object;
        Object object2 = this.a;
        int n11 = 1107;
        Object object3 = "Switches from software encoding to hardware encoding";
        b.a((b)object2, n11, (String)object3);
        object2 = b.d(this.a);
        if (object2 != null) {
            object2 = b.d(this.a);
            n11 = 0;
            object = null;
            ((c)object2).setListener(null);
            object2 = b.d(this.a);
            ((c)object2).stop();
        }
        object2 = this.a;
        object = new a();
        b.a((b)object2, (c)object);
        b.a(this.a, 1);
        object2 = this.a;
        n11 = 4007;
        int n12 = b.g((b)object2);
        long l10 = n12;
        object3 = l10;
        ((com.tencent.liteav.basic.module.a)object2).setStatusValue(n11, object3);
        object2 = b.d(this.a);
        object = b.h(this.a);
        ((c)object2).start((TXSVideoEncoderParam)object);
        object2 = b.e(this.a);
        if (object2 != null) {
            object2 = b.d(this.a);
            object = b.e(this.a);
            ((c)object2).setListener((d)object);
        }
        if ((n10 = b.f((b)(object2 = this.a))) != 0) {
            object2 = b.d(this.a);
            object = this.a;
            n11 = b.f((b)object);
            ((c)object2).setBitrate(n11);
        }
        object2 = b.d(this.a);
        object = this.a.getID();
        ((com.tencent.liteav.basic.module.a)object2).setID((String)object);
    }
}

