/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.util.SparseArray
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.aj;
import com.xiaomi.push.ak;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ai {
    private static volatile ai a;
    private SharedPreferences a;
    private SparseArray a;
    private Object a;
    private ScheduledThreadPoolExecutor a;

    private ai(Context context) {
        Object object = new ScheduledThreadPoolExecutor(1);
        this.a = object;
        this.a = object;
        this.a = object = new Object();
        context = context.getSharedPreferences("mipush_extra", 0);
        this.a = context;
    }

    public static /* synthetic */ SharedPreferences a(ai ai2) {
        return ai2.a;
    }

    public static /* synthetic */ SparseArray a(ai ai2) {
        return ai2.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ai a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = ai.class;
        synchronized (object) {
            ai ai2 = a;
            if (ai2 != null) return a;
            a = ai2 = new ai(context);
            return a;
        }
    }

    public static /* synthetic */ Object a(ai ai2) {
        return ai2.a;
    }

    private static String a(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("last_job_time");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ScheduledFuture a(ai$a object) {
        Object object2 = this.a;
        synchronized (object2) {
            SparseArray sparseArray = this.a;
            int n10 = ((ai$a)object).a();
            object = sparseArray.get(n10);
            return (ScheduledFuture)object;
        }
    }

    public void a(Runnable runnable) {
        this.a(runnable, 0);
    }

    public void a(Runnable runnable, int n10) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.a;
        long l10 = n10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        scheduledThreadPoolExecutor.schedule(runnable, l10, timeUnit);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(int n10) {
        Object object = this.a;
        synchronized (object) {
            Object object2 = this.a;
            object2 = object2.get(n10);
            object2 = (ScheduledFuture)object2;
            if (object2 == null) {
                return false;
            }
            SparseArray sparseArray = this.a;
            sparseArray.remove(n10);
            return object2.cancel(false);
        }
    }

    public boolean a(ai$a ai$a) {
        return this.b(ai$a, 0);
    }

    public boolean a(ai$a ai$a, int n10) {
        return this.a(ai$a, n10, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(ai$a ai$a, int n10, int n11) {
        int n12;
        ScheduledFuture<?> scheduledFuture;
        long l10;
        if (ai$a == null) return false;
        Object object = this.a(ai$a);
        if (object != null) {
            return false;
        }
        int n13 = ai$a.a();
        object = ai.a(n13);
        aj aj2 = new aj(this, ai$a, (String)object);
        Object object2 = this.a;
        long l11 = object2.getLong((String)object, 0L);
        l11 = Math.abs(System.currentTimeMillis() - l11) / 1000L;
        long l12 = l11 - (l10 = (long)(n10 - n11));
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 < 0) {
            l10 = (long)n10 - l11;
            n11 = (int)l10;
        }
        try {
            object2 = this.a;
            l10 = n11;
            long l13 = n10;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            scheduledFuture = ((ScheduledThreadPoolExecutor)object2).scheduleAtFixedRate(aj2, l10, l13, timeUnit);
            Object object4 = this.a;
            synchronized (object4) {
                object = this.a;
                n12 = ai$a.a();
            }
        }
        catch (Exception exception) {
            b.a(exception);
            return true;
        }
        {
            object.put(n12, scheduledFuture);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b(ai$a ai$a, int n10) {
        if (ai$a == null) return false;
        Object object = this.a(ai$a);
        if (object != null) {
            return false;
        }
        object = new ak(this, ai$a);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.a;
        long l10 = n10;
        Object object2 = TimeUnit.SECONDS;
        object2 = scheduledThreadPoolExecutor.schedule((Runnable)object, l10, (TimeUnit)((Object)object2));
        object = this.a;
        synchronized (object) {
            scheduledThreadPoolExecutor = this.a;
            int n11 = ai$a.a();
            scheduledThreadPoolExecutor.put(n11, object2);
            return true;
        }
    }
}

