/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.e;

import com.baidu.location.BDLocation;
import com.baidu.location.e.c;
import com.baidu.location.e.d;
import com.baidu.location.e.h;
import com.baidu.location.e.k;
import java.util.LinkedHashMap;

public class c$b
extends Thread {
    private String a;
    public final /* synthetic */ c b;
    private Long c;
    private BDLocation d;
    private BDLocation e;
    private BDLocation f;
    private String g;
    private LinkedHashMap h;

    private c$b(c c10, String string2, Long l10, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String string3, LinkedHashMap linkedHashMap) {
        this.b = c10;
        this.a = string2;
        this.c = l10;
        this.d = bDLocation;
        this.e = bDLocation2;
        this.f = bDLocation3;
        this.g = string3;
        this.h = linkedHashMap;
    }

    public /* synthetic */ c$b(c c10, String string2, Long l10, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String string3, LinkedHashMap linkedHashMap, d d10) {
        this(c10, string2, l10, bDLocation, bDLocation2, bDLocation3, string3, linkedHashMap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            Object object = this.b;
            Object object2 = this.a;
            Object object3 = this.c;
            BDLocation bDLocation = this.d;
            com.baidu.location.e.c.a((c)object, (String)object2, (Long)object3, bDLocation);
            object = this.b;
            com.baidu.location.e.c.a((c)object, null);
            object = this.b;
            com.baidu.location.e.c.b((c)object, null);
            object = this.b;
            object2 = this.h;
            com.baidu.location.e.c.a((c)object, (LinkedHashMap)object2);
            object3 = this.b;
            bDLocation = this.f;
            BDLocation bDLocation2 = this.d;
            BDLocation bDLocation3 = this.e;
            String string2 = this.a;
            Long l10 = this.c;
            com.baidu.location.e.c.a((c)object3, bDLocation, bDLocation2, bDLocation3, string2, l10);
            object = this.g;
            if (object != null) {
                object = this.b;
                object = com.baidu.location.e.c.a((c)object);
                object = ((h)object).j();
                object2 = this.g;
                ((k)object).a((String)object2);
            }
        }
        catch (Exception exception) {}
        this.h = null;
        this.a = null;
        this.g = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }
}

