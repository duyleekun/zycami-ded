/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net;

import g.a0;
import g.c0;
import g.d0;
import g.u;
import g.u$a;
import g.v;
import m.a.a;

public class ApiLogInterceptor
implements u {
    private static final String TAG = "ApiLogInterceptor";

    public c0 intercept(u$a object) {
        Object object2 = object.C();
        int n10 = 1;
        Object object3 = new Object[n10];
        String string2 = ((a0)object2).toString();
        object3[0] = string2;
        a.i("request:%s", object3);
        object = object.c((a0)object2);
        object2 = ((c0)object).r0().contentType();
        object3 = ((c0)object).r0().string();
        Object object4 = new Object[n10];
        object4[0] = object3;
        string2 = "response body:%s";
        a.i(string2, object4);
        object4 = ((c0)object).r0();
        if (object4 != null) {
            object2 = d0.create((v)object2, (String)object3);
            object = ((c0)object).G0().b((d0)object2).c();
        }
        return object;
    }
}

