/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
    public static final a b;
    public List a;

    static {
        a a10;
        b = a10 = new a();
    }

    public a() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList(1);
    }

    public void a(Activity activity) {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Activity activity2 = (Activity)iterator2.next();
            if (activity2 == null || activity2 == activity || (bl3 = activity2.isFinishing())) continue;
            activity2.finish();
        }
        this.a.add(activity);
    }

    public void b(Activity activity) {
        this.a.remove(activity);
    }
}

