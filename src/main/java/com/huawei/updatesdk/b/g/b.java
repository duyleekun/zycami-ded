/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.AsyncTask$Status
 */
package com.huawei.updatesdk.b.g;

import android.os.AsyncTask;
import com.huawei.updatesdk.a.b.c.c.a;
import com.huawei.updatesdk.b.g.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

public class b {
    private static List a;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList;
        a = copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

    public static com.huawei.updatesdk.a.b.c.b a(com.huawei.updatesdk.b.b.c c10, a a10) {
        com.huawei.updatesdk.a.b.c.b b10 = new com.huawei.updatesdk.a.b.c.b(c10, a10);
        b.a(b10, c10);
        return b10;
    }

    public static List a() {
        return a;
    }

    public static void a(AsyncTask asyncTask) {
        boolean bl2;
        if (asyncTask == null) {
            return;
        }
        Iterator iterator2 = a.iterator();
        while (bl2 = iterator2.hasNext()) {
            AsyncTask.Status status;
            AsyncTask.Status status2;
            Object object = (AsyncTask)iterator2.next();
            if (object == null || (status2 = object.getStatus()) != (status = AsyncTask.Status.FINISHED) && !(bl2 = object.isCancelled())) continue;
            object = a;
            object.remove(asyncTask);
        }
        a.add(asyncTask);
    }

    private static void a(com.huawei.updatesdk.a.b.c.b b10, com.huawei.updatesdk.b.b.c object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("executeTask, ActiveCount:");
        ThreadPoolExecutor threadPoolExecutor = c.a;
        int n10 = threadPoolExecutor.getActiveCount();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", TaskCount:");
        long l10 = threadPoolExecutor.getTaskCount();
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        com.huawei.updatesdk.a.a.c.a.a.a.a("StoreAgent", (String)object);
        b10.a(threadPoolExecutor);
    }
}

