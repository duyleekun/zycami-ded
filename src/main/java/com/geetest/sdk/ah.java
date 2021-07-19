/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.StatFs
 *  android.text.TextUtils
 */
package com.geetest.sdk;

import android.os.StatFs;
import android.text.TextUtils;
import com.geetest.sdk.ac;
import com.geetest.sdk.af;
import com.geetest.sdk.af$a;
import com.geetest.sdk.ag;
import com.geetest.sdk.ah$a;
import com.geetest.sdk.ah$b;
import com.geetest.sdk.ah$c;
import com.geetest.sdk.ai;
import com.geetest.sdk.aj;
import com.geetest.sdk.al;
import com.geetest.sdk.ao;
import com.geetest.sdk.ap;
import com.geetest.sdk.aq;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ah
extends Thread {
    private final Object a;
    private final Object b;
    private volatile boolean c;
    private long d;
    private boolean e;
    private File f;
    private boolean g;
    private long h;
    private ag i;
    private ConcurrentLinkedQueue j;
    private String k;
    private String l;
    private long m;
    private long n;
    private long o;
    private String p;
    private String q;
    private int s;
    private ConcurrentLinkedQueue t;
    private ExecutorService u;

    public ah(ConcurrentLinkedQueue concurrentLinkedQueue, String string2, String string3, long l10, long l11, long l12, String string4, String string5) {
        ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
        this.a = concurrentLinkedQueue2;
        concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
        this.b = concurrentLinkedQueue2;
        this.c = true;
        this.t = concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
        this.j = concurrentLinkedQueue;
        this.k = string2;
        this.l = string3;
        this.m = l10;
        this.n = l11;
        this.o = l12;
        this.p = string4;
        this.q = string5;
    }

    public static /* synthetic */ int a(ah ah2, int n10) {
        ah2.s = n10;
        return n10;
    }

    public static /* synthetic */ Object a(ah ah2) {
        return ah2.b;
    }

    private void a(long l10) {
        String string2 = this.l;
        String[] stringArray = new File(string2);
        int n10 = stringArray.isDirectory();
        if (n10 != 0 && (stringArray = stringArray.list()) != null) {
            for (String string3 : stringArray) {
                int n11 = TextUtils.isEmpty((CharSequence)string3);
                if (n11 != 0) continue;
                Object object = "\\.";
                object = string3.split((String)object);
                int n12 = ((String[])object).length;
                if (n12 <= 0) continue;
                String string4 = object[0];
                long l11 = Long.parseLong(string4);
                n12 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
                if (n12 > 0) continue;
                n11 = ((String[])object).length;
                n12 = 1;
                if (n11 != n12) continue;
                string4 = this.l;
                try {
                    object = new File(string4, string3);
                    ((File)object).delete();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(af object) {
        boolean bl2;
        Object object2;
        if (object == null) return;
        boolean bl3 = ((af)object).a();
        if (!bl3) {
            return;
        }
        Object object3 = this.i;
        if (object3 == null) {
            object3 = ag.b();
            this.i = object3;
            object2 = new ah$a(this);
            ((ag)object3).a((aj)object2);
            ag ag2 = this.i;
            String string2 = this.k;
            String string3 = this.l;
            long l10 = this.n;
            int n10 = (int)l10;
            String string4 = this.p;
            String string5 = this.q;
            ag2.a(string2, string3, n10, string4, string5);
            object3 = this.i;
            bl2 = ac.c;
            ((ag)object3).a(bl2);
        }
        if ((object3 = ((af)object).a) == (object2 = af$a.WRITE)) {
            object = ((af)object).b;
            this.a((aq)object);
            return;
        }
        object2 = af$a.SEND;
        if (object3 != object2) {
            object = af$a.FLUSH;
            if (object3 != object) return;
            this.b();
            return;
        }
        object3 = object.c.d;
        if (object3 == null) return;
        object3 = this.b;
        synchronized (object3) {
            bl2 = this.s;
            boolean bl4 = 10001 != 0;
            if (bl2 == bl4) {
                object2 = this.t;
                ((ConcurrentLinkedQueue)object2).add(object);
            } else {
                object = ((af)object).c;
                this.a((al)object);
            }
            return;
        }
    }

    private void a(al object) {
        ai.a("Logan send start");
        Object object2 = this.l;
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 == 0 && object != null && (n10 = ((al)object).a()) != 0) {
            n10 = this.b((al)object);
            if (n10 == 0) {
                ai.a("Logan prepare log file failed, can't find log file");
                return;
            }
            ((al)object).d.a((al)object);
            object2 = ((al)object).d;
            ah$b ah$b = new ah$b(this);
            ((ao)object2).setCallBackListener(ah$b);
            this.s = n10 = 10001;
            object2 = this.u;
            if (object2 == null) {
                object2 = new ah$c(this);
                this.u = object2 = Executors.newSingleThreadExecutor((ThreadFactory)object2);
            }
            object2 = this.u;
            object = ((al)object).d;
            object2.execute((Runnable)object);
        }
    }

    private void a(aq aq2) {
        long l10;
        long l11;
        Object object;
        Object object2;
        Object object3 = ac.c;
        if (object3 != 0) {
            object2 = "Logan write start";
            ai.a((String)object2);
        }
        if ((object2 = this.f) == null) {
            object = this.l;
            this.f = object2 = new File((String)object);
        }
        if ((object3 = this.d()) == 0) {
            l11 = ap.a();
            l10 = this.m;
            l10 = l11 - l10;
            this.a(l10);
            this.d = l11;
        }
        l11 = System.currentTimeMillis();
        l10 = this.h;
        long l12 = (l11 -= l10) - (l10 = 60000L);
        object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 > 0) {
            object3 = this.c();
            this.g = object3;
        }
        this.h = l11 = System.currentTimeMillis();
        object3 = this.g;
        if (object3 == 0) {
            return;
        }
        object = this.i;
        int n10 = aq2.f;
        String string2 = aq2.a;
        long l13 = aq2.e;
        String string3 = aq2.d;
        long l14 = aq2.c;
        boolean bl2 = aq2.b;
        ((ag)object).a(n10, string2, l13, string3, l14, bl2);
    }

    private boolean a(String string2) {
        Object object = this.l;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = this.l;
        stringBuilder.append(string3);
        string3 = File.separator;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new File(string2);
        boolean bl4 = ((File)object).exists();
        if (bl4 && (bl4 = ((File)object).isFile())) {
            bl3 = true;
        }
        return bl3;
    }

    public static /* synthetic */ ConcurrentLinkedQueue b(ah ah2) {
        return ah2.t;
    }

    private void b() {
        Object object;
        boolean bl2 = ac.c;
        if (bl2) {
            object = "Logan flush start";
            ai.a((String)object);
        }
        if ((object = this.i) != null) {
            ((ag)object).a();
        }
    }

    private boolean b(al al2) {
        ai.a("prepare log file");
        CharSequence charSequence = al2.b;
        boolean bl2 = this.a((String)charSequence);
        if (bl2) {
            charSequence = new StringBuilder();
            String string2 = this.l;
            ((StringBuilder)charSequence).append(string2);
            string2 = File.separator;
            ((StringBuilder)charSequence).append(string2);
            string2 = al2.b;
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            al2.c = charSequence;
            return true;
        }
        al2.c = "";
        return false;
    }

    public static /* synthetic */ ConcurrentLinkedQueue c(ah ah2) {
        return ah2.j;
    }

    private boolean c() {
        int n10;
        block7: {
            StatFs statFs;
            block6: {
                long l10;
                String string2 = this.l;
                statFs = new StatFs(string2);
                int n11 = statFs.getBlockSize();
                long l11 = n11;
                n10 = statFs.getAvailableBlocks();
                long l12 = (long)n10 * l11;
                try {
                    l10 = this.o;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    illegalArgumentException.printStackTrace();
                }
                n10 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1));
                if (n10 <= 0) break block6;
                n10 = 1;
                break block7;
            }
            n10 = 0;
            statFs = null;
        }
        return n10 != 0;
    }

    private boolean d() {
        long l10;
        long l11;
        int n10;
        long l12 = this.d;
        long l13 = System.currentTimeMillis();
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        n10 = object < 0 && (n10 = (l11 = (l12 += (l10 = 86400000L)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        boolean bl2 = this.e;
        if (bl2) return;
        Object object = this.a;
        synchronized (object) {
            Object object2 = this.a;
            object2.notify();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        super.run();
        boolean bl2;
        while (bl2 = this.c) {
            Object object = this.a;
            synchronized (object) {
                boolean bl3;
                this.e = bl3 = true;
                try {
                    Object object2 = this.j;
                    object2 = ((ConcurrentLinkedQueue)object2).poll();
                    object2 = (af)object2;
                    if (object2 == null) {
                        this.e = false;
                        object2 = this.a;
                        object2.wait();
                        this.e = bl3;
                    } else {
                        this.a((af)object2);
                    }
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    this.e = false;
                }
            }
        }
        return;
    }
}

