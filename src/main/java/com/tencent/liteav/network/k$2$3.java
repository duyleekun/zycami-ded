/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.network.k$2;
import com.tencent.liteav.network.k$a;
import java.util.Vector;

public class k$2$3
implements Runnable {
    public final /* synthetic */ Vector a;
    public final /* synthetic */ k$2 b;

    public k$2$3(k$2 k$2, Vector vector) {
        this.b = k$2;
        this.a = vector;
    }

    public void run() {
        k$a k$a = this.b.f;
        if (k$a != null) {
            Vector vector = this.a;
            String string2 = "Success";
            k$a.a(0, string2, vector);
        }
    }
}

