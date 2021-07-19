/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.fm;
import com.xiaomi.push.fq;

public class fr
extends Thread {
    public final /* synthetic */ fq a;

    public fr(fq fq2, String string2) {
        this.a = fq2;
        super(string2);
    }

    public void run() {
        Object object = this.a;
        object = fq.a((fq)object);
        try {
            ((fm)object).a();
        }
        catch (Exception exception) {
            fq fq2 = this.a;
            int n10 = 9;
            fq2.c(n10, exception);
        }
    }
}

