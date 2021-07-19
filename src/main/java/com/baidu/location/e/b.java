/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.e;

import com.baidu.location.e.a;
import com.baidu.location.f;

public class b
implements Runnable {
    public final /* synthetic */ a a;

    public b(a a10) {
        this.a = a10;
    }

    public void run() {
        boolean bl2 = f.isServing;
        if (bl2) {
            a a10 = this.a;
            com.baidu.location.e.a.a(a10);
        }
    }
}

