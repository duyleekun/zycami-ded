/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.i;
import java.util.ArrayList;
import java.util.HashMap;

public class f {
    private static f a;
    private HashMap b;

    private f() {
        boolean bl2;
        Object object = this.c();
        this.b = object;
        if (object == null) {
            object = new HashMap();
            this.b = object;
        }
        if ((object = MobProductCollector.getProducts()) != null && !(bl2 = ((ArrayList)object).isEmpty())) {
            object = ((ArrayList)object).iterator();
            while (bl2 = object.hasNext()) {
                HashMap hashMap = this.b;
                Object object2 = (MobProduct)object.next();
                Object object3 = object2.getProductTag();
                boolean bl3 = hashMap.containsKey(object3);
                if (bl3) continue;
                hashMap = this.b;
                object2 = object2.getProductTag();
                object3 = 0;
                hashMap.put(object2, object3);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static f a() {
        Object object = a;
        if (object != null) return a;
        object = f.class;
        synchronized (object) {
            f f10 = a;
            if (f10 != null) return a;
            a = f10 = new f();
            return a;
        }
    }

    private void a(HashMap hashMap) {
        try {
            i.c(hashMap);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private HashMap c() {
        try {
            return i.u();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    public void a(MobProduct object, int n10) {
        synchronized (this) {
            if (object != null) {
                HashMap hashMap = this.b;
                object = object.getProductTag();
                Integer n11 = n10;
                hashMap.put(object, n11);
                object = this.b;
                this.a((HashMap)object);
            }
            return;
        }
    }

    public HashMap b() {
        synchronized (this) {
            HashMap hashMap = this.b;
            return hashMap;
        }
    }
}

