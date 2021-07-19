/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.updatesdk.a.a.d.h;

import android.content.Context;
import com.huawei.updatesdk.a.a.d.e;
import com.huawei.updatesdk.a.a.d.h.b;
import com.huawei.updatesdk.a.a.d.h.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class b$b {
    private final Context a;
    private boolean b;
    private Set c;
    private String[] d;
    private boolean e;

    public b$b(Context context) {
        this.a = context;
    }

    private String b() {
        String string2;
        Object object = com.huawei.updatesdk.a.a.d.h.c.d(this.a);
        ArrayList<String> arrayList = new ArrayList<String>((Collection<String>)object);
        object = this.c;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                string2 = (String)object.next();
                boolean bl3 = arrayList.contains(string2);
                if (bl3) continue;
                arrayList.add(string2);
            }
        }
        boolean bl4 = this.e;
        string2 = ",";
        if (bl4) {
            object = this.d;
            return com.huawei.updatesdk.a.a.d.e.a(com.huawei.updatesdk.a.a.d.h.c.a(arrayList, object), string2);
        }
        return com.huawei.updatesdk.a.a.d.e.a(arrayList, string2);
    }

    public b$b a(boolean bl2) {
        this.b = bl2;
        return this;
    }

    public b a() {
        b b10 = new b(null);
        Object object = com.huawei.updatesdk.a.a.d.h.c.f();
        String string2 = ",";
        object = com.huawei.updatesdk.a.a.d.e.a(object, string2);
        com.huawei.updatesdk.a.a.d.h.b.a(b10, (String)object);
        int n10 = Integer.parseInt(com.huawei.updatesdk.a.a.d.h.c.f(this.a));
        com.huawei.updatesdk.a.a.d.h.b.a(b10, n10);
        object = this.b();
        com.huawei.updatesdk.a.a.d.h.b.b(b10, (String)object);
        n10 = (int)(this.b ? 1 : 0);
        if (n10 != 0) {
            object = com.huawei.updatesdk.a.a.d.h.c.a(this.a);
            com.huawei.updatesdk.a.a.d.h.b.c(b10, (String)object);
        }
        return b10;
    }
}

