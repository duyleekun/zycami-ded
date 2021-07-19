/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.geofence.a;

import com.baidu.geofence.a.b;
import com.baidu.geofence.a.b$a;

public class e
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ b b;

    public e(b b10, int n10) {
        this.b = b10;
        this.a = n10;
    }

    public void run() {
        b$a b$a = com.baidu.geofence.a.b.b(this.b);
        if (b$a != null) {
            b$a = com.baidu.geofence.a.b.b(this.b);
            int n10 = this.a;
            b$a.a(n10);
        }
    }
}

