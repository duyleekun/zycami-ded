/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty;

import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.beauty.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class d$a {
    public WeakReference a;
    private HashMap b;

    public d$a(d d10) {
        WeakReference<d> weakReference = new WeakReference<d>();
        this.b = weakReference;
        this.a = weakReference = new WeakReference<d>(d10);
    }

    public String a() {
        boolean bl2;
        Object object = this.b.keySet().iterator();
        String string2 = "";
        while (bl2 = object.hasNext()) {
            String string3 = (String)object.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            stringBuilder.append(":");
            string2 = (String)this.b.get(string3);
            stringBuilder.append(string2);
            stringBuilder.append(" ");
            string2 = stringBuilder.toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("{");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("}");
        return ((StringBuilder)object).toString();
    }

    public void a(String object, int n10) {
        Object object2 = this.b;
        String string2 = String.valueOf(n10);
        ((HashMap)object2).put(object, string2);
        object = (d)this.a.get();
        if (object != null && (string2 = ((a)object).getID()) != null && (n10 = string2.length()) > 0) {
            n10 = 3001;
            object2 = this.a();
            ((a)object).setStatusValue(n10, object2);
        }
    }
}

