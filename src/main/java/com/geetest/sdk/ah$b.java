/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.ah;
import com.geetest.sdk.ao$a;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ah$b
implements ao$a {
    public final /* synthetic */ ah a;

    public ah$b(ah ah2) {
        this.a = ah2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10) {
        Object object = ah.a(this.a);
        synchronized (object) {
            Object object2 = this.a;
            ah.a((ah)object2, n10);
            int n11 = 10002;
            if (n10 == n11) {
                Object object3 = this.a;
                object3 = ah.c((ah)object3);
                object2 = this.a;
                object2 = ah.b((ah)object2);
                ((ConcurrentLinkedQueue)object3).addAll(object2);
                object3 = this.a;
                object3 = ah.b((ah)object3);
                ((ConcurrentLinkedQueue)object3).clear();
                object3 = this.a;
                ((ah)object3).a();
            }
            return;
        }
    }
}

