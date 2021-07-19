/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.screencapture;

import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.c$b;
import java.lang.ref.WeakReference;

public class a$1
implements c$b {
    public final /* synthetic */ a a;

    public a$1(a a10) {
        this.a = a10;
    }

    public void a() {
        Object object = com.tencent.liteav.screencapture.a.a(this.a);
        int n10 = -7001;
        g.a((WeakReference)object, n10, "Screen recording stopped. It may be preempted by other apps");
        object = com.tencent.liteav.screencapture.a.b(this.a);
        a a10 = this.a;
        com.tencent.liteav.screencapture.a.a(a10, null);
        if (object != null) {
            n10 = 1;
            object.a(n10);
        }
    }

    public void a(boolean bl2) {
        a a10 = this.a;
        int n10 = com.tencent.liteav.screencapture.a.c(a10);
        if (n10 != 0) {
            a10 = this.a;
            a10.b(bl2);
            a a11 = this.a;
            n10 = 105;
            int n11 = com.tencent.liteav.screencapture.a.d(a11);
            a a12 = this.a;
            int n12 = com.tencent.liteav.screencapture.a.e(a12);
            a11.b(n10, n11, n12);
        }
    }

    public void a(boolean bl2, boolean bl3) {
        if (bl2) {
            a a10 = this.a;
            int n10 = 106;
            a10.b(n10);
        } else {
            com.tencent.liteav.screencapture.a.a(this.a, null);
            WeakReference weakReference = com.tencent.liteav.screencapture.a.a(this.a);
            int n11 = -1308;
            String string2 = "Failed to share screen";
            g.a(weakReference, n11, string2);
        }
    }
}

