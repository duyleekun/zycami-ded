/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.b.c$4;
import com.sina.weibo.sdk.b.c$b;
import java.util.concurrent.ThreadPoolExecutor;

public final class b {
    private a O;

    private b() {
        a a10 = null;
        this.O = null;
        if (!false) {
            this.O = a10 = new a();
        }
    }

    public /* synthetic */ b(byte by2) {
        this();
    }

    public final void a(c object) {
        Object object2;
        ThreadPoolExecutor threadPoolExecutor = this.O.M;
        int n10 = ((c)object).Q;
        int n11 = c$b.Z;
        if (n10 != n11) {
            object2 = c$4.W;
            n11 = ((c)object).Q;
            int n12 = 1;
            n10 = object2[n11 -= n12];
            if (n10 != n12) {
                n11 = 2;
                if (n10 == n11) {
                    object = new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    throw object;
                }
            } else {
                object = new IllegalStateException("Cannot execute task: the task is already running.");
                throw object;
            }
        }
        ((c)object).Q = n10 = c$b.aa;
        object2 = ((c)object).R;
        Object[] objectArray = ((c)object).U;
        object2.ad = objectArray;
        object2.priority = n11 = ((c)object).T;
        object = ((c)object).S;
        threadPoolExecutor.execute((Runnable)object);
    }
}

