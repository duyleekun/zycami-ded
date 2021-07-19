/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al$b;
import com.xiaomi.push.gx;
import java.util.ArrayList;

public final class gy
extends al$b {
    public final /* synthetic */ Context a;

    public gy(Context context) {
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        ArrayList arrayList;
        Object object = gx.a();
        synchronized (object) {
            Object object2 = gx.a();
            arrayList = new ArrayList(object2);
            object2 = gx.a();
            object2.clear();
        }
        gx.a(this.a, arrayList);
    }
}

