/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.geetest.sdk;

import android.os.Looper;
import android.text.TextUtils;
import com.geetest.sdk.ad;
import com.geetest.sdk.af;
import com.geetest.sdk.af$a;
import com.geetest.sdk.ah;
import com.geetest.sdk.al;
import com.geetest.sdk.ao;
import com.geetest.sdk.aq;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ae {
    private static ae k;
    private ConcurrentLinkedQueue a;
    private String b;
    private String c;
    private long d;
    private long e;
    private long f;
    private long g;
    private String h;
    private String i;
    private ah j;

    private ae(ad object) {
        Object object2 = new ConcurrentLinkedQueue();
        this.a = object2;
        Object object3 = "yyyy-MM-dd";
        super((String)object3);
        boolean bl2 = ((ad)object).a();
        if (bl2) {
            long l10;
            object3 = ((ad)object).b;
            super((String)object3, "gee_logger");
            this.c = object2 = ((File)object2).getAbsolutePath();
            this.b = object2 = ((ad)object).a;
            this.d = l10 = ((ad)object).d;
            this.f = l10 = ((ad)object).f;
            this.e = l10 = ((ad)object).c;
            this.g = l10 = ((ad)object).e;
            object3 = ((ad)object).g;
            this.h = object2 = new String((byte[])object3);
            object = ((ad)object).h;
            this.i = object2 = new String((byte[])object);
            this.b();
            return;
        }
        object = new NullPointerException("config's param is invalid");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ae a(ad ad2) {
        Object object = k;
        if (object != null) return k;
        object = ae.class;
        synchronized (object) {
            ae ae2 = k;
            if (ae2 != null) return k;
            k = ae2 = new ae(ad2);
            return k;
        }
    }

    private void b() {
        ah ah2 = this.j;
        if (ah2 == null) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.a;
            String string2 = this.b;
            String string3 = this.c;
            long l10 = this.d;
            long l11 = this.e;
            long l12 = this.f;
            String string4 = this.h;
            String string5 = this.i;
            Object object = ah2;
            this.j = ah2 = new ah(concurrentLinkedQueue, string2, string3, l10, l11, l12, string4, string5);
            object = "geeLogger-thread";
            ah2.setName((String)object);
            ah2 = this.j;
            ah2.start();
        }
    }

    public void a() {
        Object object = this.c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        object = new af();
        Object object2 = af$a.OTHER;
        ((af)object).a = object2;
        object2 = this.a;
        ((ConcurrentLinkedQueue)object2).add(object);
        object = this.j;
        if (object != null) {
            ((ah)object).a();
        }
    }

    public void a(String object, int n10) {
        long l10;
        long l11;
        Looper looper;
        Object object2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        af af2 = new af();
        af2.a = object2 = af$a.WRITE;
        object2 = new aq();
        String string2 = Thread.currentThread().getName();
        Thread thread = Thread.currentThread();
        long l12 = thread.getId();
        boolean bl3 = false;
        Looper looper2 = Looper.getMainLooper();
        if (looper2 == (looper = Looper.myLooper())) {
            bl3 = true;
        }
        ((aq)object2).a = object;
        ((aq)object2).e = l11 = System.currentTimeMillis();
        ((aq)object2).f = n10;
        ((aq)object2).b = bl3;
        ((aq)object2).c = l12;
        ((aq)object2).d = string2;
        af2.b = object2;
        object = this.a;
        long l13 = ((ConcurrentLinkedQueue)object).size();
        long l14 = l13 - (l10 = this.g);
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 < 0) {
            this.a.add(af2);
            object = this.j;
            if (object != null) {
                ((ah)object).a();
            }
        }
    }

    public void a(String[] object, ao ao2) {
        int n10;
        object = this.c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        String string2 = this.c;
        object = new File(string2);
        if ((object = ((File)object).list()) != null && (n10 = ((Object)object).length) > 0) {
            for (Object object2 : object) {
                af$a af$a;
                boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
                if (bl3) continue;
                af af2 = new af();
                al al2 = new al();
                af2.a = af$a = af$a.SEND;
                al2.b = object2;
                al2.d = ao2;
                af2.c = al2;
                this.a.add(af2);
                object2 = this.j;
                if (object2 == null) continue;
                ((ah)object2).a();
            }
        }
    }
}

