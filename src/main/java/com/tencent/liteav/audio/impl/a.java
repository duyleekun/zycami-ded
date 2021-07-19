/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.telephony.PhoneStateListener
 */
package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import com.tencent.liteav.audio.impl.a$1;
import com.tencent.liteav.audio.impl.a$2;
import com.tencent.liteav.audio.impl.b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static final a a;
    private ConcurrentHashMap b;
    private PhoneStateListener c;
    private Context d;

    static {
        a a10;
        a = a10 = new a();
    }

    private a() {
        ConcurrentHashMap concurrentHashMap;
        this.b = concurrentHashMap = new ConcurrentHashMap();
        this.c = null;
    }

    public static /* synthetic */ PhoneStateListener a(a a10) {
        return a10.c;
    }

    public static /* synthetic */ PhoneStateListener a(a a10, PhoneStateListener phoneStateListener) {
        a10.c = phoneStateListener;
        return phoneStateListener;
    }

    public static a a() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10) {
        synchronized (this) {
            Iterator iterator2 = this.b;
            iterator2 = ((ConcurrentHashMap)((Object)iterator2)).entrySet();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (Map.Entry)object;
                object = object.getValue();
                object = (WeakReference)object;
                object = ((Reference)object).get();
                if ((object = (b)object) != null) {
                    object.onCallStateChanged(n10);
                    continue;
                }
                iterator2.remove();
            }
            return;
        }
    }

    public static /* synthetic */ void a(a a10, int n10) {
        a10.a(n10);
    }

    public static /* synthetic */ Context b(a a10) {
        return a10.d;
    }

    public void a(Context context) {
        Object object = this.c;
        if (object != null) {
            return;
        }
        this.d = context = context.getApplicationContext();
        object = Looper.getMainLooper();
        context = new Handler((Looper)object);
        object = new a$1(this);
        context.post((Runnable)object);
    }

    public void a(b b10) {
        synchronized (this) {
            if (b10 == null) {
                return;
            }
            ConcurrentHashMap concurrentHashMap = this.b;
            int n10 = b10.hashCode();
            Integer n11 = n10;
            WeakReference<b> weakReference = new WeakReference<b>(b10);
            concurrentHashMap.put(n11, weakReference);
            return;
        }
    }

    public void finalize() {
        super.finalize();
        PhoneStateListener phoneStateListener = this.c;
        if (phoneStateListener != null && (phoneStateListener = this.d) != null) {
            Object object = Looper.getMainLooper();
            phoneStateListener = new Handler(object);
            object = new a$2(this);
            phoneStateListener.post((Runnable)object);
        }
    }
}

