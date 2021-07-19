/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.os.SystemClock
 */
package com.mob.commons.a;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.mob.MobSDK;
import com.mob.commons.FBListener;
import com.mob.commons.a.m$1;
import com.mob.commons.a.m$2;
import com.mob.commons.b;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.utils.ActivityTracker;
import java.util.HashSet;

public class m {
    private static m a;
    private final HashSet b;
    private volatile Handler c;
    private String d;
    private long e;

    private m() {
        Object object = new HashSet();
        this.b = object;
        this.d = null;
        this.e = 0L;
        object = new m$1(this);
        object = MobHandlerThread.newHandler((Handler.Callback)object);
        this.c = object;
    }

    public static /* synthetic */ long a(m m10, long l10) {
        m10.e = l10;
        return l10;
    }

    public static m a() {
        Class<m> clazz = m.class;
        synchronized (clazz) {
            m m10 = a;
            if (m10 == null) {
                a = m10 = new m();
                m10 = m10.c;
                if (m10 != null) {
                    m10 = a;
                    m10 = m10.c;
                    m10.sendEmptyMessage(0);
                }
            }
            m10 = a;
            return m10;
        }
    }

    public static /* synthetic */ String a(m m10, String string2) {
        m10.d = string2;
        return string2;
    }

    private void a(long l10, boolean bl2) {
        long l11 = SystemClock.elapsedRealtime();
        boolean bl3 = true;
        com.mob.commons.b.a(l11, bl3);
        if (bl2) {
            bl2 = false;
            this.a(false, false, l10);
        }
    }

    public static /* synthetic */ void a(m m10) {
        m10.b();
    }

    public static /* synthetic */ void a(m m10, long l10, boolean bl2) {
        m10.a(l10, bl2);
    }

    public static /* synthetic */ void a(m m10, boolean bl2) {
        m10.a(bl2);
    }

    private void a(boolean bl2) {
        long l10 = 0L;
        boolean bl3 = true;
        com.mob.commons.b.a(l10, bl3);
        if (bl2) {
            bl2 = false;
            this.a(bl3, false, l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(boolean bl2, boolean bl3, long l10) {
        HashSet hashSet = this.b;
        synchronized (hashSet) {
            Object object = this.b;
            object = ((HashSet)object).iterator();
            boolean bl4;
            while (bl4 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (FBListener)object2;
                object2.onFBChanged(bl2, bl3, l10);
            }
            return;
        }
    }

    public static /* synthetic */ HashSet b(m m10) {
        return m10.b;
    }

    private void b() {
        ActivityTracker activityTracker = ActivityTracker.getInstance(MobSDK.getContext());
        m$2 m$2 = new m$2(this);
        activityTracker.addTracker(m$2);
    }

    public static /* synthetic */ long c(m m10) {
        return m10.e;
    }

    public static /* synthetic */ Handler d(m m10) {
        return m10.c;
    }

    public static /* synthetic */ String e(m m10) {
        return m10.d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(FBListener fBListener) {
        if (fBListener == null) {
            return;
        }
        HashSet hashSet = this.b;
        synchronized (hashSet) {
            HashSet hashSet2 = this.b;
            boolean bl2 = hashSet2.contains(fBListener);
            if (bl2) {
                return;
            }
            hashSet2 = this.c;
            if (hashSet2 != null) {
                int n10;
                hashSet2 = new Message();
                ((Message)hashSet2).what = n10 = 3;
                ((Message)hashSet2).obj = fBListener;
                fBListener = this.c;
                fBListener.sendMessage((Message)hashSet2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(FBListener fBListener) {
        if (fBListener == null) {
            return;
        }
        HashSet hashSet = this.b;
        synchronized (hashSet) {
            HashSet hashSet2 = this.b;
            hashSet2.remove(fBListener);
            return;
        }
    }
}

