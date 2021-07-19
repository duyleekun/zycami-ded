/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.geofence.a;

import com.baidu.geofence.a.f;
import com.baidu.geofence.a.f$a;
import java.util.ArrayList;

public class i
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ f c;

    public i(f f10, int n10, ArrayList arrayList) {
        this.c = f10;
        this.a = n10;
        this.b = arrayList;
    }

    public void run() {
        f$a f$a = f.c(this.c);
        if (f$a != null) {
            f$a = f.c(this.c);
            int n10 = this.a;
            ArrayList arrayList = this.b;
            f$a.a(n10, arrayList);
        }
    }
}

