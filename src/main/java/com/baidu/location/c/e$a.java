/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.c;

import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.c.e;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class e$a
extends f {
    public String a = null;
    public boolean b = false;
    public boolean c = false;
    public final /* synthetic */ e d;

    public e$a(e hashMap) {
        this.d = hashMap;
        this.k = hashMap = new HashMap();
    }

    public void a(String object, boolean bl2) {
        boolean bl3 = this.c;
        if (bl3) {
            return;
        }
        this.c = bl3 = true;
        this.a = object;
        this.b = bl2;
        object = aa.a().c();
        if (bl2) {
            String string2 = "loc.map.baidu.com";
            this.a((ExecutorService)object, bl3, string2);
        } else if (object != null) {
            String string3 = e.b(this.d);
            this.a((ExecutorService)object, string3);
        } else {
            object = e.b(this.d);
            this.e((String)object);
        }
    }

    public void a(boolean bl2) {
        Object object;
        if (bl2 && (object = this.j) != null) {
            boolean bl3 = this.b;
            if (bl3) {
                object = this.d;
                byte[] byArray = this.m;
                e.a((e)object, byArray);
            } else {
                e e10 = this.d;
                e.a(e10, (String)object);
            }
        } else {
            object = this.d;
            boolean bl4 = false;
            Object var4_7 = null;
            e.a((e)object, null);
        }
        object = this.k;
        if (object != null) {
            object.clear();
        }
        this.c = false;
    }

    public void b() {
        String string2;
        int n10;
        String string3;
        this.h = string3 = com.baidu.location.h.l.e();
        this.i = n10 = 2;
        string3 = Jni.encode(this.a);
        Map map = null;
        this.a = null;
        boolean bl2 = this.b;
        String string4 = "qt";
        if (bl2) {
            map = this.k;
            string2 = "grid";
        } else {
            map = this.k;
            string2 = "conf";
        }
        map.put(string4, string2);
        this.k.put("req", string3);
    }
}

