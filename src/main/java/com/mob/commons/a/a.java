/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.commons.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.mob.MobSDK;
import com.mob.commons.FBListener;
import com.mob.commons.a.a$1;
import com.mob.commons.a.a$2;
import com.mob.commons.a.d;
import com.mob.commons.a.m;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;
import java.util.Map;

public class a
extends d
implements Handler.Callback {
    private SharePrefrenceHelper a;
    private FBListener b = null;
    private long c = 0L;
    private HashMap d;
    private boolean e;
    private boolean f;
    private Handler g;

    public a() {
        a$1 a$1 = new a$1(this);
        a$1.start();
    }

    public static /* synthetic */ long a(a a10, long l10) {
        a10.c = l10;
        return l10;
    }

    public static /* synthetic */ Handler a(a a10, Handler handler) {
        a10.g = handler;
        return handler;
    }

    public static /* synthetic */ boolean a(a a10) {
        return a10.e;
    }

    public static /* synthetic */ Handler b(a a10) {
        return a10.g;
    }

    public static /* synthetic */ boolean c(a a10) {
        return a10.f;
    }

    public static /* synthetic */ void d(a a10) {
        a10.h();
    }

    public static /* synthetic */ void e(a a10) {
        a10.j();
    }

    public static /* synthetic */ void f(a a10) {
        a10.k();
    }

    private void h() {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object = "type";
        Object object2 = "PV";
        hashMap.put(object, object2);
        object = "datetime";
        long l10 = com.mob.commons.b.a();
        object2 = l10;
        hashMap.put(object, object2);
        object = com.mob.commons.c.a();
        l10 = com.mob.commons.b.a();
        try {
            ((c)object).a(l10, hashMap);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i() {
        synchronized (this) {
            SharePrefrenceHelper sharePrefrenceHelper = this.a;
            if (sharePrefrenceHelper == null) {
                Context context = MobSDK.getContext();
                this.a = sharePrefrenceHelper = new SharePrefrenceHelper(context);
                String string2 = "top_time";
                sharePrefrenceHelper.open(string2);
            }
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        synchronized (this) {
            block6: {
                long l10;
                Object[] objectArray;
                Object object;
                Object object2;
                long l11;
                HashMap hashMap;
                try {
                    hashMap = this.d;
                    if (hashMap == null) {
                        hashMap = new HashMap();
                        this.d = hashMap;
                    }
                    l11 = com.mob.commons.b.a();
                    object2 = MobLog.getInstance();
                    object = new StringBuilder();
                    objectArray = "[cache] foregndAt: ";
                    ((StringBuilder)object).append((String)objectArray);
                    l10 = this.c;
                    ((StringBuilder)object).append(l10);
                    objectArray = ", duration: ";
                    ((StringBuilder)object).append((String)objectArray);
                    l10 = this.c;
                    l10 = l11 - l10;
                }
                catch (Throwable throwable) {
                    NLog nLog = MobLog.getInstance();
                    nLog.w(throwable);
                    break block6;
                }
                {
                    ((StringBuilder)object).append(l10);
                    object = ((StringBuilder)object).toString();
                    objectArray = null;
                    objectArray = new Object[]{};
                    ((NLog)object2).d(object, objectArray);
                    object2 = this.d;
                    long l12 = this.c;
                    object = l12;
                    hashMap = Long.valueOf(l11);
                    ((HashMap)object2).put(object, hashMap);
                    hashMap = this.d;
                    this.a(hashMap);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void k() {
        synchronized (this) {
            HashMap<Object, Object[]> hashMap;
            try {
                boolean bl2;
                this.i();
                Object object = this.c();
                if (object != null && !(bl2 = ((HashMap)object).isEmpty())) {
                    object = ((HashMap)object).entrySet();
                    object = object.iterator();
                    while (bl2 = object.hasNext()) {
                        hashMap = object.next();
                        hashMap = (Map.Entry)((Object)hashMap);
                        Object object2 = hashMap.getKey();
                        object2 = (Long)object2;
                        long l10 = (Long)object2;
                        hashMap = hashMap.getValue();
                        hashMap = (Long)((Object)hashMap);
                        long l11 = (Long)((Object)hashMap);
                        long l12 = l11 - l10;
                        hashMap = MobLog.getInstance();
                        StringBuilder stringBuilder = new StringBuilder();
                        String string2 = "foregndAt: ";
                        stringBuilder.append(string2);
                        stringBuilder.append(l10);
                        object2 = ", until: ";
                        stringBuilder.append((String)object2);
                        stringBuilder.append(l11);
                        object2 = ", runtimes: ";
                        stringBuilder.append((String)object2);
                        stringBuilder.append(l12);
                        object2 = stringBuilder.toString();
                        Object object3 = null;
                        object3 = new Object[]{};
                        ((NLog)((Object)hashMap)).d(object2, object3);
                        hashMap = new HashMap<Object, Object[]>();
                        object2 = "type";
                        object3 = "BACK_INFO";
                        hashMap.put(object2, (Object[])object3);
                        object2 = "datetime";
                        long l13 = com.mob.commons.b.a();
                        object3 = l13;
                        hashMap.put(object2, (Object[])object3);
                        object2 = new HashMap();
                        object3 = "until";
                        Long l14 = l11;
                        ((HashMap)object2).put(object3, l14);
                        object3 = "runtimes";
                        l14 = l12;
                        ((HashMap)object2).put(object3, l14);
                        object3 = "data";
                        hashMap.put(object3, (Object[])object2);
                        object2 = com.mob.commons.c.a();
                        long l15 = com.mob.commons.b.a();
                        ((c)object2).a(l15, hashMap);
                    }
                    object = this.d;
                    if (object != null) {
                        ((HashMap)object).clear();
                    }
                    object = null;
                    this.a((HashMap)null);
                }
            }
            catch (Throwable throwable) {
                hashMap = MobLog.getInstance();
                ((NLog)((Object)hashMap)).w(throwable);
            }
            return;
        }
    }

    public void a(Message message) {
        int n10 = message.what;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 == n11) {
                this.j();
                message = this.g;
                long l10 = com.mob.commons.b.C();
                long l11 = 1000L;
                message.sendEmptyMessageDelayed(n11, l10 *= l11);
            }
        } else {
            this.k();
            message = this.g;
            message.sendEmptyMessage(n11);
        }
    }

    public void a(HashMap object) {
        boolean bl2;
        this.i();
        String string2 = "key_active_log";
        if (object != null && !(bl2 = ((HashMap)object).isEmpty())) {
            SharePrefrenceHelper sharePrefrenceHelper = this.a;
            sharePrefrenceHelper.put(string2, object);
        } else {
            object = this.a;
            ((SharePrefrenceHelper)object).remove(string2);
        }
    }

    public void a_() {
        boolean bl2;
        this.e = bl2 = com.mob.commons.b.B();
        this.f = bl2 = com.mob.commons.b.w();
        boolean bl3 = this.e;
        if (bl3 || bl2) {
            Object object = new a$2(this);
            this.b = object;
            object = m.a();
            FBListener fBListener = this.b;
            ((m)object).a(fBListener);
        }
    }

    public void b() {
        Object object = this.b;
        if (object != null) {
            object = m.a();
            FBListener fBListener = this.b;
            ((m)object).b(fBListener);
        }
    }

    public HashMap c() {
        this.i();
        HashMap hashMap = this.a;
        Object object = "key_active_log";
        hashMap = ((SharePrefrenceHelper)((Object)hashMap)).get((String)object);
        try {
            hashMap = hashMap;
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).d(throwable);
            hashMap = null;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        return hashMap;
    }
}

