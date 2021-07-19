/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.e;

import com.baidu.location.b.aa;
import com.baidu.location.e.h;
import com.baidu.location.e.k;
import com.baidu.location.h.f;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class k$a
extends f {
    public final /* synthetic */ k a;
    private int b;
    private long c;
    private String d;
    private boolean e;
    private boolean f;
    private k q;

    public k$a(k k10, k hashMap) {
        this.a = k10;
        this.q = hashMap;
        this.d = null;
        this.e = false;
        this.f = false;
        this.k = hashMap = new HashMap();
        this.b = 0;
        this.c = -1;
    }

    private void a() {
        int n10 = this.e;
        if (n10 == 0) {
            int n11;
            long l10;
            long l11;
            Object object = com.baidu.location.e.k.a(this.q);
            this.d = object;
            long l12 = this.c;
            long l13 = -1;
            long l14 = l12 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false && (n10 = (int)((l11 = (l12 += 86400000L) - (l10 = System.currentTimeMillis())) == 0L ? 0 : (l11 < 0L ? -1 : 1))) <= 0) {
                n10 = 0;
                object = null;
                this.b = 0;
                this.c = l13;
            }
            if ((object = this.d) != null && (n10 = this.b) < (n11 = 2)) {
                n10 = 1;
                this.e = n10;
                object = aa.a().c();
                String string2 = "https://ofloc.map.baidu.com/offline_loc";
                if (object != null) {
                    this.a((ExecutorService)object, string2);
                } else {
                    this.e(string2);
                }
            }
        }
    }

    public static /* synthetic */ void a(k$a k$a) {
        k$a.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean n10) {
        int n11;
        Object object;
        String string2 = "error";
        this.f = false;
        int n12 = 1;
        if (n10 != 0 && (object = this.j) != null) {
            try {
                JSONObject jSONObject = new JSONObject((String)object);
                n10 = (int)(jSONObject.has(string2) ? 1 : 0);
                if (n10 != 0 && (n10 = jSONObject.getInt(string2)) == (n11 = 161)) {
                    this.f = n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = (int)(this.f ? 1 : 0)) == 0) {
            long l10;
            this.b = n10 = this.b + n12;
            this.c = l10 = System.currentTimeMillis();
        }
        object = this.q;
        n11 = this.f;
        com.baidu.location.e.k.a((k)object, n11 != 0);
        this.e = false;
    }

    public void b() {
        this.k.clear();
        this.k.put("qt", "ofbh");
        Object object = this.k;
        String string2 = this.d;
        object.put("req", string2);
        this.h = object = com.baidu.location.e.h.b;
    }
}

