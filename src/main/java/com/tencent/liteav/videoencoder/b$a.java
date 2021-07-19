/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.videoencoder.b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

public class b$a
extends TimerTask {
    private WeakReference a;

    public b$a(b b10) {
        WeakReference<b> weakReference;
        this.a = weakReference = new WeakReference<b>(b10);
    }

    public void run() {
        Object object = this.a;
        if (object == null) {
            return;
        }
        if ((object = (b)((Reference)object).get()) == null) {
            return;
        }
        int n10 = b.i((b)object);
        int n11 = b.j((b)object);
        float f10 = 0.0f;
        if (n10 < n11) {
            int[] nArray = g.a();
            b.k((b)object);
            float f11 = b.l((b)object);
            f10 = nArray[0] / 10;
            b.a((b)object, f11 += f10);
            f11 = b.m((b)object);
            float f12 = nArray[1] / 10;
            b.b((b)object, f11 += f12);
            double d10 = b.n((b)object);
            double d11 = ((b)object).b() * 100.0;
            double d12 = b.h((b)object).fps;
            f12 = (float)(d10 + (d11 /= d12));
            b.c((b)object, f12);
            return;
        }
        Object object2 = c.a();
        float f13 = b.l((b)object);
        int n12 = b.j((b)object);
        float f14 = n12;
        f13 /= f14;
        f14 = b.m((b)object);
        int n13 = b.j((b)object);
        float f15 = n13;
        f14 /= f15;
        f15 = b.n((b)object);
        int n14 = b.j((b)object);
        float f16 = n14;
        n10 = (int)(((c)object2).a(f13, f14, f15 /= f16) ? 1 : 0);
        if (n10 != 0 && (n10 = ((c)(object2 = c.a())).d()) != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("VideoEncoder: Insufficient performance, switching software encoding to hardware encoding [appCPU:");
            f13 = b.l((b)object);
            ((StringBuilder)object2).append(f13);
            ((StringBuilder)object2).append("][sysCPU:");
            f13 = b.m((b)object);
            ((StringBuilder)object2).append(f13);
            ((StringBuilder)object2).append("][fps:");
            f13 = b.n((b)object);
            ((StringBuilder)object2).append(f13);
            ((StringBuilder)object2).append("][checkCount:");
            n11 = b.j((b)object);
            ((StringBuilder)object2).append(n11);
            String string2 = "]";
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            n11 = 2;
            f13 = 2.8E-45f;
            String string3 = "";
            Monitor.a(n11, (String)object2, string3, 0);
            b.o((b)object);
        }
        b.p((b)object);
    }
}

