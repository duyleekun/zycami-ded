/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.videoencoder.a;
import com.tencent.liteav.videoencoder.c;

public class a$4
implements Runnable {
    public final /* synthetic */ a a;

    public a$4(a a10) {
        this.a = a10;
    }

    public void run() {
        Object object = this.a;
        int n10 = ((c)object).mInit;
        if (n10 != 0) {
            n10 = 2;
            Object object2 = new Object[n10];
            object2[0] = object = Integer.valueOf(object.hashCode());
            int n11 = 1;
            int n12 = this.a.mStreamType;
            Integer n13 = n12;
            object2[n11] = n13;
            object = String.format("VideoEncoder[%d]: Stop, streamType:%d", object2);
            object2 = "streamType: 2-big, 3-small, 7-sub";
            Monitor.a(n10, (String)object, (String)object2, 0);
            object = this.a;
            com.tencent.liteav.videoencoder.a.a((a)object);
        }
    }
}

