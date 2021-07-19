/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ai$a;
import com.xiaomi.push.cb;
import com.xiaomi.push.cb$a;
import java.util.ArrayList;

public class cc
extends ai$a {
    public final /* synthetic */ cb a;

    public cc(cb cb2) {
        this.a = cb2;
    }

    public int a() {
        return 100957;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        ArrayList arrayList = cb.a(this.a);
        synchronized (arrayList) {
            Object object = this.a;
            object = cb.a((cb)object);
            int n10 = ((ArrayList)object).size();
            if (n10 > 0) {
                int n11;
                object = this.a;
                n10 = ((ArrayList)(object = cb.a((cb)object))).size();
                if (n10 > (n11 = 1)) {
                    object = this.a;
                    ArrayList arrayList2 = cb.a((cb)object);
                    ((cb)object).a(arrayList2);
                } else {
                    object = this.a;
                    Object object2 = cb.a((cb)object);
                    object2 = ((ArrayList)object2).get(0);
                    object2 = (cb$a)object2;
                    ((cb)object).b((cb$a)object2);
                }
                object = this.a;
                object = cb.a((cb)object);
                ((ArrayList)object).clear();
                System.gc();
            }
            return;
        }
    }
}

