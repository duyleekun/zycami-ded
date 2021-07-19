/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.CoworkerThread$Builder3;

public class CoworkerThread$Builder3$1
extends Thread {
    public final /* synthetic */ CoworkerThread$Builder3 this$0;

    public CoworkerThread$Builder3$1(CoworkerThread$Builder3 coworkerThread$Builder3) {
        this.this$0 = coworkerThread$Builder3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        while (true) {
            try {
                object2 = this.this$0;
                object2 = CoworkerThread$Builder3.access$000((CoworkerThread$Builder3)object2);
                if (object2 != null) break;
                object2 = this.this$0;
                object2 = CoworkerThread$Builder3.access$100((CoworkerThread$Builder3)object2);
                synchronized (object2) {
                    object = this.this$0;
                }
            }
            catch (Throwable throwable) {
                object = this.this$0;
                CoworkerThread$Builder3.access$002((CoworkerThread$Builder3)object, throwable);
                break;
            }
            {
                object = CoworkerThread$Builder3.access$100((CoworkerThread$Builder3)object);
                object = object.call();
                if (object == null) break;
            }
            {
                object2 = this.this$0;
                object2 = CoworkerThread$Builder3.access$200((CoworkerThread$Builder3)object2);
                object2.call(object);
                continue;
            }
            break;
        }
        object2 = this.this$0;
        synchronized (object2) {
            object = this.this$0;
            CoworkerThread$Builder3.access$308((CoworkerThread$Builder3)object);
            object = this.this$0;
            int n10 = CoworkerThread$Builder3.access$300((CoworkerThread$Builder3)object);
            CoworkerThread$Builder3 coworkerThread$Builder3 = this.this$0;
            int n11 = CoworkerThread$Builder3.access$400(coworkerThread$Builder3);
            if (n10 == n11) {
                object = this.this$0;
                object.notify();
            }
            return;
        }
    }
}

