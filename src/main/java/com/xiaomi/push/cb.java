/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.bz;
import com.xiaomi.push.ca;
import com.xiaomi.push.cb$a;
import com.xiaomi.push.cb$c;
import com.xiaomi.push.cc;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cb {
    private static volatile cb a;
    private Context a;
    private ca a;
    private final ArrayList a;
    private final HashMap a;
    private ThreadPoolExecutor a;

    private cb(Context context) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        arrayList = new ArrayList(1, 1, 15, timeUnit, linkedBlockingQueue);
        this.a = arrayList;
        this.a = arrayList = new ArrayList();
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private bz a(String string2) {
        Object object = (bz)((Object)this.a.get(string2));
        if (object != null) return object;
        HashMap hashMap = this.a;
        synchronized (hashMap) {
            if (object != null) return object;
            object = this.a;
            Object object2 = this.a;
            object = ((ca)object).a((Context)object2, string2);
            object2 = this.a;
            ((HashMap)object2).put(string2, object);
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static cb a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = cb.class;
        synchronized (object) {
            cb cb2 = a;
            if (cb2 != null) return a;
            a = cb2 = new cb(context);
            return a;
        }
    }

    public static /* synthetic */ ArrayList a(cb cb2) {
        return cb2.a;
    }

    private void a() {
        ai ai2 = ai.a(this.a);
        cc cc2 = new cc(this);
        ak ak2 = ak.a(this.a);
        int n10 = hr.bb.a();
        int n11 = ak2.a(n10, 5);
        ai2.b(cc2, n11);
    }

    public String a(String string2) {
        return this.a(string2).a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(cb$a object) {
        Object object2;
        if (object == null) {
            return;
        }
        Object object3 = this.a;
        if (object3 == null) {
            object = new IllegalStateException("should exec init method first!");
            throw object;
        }
        object3 = ((cb$a)object).a();
        Cloneable cloneable = this.a;
        synchronized (cloneable) {
            object2 = this.a;
            object2 = object2.get(object3);
            object2 = (bz)((Object)object2);
            if (object2 == null) {
                object2 = this.a;
                Object object4 = this.a;
                object2 = ((ca)object2).a((Context)object4, (String)object3);
                object4 = this.a;
                ((HashMap)object4).put(object3, object2);
            }
        }
        object3 = this.a;
        boolean bl2 = ((ThreadPoolExecutor)object3).isShutdown();
        if (!bl2) {
            object3 = this.a;
            ((cb$a)object).a((bz)((Object)object2), (Context)object3);
            object3 = this.a;
            synchronized (object3) {
                cloneable = this.a;
                ((ArrayList)cloneable).add(object);
                this.a();
            }
        }
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.a;
        boolean bl2 = threadPoolExecutor.isShutdown();
        if (!bl2) {
            threadPoolExecutor = this.a;
            threadPoolExecutor.execute(runnable);
        }
    }

    public void a(ArrayList iterator2) {
        Object object = this.a;
        if (object != null) {
            object = new Object();
            Object object2 = this.a;
            boolean bl2 = ((ThreadPoolExecutor)object2).isShutdown();
            if (!bl2) {
                Object object3;
                Object object4;
                iterator2 = ((ArrayList)((Object)iterator2)).iterator();
                while (bl2 = iterator2.hasNext()) {
                    object2 = (cb$a)iterator2.next();
                    boolean bl3 = ((cb$a)object2).a();
                    if (bl3) {
                        object4 = ((cb$a)object2).a();
                        object4 = this.a((String)object4);
                        object3 = this.a;
                        ((cb$a)object2).a((bz)((Object)object4), (Context)object3);
                    }
                    object4 = ((cb$a)object2).a();
                    if ((object4 = (ArrayList)((HashMap)object).get(object4)) == null) {
                        object4 = new ArrayList();
                        object3 = ((cb$a)object2).a();
                        ((HashMap)object).put(object3, object4);
                    }
                    ((ArrayList)object4).add(object2);
                }
                iterator2 = ((HashMap)object).keySet().iterator();
                while (bl2 = iterator2.hasNext()) {
                    int n10;
                    object2 = (String)iterator2.next();
                    object4 = (ArrayList)((HashMap)object).get(object2);
                    if (object4 == null || (n10 = ((ArrayList)object4).size()) <= 0) continue;
                    object3 = new cb$c((String)object2, (ArrayList)object4);
                    bl2 = false;
                    object2 = ((cb$a)object4.get((int)0)).a;
                    object4 = this.a;
                    ((cb$a)object3).a((bz)((Object)object2), (Context)object4);
                    object2 = this.a;
                    ((ThreadPoolExecutor)object2).execute((Runnable)object3);
                }
            }
            return;
        }
        iterator2 = new Iterator("should exec setDbHelperFactory method first!");
        throw iterator2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(cb$a object) {
        Object object2;
        if (object == null) {
            return;
        }
        Object object3 = this.a;
        if (object3 == null) {
            object = new IllegalStateException("should exec init method first!");
            throw object;
        }
        object3 = ((cb$a)object).a();
        HashMap hashMap = this.a;
        synchronized (hashMap) {
            object2 = this.a;
            object2 = object2.get(object3);
            object2 = (bz)((Object)object2);
            if (object2 == null) {
                object2 = this.a;
                Object object4 = this.a;
                object2 = ((ca)object2).a((Context)object4, (String)object3);
                object4 = this.a;
                ((HashMap)object4).put(object3, object2);
            }
        }
        object3 = this.a;
        boolean bl2 = ((ThreadPoolExecutor)object3).isShutdown();
        if (!bl2) {
            object3 = this.a;
            ((cb$a)object).a((bz)((Object)object2), (Context)object3);
            this.a((Runnable)object);
        }
    }
}

