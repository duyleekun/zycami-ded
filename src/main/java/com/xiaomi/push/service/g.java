/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.xiaomi.push.service;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.g$a;
import com.xiaomi.push.service.g$b;
import com.xiaomi.push.service.g$c;
import com.xiaomi.push.service.g$c$a;
import com.xiaomi.push.service.g$d;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class g {
    private static long a;
    private static long b;
    private static long c;
    private final g$a a;
    private final g$c a;

    static {
        long l10;
        long l11 = SystemClock.elapsedRealtime();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            l10 = SystemClock.elapsedRealtime();
        }
        a = l10;
        b = l10;
    }

    public g() {
        this(false);
    }

    public g(String string2) {
        this(string2, false);
    }

    public g(String object, boolean bl2) {
        g$c g$c;
        Objects.requireNonNull(object, "name == null");
        this.a = g$c = new g$c((String)object, bl2);
        this.a = object = new g$a(g$c);
    }

    public g(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Timer-");
        long l10 = g.b();
        charSequence.append(l10);
        charSequence = charSequence.toString();
        this((String)charSequence, bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static long a() {
        Class<g> clazz = g.class;
        synchronized (clazz) {
            long l10 = SystemClock.elapsedRealtime();
            long l11 = b;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 > 0) {
                long l13 = a;
                l11 = l10 - l11;
                a = l13 += l11;
            }
            b = l10;
            return a;
        }
    }

    private static long b() {
        Class<g> clazz = g.class;
        synchronized (clazz) {
            long l10 = c;
            long l11 = 1L + l10;
            c = l11;
            return l10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(g$b object, long l10) {
        g$c g$c = this.a;
        synchronized (g$c) {
            Object object2 = this.a;
            Object object3 = g$c.a((g$c)object2);
            if (object3 != 0) {
                String string2 = "Timer was canceled";
                object = new IllegalStateException(string2);
                throw object;
            }
            long l11 = g.a();
            long l12 = (l10 += l11) - (l11 = 0L);
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 >= 0) {
                int n10;
                object2 = new g$d();
                ((g$d)object2).a = n10 = ((g$b)object).a;
                ((g$d)object2).a = object;
                ((g$d)object2).a = l10;
                object = this.a;
                g$c.a((g$c)object, (g$d)object2);
                return;
            }
            object2 = new StringBuilder();
            String string3 = "Illegal delay to start the TimerTask: ";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(l10);
            String string4 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string4);
            throw object;
        }
    }

    public void a() {
        this.a.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10) {
        g$c g$c = this.a;
        synchronized (g$c) {
            Object object = this.a;
            object = g$c.a((g$c)object);
            ((g$c$a)object).a(n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, g$b g$b) {
        g$c g$c = this.a;
        synchronized (g$c) {
            Object object = this.a;
            object = g$c.a((g$c)object);
            ((g$c$a)object).a(n10, g$b);
            return;
        }
    }

    public void a(g$b object) {
        g$c g$c;
        Thread thread;
        int n10;
        int n11 = com.xiaomi.channel.commonutils.logger.b.a();
        if (n11 < (n10 = 1) && (thread = Thread.currentThread()) != (g$c = this.a)) {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            object = new RejectedExecutionException("Run job outside job thread");
            throw object;
        }
        object.run();
    }

    public void a(g$b object, long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 >= 0) {
            this.b((g$b)object, l10);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delay < 0: ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public boolean a() {
        return this.a.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(int n10) {
        g$c g$c = this.a;
        synchronized (g$c) {
            Object object = this.a;
            object = g$c.a((g$c)object);
            return (int)(((g$c$a)object).a(n10) ? 1 : 0) != 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        g$c g$c = this.a;
        synchronized (g$c) {
            Object object = this.a;
            object = g$c.a((g$c)object);
            ((g$c$a)object).a();
            return;
        }
    }
}

